package JavaConcepts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavascriptExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.tutorialspoint.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Welcome to Selenium')");
		js.executeScript("window.scrollBy(0,600)");
	}
}
