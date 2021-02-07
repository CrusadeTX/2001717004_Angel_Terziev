package com.project.selenium.models;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Plovdiv24WebPageModel {
	private WebDriver driver;
	WebElement heading;
	WebElement EnterWebsiteButton;
	
	
	
	public Plovdiv24WebPageModel(final WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateToMain() {
		driver.get(
				"https://www.plovdiv24.bg/");
	}
	
	public WebElement getHeading () {
		return heading = driver.findElement(By.tagName("h1"));
	}
	public void PressOnEnterWebsiteButton() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		EnterWebsiteButton = driver.findElement(By.className("fc-cta-consent"));
		
		EnterWebsiteButton.click();
	}
	
	
	
	
	

}




