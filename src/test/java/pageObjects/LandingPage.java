package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage{
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
		
	}
	
	// Buy ticket
	@FindBy(xpath="//a[contains(text(),'Buy Ticket')]")
	WebElement buyTicketLink;
	
	
	public void clickBuyTicket() {
		buyTicketLink.click();
	}
	
	
}


