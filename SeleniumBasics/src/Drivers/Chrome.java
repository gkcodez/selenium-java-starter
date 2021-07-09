package Drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\DATA\\Work\\Automation\\Selenium\\References\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.debenhams.com");
		System.out.println("Debenhams site opened in chrome");
		driver.findElement(By.cssSelector("input[id^=substring-def]"));
	}
}