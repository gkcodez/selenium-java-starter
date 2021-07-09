package TestDesign;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class Video {

	private static ScreenRecorder screenRecorder;

	@Test
	public void screenshot() throws IOException, AWTException, InterruptedException {
		GraphicsConfiguration gconfig = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice().getDefaultConfiguration();
		screenRecorder = new ScreenRecorder(gconfig, new Format(MediaTypeKey, MediaType.FILE,
				MimeTypeKey, MIME_AVI), new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
				ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, CompressorNameKey,
				ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
				Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60), new Format(
				MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey,
				Rational.valueOf(30)), null);
		screenRecorder.start();
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("Selenium");
		WebDriver driver = new FirefoxDriver(fxProfile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://calculator.net");
		driver.manage().window().maximize();
		try {
			WebElement accept = driver.findElement(By.name("button"));
			accept.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("unable to find accept");
		}
		String i = "20";
		String j = "50";
		driver.findElement(By.partialLinkText("Percentage")).click();
		driver.findElement(By.id("cpar1")).sendKeys(i);
		driver.findElement(By.id("cpar2")).sendKeys(j);
		driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]"))
				.click();
		String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
		System.out.println(i + "% of " + j + " is " + result);
		driver.close();
		Thread.sleep(3000);
		screenRecorder.stop();
	}
}
