package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3_day4 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions co= new EdgeOptions();
		WebDriver driver=new EdgeDriver(co);
		JavascriptExecutor js=(JavascriptExecutor)driver;

		
		driver.get("https://demo.opencart.com/index.php?route=checkout/voucher&language=en-gb");

	    WebElement rName=driver.findElement(By.xpath("//*[@id=\"input-to-name\"]"));
	    WebElement rEmail=driver.findElement(By.xpath("//*[@id=\"input-to-email\"]"));
	    WebElement name=driver.findElement(By.xpath("//*[@id=\"input-from-name\"]"));
	    WebElement email=driver.findElement(By.xpath("//*[@id=\"input-from-email\"]"));
	    WebElement giftTheme=driver.findElement(By.xpath("//*[@id=\"input-theme-6\"]"));
	    WebElement msg=driver.findElement(By.xpath("//*[@id=\"input-message\"]"));
	    WebElement amount=driver.findElement(By.xpath("//*[@id=\"input-amount\"]"));
	    WebElement check=driver.findElement(By.xpath("//*[@id=\"form-voucher\"]/div[8]/div/div/input"));
	    
	    rName.sendKeys("Manik");
	    rEmail.sendKeys("manik@alive.com");
	    name.sendKeys("Baasha");
	    email.sendKeys("baasha@dead.com");
	    
	    js.executeScript("window.scrollBy(0,500)", "");
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    
	    giftTheme.click();
	    msg.sendKeys("Yo Yo Yo");
	    amount.clear();
	    amount.sendKeys("100");
	    check.click();
	    
	}

}
