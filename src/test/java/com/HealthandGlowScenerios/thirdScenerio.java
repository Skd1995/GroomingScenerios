package com.HealthandGlowScenerios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class thirdScenerio {
	@Test
	public void enterOlay() {

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
		
		// Mousehover on 'Brands' Major Tab
		Actions act = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//p[text()='BRANDS']"));
		act.moveToElement(brands).perform();
		wb.until(ExpectedConditions.visibilityOf(brands));
		
		//Enter 'Olay' in the Search Brands Text Field
		driver.findElement(By.xpath("//input[@placeholder='Search brands']")).sendKeys("Olay");
		
		// Select 'Olay' option from the Autosuggestion
		driver.findElement(By.xpath("//li/a[contains(@href,'olay')]")).click();
		
		// Validate Olay Page
		String actualOlayPageTitle = driver.getTitle();
		String expectedOlayPageTitle = "Buy Cosmetics & Beauty Products Online in India at Best Price | Health and Glow";
		Assert.assertTrue(expectedOlayPageTitle.contains(actualOlayPageTitle), "title is failed");
		System.out.println("Olay Page Validated");
		
		// Click on the 'Clear All' link present on the left side of Sort By Dropdown
		driver.findElement(By.xpath("//span[text()='Clear All']")).click();
		
		// Print all the product names that have '20%' Off 
		List<WebElement> eleList = driver.findElements(By.xpath("//span[text()='20% OFF']/ancestor::a/p"));
		int count=0;
		for (int i=0; i<=eleList.size()-1; i++) 
		{
			String products = eleList.get(i).getText();
			count++;
			System.out.println(products+" PRODUCT NUMBER "+count);
		}
		
		// Click on 'the first  '20%' Off  product  Image
		WebElement reqProduct = driver.findElement(By.xpath("//span[text()='20% OFF']/ancestor::a/p"));
		js.executeScript("arguments[0].click();", reqProduct);
		
//		// Validate whether the product name and price selected is the same product from the previous Page or not
//		String previousPageProductName = driver.findElement(By.xpath("//div[@class='title-and-price']/h1")).getText();
//		String currentPageProductName = "Olay Regenerist Retinol24 Night Serum 30ml";
//		Assert.assertTrue(currentPageProductName.contains(previousPageProductName), "Assertion is failed");
//		System.out.println("same product name is validated");
//
//		String previousPageProductPrice = driver.findElement(By.xpath("//div[contains(@class,'quantity-and-price-container')]/div[@class='is-flex']/div/descendant::span[text()='1599']")).getText();
//		String currentPageProductPrice = "1599";
//		Assert.assertTrue( previousPageProductPrice.contains(currentPageProductPrice), "Assertion is failed");
//		System.out.println("same product price is validated");
		
		// Enter your locality pincode in the Pincode Textfield
		WebElement pincode = driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']"));
		pincode.sendKeys("");
		pincode.clear();
		pincode.sendKeys("560085");
       
		// Click on 'Check' Button
		driver.findElement(By.xpath("//button[text()='Check']")).click();
		
		// Scroll to the end of the Page
		js.executeScript("window.scrollBy(0,3250)", "");   // avoid numerical value
		
		// Click on the 'Add to Bag' Button
		driver.findElement(By.xpath("//div[@class='right-container']/button[text()='Add to Bag']")).click();
	
		// Click on the 'Go to Bag' Button
		driver.findElement(By.xpath("//div[@class='right-container']/button[text()='Go to Bag']")).click();
	
		// Click on the 'Qty' DropDown
		WebElement qtyBtn = driver.findElement(By.xpath("//div[@class='quantity-dropdown-btn is-flex has-ai-c']"));
		act.moveToElement(qtyBtn).perform();
		
		// Select Quantity as '2' from the DropDown
		WebElement reqQty = driver.findElement(By.xpath("//ul/li[text()='2']"));
		wb.until(ExpectedConditions.elementToBeClickable(reqQty));
		js.executeScript("arguments[0].click();", reqQty);
//	
		
	}

}
