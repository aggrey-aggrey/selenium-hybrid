package seleniumhybrid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.pageobjects.Course;
import com.automation.testBase.TestBase;

public class CourseTest extends TestBase{
	private static final Logger log = LogManager.getLogger(CourseTest.class.getName());
	Course course;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
    @Test
	public void verifyCategoryDropDown () throws InterruptedException {
		log.info("=== Starting VerifyCategoryDropDown Test ===");
		course = new Course(driver);
		course.selectCategoryDropDown();
		log.info("End Test");
	}

}
