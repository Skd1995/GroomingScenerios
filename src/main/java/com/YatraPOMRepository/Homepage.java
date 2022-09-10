package com.YatraPOMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Homepage {
	
	@FindBy(xpath="//button[text()='Ok,I Agree']")
	private WebElement cookies;
	
	@FindBy(xpath="//div[@class='be-container-snipe']/descendant::span[text()='Departure Date']")
	private WebElement DepartureDate;
	
	//constructor initialize
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clkOnDepartureDate() {
		DepartureDate.click();
	}
	public void clkOncookies() {
		cookies.click();
	}
}
