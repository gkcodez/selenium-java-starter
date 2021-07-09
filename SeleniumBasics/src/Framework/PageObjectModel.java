package Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class PageObjectModel {

	WebDriver driver = new FirefoxDriver();
	String baseUrl;
	SearchPageFactory search = new SearchPageFactory(driver);

	@Test(priority = 0)
	public void setUp() {
		baseUrl = "http://calculator.net/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void calculate() {
		search.clickPercentageCalculator();
		Reporter.log("Clicked on Percentage Calculator Link");
		search.setFirstValue("200");
		Reporter.log("Entered the first Value");
		search.setSecondValue("600");
		Reporter.log("Entered the second Value");
		search.clickCalculate();
		Reporter.log("Clicked on calculate");
	}

	@AfterClass
	public void tearDown() throws Exception {
	}
}
