package Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewTab {

	WebDriver driver;
	WebElement body = driver.findElement(By.tagName("body"));

	@Test
	public void newtab() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		body.sendKeys(Keys.chord(Keys.CONTROL, "t"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void newwindow() {
		body.sendKeys(Keys.chord(Keys.CONTROL, "n"));
	}
}
