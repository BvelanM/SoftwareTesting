package day4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task6_day {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions co= new EdgeOptions();
		WebDriver driver=new EdgeDriver(co);
		driver.get("https://j2store.net/free/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement clothing=driver.findElement(By.xpath("//*[@id=\"Mod112\"]/div/div/ul/li[1]/h4/a"));
		clothing.click();
		List<WebElement> items=driver.findElements(By.xpath("//*[@id=\"akeeba-renderjoomla\"]/div/div/div[1]/div/div/div/h2");
		for (int i=0;i<items.size();i++) {
			System.out.println(items.get(i).getText());
		}
	}

}
