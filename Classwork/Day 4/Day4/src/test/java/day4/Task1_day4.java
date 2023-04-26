package day4;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.*;
import java.lang.Thread;

public class Task1_day4{
	public static void main(String args[]) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions co= new EdgeOptions();
		WebDriver driver=new EdgeDriver(co);
		JavascriptExecutor js=(JavascriptExecutor)driver;

		
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		
		
		WebElement fname= driver.findElement(By.id("input-firstname"));
		WebElement lname= driver.findElement(By.id("input-lastname"));
		WebElement email= driver.findElement(By.id("input-email"));
		WebElement pword= driver.findElement(By.id("input-password"));
		WebElement radio= driver.findElement(By.xpath("//*[@id=\"input-newsletter-yes\"]"));
		
		
		
		fname.sendKeys("Not Firstname");
		lname.sendKeys("Not Lastname");
		email.sendKeys("notemail@gmail.com");
		pword.sendKeys("notpassword");

		js.executeScript("window.scrollBy(0,500)","");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		radio.click();	
	}
}