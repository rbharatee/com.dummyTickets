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
		logger.info("Starting HomePage test: validateHomePageTitle");
		driver = setup();
		String actualTitle = driver.getTitle();

		ReadData data = new ReadData();
		String ExpectedTitle = data.getHomePageTitle();

		// validating home page
		Assert.assertEquals(actualTitle, ExpectedTitle);
		logger.info("HomePage test: validateHomePageTitle completed successfully");
	}

	@Test(priority=2)
	public void clickBookingLink() {
		logger.info("Starting HomePage test: clickBookingLink");
		LandingPage home = new LandingPage(driver);
		home.clickBuyTicket();
		logger.info("HomePage test: clickBookingLink completed successfully");
	}

}
