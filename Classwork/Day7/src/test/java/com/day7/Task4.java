package com.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 { 
    static WebDriver driver;
	
	@BeforeSuite
  public static void Drive() {
	    EdgeOptions ed= new EdgeOptions();
		driver=new EdgeDriver(ed);
		}
	@Test
	public void dotsuff() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize()	;
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
	@Test(dependsOnMethods = "dotsuff")
    void distuff() throws InterruptedException {	
		WebElement profile=driver.findElement(By.className("oxd-userdropdown-name"));
		profile.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement logout=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a"));
		logout.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        String expecturl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String curl=driver.getCurrentUrl();
        Assert.assertEquals(expecturl, curl);
	}
	@AfterSuite
	public void teardown() {
		driver.close();
	}
}
