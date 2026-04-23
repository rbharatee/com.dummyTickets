package pageObjects.TicketBookingPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorrectionOptionElements {

	public CorrectionOptionElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// page Logo

	@FindBy(xpath = "//img[@class='navbar-logo-img navbar-logo-img-normal']")
	WebElement bookingPageLogo;

	// choose correct option all elements
	@FindBy(xpath = "//div[@id='opc-product-selection']//input[@type='radio']")
	List<WebElement> allOptions;

	// Coupon code

	@FindBy(xpath = "//a[@class='showcoupon']")
	WebElement coupon;
	@FindBy(xpath = "//input[@id='coupon_code']")
	WebElement couponCodeTxt;
	@FindBy(xpath = "//button[normalize-space()='Apply coupon']")
	WebElement applyCouponButton;	
	@FindBy(xpath="//span[@id='coupon-error-notice']")
	WebElement couponError;

	// ticket booking page logo

	public boolean logo() {
		boolean bookingpageLogo = bookingPageLogo.isDisplayed();
		return bookingpageLogo;
	}

	// all correct option
	// clicking all option

	public void selectAllCorrectOption() {
		for (WebElement option : allOptions) {
			option.click();
		}
	}

	// all correct option
	// Total number of radio button
	public int countTotalRadioButton() {
		return allOptions.size();
	}

	// all correct option
	// Returning selected radio button count

	public int getSelectedCount() {
		int count = 0;

		for (WebElement option : allOptions) {
			if (option.isSelected()) {
				count++;
			}
		}
		return count;
	}

	// coupon code

	public void clickCouponCode() {
		coupon.click();
	}

	public void enterCouponCode() {
		couponCodeTxt.sendKeys("arc254");
	}

	public void clickApplyCoupon() {
		applyCouponButton.click();
	}
	
	public String getCouponErrorMessage() {
		String error=couponError.getText();
		return error;
	}

}
