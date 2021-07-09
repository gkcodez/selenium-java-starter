package Log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4j {

	// static final Logger logger = LogManager.getLogger(Log4j.class.getName());
	private static final Logger logger = Logger.getLogger(Log4j.class);

	public static void main(String[] args) {
		DOMConfigurator.configure("log4j.xml");
		logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # \n");
		logger.info("TEST Has Started");
		// WebDriver driver;
		// driver = new FirefoxDriver();
		logger.info("Firefox Opened");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("http://calculator.net");
		// driver.manage().window().maximize();
		logger.info("Window Maximized");
		// WebElement accept = driver.findElement(By.name("button"));
		// accept.click();
		logger.info("Terms accepted");
		logger.info("Homepage Opened");
		// List<WebElement> Links = driver.findElements(By.tagName("a"));
		// System.out.println("Total Number of Links Available is " +
		// Links.size());
		// logger.info("Total Number of Links Available is " + Links.size());
		System.out.println("\n");
		// for (int i = 1; i < Links.size(); i++) {
		// System.out.println(i + "-" + Links.get(i).getText());
		// }
		// driver.quit();
		logger.error("Firefox Closed");
		logger.info("\n # # # # # # # # # # # # # # # # # # # # # # # # # # # ");
	}
}
