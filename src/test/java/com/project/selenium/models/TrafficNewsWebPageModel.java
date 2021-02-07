package com.project.selenium.models;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Angel
 * Page Object model used for configuring UI Tests
 */
public class TrafficNewsWebPageModel {
	private WebDriver driver;

	//@FindBy(linkText = "Пловдив")
	WebElement element;
	
	@FindBy(linkText = "Най-четени")
	WebElement MostRead;
	
	/**
	 * @param driver
	 * Initializes driver
	 */
	public TrafficNewsWebPageModel(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * navigates to https://trafficnews.bg/
	 */
	public void navigateToMain() {
		driver.get(
				"https://trafficnews.bg/");
	}
	/**
	 * @param element
	 * Performs a click on the provided element
	 */
	public void PressOnLink(WebElement element) {
		element.click();
	}
	/**
	 * @return WebElement MostRead element
	 */
	public WebElement getMostRead() {
		return MostRead;
		
	}
	/**
	 * @return WebElement that is stored locally
	 * 
	 */
	public WebElement getLink() {
		return element;
		
	}
	/**Finds and saves a WebElement by its text property
	 * @param name String - text property of the supplied element 
	 */
	public void FindElement(String name) {
		this.element = driver.findElement(By.linkText(name));
	}
	

}
