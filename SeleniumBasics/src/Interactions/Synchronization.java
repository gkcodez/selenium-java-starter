package Interactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Synchronization {

	public static void main(String[] args) throws InterruptedException {
		String link = "http://www.calculator.net";
		WebDriver driver;
		driver = new FirefoxDriver();
		Thread.sleep(3000); // Static wait for 5 seconds
		driver.manage().window().maximize();
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Implicit
																			// wait
																			// for
																			// 30
																			// seconds
		WebElement accept = driver.findElement(By.name("button"));
		accept.click();
	}
}
