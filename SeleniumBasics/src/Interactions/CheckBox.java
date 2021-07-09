package Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		WebDriver driver;
		String link = "http://www.calculator.net";
		System.setProperty("webdriver.chrome.driver",
				"D:\\DATA\\Work\\Automation\\Selenium\\References\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(link);
		driver.findElement(By.partialLinkText("Mortgage")).click();
		WebElement check = driver.findElement(By.id("caddoptional"));
		check.click();
		if (check.isSelected()) {
			System.out.println("Checkbox is selected");
		} else {
			System.out.println("Checkbox is not selected");
		}
	}
}
