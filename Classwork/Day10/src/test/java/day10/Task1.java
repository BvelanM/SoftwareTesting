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
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.base.Verify;

public class Task1{
    WebDriver driver;
    static ExtentTest test;
    static ExtentReports extent;
    ExtentSparkReporter htmlReporter;
    String loc="test.png";
    @BeforeClass
    public void before() {
    	htmlReporter = new ExtentSparkReporter("extentReport.html");
    	  extent = new ExtentReports();
    	  extent.attachReporter(htmlReporter);
    	  
    }
  @Test
  public void Testcase01() {
	    EdgeOptions ed= new EdgeOptions();
		driver=new EdgeDriver(ed);
	  driver.get("https://www.godaddy.com");
	  driver.manage().window().maximize();
	  test = extent.createTest("Open GoDaddy.com and validate it's Page Title");
	  Assert.assertEquals(driver.getTitle(),"Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN");
	  Assert.assertEquals(driver.getCurrentUrl(),"https://www.godaddy.com/en-in" );	  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  driver.close();
  }
  @Test
  public void Testcase02() {
	    EdgeOptions ed= new EdgeOptions();
		driver=new EdgeDriver(ed);
	  driver.get("https://www.godaddy.com");
	  driver.manage().window().maximize();
	  test = extent.createTest("Open GoDaddy.com and click on 'Domain Name Search'");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button")).click();
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul/li[2]/a")).click();
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     driver.close();
  }
  @Test
  public void Testcase03() {
	    EdgeOptions ed= new EdgeOptions();
		driver=new EdgeDriver(ed);
	  driver.get("https://www.godaddy.com");
	  driver.manage().window().maximize();
	  test = extent.createTest("Open GoDaddy.com and click on 'Domain Name Search' then search for an available domain name");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button")).click();
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul/li[2]/a")).click();
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  System.out.println(driver.getTitle());
	  if(driver.getTitle().equals("GoDaddy Domain Search - Buy and Register Available Domain Names")) {
		 WebElement search= driver.findElement(By.name("searchText"));
		 System.out.println(search.isDisplayed());
		 System.out.println(search.isEnabled());
		 WebElement buyit=driver.findElement(By.xpath("//*[@id=\"id-1467954b-c5e3-4b0c-9046-9fc94d8ca892\"]/section/div/div/section/div/div[1]/div/div/div[2]/button"));
		 System.out.println(buyit.isDisplayed());
		 System.out.println(buyit.isEnabled());
		 search.sendKeys("monkyhomie");
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 buyit.click();
		 try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[1]/span")).getText(),"EXACT MATCH");
		 Verify.verify((driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[4]/div/div/div/div[2]/button")).getText()).equals("Add to Cart"));
		 Verify.verify(driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div/div[1]/div[1]/div/span[1]/span")).isDisplayed());
		 }
	  else Assert.assertTrue(false);
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
  @AfterTest
  public void save() {
	  extent.flush();
  }
}
