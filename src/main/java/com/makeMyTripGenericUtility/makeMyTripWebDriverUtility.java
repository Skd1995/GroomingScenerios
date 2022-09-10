package com.makeMyTripGenericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makeMyTripPOMRepository.HomePage;
import com.sdet34L1.genericUtility.JavaUtility;

public class makeMyTripWebDriverUtility {
	public Actions act;
	public WebDriverWait wait;

	static Select select = null;
	public JavascriptExecutor js;
	static JavaUtility jutil = new JavaUtility();


	public void waitTillPageLoad(long longtimeout, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
	}
	public  void waitUntillElementClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public  void waitUntillElementVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public  void waitUntillInVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public  void explicitlyWait(WebDriver driver, long timeout) {
		wait = new WebDriverWait(driver, timeout);
	}

	public  void intializeJs(WebDriver driver)
	{
		js = (JavascriptExecutor)driver;
	}
	public  void enterDataThroughJs(WebElement element, String data)
	{
		js.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	public  void clickThroughJs(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);
	}
	public  void navigateApplicationThroughJs(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	public  void scrollToSpecifiedHeight(String height) 
	{
		js.executeScript("window.scrollBy(0,"+height+")");
	}
	public  void scrollToBottom()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public  void scrollTillElement(WebDriver driver,WebElement element)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}


}
