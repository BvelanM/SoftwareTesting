package Day5;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task5_day5 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions co= new EdgeOptions();
		WebDriver driver=new EdgeDriver(co);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//Window1
		driver.get("https://google.com");
		driver.manage().window().maximize();
		WebElement bar=driver.findElement(By.name("q"));
		bar.sendKeys("Apple");
		bar.sendKeys(Keys.ENTER);
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		//Window2
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://google.com");
		driver.manage().window().maximize();
		WebElement bar2=driver.findElement(By.name("q"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bar2.sendKeys("Selenium");
		bar2.sendKeys(Keys.ENTER);
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		//Window3
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://google.com");
		driver.manage().window().maximize();
		WebElement bar3=driver.findElement(By.name("q"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bar3.sendKeys("Cucumber");
		bar3.sendKeys(Keys.ENTER);
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		
	}

}
