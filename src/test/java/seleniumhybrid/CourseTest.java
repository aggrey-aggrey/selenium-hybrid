package seleniumhybrid;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pageobjects.Course;
import com.automation.testBase.TestBase;

public class CourseTest extends TestBase{
	Course course;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
    @Test
	public void verifyCategoryDropDown () throws InterruptedException {
		System.out.println("Starting VerifyCategoryDropDown Test");
		course = new Course(driver);
		course.selectCategoryDropDown();
		System.out.println("End Test");
	}

}
