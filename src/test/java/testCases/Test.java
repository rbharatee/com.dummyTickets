package testCases;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import utilities.ReadData;


public class Test {

	public static void main(String[] args) throws Exception {
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.dummyticket.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Buy Ticket')]")).click();
		
		List<WebElement> options= driver.findElements(By.xpath("//div[@id='opc-product-selection']//li/label"));
	//driver.findElement(By.xpath("//ul[@id='checkout-products']/li[5]")).click();
		
		for(WebElement option:options) {
			System.out.println(option.getText());
			option.click();
			boolean radioButtonSelected= option.isSelected();
			

		}
			
	
		
		
		
		
		

	}

}
