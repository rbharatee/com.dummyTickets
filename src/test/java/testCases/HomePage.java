package testCases;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.LandingPage;
import utilities.ReadData;

public class HomePage extends BaseClass {

	WebDriver driver;

	@Test(priority=1)
	public void validateHomePageTitle() throws IOException {

		driver = setup();
		String actualTitle = driver.getTitle();

		ReadData data = new ReadData();
		String ExpectedTitle = data.getHomePageTitle();

		// validating home page
		Assert.assertEquals(actualTitle, ExpectedTitle);

	}

	@Test(priority=2)
	public void clickBookingLink() {
		LandingPage home = new LandingPage(driver);
		home.clickBuyTicket();
	

	}

}
