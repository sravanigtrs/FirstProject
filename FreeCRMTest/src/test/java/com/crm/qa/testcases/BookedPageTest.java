package com.crm.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BookedPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class BookedPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	BookedPage bookedPage;
	public BookedPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage=new LoginPage();
		bookedPage=new BookedPage();
		homePage=new HomePage();
	    homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		bookedPage=homePage.BookedPageClick();

	}

	@Test(priority=1)
	public void verifyBookedItineraryLabelTest() {
		boolean flag = bookedPage.VerifyBookedPageLabel();
		Assert.assertTrue(flag);

	}
	
	/*@Test(priority=2)
	public void selectOrderidCheckboxTest() {
		bookedPage.selectOrderidCheckbox("E6E741AX46");
		bookedPage.selectOrderidCheckbox("PPP05ZYYW5");

	}
	*/
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
	
	
	
	
	
}
