package com.crm.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intialization();
		 loginPage=new LoginPage();
	}
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(title,"AdactIn.com - Hotel Reservation System");
}
	@Test(priority=2)
	public void AdctinLogoImageTest() {
		boolean flag = loginPage.ValidateAdctinImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//
//}


}
