package TestNG;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

public class BasicTestNG implements IReporter {

	// test case 1
	@Test(groups = { "test" }, dependsOnMethods = { "testCase3" }, dependsOnGroups = { "tests" })
	public void testCase1() {
		System.out.println("in test case 1");
	}

	// test case 2
	@Test(enabled = true, groups = { "tests" })
	public void testCase2() {
		System.out.println("in test case 2");
	}

	@DataProvider
	public static Object[][] NamesProvider() {
		return new Object[][] { { "Gopal" }, { "Krishna" } };
	}

	@Test(expectedExceptions = ArithmeticException.class, groups = { "tests" }, dataProvider = "NamesProvider")
	@Parameters("name")
	public void testCase3(String name) {
		System.out.println("in test case 3");
		System.out.println(name);
		int a = 0;
		int b = 6;
		int c;
		c = b / a;
		System.out.println(c);
	}

	@BeforeMethod(groups = { "methods" })
	public void beforeMethod() {
		System.out.println("in beforeMethod");
	}

	@AfterMethod(groups = { "methods" })
	public void afterMethod() {
		System.out.println("in afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("in beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("in afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("in beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("in afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("in beforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("in afterSuite");
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
	}
}
