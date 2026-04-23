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
		driver = setup();
		data = new ReadData();
		
	     // initialize page objects
		option = new CorrectionOptionElements(driver);
		details = new PassengerDetails(driver);
		
		LandingPage home = new LandingPage(driver);

		home.clickBuyTicket();
		Assert.assertEquals(driver.getTitle(), data.getTicketBookingPageTitle());
		System.out.println("Ticket booking page:  " + driver.getTitle() + "\n");

	}

	// Booking page logo verify
	@Test(dependsOnMethods = "clickBookingLink")
	public void verifyLogo() {
	
		boolean logoDisplayed = option.logo();
		Assert.assertEquals(true, logoDisplayed);
		System.out.println("Booking page logo displayed:  " + logoDisplayed + "\n");

	}

	// Choosing correct option
	@Test(dependsOnMethods = "clickBookingLink")

	public void selectRadioButton() {
		
		option.selectAllCorrectOption();
		int actualSelectedRadioButton = option.getSelectedCount();// total radio button selected count
		int totalRadioButton = option.countTotalRadioButton();// total number of radio button available
		System.out.println("Total number of radio button available:  " + totalRadioButton);

		// validation- only one radio button selected.
		Assert.assertEquals(1, actualSelectedRadioButton);
		System.out.println("Number of redio button selected at time:  " + actualSelectedRadioButton + "\n");

	}

	// Coupon code
	@Test(dependsOnMethods = "clickBookingLink")
	public void addCouponCode() {

		option.clickCouponCode();
		option.enterCouponCode();
		option.clickApplyCoupon();
		String actualMessage = option.getCouponErrorMessage();

		// getting error message from property file
		String expectedMessage = data.getCouponErrorMessage();
		Assert.assertEquals(actualMessage, expectedMessage, expectedMessage);
		System.out.println("Coupon Error message:   " + actualMessage + "\n");
	}

	// Passenger Details
	@Test(dependsOnMethods = "clickBookingLink")
	public void enterPassengerDetails() {
		//details = new PassengerDetails(driver);
		details.enterFirstName();
		details.enterLastName();

		// date of birth
		details.clickDOB();
		details.clickYearDropdown();
		details.selectYear();
		details.clickMothDropdown();
		details.selectMonth();
		details.selectDate();

	}

	// sex

	@Test(dependsOnMethods = "enterPassengerDetails")
	public void selectSex() {
		
		details.selectMaleOption();
		Assert.assertTrue(details.isMaleSelected(),"Male option is selected after clicking");
		Assert.assertFalse(details.isFemaleSelected(),"Female option is should not be selected");

		details.selectFemaleOption();
		Assert.assertTrue(details.isFemaleSelected(),"Female option is selected after clicking");
		Assert.assertFalse(details.isMaleSelected(),"Male option should  not be selected");

	}

	// add more passengers(Optional)
	@Test(dependsOnMethods = "enterPassengerDetails")
	public void selectOptionalPassenger(){

		details.clickCheckBox();
		boolean displays = details.isDropdownDisplays();

		// isDropdown display validation
		// Assert.assertEquals(displays, true);
		Assert.assertTrue(displays);
		System.out.println("Add more passengers dropdown displays:  " + displays);

		details.clickOptionalDropdown();
		details.selectDropDown("add 1 more passenger (100%)");

	}

	// Second passenger details

	@Test(dependsOnMethods = "selectOptionalPassenger")
	public void secondPassengerDetails() {
		details.enterSecondPassengerFirtName("Sally");

		// date of birth
		details.clickDOB2();
		details.clickYearDropdown2();
		details.selectYear2();
		details.clickMothDropdown2();
		details.selectMonth2();
		details.selectDate2();

		// throw new SkipException("Skipping because condition met");

	}

}
