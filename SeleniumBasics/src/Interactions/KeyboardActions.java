package Interactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		String home = "http://calculator.net/";
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.get(home);
		driver.navigate().to(home);
		driver.findElement(By.name("button")).click();
		WebElement link = driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a"));
		Thread.sleep(3000);
		Actions move = new Actions(driver);
		Action actionseries = move.moveToElement(link).click().build();
		actionseries.perform();
	}
}
