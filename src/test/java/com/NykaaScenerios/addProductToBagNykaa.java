package com.NykaaScenerios;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addProductToBagNykaa{
	public static void main(String[] args) throws InterruptedException {

		// Launching the browser and Maximize the window
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Enter the URL of Nykaa
		driver.get("https://www.nykaa.com/");

		// Click on Category
		driver.findElement(By.id("category")).click();

		// page scroll down to Best Sellers
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Bestsellers = driver.findElement(By.xpath("//div[text()='Bestsellers']"));
		js.executeScript("arguments[0].scrollIntoView();", Bestsellers);

		// Click on First Product
		driver.findElement(By.xpath("//div[text()='Bestsellers']/ancestor::div/descendant::div[@class='width-limiter']")).click();

		// Click on Add to Bag
		driver.findElement(By.xpath("//div[@class='css-1x9oqpp']/descendant::button[@class=' css-12z4fj0']")).click();

		// Click on Cart Button
		driver.findElement(By.xpath("//button[@type='button']")).click();

		// Switch to frame
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='button' and @class='back-btn']")).click();
		try {
			Actions action = new Actions(driver);
			WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));

			// Move to Brands
			action.moveToElement(brands).build().perform();
		} catch (StaleElementReferenceException e) {

		}

		// Click on Lakme		
		driver.findElement(By.xpath("//li[.='*']/parent::div[@class='brandsSorting']/preceding-sibling::div//a[text()='Lakme']")).click();
		js.executeScript("window.scrollBy(0,400)");

		//scroll to category => Makeup => Face => Foundation
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Makeup']")).click();
		driver.findElement(By.xpath("//span[text()='Face']")).click();
		driver.findElement(By.xpath("//span[text()='Foundation']")).click();
        
		// Print all Products Names
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='css-xrzmfa']"));
		System.out.println("********* List of Product are *********");
		int count=0;
		for (int i=0; i<=ele.size()-1; i++) {
			String products = ele.get(i).getText();
			count++;
			System.out.println(products);
			
		}
		System.out.println("no of prducts are "+count);

		// Switch to child window
		driver.findElement(By.xpath("//div[@class='css-jtn0l5']")).click();
		Thread.sleep(2000);
		Set<String> childwindow = driver.getWindowHandles();
		for (String i : childwindow) {
			driver.switchTo().window(i);
			if (driver.getTitle().contains("Lakme Absolute Skin")) {
				js.executeScript("window.scrollBy(0,200)");
				Thread.sleep(2000);

				// Enter PIN code
				driver.findElement(By.xpath("//input[@placeholder='Enter pincode']")).sendKeys("560017");

				// Click on check
				driver.findElement(By.xpath("//button[@class='css-1mqke1m']")).click();
				Thread.sleep(2000);

				// Click on Add to Bag
				driver.findElement(By.xpath("//div[@class='css-1x9oqpp']/descendant::button[@class=' css-12z4fj0']")).click();
				Thread.sleep(2000);

				// Click on Cart
				driver.findElement(By.xpath("//button[@type='button']")).click();

				System.out.println("=========================================");
				System.out.println("Product Successfully added to Cart");
			}
		}	
	}
}
