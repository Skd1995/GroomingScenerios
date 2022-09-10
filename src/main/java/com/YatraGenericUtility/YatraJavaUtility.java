package com.YatraGenericUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.YatraPOMRepository.Homepage;



public class YatraJavaUtility {
	@Test
	public void date(WebDriver driver,String month1, String day1) throws InterruptedException {
		Homepage homepage = new Homepage(driver);
		for (;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month1+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day1+"']")).click();
				break;
			} catch (Exception e) {
//				homepage.clkOnNxtMonth();
				
			}
		}
	}

}
