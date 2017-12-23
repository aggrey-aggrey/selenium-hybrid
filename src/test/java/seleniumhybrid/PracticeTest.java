package seleniumhybrid;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pageobjects.Practice;
import com.automation.testBase.TestBase;

public class PracticeTest extends TestBase{
	//private WebDriver driver;
	Practice practice;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	@Test
	public void verifySelectBox() throws InterruptedException {
		System.out.println("Starting VerifySelectBox test");
	    practice = new Practice(driver);
		practice.selectAndDeselectFromSelectBox();
		practice.hideAndShowTextBox();
		System.out.println("End of Test");
		
	} 
	@Test
	public void verifySwitchToWindow() throws InterruptedException {
		System.out.println("Starting SwitchToWindow Test");
		practice = new Practice(driver);
		practice.openSwitchWindow();
		System.out.println("End of Test");
	}
	
	@Test
	public void verifySwitchToIframe() throws InterruptedException {
		System.out.println("Starting VerifySwitchToInframe Test");
	    practice = new Practice(driver);
		practice.swithToIframe();
		System.out.println("End of Test");
	}
	

	@AfterClass
	public void endTest() {
		//tearDown;
	}
	


}
