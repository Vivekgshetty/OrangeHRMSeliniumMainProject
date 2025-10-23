package com.myinfo;
 
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
 
import java.time.Duration;
 
public class EditUserPage {
    private WebDriver driver;
 
    @FindBy(xpath = "//i[@class='oxd-icon bi-pencil-fill']")
    private WebElement editIcon;
 
    @FindBy(xpath = "//label[text()='Status']/following::div[1]//div[contains(@class,'oxd-select-text')]")
    private WebElement statusDropdown;
 
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;
 
    public EditUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    public void editUserStatus(String newStatus) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(editIcon)).click();
 
        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']//span[text()='" + newStatus + "']"))).click();
 
        saveButton.click();
    }
}
 
 
 