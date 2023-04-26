package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task5_day4 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions co= new EdgeOptions();
		WebDriver driver=new EdgeDriver(co);
		driver.get("https://j2store.net/free/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String cURL=driver.getCurrentUrl();
		if (cURL.equals("https://j2store.net/free/")) {
			System.out.println("Validate URL : Passed");
		}
		WebElement clothing=driver.findElement(By.xpath("//*[@id=\"Mod112\"]/div/div/ul/li[1]/h4/a"));
		clothing.click();
		String cURL2=driver.getCurrentUrl();
		if (cURL2.equals("https://j2store.net/free/index.php/shop?filter_catid=11")) {
			System.out.println("Validate URL : Passed");
		}
	}

}
