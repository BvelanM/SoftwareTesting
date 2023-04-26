package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4_day4 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions co= new EdgeOptions();
		WebDriver driver=new EdgeDriver(co);
		co.addArguments("--remote-allow-origins=*");
		driver.navigate().to("https://j2store.net/free/");
		driver.manage().window().maximize();
		WebElement clothing=driver.findElement(By.xpath("//*[@id=\"Mod112\"]/div/div/ul/li[1]/h4/a"));
		clothing.click();
		driver.manage().window().maximize();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.close();

	}

}
