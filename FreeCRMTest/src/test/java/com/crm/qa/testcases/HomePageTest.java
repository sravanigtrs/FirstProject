package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BookedPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	BookedPage bookedPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void validateHomePageTitle() {

		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "AdactIn.com - Search Hotel", "Home page title is matched");

	}

	@Test(priority = 2)
	public void verifyUserName() {
		boolean flag = homePage.VerifyUsernameDisplay();
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void bookedPageClickTest() {

		bookedPage = homePage.BookedPageClick();
	}

	@DataProvider
	public Object[][] bookingHotelData() {
		Object data[][] = TestUtil.getTestData("Booking_Hotel_Data");
		return data;

	}

	@Test(priority = 4, dataProvider = "bookingHotelData")
	public void verifyBookingHotelTest(String locationName, String hotels, String roomtyp, String roomcount,
			String adultcount, String childrencount) {

		homePage.verifyBookingHotel(locationName, hotels, roomtyp, roomcount, adultcount, childrencount);

	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//
//	}

}
