package Interactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextBox {

	public static void main(String[] args) {
		String home = "http://calculator.net/";
		String i = "56";
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.get(home);
		driver.navigate().to(home);
		driver.findElement(By.name("button")).click();
		driver.findElement(By.partialLinkText("Percentage")).click();
		WebElement input = driver.findElement(By.id("cpar1"));
		input.sendKeys(i);
		String result = input.getAttribute("value");
		System.out.println("The first value is " + result);
		// driver.close();
	}
}
