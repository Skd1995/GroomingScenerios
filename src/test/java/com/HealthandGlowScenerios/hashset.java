package com.HealthandGlowScenerios;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hashset {
	
    @Test
	public void nailpolish() throws InterruptedException {

		// To handle Notification Pop-up
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");

		// Launching the browser and Maximize the window
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wb = new WebDriverWait(driver, 10l);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Launch the given Application URL
		driver.get("https://healthandglow.com");

		// Mousehover on 'Makeup' Tab
		Actions act = new Actions(driver);
		WebElement makeup = driver.findElement(By.xpath("//div/a[text()='Makeup']"));
		act.moveToElement(makeup).perform();
		wb.until(ExpectedConditions.visibilityOf(makeup));
		Thread.sleep(2000);

		// Validate the contents under 'Eyes' Category Text
		List<WebElement> eyesList = driver.findElements(By.xpath("//div/li/a[contains(@href,'eyes')]/div[@class='css-axome2']"));
		ArrayList<String> allProducts = new ArrayList<String>();
		
		for (int i = 0; i <eyesList.size(); i++) {
			allProducts.add(eyesList.get(i).getText());
		}
		
		
		for (WebElement eye:eyesList)
		{
			Assert.assertTrue(allProducts.contains(eye.getText()));
		}
		

		// Click on the 'NailPolish' text present under Nails Category
		WebElement nailpolish = driver.findElement(By.xpath("//a[contains(@href,'nails')]/div[text()='Nail Polish']"));
		js.executeScript("arguments[0].click();", nailpolish);
	
    }

}
