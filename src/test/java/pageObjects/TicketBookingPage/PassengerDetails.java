package pageObjects.TicketBookingPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassengerDetails {

	WebDriver driver;

	public PassengerDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Passenger details

	@FindBy(xpath = "//input[@id='travname']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='travlastname']")
	WebElement lastName;

	// Date of birth date picker
	WebElement dateOfBirth;
	@FindBy(xpath = "(//input[@id='dob'])[1]")
	WebElement datOfBirth;

	// year selection
	@FindBy(xpath = "//select[@aria-label='Select year']")
	WebElement yearDropdown;
	@FindBy(xpath = "//select[@aria-label='Select year']//option[@value='1990']")
	WebElement year;

	// month selection
	@FindBy(xpath = "//select[@aria-label='Select month']")
	WebElement monthDropdown;
	@FindBy(xpath = "//select[@aria-label='Select month']//option[@value='7']")
	WebElement month;

	// date selection)
	@FindBy(xpath = "//a[normalize-space()='8']")
	WebElement date;

	// sex
	@FindBy(xpath = "//input[@id='sex_1']")
	WebElement male;
	@FindBy(xpath = "//input[@id='sex_2']")
	WebElement female;

	// add more passenger optional
	@FindBy(xpath = "//input[@id='addmorepax']")
	WebElement checkBox;

	// drop down
	@FindBy(xpath = "//span[@id='select2-addpaxno-container']")
	WebElement optionalDropdown;

	// all drop down
	@FindBy(xpath = "//ul[@id='select2-addpaxno-results']//li")
	List<WebElement> allDropDown;
	
	// 2nd passenger details
	@FindBy(xpath="//input[@id='travname2']")
	WebElement secondPassengerName;
	@FindBy(xpath="//input[@id='travlastname2']")
	WebElement secondPassengerLastName;
	
	// date of birth date picker
	
	// date of birth picker
	@FindBy(xpath="//input[@id='dob2']")
	WebElement dateOfBirth2;
		
	//year drop down 
	@FindBy(xpath="//select[@aria-label='Select year']")
	WebElement yearDropdown2;
	//year selection
	@FindBy(xpath="//option[@value='1975']")
	WebElement year2;
	
	//month dropdown
	@FindBy(xpath="//select[@aria-label='Select month']")
	WebElement monthDropdown2;
	//month
	@FindBy(xpath="//option[@value='10']")
	WebElement month2;

	//date
	@FindBy(xpath="//a[normalize-space()='26']")
	WebElement date2;
	
	
	
	
	
	
	// ================================

	// Passenger details

	public void enterFirstName() {
		firstName.sendKeys("John"); // add random name
	}

	public void enterLastName() {
		lastName.sendKeys("Smith"); // add random name
	}

	// DOB

	public void clickDOB() {
		datOfBirth.click();
	}

	public void clickYearDropdown() {
		yearDropdown.click();
	}

	public void selectYear() {
		year.click();
	}

	public void clickMothDropdown() {
		monthDropdown.click();
	}

	public void selectMonth() {
		month.click();
	}

	public void selectDate() {
		date.click();
	}

	// sex

	public void selectMaleOption() {
		male.click();

	}
	
	public boolean isMaleSelected() {
	    return male.isSelected();
	}

	public void selectFemaleOption() {
		female.click();

	}

	public boolean isFemaleSelected() {
	    return female.isSelected();
	}

	// add more passenger optional
	public void clickCheckBox() {
		if (!checkBox.isSelected()) {
			checkBox.click();
		}

	}

	// optional drop down
	public boolean isDropdownDisplays() {
		boolean dropdown = optionalDropdown.isDisplayed();
		return dropdown;

	}

	public void clickOptionalDropdown() {
		optionalDropdown.click();
	}


	public void selectDropDown(String value) {
		for (WebElement dropdown : allDropDown) {
			if (dropdown.getText().equalsIgnoreCase(value)) {

				dropdown.click();
				System.out.println("Dopdown menu selected:  " + value+"\n");
				break;

			}

		}
	}
	
	// Second passenger's details
	
	public void enterSecondPassengerFirtName(String firstName) {
		secondPassengerName.sendKeys(firstName);
	}
	
	public void enterSecondPassengerLastName(String lastName) {
		secondPassengerLastName.sendKeys(lastName);
	}
	
	//date of birth
	
	public void clickDOB2() {
		dateOfBirth2.click();
	}
	
	//Year
	public void clickYearDropdown2() {
		yearDropdown2.click();
	}
	
	public void selectYear2() {
		year2.click();
	}
	
	//Moth
	
	public void clickMothDropdown2() {
		monthDropdown2.click();
	}

	public void selectMonth2() {
		month2.click();
	}

	public void selectDate2() {
		date2.click();
	}

	
	
	
	
	
	
	
	
	
	
	

}
