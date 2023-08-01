package com.WebTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D02EchotrakLogin {
	WebDriver driver;
	 int i=1;
	
  @Test(dataProvider = "dp")
  public void f(String na, String ps) {
	 
	  driver.findElement(By.name("txtCustomerID")).sendKeys(na);
		driver.findElement(By.name("txtPassword")).sendKeys(ps);
		driver.findElement(By.name("Butsub")).click();
	 System.out.println("error msg fo "+i +":"+driver.findElement(By.id("lblMsg")).getText());
	
	
  }
  @BeforeMethod
  public void beforeMethod() {

  }

  @AfterMethod
  public void afterMethod() {
	  Assert.assertEquals(driver.findElement(By.id("lblMsg")).getText(), "Invalid Username/Password");
	  driver.findElement(By.name("txtCustomerID")).clear();
	  i++;
	
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "purvi panse", "pur@123" },
      new Object[] {"minakshi vyavahare", "mna@123" },
      new Object[] {"lalita Joshi", "la@123" },
      new Object[] {"Swati Neema", "Swa@123" },
    };
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	// driver = new EdgeDriver(); //2
	 /* ChromeOptions options = new ChromeOptions();// 3
		options.addArguments("--headless");//3
		driver = new ChromeDriver(options);*///3 Headless Browser: when u r 100% sure about code and don't want to see the execution 
		//EdgeOptions options = new EdgeOptions();// 4 for Edge
		//options.addArguments("--headless");//4
		//driver = new EdgeDriver(options);//4
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
	 
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
