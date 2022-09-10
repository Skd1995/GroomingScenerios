package com.makeMyTripScenerios;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.makeMyTripGenericUtility.MakeMyTripBaseClass;
import com.makeMyTripGenericUtility.MakeMyTripJavaUtility;
import com.makeMyTripGenericUtility.makeMyTripWebDriverUtility;
import com.makeMyTripPOMRepository.BookingPage;
import com.makeMyTripPOMRepository.HomePage;
import com.makeMyTripPOMRepository.SearchPage;

public class RoundTrip extends MakeMyTripBaseClass {


	@Test
	public void roundTrip()  {

		HomePage homepage = new HomePage(driver);
		SearchPage searchpage = new SearchPage(driver);
		BookingPage bookingpage = new BookingPage(driver);
		makeMyTripWebDriverUtility webdriverutility = new makeMyTripWebDriverUtility();
		MakeMyTripJavaUtility javautility = new MakeMyTripJavaUtility();

		homepage.clkRoundTripRadioBtn();;
		webdriverutility.waitUntillElementVisible(driver,homepage.getCloseBtn());
		homepage.clkCloseBtn();
		homepage.getFrom().click();
		String City = "Bengaluru";
		homepage.getFromCityEnter().sendKeys(City);

		List<WebElement> list = homepage.frmCitySuggestion();
		for(int i=0; i<list.size(); i++)
		{
			String s = list.get(i).getText();
			if(s.contains(City)) {
				list.get(i).click();
			}
		}

		homepage.getTo().click();
		String toCity = "Kolkata";
		homepage.getToCityEnter().sendKeys(toCity);
		List<WebElement> list1 = homepage.getDrptoCitySuggestion();
		for(int j=0; j<list.size(); j++)
		{
			String s = list.get(j).getText();
			if(s.contains(toCity)) {
				list.get(j).click();
			}
		}


		webdriverutility.waitUntillElementClickable(driver, homepage.getReturn());
		homepage.clkOnReturn();
		javautility.returnDate(driver);


		webdriverutility.waitUntillElementClickable(driver, homepage.getTravellers());
		homepage.clkOnTravellers();
		homepage.clkOnSelectAdults();
		homepage.clkOnApplyBtn();
		homepage.clkOnSearchBtn();

		Set<String> childwindow = driver.getWindowHandles();
		for (String i : childwindow) {
			driver.switchTo().window(i);
			if (driver.getCurrentUrl().contains("search")) {	

				
				try {
					searchpage.clkOkayBtn();
					searchpage.clkBookNowBtn();
					searchpage.clkOnContinueBtn();
				} catch (Exception e) {
					searchpage.clkBookNowBtn();
					searchpage.clkOnContinueBtn();
				}


				Set<String> childwindow1 = driver.getWindowHandles();
				for (String j : childwindow1) {
					driver.switchTo().window(j);
					if (driver.getCurrentUrl().contains("reviewDetails")) {


						webdriverutility.scrollTillElement(driver,driver.findElement(By.xpath("//h2[text()='Traveller Details']")));
						bookingpage.clkAddAdultBtn(driver);
						bookingpage.clkOnadult1ChekBox();
						bookingpage.enterFirstAndMiddleName1();
						bookingpage.enterLastName1();

						bookingpage.clkOnSelectMale1();
						webdriverutility.waitUntillElementClickable(driver, bookingpage.getAdult1chkbox());

						webdriverutility.waitUntillElementClickable(driver, bookingpage.getAddAdultBtn());
						bookingpage.clkAddAdultBtn(driver);
						//wait for invisibility of adult1
						try {
							webdriverutility.waitUntillInVisible(driver, bookingpage.getAdult1drp());
						}catch(Exception e) {
						}

						try {
							webdriverutility.waitUntillElementVisible(driver, bookingpage.getAdult2drp());
						}catch(Exception e) {
						}

						bookingpage.clkOnadult2ChekBox();
						webdriverutility.waitUntillElementVisible(driver, bookingpage.getFirstAndMiddleName2());
						bookingpage.enterFirstAndMiddleName2();

						webdriverutility.waitUntillElementVisible(driver, bookingpage.getLastName2());
						bookingpage.enterLastName2();

						bookingpage.clkOnSelectMale2();
						webdriverutility.waitUntillElementClickable(driver, bookingpage.getAdult2chkbox());


						bookingpage.enterMobNo();
						bookingpage.enterEmail();
						webdriverutility.waitUntillElementClickable(driver, bookingpage.getContinueBtn());
						bookingpage.clkOnContinueBtn();
					}
				}
			}
		}
	}
}







