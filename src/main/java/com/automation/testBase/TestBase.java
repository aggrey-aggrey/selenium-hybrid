package com.automation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//@SuppressWarnings("unused")
@SuppressWarnings("unused")
public class TestBase {
	
	public WebDriver driver;
	public static WebDriverWait wait;
	public Properties properties;
	public File file;
	public FileInputStream fileinputstream;
	static String driverPath = "/src/main/java/com/automation/drivers/";
	static String configPath = "/src/main/java/com/automation/config/";
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void setDriver (String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
        break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		case "ie":
			driver = initIEDriver(appURL);
			break;
		}
	}
	
	
	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath  + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
		
	}
	
	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox with new profile..");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +  driverPath + "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
		
	}
	
	private static WebDriver initIEDriver(String appURL) {
		System.out.println("Launching internetexplorer with new profile..");
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + driverPath + "" );
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
		
	}
	
	
	@Parameters({"browserType", "appURL"})
	@BeforeClass
	public void initializeTestBase(String browserType, String appURL) {
		
		try	{
			setDriver(browserType,appURL);
		}catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
		}
		
		
	}
	
	public void loadPropertiesFile() throws IOException {
			    properties = new Properties();
				file = new File(System.getProperty("user.dir") + configPath + "config.properties");
			    fileinputstream = new FileInputStream(file);
			    properties.load(fileinputstream);
			    
			    file = new File(System.getProperty("user.dir") + configPath + "org.properties");
			    fileinputstream = new FileInputStream(file);
			    properties.load(fileinputstream);
	}
	
	public void getPropertiesData() {
		
	}
	
	
	public void getaScreenShot(String imageName) {
		
		if (imageName.equals("")) {
			imageName = "blank";
		}
		
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imageLocation = (System.getProperty("user.dir") + "/src/test/java/com/automation/screenshots/");
		Calendar calendar =  Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat ("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imageLocation + imageName + "_" + formater.format(calendar.getTime()) + ".png";
		File destFile = new File(actualImageName);
		//FileUtils.copyFile(image,destFile);
		
	}
	
	public WebElement waitForElementClickable(WebElement locator,int timeout) {
		WebElement element = null;

		try {
			
			System.out.println("");
			 wait = new WebDriverWait(driver,30);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			System.out.print("Element is clickable");
		}catch(Exception e) {
			System.out.println("Element is not clickable");
			
		}
		return element;
		
	}
	
	
	public WebElement waitForElementVisible(By locator, int timeout) {
		WebElement element = null;
		try {
			System.out.println("Waiting for max: " + timeout + " seconds for element to be available");
			
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element " + locator + " appeared on the web page");	
		} catch(Exception e) {
			System.out.println("Element  has not appeared on the web page");
		}
		return element;
	}
	
	public void getWindowHandles() throws InterruptedException {
		
		//Get the handle
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle: " + parentHandle);
		
		//Find Open Window button
		WebElement openWindow = driver.findElement(By.xpath("//button[@id='openwindow']"));
		openWindow.click();
		
		//Get all window handles
		Set<String> handles = driver.getWindowHandles();
		System.out.print(handles);
		
		//Switching between handles
		for (String handle: handles){
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				//perform some action after switching window
				break;
		  }
		  //switch back to parent window
			//driver.switchTo().window(parentHandle);	
		}
		
	}
	
	public Iterator<String> getAllWindows(){
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		System.out.println(itr);
		return itr;
		
	}
	public static void main(String []args) throws IOException {
		TestBase testbase = new TestBase();
		testbase.loadPropertiesFile();
		System.out.println(testbase.properties.getProperty("url"));
		System.out.println(testbase.properties.getProperty("testname"));
		
	}
	@AfterClass 
	public void tearDown() {
		driver.quit();
	}
}
