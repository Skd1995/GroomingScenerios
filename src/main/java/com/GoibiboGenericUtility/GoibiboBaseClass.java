package com.GoibiboGenericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboBaseClass {

	public WebDriver driver;
	public WebElement element;
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

		// Launch the given Application URL
		String url = "https://www.goibibo.com/";
		driver.get(url);
		
		//date
		
	}

}
