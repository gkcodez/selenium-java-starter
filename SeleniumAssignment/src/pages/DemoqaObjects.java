package pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import library.ExcelLibrary;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class DemoqaObjects {

	WebDriver driver;
	@FindBy(name = "first_name")
	WebElement firstName;
	@FindBy(name = "last_name")
	WebElement lastName;
	@FindAll({ @FindBy(name = "radio_4[]") })
	public List<WebElement> RadioButtons;
	@FindAll({ @FindBy(name = "checkbox_5[]") })
	public List<WebElement> Checkboxes;
	@FindBy(name = "dropdown_7")
	WebElement CountryDropdown;
	@FindBy(id = "mm_date_8")
	WebElement Month;
	@FindBy(id = "dd_date_8")
	WebElement Date;
	@FindBy(id = "yy_date_8")
	WebElement Year;
	@FindBy(name = "phone_9")
	WebElement phoneNumber;
	@FindBy(name = "username")
	WebElement userName;
	@FindBy(name = "e_mail")
	WebElement Email;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(id = "confirm_password_password_2")
	WebElement ConfirmPassword;
	@FindBy(name = "pie_submit")
	WebElement Submit;
	@FindAll({ @FindBy(className = "piereg_message"), @FindBy(className = "piereg_login_error") })
	public List<WebElement> RegistrationMessage;
	ExcelLibrary xllib = new ExcelLibrary("sheet1", "D://DemoQA.xlsx");
	SoftAssert softAssert = new SoftAssert();

	public DemoqaObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void Register() throws InvalidFormatException, IOException {
		int rowcount = xllib.getRowCount();
		for (int i = 1; i <= rowcount; i++) {
			driver.get("http://demoqa.com/registration/");
			String fName = xllib.getExcelData(i, 1);
			String lName = xllib.getExcelData(i, 2);
			String pNumber = xllib.getExcelData(i, 3);
			String uName = xllib.getExcelData(i, 4);
			String email = xllib.getExcelData(i, 5);
			String pwd = xllib.getExcelData(i, 6);
			Select country = new Select(CountryDropdown);
			country.selectByValue("India");
			Select month = new Select(Month);
			month.selectByIndex(5);
			Select date = new Select(Date);
			date.selectByValue("15");
			Select year = new Select(Year);
			year.selectByValue("1993");
			System.out.println("The firstname is " + fName);
			System.out.println("The lastname is " + lName);
			System.out.println("The Phone Number is " + pNumber);
			System.out.println("The User Name is " + uName);
			System.out.println("The Email is " + email);
			System.out.println("The password is " + pwd);
			firstName.sendKeys(fName);
			lastName.sendKeys(lName);
			RadioButtons.get(1).click();
			Checkboxes.get(0).click();
			Checkboxes.get(2).click();
			phoneNumber.sendKeys(pNumber);
			userName.sendKeys(uName);
			Email.sendKeys(email);
			Password.sendKeys(pwd);
			ConfirmPassword.sendKeys(pwd);
			Submit.click();
			System.out.println("Registering user.. " + uName);
			String actual = RegistrationMessage.get(0).getText();
			String expected = "Thank you for your registration";
			if (actual.equals(expected)) {
				System.out.println(actual);
				softAssert.assertTrue(true);
				System.out.println("Registration Successful..");
				xllib.writeToExcel(i, 7, "Pass");
			} else {
				System.out.println(actual);
				System.out.println("Registration Failed..");
				softAssert.assertTrue(false);
				xllib.writeToExcel(i, 7, "Fail");
			}
		}
	}
}
