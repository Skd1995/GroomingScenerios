package INTERVIEW;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class phpTravels {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://phptravels.com/");
		driver.findElement(By.xpath("//nav[@class='clearfix']/a[text()='Pricing']")).click();
		Thread.sleep(4000);
		List<WebElement> allplans = driver.findElements(By.xpath("//div[@class='card wow fadeInUp animated']/descendant::div[@class='plan-type']"));
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='plan-type']/../descendant::div[@class='show-price yearly']/span[@class='money number']"));
		for(int i=0; i<allplans.size(); i++) {
//			String plans = e.getText();
//			System.out.println(plans);
			System.out.println(allplans.get(i).getText()+" => "+prices.get(i).getText());
		}
//		List<ArrayList<String>> plansList = new ArrayList<ArrayList<String>>();
//		for(int i=0; i<allplans.size(); i++)
//		{
//			
//		ArrayList<String> addplansprice = new ArrayList<String>();
//		addplansprice.add(allplans.get(i).getText());
//		addplansprice.add(prices.get(i).getText());
//		plansList.add(addplansprice);
//		}
//		for(int i=0; i<plansList.size(); i++) {
//			System.out.println(plansList.get(i));
//		}
	}

} 
