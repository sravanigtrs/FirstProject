package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class BookedPage extends TestBase{
	
	@FindBy(xpath="//td[text()='Booked Itinerary']")
	WebElement BookedPageLable;
	
	public BookedPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyBookedPageLabel() {
	return BookedPageLable.isDisplayed();
}
	public void selectOrderidCheckbox(String name) {
		driver.findElement(By.xpath("//input[contains(@value,'"+name+"')][contains(@class,'select_text') ]//parent::td[@bgcolor='#FFFFFF']//preceding-sibling::td//input[@type='checkbox']")).click();;

	}
	
}
