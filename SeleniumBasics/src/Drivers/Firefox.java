package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Firefox {

	static WebDriver driver;

	public static void main(String[] args) {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("Selenium");
		driver = new FirefoxDriver(fxProfile);
		driver.get("http://www.google.com");
		System.out.println("Google site opened in firefox");
	}
}
