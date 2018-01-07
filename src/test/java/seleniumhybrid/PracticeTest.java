package seleniumhybrid;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.pageobjects.Practice;
import com.automation.testBase.TestBase;
import com.automation.utilities.FindLinks;

public class PracticeTest extends TestBase{
	Practice practice;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
    @Test
	public void verifyRadioButtons () {
		System.out.println("Starting VerifyRadioButtons Test");
		practice = new Practice(driver);
		practice.clickRadioButtons();
		System.out.println("End Test");
	}
	
	@Test
		public void verifyDropDown () throws InterruptedException {
			System.out.println("Starting VerifyDropDown Test");
			practice = new Practice(driver);
			practice.selectFromDropDown();
			System.out.println("End Test");
		}
	
	@Test
	public void verifyCheckBox() {
		System.out.println("Starting VerifyCheckbox Test");
		practice = new Practice(driver);
		practice.selectCheckBox();
		System.out.println("End Test");
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
    
   //@Test
   	public void verifySwitchingTabs() throws InterruptedException {
   		System.out.println("Starting VerifySwitchingTabs Test");
   	    practice = new Practice(driver);
   		practice.switchTabWindow();
   		System.out.println("End of Test");
   	}
   	
   	
    @Test
   	public void verifyConfirmPopWindow() throws InterruptedException {
   		System.out.println("Starting VerifyConfirmPopWindow Test");
   	    practice = new Practice(driver);
   		practice.confirmBoxPop();
   		System.out.println("End of Test");
   	}
    
    @Test
   	public void verifyAlertWindow() throws InterruptedException {
   		System.out.println("Starting VerifyAlertBoxWindow Test");
   	    practice = new Practice(driver);
   		practice.alertBoxPop();
   		System.out.println("End of Test");
    }
    
    @Test
    public void verifyAllLinksOnThePage () {
    	System.out.println("Start VerifyLinksOnThePage Test");
    	FindLinks findLinks = new FindLinks();
    	findLinks.testFindLinks(driver);
    	System.out.println("End the test");
    }
    
	@AfterClass
	public void endTest() {
		tearDown();
	}
	


}
