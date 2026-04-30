package testCases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import pageObjects.LandingPage;
import pageObjects.TicketBookingPage.CorrectionOptionElements;
import pageObjects.TicketBookingPage.PassengerDetails;
import utilities.ReadData;

public class BookingPageTest extends BaseClass {

	WebDriver driver;
	CorrectionOptionElements option;
	PassengerDetails details;
	ReadData data;

	// Clicking booking page from Home page
	@Test()
	public void clickBookingLink() throws IOException {
		logger.info("Starting BookingPageTest: clickBookingLink");

		driver = setup();
		data = new ReadData();

		// initialize page objects
		logger.info("Initializing page objects for BookingPageTest");

		option = new CorrectionOptionElements(driver);
		details = new PassengerDetails(driver);

		LandingPage home = new LandingPage(driver);
		home.clickBuyTicket();

		logger.info("Clicked on booking link, now validating booking page title");
		try {
			Assert.assertEquals(driver.getTitle(), data.getTicketBookingPageTitle());
			System.out.println("Ticket booking page:  " + driver.getTitle() + "\n");

		} catch (AssertionError e) {

			logger.error("Booking page title validation failed", e);
			throw e; // rethrow to mark the test as failed
		}
	}

	// Booking page logo verify
	@Test(dependsOnMethods = "clickBookingLink")
	public void verifyLogo() {
		logger.info("Starting BookingPageTest: verifyLogo");

		boolean logoDisplayed = option.logo();

		logger.info("Checking if booking page logo is displayed");

		Assert.assertEquals(true, logoDisplayed);
		System.out.println("Booking page logo displayed:  " + logoDisplayed + "\n");
		logger.info("BookingPageTest: verifyLogo completed successfully");
	}

	// Choosing correct option
	@Test(dependsOnMethods = "clickBookingLink")

	public void selectRadioButton() {
		logger.info("Starting BookingPageTest: selectRadioButton");

		option.selectAllCorrectOption();

		int actualSelectedRadioButton = option.getSelectedCount();// total radio button selected count
		int totalRadioButton = option.countTotalRadioButton();// total number of radio button available
		System.out.println("Total number of radio button available:  " + totalRadioButton);

		// validation- only one radio button selected.
		logger.info("Validating that only one radio button is selected");

		try {
			Assert.assertEquals(1, actualSelectedRadioButton);
			System.out.println("Number of redio button selected at time:  " + actualSelectedRadioButton + "\n");
			logger.info("BookingPageTest: selectRadioButton completed successfully");

		} catch (AssertionError e) {

			logger.error("Radio button selection validation failed", e);
			throw e; // rethrow to mark the test as failed
		}

	}

	// Coupon code
	@Test(dependsOnMethods = "clickBookingLink")
	public void addCouponCode() {
		logger.info("Starting BookingPageTest: addCouponCode");

		option.clickCouponCode();
		option.enterCouponCode();
		option.clickApplyCoupon();

		String actualMessage = option.getCouponErrorMessage();

		// getting error message from property file
		String expectedMessage = data.getCouponErrorMessage();

		logger.info("Validating coupon error message");

		try {
			Assert.assertEquals(actualMessage, expectedMessage, expectedMessage);
			System.out.println("Coupon Error message:   " + actualMessage + "\n");
			logger.info("BookingPageTest: addCouponCode completed successfully");

		} catch (AssertionError e) {

			logger.error("Coupon error message validation failed", e);
			throw e; // rethrow to mark the test as failed
		}
	}

	// Passenger Details
	@Test(dependsOnMethods = "clickBookingLink")
	public void enterPassengerDetails() {
		logger.info("Starting BookingPageTest: enterPassengerDetails");

		// details = new PassengerDetails(driver);
		details.enterFirstName();
		details.enterLastName();

		// date of birth
		details.clickDOB();
		details.clickYearDropdown();
		details.selectYear();
		details.clickMothDropdown();
		details.selectMonth();
		details.selectDate();

		logger.info("BookingPageTest: enterPassengerDetails completed successfully");

	}

	// sex

	@Test(dependsOnMethods = "enterPassengerDetails")
	public void selectSex() {
		logger.info("Starting BookingPageTest: selectSex");

		details.selectMaleOption();
		logger.info("Validating Male option is selected");

		try {
			Assert.assertTrue(details.isMaleSelected(), "Male option is selected after clicking");
			Assert.assertFalse(details.isFemaleSelected(), "Female option is should not be selected");

		} catch (AssertionError e) {
			logger.error("Only Male is selected validation failed", e);
		}

		details.selectFemaleOption();
		logger.info("Validating Female option is selected");

		try {
			Assert.assertTrue(details.isFemaleSelected(), "Female option is selected after clicking");
			Assert.assertFalse(details.isMaleSelected(), "Male option should  not be selected");
			logger.info("BookingPageTest: selectSex completed successfully");

		} catch (AssertionError ex) {

			logger.error("Only Female is selected validation failed", ex);
		}
	}

	// add more passengers(Optional)
	@Test(dependsOnMethods = "enterPassengerDetails")
	public void selectOptionalPassenger() {
		logger.info("Starting BookingPageTest: selectOptionalPassenger");

		details.clickCheckBox();
		boolean displays = details.isDropdownDisplays();

		// isDropdown display validation
		// Assert.assertEquals(displays, true);
		Assert.assertTrue(displays);
		System.out.println("Add more passengers dropdown displays:  " + displays);

		details.clickOptionalDropdown();
		details.selectDropDown("add 1 more passenger (100%)");
		logger.info("BookingPageTest: selectOptionalPassenger completed successfully");
	}

	// Second passenger details

	@Test(dependsOnMethods = "selectOptionalPassenger")
	public void secondPassengerDetails() {
		logger.info("Starting BookingPageTest: secondPassengerDetails");
		details.enterSecondPassengerFirtName("Sally");

		// date of birth

		details.clickDOB2();
		details.clickYearDropdown2();
		details.selectYear2();
		details.clickMothDropdown2();
		details.selectMonth2();
		details.selectDate2();

		// throw new SkipException("Skipping because condition met");
		logger.info("BookingPageTest: secondPassengerDetails completed successfully");

	}

}
