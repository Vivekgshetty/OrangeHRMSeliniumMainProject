package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
	private WebDriver driver;
	
	@FindBy(xpath ="//input[@placeholder='Username']")
	private WebElement usernameInput;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passWordInput;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	public LoginPages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterUsername(String username) {
		usernameInput.sendKeys(username);
	}
	public void enterPassword(String password) {
		passWordInput.sendKeys(password);
	}
	public void clickLogin() {
		loginButton.click();
	}
	public void login(String username,String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

}
