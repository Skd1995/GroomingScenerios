package com.MyntraScenerios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class printTextOfElements {
	public static void main(String[] args) throws InterruptedException {

		// Launching the browser and Maximize the window
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wb = new WebDriverWait(driver, 10l);

		// Enter the URL of Myntra
		driver.get("https://www.myntra.com/");
		
		
		// Mouse over on elements
		Actions action = new Actions(driver);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='desktop-navLink']"));
		for (WebElement a : elements)
			
			{
			wb.until(ExpectedConditions.visibilityOfAllElements(elements));
				action.moveToElement(a).build().perform();
				
	    
	 // Fetching the text of each element
	 	List<WebElement> eleList = driver.findElements(By.xpath("//div[@class='desktop-paneContent']"));
	 	for (int i=0; i<=eleList.size()-1; i++) 
	 	    {
	 			String products = eleList.get(i).getText();
	 			System.out.println(products);
	 	    }
			}
	}
}

	 			
		
	