package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorer {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver",
				"D:\\DATA\\Work\\Automation\\Selenium\\References\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://www.debenhams.com");
		System.out.println("Debenhams site opened in Internet Explorer");
	}
}