package Interactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton {

	public static void main(String[] args) {
		String link = "http://www.calculator.net/mortgage-payoff-calculator.html";
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement accept = driver.findElement(By.name("button"));
		accept.click();
		WebElement radio = driver.findElement(By.id("cpayoff1"));
		radio.click();
		if (radio.isSelected()) {
			System.out.println("Payoff altogether radio button is selected");
		}
	}
}
