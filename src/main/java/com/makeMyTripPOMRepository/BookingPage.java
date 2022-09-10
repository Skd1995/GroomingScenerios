package com.makeMyTripPOMRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {
	

	@FindBy(xpath = "//button[text()='+ ADD NEW ADULT']")
	private WebElement addAdultBtn;
	
	
	@FindBy(xpath = "//span[text()='ADULT  1']/parent::label/following-sibling::div[@class='AdultFormWrapper collapse show']/descendant::input[@placeholder='First & Middle Name']")
	private WebElement firstAndMiddleName1;
	
	@FindBy(xpath = "//span[text()='ADULT  1']/parent::label/following-sibling::div[@class='AdultFormWrapper collapse show']/descendant::input[@placeholder='Last Name']")
	private WebElement lastName1;
	
	@FindBy(xpath = "//span[text()='ADULT  2']/parent::label/following-sibling::div[@class='AdultFormWrapper collapse show']/descendant::input[@placeholder='First & Middle Name']")
	private WebElement firstAndMiddleName2;
	
	@FindBy(xpath = "//span[text()='ADULT  2']/parent::label/following-sibling::div[@class='AdultFormWrapper collapse show']/descendant::input[@placeholder='Last Name']")
	private WebElement lastName2;
	
	@FindBy(xpath = "//span[text()='ADULT  1']/parent::label/following-sibling::div[@class='AdultFormWrapper collapse show']/descendant::span[text()='MALE']/parent::label")
	private WebElement selectMale1;
	
	@FindBy(xpath = "//span[text()='ADULT  2']/parent::label/following-sibling::div[@class='AdultFormWrapper collapse show']/descendant::span[text()='MALE']/parent::label")
	private WebElement selectMale2;
	

	@FindBy(xpath = "//span[text()='ADULT  1']")
	private WebElement adult1drp;
	
	@FindBy(xpath = "//span[text()='ADULT  2']")
	private WebElement adult2drp;
	
	
	
	@FindBy(xpath = "//input[@placeholder='Mobile No']")
	private WebElement mobNo;
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement email;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueBtn;
	
	
	@FindBy(xpath = "//span[text()='ADULT  1']/preceding-sibling::span/span/span")
	private WebElement adult1chkbox;
	
	
	@FindBy(xpath = "//span[text()='ADULT  2']/preceding-sibling::span/span/span")
	private WebElement adult2chkbox;

	
	@FindBy(xpath = "//b[text()='Yes, Secure my trip. ']/ancestor::label/span")
	private WebElement securechkbox;
	
	//constructor initialize
		public BookingPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		public WebElement getAdult1chkbox() {
			return adult1chkbox;
		}
		public void setAdult1chkbox(WebElement adult1chkbox) {
			this.adult1chkbox = adult1chkbox;
		}
		public WebElement getAdult2chkbox() {
			return adult2chkbox;
		}
		public void setAdult2chkbox(WebElement adult2chkbox) {
			this.adult2chkbox = adult2chkbox;
		}
		public void clkAddAdultBtn(WebDriver driver)
		{
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", addAdultBtn);

		}
		public void enterFirstAndMiddleName1()
		{
			firstAndMiddleName1.sendKeys("Sanjay Kumar");
		}
		public void enterLastName1()
		{
			lastName1.sendKeys("Das");
		}
		public void clkOnSelectMale1()
		{
			selectMale1.click();
		}
		public void clkOnSelectMale2()
		{
			selectMale2.click();
		}
		public void clkOnSecureChkBox()
		{
			securechkbox.click();
		}
		
		public WebElement getAddAdultBtn() {
			return addAdultBtn;
		}
		public void setAddAdultBtn(WebElement addAdultBtn) {
			this.addAdultBtn = addAdultBtn;
		}
		public void enterFirstAndMiddleName2()
		{
			firstAndMiddleName2.sendKeys("Manoj Kumar");
		}
		public void enterLastName2()
		{
			lastName2.sendKeys("Das");
		}
		
		public WebElement getSelectMale1() {
			return selectMale1;
		}
		public void setSelectMale1(WebElement selectMale1) {
			this.selectMale1 = selectMale1;
		}
		public WebElement getSelectMale2() {
			return selectMale2;
		}
		public void setSelectMale2(WebElement selectMale2) {
			this.selectMale2 = selectMale2;
		}
		public void enterMobNo()
		{
			mobNo.sendKeys("8787865444");
		}

		public void enterEmail()
		{
			email.sendKeys("skd@gmail.com");
		}
		public void clkOnContinueBtn()
		{
			continueBtn.click();
		}
		public void clkOnadult1ChekBox()
		{
			adult1chkbox.click();
		}
		public void clkOnadult2ChekBox()
		{
			adult2chkbox.click();
		}
		
		
		public WebElement adult1Drpdown()
		{
			return adult1drp;
		}
		public WebElement getAdult1drp() {
			return adult1drp;
		}
		public WebElement adult2Drpdown()
		{
			return adult2drp;
		}
		public WebElement getAdult2drp() {
			return adult2drp;
		}
		public WebElement getFirstAndMiddleName2() {
			return firstAndMiddleName2;
		}
		public void setFirstAndMiddleName2(WebElement firstAndMiddleName2) {
			this.firstAndMiddleName2 = firstAndMiddleName2;
		}
		public WebElement getLastName2() {
			return lastName2;
		}
		public void setLastName2(WebElement lastName2) {
			this.lastName2 = lastName2;
		}
		public WebElement getMobNo() {
			return mobNo;
		}
		public void setMobNo(WebElement mobNo) {
			this.mobNo = mobNo;
		}
		public WebElement getContinueBtn() {
			return continueBtn;
		}
		public void setContinueBtn(WebElement continueBtn) {
			this.continueBtn = continueBtn;
		}
		public void setAdult2drp(WebElement adult2drp) {
			this.adult2drp = adult2drp;
		}
		public void setAdult1drp(WebElement adult1drp) {
			this.adult1drp = adult1drp;
		}

}
