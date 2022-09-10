package com.HealthandGlowScenerios;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firststScenerio {
	@Test
	public void searchEyeliner() {

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

		// Click on Search Text Field
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).click(); 
		//numerical value avoid

		// Type 'eyeliner' in the search Text Field
		driver.findElement(By.xpath("//input[@class='input-search']")).sendKeys("eyeliner");

		// Click on the 'Search' Button present on the right side in the Search Text Field
		driver.findElement(By.xpath("//div/img[contains(@src,'search')]")).click();

		// Validate Eyeliner Header Text is present
		String actualHeaderTxt = driver.findElement(By.xpath("//h1")).getText();
		String expectedHeaderTxt = "Eyeliner - Eyes Products";
		Assert.assertTrue(actualHeaderTxt.contains(expectedHeaderTxt), "Assertion is failed");
		System.out.println("Eyeliner Header Text is present");

		// Click on 'Brand' Button Filter present under Filter By
		driver.findElement(By.xpath("//h3[text()='Brand']")).click();

		// Select  'Lakme' Text as the Brand Filter
		WebElement lakme = driver.findElement(By.xpath("//div[text()='Lakme']"));
		js.executeScript("arguments[0].scrollIntoView();", lakme);
		wb.until(ExpectedConditions.visibilityOf(lakme));
		js.executeScript("arguments[0].click();", lakme);

		// Print all the products that are in stock
		List<WebElement> outOfStockItemsList = driver.findElements(By.xpath("//span[text()='Out Of Stock']"));

		List<WebElement> eleList = driver.findElements(By.xpath("//button[text()='ADD TO BAG']/ancestor::div[@class='hover-product-footer']/preceding-sibling::a/descendant::p[text()]"));
		int count=0;
		for (int i=0; i<=eleList.size()-1; i++) 
		{
			String products = eleList.get(i).getText();
			count++;
			System.out.println(products+" PRODUCT NUMBER "+count);
		}

		// Click on 'Add to Bag' Button for the first product
		WebElement addToBag = driver.findElement(By.xpath("//button[text()='ADD TO BAG']/ancestor::div[@class='hover-product-footer']/preceding-sibling::a/descendant::p[text()]"));  
		js.executeScript("arguments[0].click();", addToBag);
		//dynamic text

		// Click on the 'Bag' Icon present at the right top corner in the Page
		driver.findElement(By.xpath("//a[@class='cart-icon-container']/img")).click();

		// Validate 'Shopping Bag' Header Text is displayed
		String actualShoppingBagHeaderTxt = driver.findElement(By.xpath("//div/strong")).getText();
		String expectedShoppingBagHeaderTxt = " Shopping Bag (";
		Assert.assertTrue(expectedShoppingBagHeaderTxt.contains(actualShoppingBagHeaderTxt), "Assertion is failed");
		System.out.println("'Shopping Bag' Header Text is displayed");

		// Validate the product name and price present in the Bag is the same as the product that was added to cart
		String actualProductName = driver.findElement(By.xpath("//div[@class='overlay-content bag']/descendant:p[@class='title']")).getText();
		String expectedProductName = driver.findElement(By.xpath("//button[text()='ADD TO BAG']/ancestor::div[@class='hover-product-footer']/preceding-sibling::a/descendant::p[text()]")).getText();     // fetch text from line 76
		Assert.assertTrue(expectedProductName.contains(actualProductName), "Assertion is failed");
		System.out.println("product name is validated");

		String actualProductPrice = driver.findElement(By.xpath("//div[@class='is-flex']/descendant::span[text()='325']")).getText();
		String expectedProductPrice = "325";   // fetch price from line 76  for loop
		////p[text()='Olay Regenerist Retinol24 Night Serum 30ml' and @class='title']/ancestor::div[@class='bag-item is-flex has-fd-c has-jc-sb']/descendant::span[@class='white-card-price']/span/span
		Assert.assertTrue(expectedProductPrice.contains(actualProductPrice), "Assertion is failed");
		System.out.println("product price is validated");




	}
	//REFERENCE
//	private WebElement txtPrice(String productName){
	
//		String xpath="p[text()='"+productName+"' and @class='title']/ancestor::div[@class='bag-item is-flex has-fd-c has-jc-sb']/descendant::span[@class='white-card-price']/span/span";	
//		return driver.findElement(By.xpath(xpath));
//	}

}


