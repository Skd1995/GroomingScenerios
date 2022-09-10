package com.makeMyTripGenericUtility;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTripJavaUtility  {
	//public WebDriver driver ;



	public void date(WebDriver driver) {
		String month = "October 2022";

		String day = "7";

		for (;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month+"']/../..//p[text()='"+day+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}

	}

	public void returnDate(WebDriver driver) {
		String month = "December";
		String year = "2022";

		String day = "20";

		for (;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month+"']/..//span[text()='"+year+"']/../../..//p[text()='"+day+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}

	}
}
