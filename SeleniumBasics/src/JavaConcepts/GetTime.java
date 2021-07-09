package JavaConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetTime {

	public static void main(String[] args) {
		float StartTime = System.nanoTime();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		float EndTime = System.nanoTime();
		float Duration = EndTime - StartTime;
		System.out.println(Duration / 1000000000);
	}
}
