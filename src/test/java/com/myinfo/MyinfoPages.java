package com.myinfo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyinfoPages {
		private WebDriver driver;
		
		@FindBy(xpath="//a[@class='oxd-main-menu-item active']")
		private WebElement myinfoClick;
		
		
		
		public MyinfoPages(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void myinfoClick() {
			myinfoClick.click();
		}
		
		public void myinfo() {
			myinfoClick();
			
			
		
		}		
	
}
