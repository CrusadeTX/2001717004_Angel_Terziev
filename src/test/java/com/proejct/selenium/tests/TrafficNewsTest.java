package com.proejct.selenium.tests;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.mockito.internal.matchers.Contains;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	public void checkPlovdivPage() {
		final String expectedURL = "https://trafficnews.bg/plovdiv/";
		model.navigateToMain();
		model.FindElement("Пловдив");
		WebElement linkPl = model.getLink();
		model.PressOnLink(linkPl);
		final String result = driver.getCurrentUrl();
		collector.checkThat(result,IsEqual.equalTo(expectedURL));
		WebElement mostRead = model.getMostRead();
		collector.checkThat(mostRead.getText(),IsEqual.equalTo("Най-четени"));

	}
	@Test
	public void checkBulgariaPage() {
		final String expectedURL ="https://trafficnews.bg/bulgaria/";
		model.navigateToMain();
		model.FindElement("България");
		WebElement linkGb = model.getLink();
		model.PressOnLink(linkGb);
		final String result = driver.getCurrentUrl();
		collector.checkThat(result,IsEqual.equalTo(expectedURL));
		WebElement heading = driver.findElement(By.tagName("h1"));
		collector.checkThat(heading.getText(),IsEqual.equalTo("България"));
	}
	@Test
	public void CheckLoginButton() {
		final String expectedURL ="https://trafficnews.bg/login/";
		model.navigateToMain();
		WebElement LoginBtn = driver.findElement(By.className("user-trigger"));
		LoginBtn.click();
		final String result = driver.getCurrentUrl();
		collector.checkThat(result,IsEqual.equalTo(expectedURL));
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("a");
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("b");
		WebElement submit = driver.findElement(By.name("submitDoctor"));
		submit.click();
		WebElement error = driver.findElement(By.className("error"));
		collector.checkThat(error.getText(),IsEqual.equalTo("Грешено потребителско имейл или парола!"));
		
		
		
		
	}
	@Test
	public void CheckSearch() {
		final String expectedURL = "https://trafficnews.bg/page/search/?for=%D0%91%D1%8A%D0%BB%D0%B3%D0%B0%D1%80%D0%B8%D1%8F";
		model.navigateToMain();
		WebElement searchbtn = driver.findElement(By.className("search-trigger"));
		searchbtn.click();
		WebElement input = driver.findElement(By.id("search_query"));
		input.sendKeys("България");
		input.sendKeys(Keys.RETURN);
		final String result = driver.getCurrentUrl();
		collector.checkThat(result,IsEqual.equalTo(expectedURL));
		
	}

@After
public void after() {
	driver.close();
}
}