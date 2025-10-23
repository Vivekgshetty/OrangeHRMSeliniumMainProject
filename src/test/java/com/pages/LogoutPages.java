package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPages {
	private WebDriver driver;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement userDropdown;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement userLogout;
	
	public LogoutPages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickDropdown() {
		userDropdown.click();
	}
	public void clickLogout() {
		userLogout.click();
	}
	public void logout() {
		clickDropdown();
		clickLogout();
	}

}
