package com.erwebadmin.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumConfig {

	private WebDriver driver;
	//private String URL = "http://localhost:8080/";
	private String URL = "https://www.trucksnlorries.com/";

	public SeleniumConfig() {
		driver = new FirefoxDriver();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	static {
		System.setProperty("webdriver.gecko.driver",
				"src/test/resources/static/drivers/geckodriver-v0.23.0-win64/geckodriver.exe");
	}

	public void close() {
		driver.close();
	}

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void login() {
		navigateTo(URL);
		driver.findElement(By.name("username")).sendKeys("system");
		driver.findElement(By.name("password")).sendKeys("system");
		driver.findElement(By.tagName("button")).click();
	}

	/**
	 * Method to get menu item click for now as per link, later to get webeliment
	 * 
	 * @param menuItem
	 */
	public void menuClick(String menuItem) {
		if (menuItem.equalsIgnoreCase("/clients")) {
			navigateTo(URL + "add-client");
		}
	}
}
