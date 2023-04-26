package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task4_day5 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions co= new EdgeOptions();
		WebDriver driver=new EdgeDriver(co);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get("https://www.abhibus.com/bus-ticket-booking");
		Actions action=new Actions(driver);
		

		WebElement from=driver.findElement(By.id("source"));
		from.sendKeys("Coimbatore");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		from.sendKeys(Keys.ENTER);
		WebElement to=driver.findElement(By.id("destination"));
		to.sendKeys("Virudhunagar");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		to.sendKeys(Keys.ENTER);
		WebElement date=driver.findElement(By.id("datepicker1"));
		date.click();
		WebElement choice=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[7]/a"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		choice.click();
		WebElement seatbutt= driver.findElement(By.xpath("//*[@id=\"1503611029\"]/span"));
		seatbutt.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement seat= driver.findElement(By.xpath("//*[@id=\"O3-10ZZ\"]"));
		seat.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement board= driver.findElement(By.xpath("//*[@id=\"boardingpoint_id\"]/option[2]"));
		board.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement pay= driver.findElement(By.xpath("//*[@id=\"btnEnable1\"]"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pay.click();

		
	}

}
