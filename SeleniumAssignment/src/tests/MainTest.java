package tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DemoqaObjects;
import pages.NewToursObjects;

public class MainTest {

	WebDriver driver;
	DemoqaObjects Reg;
	NewToursObjects Newtours;

	@BeforeClass
	public void getWebDriver() throws Exception {
		ProfilesIni profilesIni = new ProfilesIni();
		FirefoxProfile fProfile = profilesIni.getProfile("default");
		driver = new FirefoxDriver(fProfile);
	}

	@Test(priority = 0)
	public void testRegistration() throws Exception {
		Reg = new DemoqaObjects(driver);
		Reg.Register();
	}

	@Test(priority = 1)
	public void loginNewTours() throws InvalidFormatException, IOException, InterruptedException {
		Newtours = new NewToursObjects(driver);
		Newtours.Login();
	}
}
