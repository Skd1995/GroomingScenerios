package com.MyntraScenerios;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class searchTshirts {
	@Test
	public void searchTxt() throws InterruptedException{

		// To handle Notification Pop-up
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");

		// Launching the browser and Maximize the window
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wb = new WebDriverWait(driver, 10l);

		// Enter the URL of Myntra
		driver.get("https://www.myntra.com/");

		WebElement searchBar = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		searchBar.sendKeys("Tshirts");
		WebElement searchInput = driver.findElement(By.xpath("//input[@value='Tshirts']"));
		System.out.println(searchInput.getAttribute("value"));
		Assert.assertEquals("Tshirts", searchInput.getAttribute("value"));
		System.out.println("validated");

		WebElement dropDown = driver.findElement(By.xpath("//li[text()='Tshirts For Men']"));
		dropDown.click();

		WebElement Roadster = driver.findElement(By.xpath("//label[text()='Roadster' ]"));
		wb.until(ExpectedConditions.elementToBeClickable(Roadster));
		Roadster.click();
		
		WebElement waitElement1 = driver.findElement(By.xpath("//ul[@class='filter-summary-filterList']/li[1]"));
		wb.until(ExpectedConditions.visibilityOf(waitElement1));
		WebElement Blue = driver.findElement(By.xpath("//label[text()='Blue']"));
		wb.until(ExpectedConditions.elementToBeClickable(Blue));
		Blue.click();
		WebElement waitElement2 = driver.findElement(By.xpath("//ul[@class='filter-summary-filterList']/li[2]"));
		wb.until(ExpectedConditions.visibilityOf(waitElement2));
		WebElement Discount = driver.findElement(By.xpath("//label[text()='40% and above']"));
		wb.until(ExpectedConditions.elementToBeClickable(Discount));
		Discount.click();
		WebElement waitElement3 = driver.findElement(By.xpath("//ul[@class='filter-summary-filterList']/li[3]"));
		wb.until(ExpectedConditions.visibilityOf(waitElement3));
		
		

		// Fetching the text of Rating 4.1
		List<WebElement> Rating = driver.findElements(By.xpath("//ul[@class='results-base']//span[text()='4.1']/ancestor::li/descendant::h3[@class='product-brand']"));
		int count=0;
		wb.until(ExpectedConditions.visibilityOfAllElements(Rating));
		for (int i=0; i<=Rating.size()-1; i++) 
		{
			
			String names = Rating.get(i).getText();
			count++;
			System.out.println(names);
			System.out.println(count);
		}
		// click on 1st product
		List<WebElement> product =driver.findElements(By.xpath("//li[@class='product-base']"));
		wb.until(ExpectedConditions.visibilityOfAllElements(product));
		product.get(0).click();

		// switch to child window
		Set<String> childwindow = driver.getWindowHandles();
		for (String i : childwindow) {
			driver.switchTo().window(i);
			if (driver.getTitle().contains("Buy The Roadster Lifestyle")) {
				
				// validate Roadster Page
				String actualPageTitle = driver.getTitle();
				System.out.println(driver.getTitle());
				String expectedPageTitle = "Buy The Roadster Lifestyle Co Men Blue Striped Cotton Pure Cotton T Shirt - Tshirts for Men 9972927 | Myntra";
				Assert.assertTrue(actualPageTitle.contains(expectedPageTitle), "title is failed");
				System.out.println("Roadster Page validated");
				
				//click on XL
				WebElement size =driver.findElement(By.xpath("//div[@class='size-buttons-tipAndBtnContainer']/div/button/p[text()='XL']"));
				wb.until(ExpectedConditions.elementToBeClickable(size));
				size.click();

				// click on add to bag
				driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();
				System.out.println("product added to bag");

				// click on go to bag
				driver.findElement(By.xpath("//span[text()='GO TO BAG']")).click();
				System.out.println("item successfully selected");
				
				String selectedSize = driver.findElement(By.xpath("//span[contains(.,'XL')]")).getText();
				String actualSize = "XL";
				Assert.assertTrue(selectedSize.contains(actualSize), "incorrect size");
				System.out.println("XL size validated");

				// validate SHOPPING BAG	
				String actualTitle = driver.getTitle();
				String expectedTitle = "SHOPPING BAG";
				Assert.assertTrue(actualTitle.contains(expectedTitle), "title is failed");
				System.out.println("SHOPPING BAG Page validated");
				
			}
		}
	}
}
			
