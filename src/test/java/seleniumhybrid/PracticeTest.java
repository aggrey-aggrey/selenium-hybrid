package seleniumhybrid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.pageobjects.Practice;
import com.automation.testBase.TestBase;
import com.automation.utilities.FindLinks;

public class PracticeTest extends TestBase{
	private static final Logger log = LogManager.getLogger(PracticeTest.class.getName());
	Practice practice;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
   // @Test
	public void verifyRadioButtons () {
		log.info("=== Starting VerifyRadioButtons Test ===");
	
		practice = new Practice(driver);
		practice.clickRadioButtons();
		log.info("End Test");
	}
	
	//@Test
		public void verifyDropDown () throws InterruptedException {
			log.info("=== Starting VerifyDropDown Test ===");
			practice = new Practice(driver);
			practice.selectFromDropDown();
			System.out.println("End Test");
		}
	
	//@Test
	public void verifyCheckBox() {
		log.info("==== Starting VerifyCheckbox Test ===");
		practice = new Practice(driver);
		practice.selectCheckBox();
		log.info("End Test");
	}
	
	//@Test
	public void verifySelectBox() throws InterruptedException {
		log.info("=== Starting VerifySelectBox test ===");
	    practice = new Practice(driver);
		practice.selectAndDeselectFromSelectBox();
		practice.hideAndShowTextBox();
		System.out.println("End of Test");
		
	} 
   // @Test
	public void verifySwitchToWindow() throws InterruptedException {
		log.info("=== Starting SwitchToWindow Test ===");
		practice = new Practice(driver);
		practice.openSwitchWindow();
		System.out.println("End of Test");
	}
	
  //  @Test
	public void verifySwitchToIframe() throws InterruptedException {
		log.info("=== Starting VerifySwitchToInframe Test ===");
	    practice = new Practice(driver);
		practice.swithToIframe();
		log.info("End of Test");
	}
    
   //@Test
   	public void verifySwitchingTabs() throws InterruptedException {
   		log.info("==== Starting VerifySwitchingTabs Test ===");
   	    practice = new Practice(driver);
   		practice.switchTabWindow();
   		log.info("End of Test");
   	}
   	
   	
  //  @Test
   	public void verifyConfirmPopWindow() throws InterruptedException {
   		log.info("=== Starting VerifyConfirmPopWindow Test ===");
   	    practice = new Practice(driver);
   		practice.confirmBoxPop();
   		log.info("End of Test");
   	}
    
  //  @Test
   	public void verifyAlertWindow() throws InterruptedException {
   		log.info("=== Starting VerifyAlertBoxWindow Test ===");
   	    practice = new Practice(driver);
   		practice.alertBoxPop();
   		log.info("End of Test");
    }
    
    @Test
    public void verifyAllLinksOnThePage () {
    	log.info("==== Start VerifyLinksOnThePage Test ====");
    	FindLinks findLinks = new FindLinks();
    	findLinks.testFindLinks(driver);
    	log.info("End the test");
    }
    
	@AfterClass
	public void endTest() {
		tearDown();
	}
	


}
