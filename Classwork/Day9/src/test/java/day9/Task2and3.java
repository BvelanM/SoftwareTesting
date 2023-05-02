package day9;

import org.testng.annotations.Test;

import com.google.common.base.Verify;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Task2and3 {
	   @Test
	   public void Testcase01() {
	 	  WebDriverManager.chromedriver().setup();
	 	    ChromeOptions ed= new ChromeOptions();
	 	WebDriver driver=new ChromeDriver(ed);
	 	  driver.get("https://www.godaddy.com");
	 	  driver.manage().window().maximize();
	 	  Assert.assertEquals(driver.getTitle(),"Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN");
	 	  Assert.assertEquals(driver.getCurrentUrl(),"https://www.godaddy.com/en-in" );
	   }
	   @Test
	   public void Testcase02() {
		 	  WebDriverManager.chromedriver().setup();
	 	    ChromeOptions ed= new ChromeOptions();
	 	   WebDriver driver=new ChromeDriver(ed);
	 	  driver.get("https://www.godaddy.com");
	 	  driver.manage().window().maximize();
	 	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 	  
	 	  driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button")).click();
	 	  try {
	 		Thread.sleep(2000);
	 	} catch (InterruptedException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	      driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul/li[2]/a")).click();
	   }
	   @Test
	   public void Testcase03() {
		 	  WebDriverManager.chromedriver().setup();
	 	    ChromeOptions ed= new ChromeOptions();
	 	   WebDriver driver=new ChromeDriver(ed);
	 	  driver.get("https://www.godaddy.com");
	 	  driver.manage().window().maximize();
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
	 		Thread.sleep(4000);
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
	 }
