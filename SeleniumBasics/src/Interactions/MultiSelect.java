package Interactions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MultiSelect {

	public static void main(String[] args) {
		String multi = "http://demos.devexpress.com/aspxeditorsdemos/ListEditors/MultiSelect.aspx";
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(multi);
		driver.manage().window().maximize();
		WebElement accept = driver.findElement(By.name("button"));
		accept.click();
		WebElement drop = driver.findElement(By
				.xpath(".//*[@id='ContentHolder_lbSelectionMode_B-1Img']"));
		WebElement sel = driver.findElement(By
				.xpath(".//*[@id='ContentHolder_lbSelectionMode_DDD_L_LBI1T0']"));
		drop.click();
		sel.click();
		WebElement select = driver.findElement(By.xpath(".//*[@id='ContentHolder_lbFeatures']"));
		List<WebElement> options = select.findElements(By.tagName("td"));
		Actions multiple = new Actions(driver);
		multiple.keyDown(Keys.CONTROL).click(options.get(2)).click(options.get(4)).build();
		multiple.perform();
	}
}
