package com.automation.pageobjects;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.automation.testBase.TestBase;


public class Practice extends TestBase {
	
	private static final Logger log = LogManager.getLogger(Practice.class.getName());

	@FindBy(how=How.XPATH,using = "//h1[contains(.,'Practice Page')]") public WebElement pageTitle;
	@FindBy(how=How.XPATH,using = "//legend[contains(.,'Radio Button Example')]") public WebElement radioButtonHeaderLabel;
	@FindBy(how=How.XPATH,using = "//input[@id='bmwradio']") public WebElement inputBmwRadioBtn ;
	@FindBy(how=How.XPATH,using = "//input[@id='benzradio']") public WebElement inputBenzRadioBtn;
	@FindBy(how=How.XPATH,using = "//input[@id='hondaradio']") public WebElement inutHondaRadioBtn;
	@FindBy(how=How.XPATH,using = "//legend[contains(.,'Select Class Example')]") public WebElement dropDownHeaderLabel;
	@FindBy(how=How.XPATH,using = "//select[@id='carselect']") public WebElement inputCarSelectDropDown;
	@FindBy(how=How.XPATH,using = "//legend[contains(.,'Multiple Select Example')]") public WebElement multipleSelectHeaderLabel;
	@FindBy(how=How.ID,using = "multiple-select-example") public WebElement inputMultipleSelect;
	@FindBy(how=How.XPATH,using = "//legend[contains(.,'Checkbox Example')]") public WebElement checkboxHeaderLabel;
	@FindBy(how=How.XPATH,using = "//input[@id='bmwcheck']") public WebElement inputBmwCheckBox;
	@FindBy(how=How.XPATH,using = "//input[@id='benzcheck']") public WebElement inputBenzCheckBox;
	@FindBy(how=How.XPATH,using = "//input[@id='hondacheck']") public WebElement inputHondaCheckBox;
	@FindBy(how=How.XPATH,using = "//legend[contains(.,'Element Displayed Example')]") public WebElement elementDisplayHeaderLabel;
	@FindBy(how=How.XPATH,using = "//input[@id='hide-textbox']") public WebElement hideCheckBoxBtn;
	@FindBy(how=How.XPATH,using = "//input[@id='show-textbox']") public WebElement showCheckBoxBtn;
	@FindBy(how=How.XPATH,using = "//input[@id='displayed-text']") public WebElement inputShowHideTextBox;
	@FindBy(how=How.XPATH,using = "//legend[contains(.,'Switch Window Example')]") public WebElement switchWindowExLabel;
	@FindBy(how=How.XPATH,using = "//button[@id='openwindow']") public WebElement openNewWindow;
	@FindBy(how=How.XPATH,using = "//input[@id='search-courses']") public WebElement courseSearchBox;
	@FindBy(how=How.XPATH,using = "//legend[contains(.,'iFrame Example')]") public WebElement iframeExampleLabelHeader;
	@FindBy(how=How.CSS,using = ".course-title") public WebElement courseTitle;
	@FindBy(how=How.XPATH,using = "//legend[contains(.,'Mouse Hover Example')]") public WebElement mouseOverExampleLabelHeader;
	@FindBy(how=How.ID,using = "name") public WebElement inputNameTextbox;
	@FindBy(how=How.XPATH,using = "//input[@id='bmwradio']") public WebElement bmwRadioBtn;
	@FindBy(how=How.XPATH,using = "//input[@id='benzradio']") public WebElement benzRadioBtn;
	@FindBy(how=How.XPATH,using = "//input[@id='hondaradio']") public WebElement hondaRadioBtn;
	@FindBy(how=How.XPATH,using = "//select[@id='carselect']") public WebElement carSelectDropDown;
	@FindBy(how=How.XPATH,using = "//input[@id='bmwcheck']") public WebElement bmwCheckBox;
	@FindBy(how=How.XPATH,using = "//input[@id='benzcheck']") public WebElement benzCheckBox;
	@FindBy(how=How.XPATH,using = "//input[@id='hondacheck']") public WebElement hondaCheckBox;
    @FindBy(how=How.XPATH,using = "//a[@id='opentab']") public WebElement openTabWindow;
    @FindBy(how=How.XPATH,using = "//button[@id='search-course-button']") public WebElement searchCourseButton;
    @FindBy(how=How.XPATH,using = "//input[@name='enter-name']") public WebElement inputEnterYourName;
    @FindBy(how=How.XPATH,using = "//input[@id='alertbtn']") public WebElement alertButton;
    @FindBy(how=How.XPATH,using = "//input[@id='confirmbtn']") public WebElement confirmButton;
   
	public Practice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickRadioButtons () {
        WebElement [] radioButtons = {bmwRadioBtn,benzRadioBtn,hondaRadioBtn};
		 
		 for(WebElement radioBtn : radioButtons) {
			 log.info("Printing all options we can select : " + radioBtn);
			 radioBtn.click();
		}
		
	}
	
	public void selectFromDropDown () throws InterruptedException {
		WebElement element = carSelectDropDown;
		 
		 Select select = new Select(element);
		 
		 select.selectByValue("benz");
		 Thread.sleep(2000);
		 select.selectByIndex(1);
		 select.selectByVisibleText("Honda");
		 log.info("Printing the list of all options");
			List<WebElement> options = select.getOptions();
			int size = options.size();
			
			for (int i=0; i<size; i++) {
				String optionName = options.get(i).getText();
				System.out.println(optionName);
			}
			
	}		

	public void selectAndDeselectFromSelectBox () {
		 log.info("Select items from Select Box");
		 log.info("Multiple Selected Header Text is displayed " + checkboxHeaderLabel.isDisplayed());
		 WebElement element = inputMultipleSelect;
		 
		 Select select = new Select(element);
		 select.selectByValue("orange");;
		 select.deselectByIndex(0);
		 select.selectByVisibleText("Apple");
		 
		 List<WebElement> selectedOptions = select.getAllSelectedOptions();
		 for(WebElement option : selectedOptions) {
			 log.info("Print all options we selected: " + option.getText());
			 select.deselectAll(); 
		 }
		 	
	}

	public void hideAndShowTextBox() throws InterruptedException {
		
		scrollElementIntoView(elementDisplayHeaderLabel);
	     log.info("The header Element Displayed Example is displayed: " + elementDisplayHeaderLabel.isDisplayed());
		 hideCheckBoxBtn.click();
		 log.info("The textbox inputShowHideTextBox is now hidden: " + !inputShowHideTextBox.isDisplayed());
		 showCheckBoxBtn.click();
		 log.info("The textox inputShowHideTextBox is now visible: " + inputShowHideTextBox.isDisplayed()); 
	 
	 }
	
	public void openSwitchWindow () throws InterruptedException {
		scrollElementIntoView(pageTitle);
		log.info("Element is now in view and displayed " + openNewWindow.isDisplayed());
		String parentHandle = driver.getWindowHandle();
		log.info("Parent Handle: " + parentHandle);
		
		//Find Open Window button
		WebElement openWindow = openNewWindow;
		openWindow.click();

		//Get all window handles
		Set<String> handles = driver.getWindowHandles();
		log.info(handles + "\n");
		
		//Switching between handles
		for (String handle: handles){
			log.info(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				WebElement searchBox = courseSearchBox;
				//perform some action after switching window
				String URL = driver.getCurrentUrl();
				Assert.assertEquals(URL, "https://letskodeit.teachable.com/courses" );
				
				searchBox.sendKeys("Java");
				driver.switchTo().defaultContent();
				break;
		  }
							
		}
		
	}
	
	public void swithToIframe() throws InterruptedException {
		scrollElementIntoView(mouseOverExampleLabelHeader);
		log.info("Element iFrame Examble label is displayed:  " + iframeExampleLabelHeader.isDisplayed());
		driver.switchTo().frame("courses-iframe");
		WebElement searchBox = courseSearchBox;
		searchBox.sendKeys("python");
		
		driver.switchTo().defaultContent();
		inputNameTextbox.sendKeys("Test Successful");
	}
	
	public void selectCheckBox () {
		WebElement [] checkboxes = {bmwCheckBox, benzCheckBox, hondaCheckBox};
		
		 for(WebElement checkbox : checkboxes) {
			 log.info("Print all options we can select : " + checkbox);
			 checkbox.click();
		 }
		
	}
	
	public void switchTabWindow() throws InterruptedException {
		scrollElementIntoView(pageTitle);
		String parentHandle = driver.getWindowHandle();
		log.info("Parent Handle: " + parentHandle);
		
		//Find Open Window button
		openTabWindow.click();
		log.info("Opened new tab");
	
		//Get all window handles
		Set<String> handles = driver.getWindowHandles();
		log.info(handles + "\n");
		
		//Switching between handles
		for (String handle: handles){
			log.info(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				//perform some action after switching window
				String URL = driver.getCurrentUrl();
				Assert.assertEquals(URL, "https://letskodeit.teachable.com/courses" );
				WebElement searchBox = courseSearchBox;
				searchBox.sendKeys("C#");
				WebElement hitReturn = searchCourseButton;
				hitReturn.sendKeys(Keys.ENTER);
				driver.switchTo().defaultContent();
			}
		}
		
	}
	
	public void alertBoxPop() throws InterruptedException {
		scrollElementIntoView(pageTitle);
		WebElement inputName = inputEnterYourName;
		inputName.sendKeys("John");
		WebElement alertBtn =  alertButton;
		alertBtn.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	
	public void confirmBoxPop() throws InterruptedException {
		
		scrollElementIntoView(pageTitle);
		WebElement inputName = inputEnterYourName;
		inputName.sendKeys("Andrew");
		WebElement confirmBtn =  confirmButton;
		confirmBtn.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	
	
	public void  scrollElementIntoView(WebElement element) {
		WebElement ele = element;
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",ele);  
	}

}
