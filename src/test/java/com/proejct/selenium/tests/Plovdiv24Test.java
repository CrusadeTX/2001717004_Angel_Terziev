package com.proejct.selenium.tests;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.selenium.models.Plovdiv24WebPageModel;
import com.project.selenium.models.TrafficNewsWebPageModel;

/**
 * @author Angel
 * Tests the UI of the webpage Plovdiv24
 */
public class Plovdiv24Test {
	WebDriver driver;
	Plovdiv24WebPageModel model;
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	/**
	 * Sets up driver info
	 */
	@BeforeClass
	public static void setupClass() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	}
	
	/**
	 * Initial test configuration - adds the correct driver and PageObjectModel
	 */
	@Before
	public void setup() {
		driver = new ChromeDriver();
		
		model = new Plovdiv24WebPageModel(driver);
	}
	
	/**
	 * Test case which ensures that a required button is successfully pressed and ensures that a heading value is as expected
	 */
	@Test
	public void checkEnterWebsite() {
		final String expectedURL = "https://www.plovdiv24.bg/";
		model.navigateToMain();
		model.PressOnEnterWebsiteButton();
		WebElement heading = model.getHeading();
		final String result = driver.getCurrentUrl();
		collector.checkThat(result,IsEqual.equalTo(expectedURL));
		collector.checkThat(heading.getText(),IsEqual.equalTo("Водещи новини от Пловдив и региона"));
	}



/**
 * Disposes of all resources which were in use
 */
@After
public void after() {
	driver.close();
}
}
