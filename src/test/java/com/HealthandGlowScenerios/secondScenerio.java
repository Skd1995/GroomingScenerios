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

public class secondScenerio {
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

		// Validate  NailPolish Page
		String actualNailPolishPageTitle = driver.getTitle();
		String expectedNailPolishPageTitle = "Buy Cosmetics & Beauty Products Online in India at Best Price | Health and Glow";
		Assert.assertTrue(actualNailPolishPageTitle.contains(expectedNailPolishPageTitle), "title is failed");
		System.out.println("NailPolish Page validated");

		// Select 'Low-High' Option from the 'Sort By' Dropdown
		WebElement sortByDropdown = driver.findElement(By.xpath("//ul/li[text()='Low - High']"));
		js.executeScript("arguments[0].click();", sortByDropdown);

		// Print all the product names that have the Best Seller Tag on it
		List<WebElement> productsList = driver.findElements(By.xpath("//img[contains(@src,'bestseller')]/ancestor::a[@rel='alternate']/p"));
		int count=0;
		for (int i=0; i<=productsList.size()-1; i++) 
		{
			String bestsellerProducts = productsList.get(i).getText();
			count++;
			System.out.println(bestsellerProducts+" PRODUCT NUMBER "+count);
		}

		// Click on 'Add to Bag' Button for the first Best Seller product 
		driver.findElement(By.xpath("//img[contains(@src,'bestseller')]/ancestor::a[@rel='alternate']/p[text()='']/../following-sibling::div/button")).click();		

		// Click on the 'Cart' Icon present at the right top corner in the Page
		driver.findElement(By.xpath("//a[@class='cart-icon-container']/img")).click();

		// Click on the 'Remove' Icon present for the Added product in Bag
		WebElement deleteBtn =driver.findElement(By.xpath("//div[@class='action delete-item']"));
		js.executeScript("arguments[0].click();", deleteBtn);

		// Validate ' Are you sure you want to remove this item? ' Header Text is displayed
		String actualRemoveMsg = driver.findElement(By.xpath("//p[@class='sub-heading']")).getText();
		String expectedRemoveMsg = " Are you sure you want to remove this item?";
		Assert.assertTrue(expectedRemoveMsg.contains(actualRemoveMsg), "validation is failed");
		System.out.println("Remove Message is validated");

		// Click on the 'Remove' Button present under ' Are you sure you want to remove this item? ' Header Text 
		driver.findElement(By.xpath("//button[text()='REMOVE']")).click();

		// Validate that the Product has been successfully removed from the Bag
		String actualMsgAfterRemove = driver.findElement(By.xpath("//div[@class='bag-container']/div/div/div/p")).getText();
		String expectedMsgAfterRemove = "Your bag is empty and sad :(";
		Assert.assertTrue(expectedMsgAfterRemove.contains(actualMsgAfterRemove), "validation is failed");
		System.out.println("Product has been successfully removed from the Bag");


	}

}
