package com.proejct.selenium.tests;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.mockito.internal.matchers.Contains;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.selenium.models.TrafficNewsWebPageModel;

public class TrafficNewsTest {
	WebDriver driver;
	TrafficNewsWebPageModel model;
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	@BeforeClass
	public static void setupClass() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	}
	@Before
	public void setup() {
		driver = new ChromeDriver();
		
		model = new TrafficNewsWebPageModel(driver);
	}
	@Test
	public void checkSearchResult() {
		final String expectedURL = "https://trafficnews.bg/plovdiv/";
		model.navigateToMain();
		WebElement linkPl = model.getPlovdivLink();
		model.PressOnLink(linkPl);
		final String result = driver.getCurrentUrl();
		collector.checkThat(result,IsEqual.equalTo(expectedURL));
		WebElement mostRead = model.getMostRead();
		collector.checkThat(mostRead.getText(),IsEqual.equalTo("Най-четени"));

	}

@After
public void after() {
	driver.close();
}
}