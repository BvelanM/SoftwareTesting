package com.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 { 
   static EdgeOptions ed= new EdgeOptions();
    static WebDriver driver=new EdgeDriver(ed);
	
	@BeforeSuite
  public static void Drive() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize()	;
		}
	@Test
	public void dotsuff() {
             try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
             WebElement uname=driver.findElement(By.name("username"));
             WebElement pword=driver.findElement(By.name("password"));
             WebElement submit=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
             
             uname.sendKeys("Admin");
             pword.sendKeys("admin123");
             submit.click();
             
             String expecturl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
             String curl=driver.getCurrentUrl();
             Assert.assertEquals(expecturl, curl);
             try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
