package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Task3 {
	WebDriver driver;
  @Test
  public void Case1() {
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

  @Parameters({ "browser" })
  @BeforeMethod()
  public void dum(String brow) {
	  if (brow.equals("edge")) {
		  EdgeOptions ed= new EdgeOptions();
		  driver=new EdgeDriver(ed);
	  }
	  else if (brow.equals("chrome")) {
	 	  WebDriverManager.chromedriver().setup();
	 	    ChromeOptions ed= new ChromeOptions();
	 	    driver=new ChromeDriver(ed);
	  }
	  else if (brow.equals("firefox")){
	 	    FirefoxOptions ed= new FirefoxOptions();
	 	 driver=new FirefoxDriver(ed);
	  }
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
