package Interactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PercentageCalculation {

	public static void main(String[] args) {
		String home = "http://calculator.net/";
		String i = "0";
		String j = "5890";
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.get(home);
		driver.navigate().to(home);
		driver.findElement(By.name("button")).click();
		driver.findElement(By.partialLinkText("Percentage")).click();
		driver.findElement(By.id("cpar1")).sendKeys(i);
		driver.findElement(By.id("cpar2")).sendKeys(j);
		driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]"))
				.click();
		String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
		System.out.println(i + "% of " + j + " is " + result);
		// driver.close();
	}
}
