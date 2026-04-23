package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {
	private Properties prop;

	public ReadData() throws IOException {

		prop = new Properties();
		String filePath = System.getProperty("user.dir") + "/src/test/resources/properties/data.properties";

		try (FileInputStream file = new FileInputStream(filePath)) {
			prop.load(file);
		}

		// getting properties value
	}

	public String getBrowserName() {
		String browser = prop.getProperty("BrowserName");
		System.out.println("Browser name: " + browser);
		return browser;
	}

	public String getUrl() {
		String url = prop.getProperty("Url");
		System.out.println("URL:  " + url);
		return url;

	}
	// home page title
	public String getHomePageTitle() {
		String homePageTitle= prop.getProperty("HomePageTitle");
		System.out.println("Home page title:  "+homePageTitle);
		return homePageTitle;
	}
	// booking page title
	public String getTicketBookingPageTitle() {
		String bookingPageTitle= prop.getProperty("TicketBookingPageTitle");
		System.out.println("Home page title:  "+bookingPageTitle);
		return bookingPageTitle;
	}
	
	// coupon error code
	public String getCouponErrorMessage() {
		String couponErrorMessage=prop.getProperty("CouponErrorMessage");
		return couponErrorMessage;
	}
}
