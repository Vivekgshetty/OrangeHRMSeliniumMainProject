package com.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
	protected static WebDriver driver;
	public String baseUrl=ReadConfig.readPropertyFileData("baseUrl", "config");
	public String userName=ReadConfig.readPropertyFileData("userName", "config");
	public String password=ReadConfig.readPropertyFileData("password", "config");

  @BeforeMethod
  @Parameters("browser")
  public void setUp(String browserName) {
	  
	 switch(browserName.toLowerCase()) {
	 case"chrome":
		 driver=new ChromeDriver();
		 break;
	 case"firefox":
		 driver=new FirefoxDriver();
		 break;
	 case"edge":
		 driver=new EdgeDriver();
		 break;
      default:
    	  throw new IllegalArgumentException(browserName);
		 
	 }
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get(baseUrl);
  }

  @AfterMethod
  public void tearDown() {
	  if(driver != null) {
//		  driver.quit();
	  }
  }
  
  public WebDriver getDriver() {
	  return driver;
  }
}
