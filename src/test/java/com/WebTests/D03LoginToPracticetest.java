package com.WebTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class D03LoginToPracticetest {
	WebDriver driver;
  @Test(dataProvider = "getLoginData" , dataProviderClass = com.DataSet.ReadData.class)
  public void login(String un, String ps) {
	  driver.findElement(By.id("username")).sendKeys(un);
	  driver.findElement(By.id("password")).sendKeys(ps);
	  driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	  
	  
  }
  @AfterMethod
  public void afterMethod() {
	  if (driver.getCurrentUrl().equals("https://practicetestautomation.com/logged-in-successfully/"))
		{
		  System.out.println("login successful");
			driver.findElement(By.partialLinkText("Log")).click();
			
		}
  }

  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://practicetestautomation.com/practice-test-login/");
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
