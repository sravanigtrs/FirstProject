package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;





public class HomePage extends TestBase {
	
	
	@FindBy(id="location")
	WebElement location;
	
	@FindBy(id="hotels")
	WebElement hotels;
	@FindBy(id="room_type")
	WebElement roomType;
	
	@FindBy(id="room_nos")
	WebElement numberOfRooms;
	
	@FindBy(id="adult_room")
	WebElement AdultsPerRoom;
	
	@FindBy(id="child_room")
	WebElement childerenPerRoom;
	
	@FindBy(xpath="//input[@id='Submit']")
	WebElement searchBtn;
	
	@FindBy(id="radiobutton_0")
	WebElement selectBtn;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="last_name")
	WebElement lastName;
	
	@FindBy(id="address")
	WebElement billingAdrs;
	
	@FindBy(id="cc_num")
	WebElement creditNumber;
	
	@FindBy(id="cc_type")
	WebElement creditType;
	
	@FindBy(id="cc_exp_month")
	WebElement expiryMonth;
	
	@FindBy(id="cc_exp_year")
	WebElement expiryYear;
	
	@FindBy(id="cc_cvv")
	WebElement ccvNum;
	
	
   @FindBy(id="book_now")
   WebElement booknowBtn;
   
   @FindBy(xpath="//td[text()='Booking Confirmation ']")
   
   WebElement bookingConfirmationLabel;
	
	
	@FindBy(xpath="//input[@value='Hello sravanigtrs!']")
	WebElement username;
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	WebElement BookedPageLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean VerifyUsernameDisplay() {
		return username.isDisplayed();
		

	}
	
	public BookedPage BookedPageClick() {
		 BookedPageLink.click();
		return new BookedPage();
		 

	}
	
	public void verifyBookingHotel(String loctn,String hotel,String roomtyp,String numofrooms,String adultnum,String childrennum ) {
		TestUtil.selectByVisibleText(location,loctn);
		TestUtil.selectByVisibleText(hotels,hotel);
		TestUtil.selectByVisibleText(roomType,roomtyp);
		TestUtil.selectByVisibleText(numberOfRooms,numofrooms);
		TestUtil.selectByVisibleText(AdultsPerRoom,adultnum);
		TestUtil.selectByVisibleText(childerenPerRoom,childrennum);
		searchBtn.click();
		selectBtn.click();
		continueBtn.click();
		

	}
	
	
	
	
	

}
