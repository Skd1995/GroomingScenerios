package com.makeMyTripPOMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	@FindBy(xpath = "//button[ text()='OKAY, GOT IT!']")
	private WebElement okayBtn;


	@FindBy(xpath = "//span[text()='View Prices']")
	private WebElement viewPricesBtn;

	@FindBy(xpath = "//button[text()='Book Now']")
	private WebElement bookNowBtn;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueBtn;

	//constructor initialize
	public SearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clkOkayBtn()
	{
		okayBtn.click();
	}
	public void clkViewPricesBtn()
	{
		viewPricesBtn.click();
	}
	public void clkBookNowBtn()
	{
		bookNowBtn.click();
	}
	public void clkOnContinueBtn()
	{
		continueBtn.click();
	}
	public WebElement getContinueBtn() {
		return continueBtn;
	}


}
