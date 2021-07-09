package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageFactory {

	WebDriver driver;
	@FindBy(partialLinkText = "Percentage")
	WebElement PercentageCalculator;
	@FindBy(id = "cpar1")
	WebElement FirstValue;
	@FindBy(id = "cpar2")
	WebElement SecondValue;
	@FindBy(xpath = ".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")
	WebElement Calculate;
	WebDriverWait driverWait;

	public SearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driverWait = new WebDriverWait(driver, 30);
	}

	public void clickPercentageCalculator() {
		PercentageCalculator.click();
	}

	public void setFirstValue(String Firstvalue) {
		FirstValue.sendKeys(Firstvalue);
	}

	public void setSecondValue(String Secondvalue) {
		SecondValue.sendKeys(Secondvalue);
	}

	public void clickCalculate() {
		Calculate.click();
	}
}
