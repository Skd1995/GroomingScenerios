package com.makeMyTripGenericUtility;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.makeMyTripPOMRepository.HomePage;
import com.makeMyTripPOMRepository.SearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/***
 * 
 * @author Admin
 *
 */
public class MakeMyTripBaseClass {
	
	
	public WebDriver driver;
	public WebElement element;
	public long longtimeout;
	static WebDriverWait wait;
	public JavascriptExecutor js;
	
	
	
	
	@BeforeClass
	public void browserSetup() {
		
		
		// To handle Notification Pop-up
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");

		// Launching the browser and Maximize the window
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 wait = new WebDriverWait(driver, 10l);
		 js = (JavascriptExecutor) driver;

		// Launch the given Application URL
		String url = "https://www.makemytrip.com/";
		driver.get(url);
	}
		
		public static void waitTillPageLoad(long longtimeout, WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
		}
		public static void waitUntillElementClickable(WebElement element) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		public static void waitUntillElementVisible(WebElement element) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		public static void explicitlyWait(WebDriver driver, long timeout) {
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
		public  void scrollTillElement(WebElement element)
		{
			js.executeScript("arguments[0].scrollIntoView()", element);
		}
	

}
