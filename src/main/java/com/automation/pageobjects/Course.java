package com.automation.pageobjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.testBase.TestBase;

public class Course extends TestBase{

	@FindBy(how=How.XPATH,using = "//button[contains(@class,'btn btn-default btn-lg btn-course-filter dropdown-toggle')]") public WebElement categoryAll;
	@FindBy(how=How.XPATH,using = "//ul[contains(@class,'dropdown-menu')]") public WebElement categoryDropDown;
	public Course(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectCategoryDropDown () throws InterruptedException {
		
		WebElement dropdown = categoryDropDown;
		List<WebElement> elements = dropdown.findElements(By.tagName("li"));
		elements.addAll(elements);
		
		WebElement mainElement = categoryAll;
		mainElement.click();
		Thread.sleep(2000);
			
		for (WebElement ele : elements) {
			
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			}
	}

}
