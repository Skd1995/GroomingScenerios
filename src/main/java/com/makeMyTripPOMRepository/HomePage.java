package com.makeMyTripPOMRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makeMyTripGenericUtility.MakeMyTripBaseClass;

public class HomePage {

	@FindBy(xpath = "//li[@data-cy='oneWayTrip']/span")
	private WebElement oneWayTripRadioBtn;

	@FindBy(xpath = "//li[@data-cy='roundTrip']/span")
	private WebElement roundTripRadioBtn;

	@FindBy(xpath = "//span[@class='langCardClose']")
	private WebElement closeBtn;

	@FindBy(xpath = "//span[text()='From']")
	private WebElement from;

	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement fromCityEnter;

	@FindBy(xpath = "//ul[@role='listbox']//div[@class='makeFlex hrtlCenter']")
	private List<WebElement> drpfromCitySuggestion;
	
	 

	@FindBy(xpath = "//span[text()='To']")
	private WebElement To;

	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement toCityEnter;

	@FindBy(xpath = "//ul[@role='listbox']//div[@class='makeFlex hrtlCenter']")
	private List<WebElement> drptoCitySuggestion;

	@FindBy(xpath = "//span[text()='DEPARTURE']")
	private WebElement Departure;

	@FindBy(xpath = "//span[text()='RETURN']")
	private WebElement Return;

	@FindBy(xpath = "//span[@aria-label='Next Month']")
	private WebElement nextMonthBtn;

	@FindBy(xpath = "//span[text()='Travellers & CLASS']")
	private WebElement Travellers;

	@FindBy(xpath = "//li[contains(@data-cy,'adults') and text()='2']")
	private WebElement selectAdults;

	@FindBy(xpath = "//button[ text()='APPLY']")
	private WebElement applyBtn;

	@FindBy(xpath = "//a[ text()='Search']")
	private WebElement searchBtn;
	
	



	//constructor initialize
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//methods
	public void clkOneWayTripRadioBtn()
	{
		oneWayTripRadioBtn.click();
	}
	public WebElement getOneWayTripRadioBtn() {
		return oneWayTripRadioBtn;
	}

	public void setOneWayTripRadioBtn(WebElement oneWayTripRadioBtn) {
		this.oneWayTripRadioBtn = oneWayTripRadioBtn;
	}

	public WebElement getRoundTripRadioBtn() {
		return roundTripRadioBtn;
	}

	public void setRoundTripRadioBtn(WebElement roundTripRadioBtn) {
		this.roundTripRadioBtn = roundTripRadioBtn;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}

	public void setCloseBtn(WebElement closeBtn) {
		this.closeBtn = closeBtn;
	}

	public WebElement getFrom() {
		return from;
	}

	public void setFrom(WebElement from) {
		this.from = from;
	}

	public WebElement getFromCityEnter() {
		return fromCityEnter;
	}

	public void setFromCityEnter(WebElement fromCityEnter) {
		this.fromCityEnter = fromCityEnter;
	}


	public List<WebElement> getDrptoCitySuggestion() {
		return drptoCitySuggestion;
	}
	
	public List<WebElement> getDrpfromCitySuggestion() {
		return drptoCitySuggestion;
	}
	public List<WebElement> frmCitySuggestion(){
		return drpfromCitySuggestion;
	}

	

	public WebElement getTo() {
		return To;
	}

	public void setTo(WebElement to) {
		To = to;
	}

	public WebElement getToCityEnter() {
		return toCityEnter;
	}

	public void setToCityEnter(WebElement toCityEnter) {
		this.toCityEnter = toCityEnter;
	}


	public WebElement getReturn() {
		return Return;
	}

	public WebElement getDeparture() {
		return Departure;
	}
	public WebElement getTravellers() {
		return Travellers;
	}

	public void setDeparture(WebElement departure) {
		Departure = departure;
	}

	public WebElement getNextMonthBtn() {
		return nextMonthBtn;
	}

	public void setNextMonthBtn(WebElement nextMonthBtn) {
		this.nextMonthBtn = nextMonthBtn;
	}

	

	public void setTravellers(WebElement travellers) {
		Travellers = travellers;
	}

	public WebElement getSelectAdults() {
		return selectAdults;
	}

	public void setSelectAdults(WebElement selectAdults) {
		this.selectAdults = selectAdults;
	}

	public WebElement getApplyBtn() {
		return applyBtn;
	}

	public void setApplyBtn(WebElement applyBtn) {
		this.applyBtn = applyBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(WebElement searchBtn) {
		this.searchBtn = searchBtn;
	}

	public void clkRoundTripRadioBtn()
	{
		roundTripRadioBtn.click();
	}


	public void clkCloseBtn()
	{
		closeBtn.click();
	}

	public void clkFromDrp()
	{
		from.click();
	}
	public void fromCity()
	{
		fromCityEnter.sendKeys("Bengaluru");
		from.click();
	}
	

	public void clkToDrp()
	{
		To.click();
	}
	public void toCity()
	{
		toCityEnter.sendKeys("Mumbai");
		To.click();
	}

	public void clkOnDeparture()
	{
		Departure.click();
	}
	public void getclkOnDeparture()
	{
		Departure.click();
	}
	public void clkOnReturn()
	{
		Return.click();
	}
	public void getclkOnReturn()
	{
		Return.click();
	}


	public void clkOnNextMonthBtn()
	{
		nextMonthBtn.click();
	}

	public void clkOnTravellers()
	{
		Travellers.click();
	}
	public void getclkOnTravellers()
	{
		Travellers.click();
	}
	public void clkOnSelectAdults()
	{
		selectAdults.click();
	}
	public void clkOnApplyBtn()
	{
		applyBtn.click();
	}
	public void clkOnSearchBtn()
	{
		searchBtn.click();
	}


	public WebElement waitToCity ()
	{
		return toCityEnter;
	}



}
