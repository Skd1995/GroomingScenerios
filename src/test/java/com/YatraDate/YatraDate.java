package com.YatraDate;

import org.testng.annotations.Test;

import com.YatraGenericUtility.YatraBaseClass;
import com.YatraPOMRepository.Homepage;






public class YatraDate extends YatraBaseClass {
	@Test
	public void demo() {
		Homepage homepage = new Homepage(driver);
		homepage.clkOncookies();
		homepage.clkOnDepartureDate();
	}

}
