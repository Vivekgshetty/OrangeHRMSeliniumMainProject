package com.myinfo;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class AdminPage {
    private WebDriver driver;
    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminTab;
 
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;
 
    @FindBy(xpath = "//label[text()='User Role']/following::div[1]//div[contains(@class,'oxd-select-text')]")
    private WebElement userRoleDropdown;
 
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;
 
    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement usernameInput;
 
    @FindBy(xpath = "//label[text()='Status']/following::div[1]//div[contains(@class,'oxd-select-text')]")
    private WebElement statusDropdown;
 
    @FindBy(xpath = "//label[text()='Password']/following::input[1]")
    private WebElement passwordInput;
 
    @FindBy(xpath = "//label[text()='Confirm Password']/following::input[1]")
    private WebElement confirmPasswordInput;
 
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;
 
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    public void openAdmin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(adminTab));
        adminTab.click();
    }
 
    public void clickAdd() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }
 
    public void fillUserDetails(String empName, String username,
                                String password, String confirmPassword) {
 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(employeeNameInput));
 
        
        userRoleDropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@role='listbox']//span[text()='Admin']"))).click();
 
        
        employeeNameInput.sendKeys(empName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@role='listbox']//span[contains(text(),'" + empName + "')]"))).click();
 
       
        usernameInput.sendKeys(username);
 
        
        statusDropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@role='listbox']//span[text()='Enabled']"))).click();
 
        
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
    }
 
    public void saveUser() {
        saveButton.click();
        System.out.println("saved");
    }
}
 