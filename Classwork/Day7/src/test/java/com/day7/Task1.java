package com.day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {
  @Test
  public void Task() {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions co=new ChromeOptions();
	  co.addArguments("--remote-allow-origins=*");
	  WebDriver driver= new ChromeDriver(co);
	  driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
	  String actTit=driver.getTitle();
	  String expecTit="Guest Registration Form - User Registration";
	  Assert.assertEquals(actTit, expecTit);
  }
}
