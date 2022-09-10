package BlueStoneScenerios;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class firstScenerio {
	@Test
	public void orderRing() throws InterruptedException {

		// To handle Notification Pop-up
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");

		// Launching the browser and Maximize the window
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wb = new WebDriverWait(driver, 10l);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Launch the given Application URL
		driver.get("https://www.bluestone.com/");
		Reporter.log("Application URL is Launched Successfully", true);

		// Mouseover on Rings
		Actions act = new Actions(driver);
		WebElement Rings = driver.findElement(By.xpath("//li[@class='menuparent repb']/a[@title='Rings']"));
		act.moveToElement(Rings).perform();
		String expectedRingTxt = Rings.getText();
		String ActualRingTxt = "Rings";
		Assert.assertTrue(expectedRingTxt.equalsIgnoreCase(ActualRingTxt));
		System.out.println("Mouseover on Rings validated");

		// Click on Plain Gold
		WebElement filterRings = driver.findElement(By.xpath("//a[@title='Gold Rings' and text()='Plain Gold']"));
		wb.until(ExpectedConditions.visibilityOf(filterRings));
		String txtFilterRings = filterRings.getText();
		String clkPlainGold = "Plain Gold";
		filterRings.click();
		Assert.assertTrue(clkPlainGold.equalsIgnoreCase(txtFilterRings));
		System.out.println("Click on Plain Gold validated");

		// Mouseover on Price
		WebElement Price = driver.findElement(By.xpath("//span[text()='Price']"));
		String expectedPriceTxt = Price.getText();
		String ActualPriceTxt = "Price";
		wb.until(ExpectedConditions.visibilityOf(Price));
		act.moveToElement(Price).perform();
		Assert.assertTrue(expectedPriceTxt.equalsIgnoreCase(ActualPriceTxt));
		System.out.println("Mouseover on Price validated");

		// Click on 30k to 40k
		WebElement filterPrice = driver.findElement(By.xpath("//span[@data-displayname='rs 30000 to rs 40000']"));
		wb.until(ExpectedConditions.visibilityOf(filterPrice));
		String txtFilterPrice = filterPrice.getText();
		String clkPrice = "Rs. 30,000 - Rs. 40,000 (79)";
		wb.until(ExpectedConditions.elementToBeClickable(filterPrice));
		filterPrice.click();
		System.out.println(txtFilterPrice);
		Assert.assertTrue(clkPrice.contains(txtFilterPrice));
		System.out.println("Click on 30k to 40k validated");

		// Mouseover on Offers
		WebElement Offers = driver.findElement(By.xpath("//span[text()='Offers']"));
		String expectedOffersTxt = Offers.getText();
		String ActualOffersTxt = "Offers";
		wb.until(ExpectedConditions.visibilityOf(Offers));
		act.moveToElement(Offers).perform();
		Assert.assertTrue(expectedOffersTxt.equalsIgnoreCase(ActualOffersTxt));
		System.out.println("Mouseover on Offers validated");

		// Click on '10% Making Charge Off'
		WebElement Charge = driver.findElement(By.xpath("//span[@data-displayname='10% Making Charge Off']"));
		wb.until(ExpectedConditions.visibilityOf(Charge));	
		String makingcharge = Charge.getText();
		String expectedMakingcharge = " 10% Making Charge Off (69)";
		Charge.click();
		Assert.assertTrue(expectedMakingcharge.contains(makingcharge));
		System.out.println("Click on '10% Making Charge Off' validated");

		// Validation for filter Plain Gold Rings
		WebElement afterFilterRings = driver.findElement(By.xpath("//div[@class='filtered-data']/descendant::span[@class='filterDisplayName']"));
		wb.until(ExpectedConditions.visibilityOf(afterFilterRings));
		String txtAfterFilterRings = afterFilterRings.getText();
		Assert.assertEquals(txtAfterFilterRings, txtFilterRings);
		System.out.println("Rings filtered by Plain Gold");

		// Click on first product
		driver.findElement(By.xpath("//li[@data-position='1']")).click();

		// Switch to child window
		Set<String> childwindow = driver.getWindowHandles();
		for (String i : childwindow) {
			driver.switchTo().window(i);
			if (driver.getTitle().contains("The Morrigan Ring | BlueStone.com")) {

				// Enter your locality pincode in the Pincode Textfield
				String pincode = "560085";
				WebElement txtField = driver.findElement(By.xpath("//input[@id='getNearestStore']"));
				txtField.clear();
				txtField.sendKeys(pincode);
				driver.findElement(By.xpath("//div[text()='Update']")).click();
				String updatedPincode = driver.findElement(By.xpath("//span[@class='delivery-pincode']")).getText();

				// Validation Pincode
				Assert.assertEquals(updatedPincode, pincode);
				System.out.println("Pincode validated");
			}
		}

		// Click on Customize the Design
		driver.findElement(By.xpath("//h4/i[@class='icon-ion-ios-plus-empty']")).click();

		// Click on 14kt radio button
		driver.findElement(By.xpath("//span[@class='Yellow-purities metal-purities']/label/input[@type='radio' and @value='14']")).click();

		// Click on Ring Size dropdown
		driver.findElement(By.xpath("//span[@class='icon-ion-android-arrow-dropdown']")).click();

		// Click on size 8
		WebElement Size =driver.findElement(By.xpath("//ul[@id='sizeDropdown']/descendant::span[text()='8']"));
		wb.until(ExpectedConditions.visibilityOf(Size));	
		String actualSize=Size.getText();
		String expectedSize="8";
		Size.click();
		Assert.assertTrue(expectedSize.contains(actualSize));
		System.out.println("Click on size 8 validated");

		String expectedProductName = driver.findElement(By.xpath("//form/h1")).getText();
		String expectedProductPrice = driver.findElement(By.xpath("//span[@class='final-pd-price']")).getText();
		String expectedRingSize = driver.findElement(By.xpath("//span[@class='size-box-overlay']")).getText();

		// Click on Buy Now Button
		driver.findElement(By.xpath("//input[@id='buy-now']")).click();

		// Validation of product name
		String actualProductName = driver.findElement(By.xpath("//div[contains(@class,'product-title')]/a")).getText();
		Assert.assertEquals(actualProductName, expectedProductName);
		System.out.println("Product Name validated");

		// Validation of product Price
		String actualProductPrice = driver.findElement(By.xpath("//div[@class='new-price']/span[contains(@id,'total_quantity_price')]")).getText();
		Assert.assertEquals(actualProductPrice, expectedProductPrice);
		System.out.println("Product Price validated");

		// Validation of Ring Size
		String actualRingSize = driver.findElement(By.xpath("//span[contains(@class,'size-box-overlay size')]")).getText();
		Assert.assertEquals(actualRingSize, expectedRingSize);
		System.out.println("Ring Size validated");


	}
}
