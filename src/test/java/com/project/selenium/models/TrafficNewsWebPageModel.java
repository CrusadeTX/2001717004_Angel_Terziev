package com.project.selenium.models;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class TrafficNewsWebPageModel {
	private WebDriver driver;

	//@FindBy(linkText = "Пловдив")
	WebElement element;
	
	@FindBy(linkText = "Най-четени")
	WebElement MostRead;
	
	public TrafficNewsWebPageModel(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateToMain() {
		driver.get(
				"https://trafficnews.bg/");
	}
	public void PressOnLink(WebElement element) {
		element.click();
	}
	public WebElement getMostRead() {
		return MostRead;
		
	}
	public WebElement getLink() {
		return element;
		
	}
	public void FindElement(String name) {
		this.element = driver.findElement(By.linkText(name));
	}
	

}
