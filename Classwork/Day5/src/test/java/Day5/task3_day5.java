package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task3_day5 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions co= new EdgeOptions();
		WebDriver driver=new EdgeDriver(co);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		Actions action=new Actions(driver);
		
		WebElement inpbox=driver.findElement(By.name("cusid"));
		WebElement submit=driver.findElement(By.name("submit"));
		
		inpbox.sendKeys("401");
		submit.click();
		driver.switchTo().alert().dismiss();
		inpbox.clear();
		inpbox.sendKeys("402");
		submit.click();
		driver.switchTo().alert().accept();
		System.out.println(driver.switchTo().alert().getText());
		

	}

}
