package Interactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) {
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://calculator.net");
		driver.manage().window().maximize();
		WebElement accept = driver.findElement(By.name("button"));
		accept.click();
		WebElement single = driver.findElement(By.xpath(".//*[@id='hl1']/li[7]/a"));
		WebElement doubles = driver.findElement(By
				.xpath(".//*[@id='sciout']/tbody/tr[2]/td[1]/div/div[1]/span[2]"));
		WebElement right = driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a"));
		Actions act = new Actions(driver);
		act.contextClick(right).doubleClick(doubles).click(single).build().perform();
	}
}
