package com.GoibiboGenericUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GoibiboPOMRepository.Homepage;

public class GoibiboJavaUtility {
	@Test
	public void date(WebDriver driver,String month1, String day1) throws InterruptedException {
		Homepage homepage = new Homepage(driver);
		for (;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month1+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day1+"']")).click();
				break;
			} catch (Exception e) {
				homepage.clkOnNxtMonth();
				
			}
		}
		Thread.sleep(2000);
//		Assert.assertTrue(month1.contains(homepage.getTxtDepartureDate()), "validation is failed");
		System.out.println(homepage.getTxtDepartureDate());
//		"January 2023"
//		"19 Jan'23"
		//Substring

	}
	public void returnDate(WebDriver driver,String month2,String day2) {
		Homepage homepage = new Homepage(driver);
		for (;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month2+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day2+"']")).click();
				break;
			} catch (Exception e) {
				homepage.clkOnNxtMonth();
				
			}
		}

	}

}
