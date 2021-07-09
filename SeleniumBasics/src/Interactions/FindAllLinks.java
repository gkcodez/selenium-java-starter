package Interactions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FindAllLinks {

	public static void main(String[] args) {
		String home = "http://calculator.net";
		WebDriver driver;
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("Selenium");
		driver = new FirefoxDriver(fxProfile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(home);
		driver.manage().window().maximize();
		List<WebElement> Link = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of Links Available is " + Link.size());
		System.out.println("\n");
		for (int i = 1; i < Link.size(); i++) {
			System.out.println(i + "-" + Link.get(i).getText());
		}
	}
}
