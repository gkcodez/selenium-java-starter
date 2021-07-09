package ExtentReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	ExtentReports report;
	ExtentTest test;

	@Test
	public void advancereport() {
		report = new ExtentReports(
				"D:\\DATA\\Work\\Automation\\Selenium\\References\\Reports\\Percentage_Calculator.html");
		test = report.startTest("Percentage Calculator");
		String home = "http://www.calculator.net";
		String i = "20";
		String j = "65";
		WebDriver driver;
		/*
		 * ProfilesIni profile = new ProfilesIni(); FirefoxProfile fxProfile =
		 * profile.getProfile("Selenium"); driver = new
		 * FirefoxDriver(fxProfile);
		 */
		System.setProperty("webdriver.chrome.driver",
				"D:\\DATA\\Work\\Automation\\Selenium\\References\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser Opened");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Window Maximized");
		driver.get(home);
		// driver.navigate().to(home);
		test.log(LogStatus.PASS, "Homepage Loaded");
		driver.findElement(By.partialLinkText("Percentage")).click();
		test.log(LogStatus.INFO, "Navigating to Percentage Calculator ... ");
		driver.findElement(By.id("cpar1")).sendKeys(i);
		test.log(LogStatus.INFO, "Entered the First Value");
		driver.findElement(By.id("cpar2")).sendKeys(j);
		test.log(LogStatus.INFO, "Entered the Second Value");
		driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]"))
				.click();
		test.log(LogStatus.INFO, "Calculating the Result ... ");
		String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
		test.log(LogStatus.PASS, i + "% of " + j + " is " + result);
		System.out.println(i + "% of " + j + " is " + result);
		report.endTest(test);
		report.flush();
	}
}
