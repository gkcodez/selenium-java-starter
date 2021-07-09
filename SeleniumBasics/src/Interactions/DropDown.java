package Interactions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		String link = "http://www.calculator.net";
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("Selenium");
		WebDriver driver = new FirefoxDriver(fxProfile);
		driver.manage().window().maximize();
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Interest")).click();
		WebElement dropdown = driver.findElement(By.id("ccompound"));
		Select drop = new Select(dropdown);
		List<WebElement> options = drop.getOptions();
		System.out.println("The dropdown contains a total of " + options.size() + " options");
		System.out.println("They are as below");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(drop.getOptions().get(i).getText());
		}
		drop.selectByValue("daily");
	}
}
