package GoibiboPOMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Homepage {
	@FindBy(xpath = "//span[text()='Departure']")
	private WebElement Departure;
	
	@FindBy(xpath = "//p[text()=' Click to add a return flight for better discounts']")
	private WebElement Return;
	
	@FindBy(xpath = "//span[@aria-label='Next Month']")
	private WebElement nxtMonth;
	
	
	@FindBy(xpath = "//span[text()='Done']")
	private WebElement Done;
	
	@FindBy(xpath = "//a[text()='Done']")
	private WebElement travellersDone;
	
	
	@FindBy(xpath = "//span[text()='Departure']/parent::div/p")
	private WebElement txtDepartureDate;
	
	
	//constructor initialize
		public Homepage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public void clkOnDeparture()
		{
			Departure.click();
		}
		public void clkOnReturn()
		{
			Return.click();
		}
		public void clkOnNxtMonth()
		{
			nxtMonth.click();
		}
		public void clkOnDoneBtn() throws InterruptedException
		{
			Done.click();
//			Thread.sleep(2000);
//			Assert.assertTrue(month1.contains(getTxtDepartureDate()), "validation is failed");
//			System.out.println("departure date validated");
			
		}
//		public void TxtDepartureDate()
//		{
//			 txtDepartureDate.getText();
//		}
		public String getTxtDepartureDate() {
			return txtDepartureDate.getText();
		}

		public void setTxtDepartureDate(WebElement txtDepartureDate) {
			this.txtDepartureDate = txtDepartureDate;
		}
		
		

		public void clkOntravellersDoneBtn()
		{
			travellersDone.click();
		}
		public void TxtDepartureDate(String date, String month, String year)
		{
//			"January 2023"
//			"19 Jan'23"
			String actualDate = txtDepartureDate.getText();
			String expDate = date+" "+month.substring(0, 3)+"'"+year.substring(2);
			Assert.assertTrue(expDate.contains(actualDate), "validation is failed");
			System.out.println("validation passed");
			System.out.println(actualDate);
			System.out.println(expDate);
					}
}
