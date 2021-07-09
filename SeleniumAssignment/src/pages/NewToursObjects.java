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

public class NewToursObjects {

	WebDriver driver;
	@FindBy(name = "userName")
	WebElement UserName;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(name = "login")
	WebElement LoginButton;
	@FindAll({ @FindBy(name = "tripType") })
	public List<WebElement> Triptype;
	@FindBy(name = "passCount")
	WebElement Passengers;
	@FindBy(name = "fromPort")
	WebElement FromPort;
	@FindBy(name = "toPort")
	WebElement ToPort;
	@FindAll({ @FindBy(name = "servClass") })
	public List<WebElement> Sclass;
	@FindBy(name = "airline")
	WebElement Airline;
	@FindBy(name = "findFlights")
	WebElement findFlights;
	@FindAll({ @FindBy(name = "outFlight") })
	public List<WebElement> Depart;
	@FindAll({ @FindBy(name = "inFlight") })
	public List<WebElement> Return;
	@FindBy(name = "reserveFlights")
	WebElement Reserveflight;
	@FindBy(name = "passFirst0")
	WebElement FirstName0;
	@FindBy(name = "passLast0")
	WebElement LastName0;
	@FindBy(name = "creditnumber")
	WebElement CreditNumber;
	@FindBy(name = "buyFlights")
	WebElement Buyflights;
	@FindBy(xpath = "a[contains(text(),'SIGN-OFF')]")
	WebElement Signoff;
	ExcelLibrary ntlib = new ExcelLibrary("sheet1", "D://NewTours.xlsx");
	SoftAssert softAssert = new SoftAssert();
	int i = 1;

	public NewToursObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void Login() throws InvalidFormatException, IOException, InterruptedException {
		int rowcount = ntlib.getRowCount();
		for (; i <= rowcount; i++) {
			driver.get("http://newtours.demoaut.com/");
			String uName = ntlib.getExcelData(i, 1);
			String pwd = ntlib.getExcelData(i, 2);
			UserName.sendKeys(uName);
			Password.sendKeys(pwd);
			LoginButton.click();
			System.out.println("Logging in.. " + uName);
			String actual = driver.getTitle();
			String expected = "Find a Flight";
			if (actual.contains((expected))) {
				softAssert.assertTrue(true);
				System.out.println("Login Successful..");
				findFlight();
			} else {
				System.out.println("Login Failed..");
				softAssert.assertTrue(false);
				ntlib.writeToExcel(i, 6, "Fail");
			}
		}
	}

	public void findFlight() throws InvalidFormatException, IOException {
		Triptype.get(1).click();
		Select nop = new Select(Passengers);
		nop.selectByIndex(0);
		Select fp = new Select(FromPort);
		fp.selectByIndex(3);
		Select tp = new Select(ToPort);
		tp.selectByIndex(1);
		Sclass.get(1).click();
		Select al = new Select(Airline);
		al.selectByIndex(3);
		findFlights.click();
		String actual = driver.getTitle();
		String expected = "Select a Flight";
		if (actual.contains((expected))) {
			softAssert.assertTrue(true);
			selectFlight();
		} else {
			softAssert.assertTrue(false);
			ntlib.writeToExcel(i, 6, "Fail");
		}
	}

	public void selectFlight() throws InvalidFormatException, IOException {
		try {
			Depart.get(2).click();
			Return.get(3).click();
			Reserveflight.click();
			reserveFlight();
		} catch (Exception e) {
			ntlib.writeToExcel(i, 6, "Fail");
		}
	}

	public void reserveFlight() throws InvalidFormatException, IOException {
		try {
			String fName0 = ntlib.getExcelData(i, 3);
			String lName0 = ntlib.getExcelData(i, 4);
			String cNumber = ntlib.getExcelData(i, 5);
			FirstName0.sendKeys(fName0);
			LastName0.sendKeys(lName0);
			CreditNumber.sendKeys(cNumber);
			Buyflights.click();
			confirmFlight();
		} catch (Exception e) {
			ntlib.writeToExcel(i, 6, "Fail");
		}
	}

	public void confirmFlight() throws InvalidFormatException, IOException {
		String actual = driver.getTitle();
		String expected = "Flight Confirmation";
		if (actual.contains((expected))) {
			softAssert.assertTrue(true);
			System.out.println("Flight Booking Successful..");
			Signoff.click();
			ntlib.writeToExcel(i, 6, "Pass");
		} else {
			System.out.println("Cannot Book a flight..");
			softAssert.assertTrue(false);
			ntlib.writeToExcel(i, 6, "Fail");
		}
	}
}
