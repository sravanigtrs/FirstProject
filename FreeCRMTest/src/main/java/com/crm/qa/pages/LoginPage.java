package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;



public class LoginPage extends TestBase {
	//Page Factory -- OR
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='Submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@class='logo']")
	WebElement AdactinLogo;
	
	@FindBy(xpath="//strong[contains(text(),'Go to Build 2 ')]")
	WebElement GoToBuild2;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean ValidateAdctinImage() {
		return AdactinLogo.isDisplayed();

	}
	public HomePage login(String us,String pw) {
		username.sendKeys(us);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage();//here login page is the landing page of HomePage so only return type is Homepage
		

	}
	
	
}
