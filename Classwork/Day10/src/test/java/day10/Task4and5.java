package day10;

import java.awt.AWTError;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4and5 {
	static ExtentSparkReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest test;
	String loc="task4&5.png";
	  static WebDriver driver;
  @BeforeClass
  public void before() {
  	htmlReporter = new ExtentSparkReporter("extentReport2.html");
  	  extent = new ExtentReports();
  	  extent.attachReporter(htmlReporter);
 
  	  
  }
  @Test
  public void Case1() {
	  test = extent.createTest("Login OrangeHRM website with first dataset of login credentials");
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
      driver.close();
}
  @Test
  public void Case2() {
	  test = extent.createTest("Login OrangeHRM website with second dataset of login credentials");
	  try {
		Thread.sleep(4000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  WebElement uname=driver.findElement(By.name("username"));
      WebElement pword=driver.findElement(By.name("password"));
      WebElement submit=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
      
      uname.sendKeys("Suvitha");
      pword.sendKeys("12345");
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
  public void something(ITestResult result) throws AWTError, IOException, AWTException {
	  if (result.getStatus() == ITestResult.SUCCESS) {
          test.log(Status.PASS, result.getTestName());
	  }
	  else if (result.getStatus()==ITestResult.FAILURE) {
		  screencapture(loc);
          test.log(Status.FAIL,result.getThrowable());
          test.addScreenCaptureFromPath(loc);
	  }
	  else if (result.getStatus()==ITestResult.SKIP) {
	        test.log(Status.SKIP, result.getTestName());
	  }
	  extent.flush();
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
  void screencapture(String loc) throws AWTError, IOException, AWTException
  {
	   Robot robot;
	   robot = new Robot();
       Dimension scr_size=Toolkit.getDefaultToolkit().getScreenSize();
       Rectangle rect=new Rectangle(scr_size);
       BufferedImage scrshot=robot.createScreenCapture(rect);
       File dest=new File(loc);
       ImageIO.write(scrshot,"png",dest);
  }
}
