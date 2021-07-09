package TestDesign;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class Screenshot {

	static WebDriver driver;
	static int n = 1;

	@Test
	public void percent() throws InterruptedException, IOException, AWTException {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("Selenium");
		driver = new FirefoxDriver(fxProfile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://calculator.net");
		driver.manage().window().maximize();
		String i = "20";
		String j = "50";
		driver.findElement(By.partialLinkText("Percentage")).click();
		driver.findElement(By.id("cpar1")).sendKeys(i);
		driver.findElement(By.id("cpar2")).sendKeys(j);
		driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]"))
				.click();
		String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
		System.out.println(i + "% of " + j + " is " + result);
		screenshot();
		driver.close();
	}

	public static void screenshot() throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(
				"C:\\Users\\u43764\\Pictures\\Selenium_Screenshots\\screenshot" + n + ".jpg"));
		n++;
	}
}
