package com.myinfo;
 
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
 
import java.time.Duration;
 
public class DeleteUserPage {
    private WebDriver driver;
 
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    private WebElement deleteIcon;
 
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement confirmDeleteButton;
 
    public DeleteUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    public void deleteUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        wait.until(ExpectedConditions.elementToBeClickable(deleteIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
    }
}

 
 