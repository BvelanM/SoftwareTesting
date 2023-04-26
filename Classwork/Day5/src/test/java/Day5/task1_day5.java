package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task1_day5 {

	public static void main(String[] args) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions co= new EdgeOptions();
			WebDriver driver=new EdgeDriver(co);
			JavascriptExecutor js=(JavascriptExecutor)driver;

			
			driver.get("https://demoqa.com/droppable/");
			WebElement dragbox=driver.findElement(By.id("draggable"));
			WebElement dropbox=driver.findElement(By.id("droppable"));
			Actions action= new Actions(driver); 
			action.dragAndDrop(dragbox, dropbox).build().perform();
	}

}
