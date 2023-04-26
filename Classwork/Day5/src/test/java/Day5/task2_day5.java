package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task2_day5 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions co= new EdgeOptions();
		WebDriver driver=new EdgeDriver(co);
		JavascriptExecutor js=(JavascriptExecutor)driver;

		
		driver.get("https://jqueryui.com/droppable/");
		Actions action=new Actions(driver);
		driver.switchTo().frame(0);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement dragbox=driver.findElement(By.id("draggable"));
		WebElement dropbox=driver.findElement(By.id("droppable"));

		action.dragAndDrop(dragbox, dropbox).build().perform();
	}

}
