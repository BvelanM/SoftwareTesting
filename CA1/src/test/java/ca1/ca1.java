package ca1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ca1 {
	static WebDriver driver;
	static ChromeOptions co;
	@BeforeSuite
	public void openall() {
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions co=new ChromeOptions();
	}
  @Test
  public void cart() {
	  ChromeOptions co=new ChromeOptions();
	  driver=new ChromeDriver(co);
	  driver.get("https://www.amazon.in/?ref_=nav_signin&");
	  driver.manage().window().maximize();
	  driver.findElement(By.linkText("Best Sellers")).click();
	    driver.findElement(By.cssSelector("#B0BK1457X3 .p13n-sc-truncate-desktop-type2")).click();
	    driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]")).isDisplayed()) {
	    	System.out.println("Add to Cart button works");
	    	try {
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
	    	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	WebElement del=driver.findElement(By.xpath("//span[2]/span/input"));
	    	if(del.isEnabled()) {
	        del.click();
	        System.out.println("Delete button works");
	  	  driver.findElement(By.linkText("Best Sellers")).click();
		    driver.findElement(By.cssSelector("#B0BK1457X3 .p13n-sc-truncate-desktop-type2")).click();
		    driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	    	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
	    	driver.findElement(By.xpath("//*[@id=\"quantity_2\"]")).click();
	    		System.out.println("Update Button works");
	    		driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input")).click();
	    		try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		Assert.assertEquals(driver.getTitle(), "Select a delivery address");
	    		System.out.println("In Checkout page");
	    		if(driver.findElement(By.xpath("//*[@id=\"subtotals-marketplace-table\"]/tbody/tr[4]/td[2]")).isDisplayed()) {
	    			System.out.println("Total Price displayed");
	    		}
	    	}
	    	else {
		        System.out.println("Delete button doesnt work");
	    	}
	    }
	    else {
	    	System.out.println("Add to Cart button doesn't work");
	    }
	    driver.close();
  }
  @Test
  public void search() {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions co=new ChromeOptions();
	  driver=new ChromeDriver(co);
	  driver.get("https://www.amazon.in/?ref_=nav_signin&");
	  driver.manage().window().maximize();
	  WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
	  search.click();
	  search.sendKeys("Wallpaper");
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     search.sendKeys(Keys.ENTER);
     System.out.println("Search bar works");
     WebElement filterbutton = driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]"));
     filterbutton.click();
     driver.findElement(By.id("s-result-sort-select_2")).click();
     try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     List<WebElement> list=   driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div/div/div/div/div/div/div/div/div/h2/a/span"));
     for (int i=0;i<list.size();i++) System.out.println(list.get(i).getText());
  }
}
