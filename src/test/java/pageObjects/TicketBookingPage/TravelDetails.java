package pageObjects.TicketBookingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelDetails {
	
	public TravelDetails(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	// trip type
	
		@FindBy(xpath="//input[@id='traveltype_1']")
		WebElement oneWay;
		@FindBy(xpath="//input[@id='traveltype_2']")
		WebElement roundTrip;
		@FindBy(xpath="//input[@id='fromcity']")
		WebElement fromCity;
		@FindBy(xpath="//input[@id='tocity']")
		WebElement toCity;
		
		// Departure date drop down
		@FindBy(xpath="//input[@id='departon']")
		WebElement departureDate; 	
		
		//year
		@FindBy(xpath="//select[@aria-label='Select year']")
		WebElement depYearDropdown;
		@FindBy(xpath="//option[@selected='selected'][normalize-space()='2026']")//2026
		WebElement depYear;
		
		//month
		@FindBy(xpath="//select[contains(@aria-label,'Select month')]")
		WebElement depMonthDropdown;
		@FindBy(xpath="//select[@class='ui-datepicker-month']//option[text()='Sep']")
		WebElement depMonth;
		
		//date- 27th Sep
		@FindBy(xpath="//table[@class='ui-datepicker-calendar']//tbody//tr[5]//td[5]/a")
		WebElement depDate;
		
		
		//Return Drop down 
		@FindBy(xpath="//input[@id='returndate']")
		WebElement retrunDate;
		//year
		@FindBy(xpath="//select[@aria-label='Select year']")
		WebElement returnYearDropdown;
		@FindBy(xpath="//select[@aria-label='Select year']/option[1]")// 2026
		WebElement returnYear;
		
		//month
		@FindBy(xpath="//select[@aria-label='Select month']")
		WebElement returnMonthDropdown;
		@FindBy(xpath="//select[@aria-label='Select month']//option[text()='Nov']")
		WebElement returnMonth;
		
		// date
		@FindBy(xpath="//table[@class='ui-datepicker-calendar']//tbody//tr[3]//td[3]/a")
		WebElement retDate;
		
		// additional information
		@FindBy(xpath="//span[@id='select2-reasondummy-container']")
		WebElement additionalInfo;
		
		// Delivery options -drop down menu
		
		@FindBy(xpath="//p[@id='reasondummy_field']//b[contains(@role,'presentation')]")
		WebElement dropDown;
		@FindBy(xpath="//li[text()='Visa application']")
		WebElement applicationVisa;
		@FindBy(xpath="//li[text()=' Proof of return at airport']")
		WebElement proofReturnApt;
		@FindBy(xpath="//li[text()='Expedite passport renewal']")
		WebElement passportExpedite;
		@FindBy(xpath="//li[text()='Visa extension']")
		WebElement visaExtension;
		@FindBy(xpath="//li[text()='Office work place needs it']")
		WebElement officeWorkPlance;
		@FindBy(xpath="//li[text()='Prank a friend']")
		WebElement prankFriend;
		@FindBy(xpath="//li[text()='Other']")
		WebElement other;
		@FindBy(xpath="//li[text()='Prefer not to say']")
		WebElement preferNotToSay;
		@FindBy(xpath="//li[text()='Car rental']")
		WebElement carRental;
		
		// Ticket delivery method(Optional_
		@FindBy(xpath="//input[@id='deliverymethod_1']")
		WebElement email;
		@FindBy(xpath="//input[@id='deliverymethod_2']")
		WebElement whatsApp;
		@FindBy(xpath="//input[@id='deliverymethod_3']")
		WebElement both;
		
		
		// trip type
		
		public void selectOneway() {
			oneWay.click();
		}
		
		public void selectRoundTrip() {
			roundTrip.click();
		}
		
		public void selectOrigin() {
			fromCity.click();
		}
		
		public void selectDestination() {
			toCity.click();
		}
		
		public void selectDepartureDate() {
			departureDate.click();
		}
		// Departure date drop down
		
		public void selectReturnDate() {
			retrunDate.click();
		}
		
		
		
		
		
		
		
		
		
}
