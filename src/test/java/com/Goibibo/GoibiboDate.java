package com.Goibibo;

import org.testng.annotations.Test;

import com.GoibiboGenericUtility.GoibiboBaseClass;
import com.GoibiboGenericUtility.GoibiboJavaUtility;


import GoibiboPOMRepository.Homepage;

public class GoibiboDate extends GoibiboBaseClass{
	@Test
	public void demo() throws InterruptedException {
		Homepage homepage = new Homepage(driver);
		GoibiboJavaUtility javautility = new GoibiboJavaUtility();
		
		
		homepage.clkOnDeparture();
		javautility.date(driver,"January 2023","19");
		
//		homepage.clkOnDoneBtn();
//		Thread.sleep(3000);
		homepage.clkOnReturn();
		javautility.returnDate(driver,"February 2023","21");
		homepage.clkOnDoneBtn();
		
		homepage.clkOntravellersDoneBtn();
		homepage.TxtDepartureDate("19", "January", "2023");
		homepage.TxtReturnDate("21", "February", "2023");
	}

}
