package SeleniumPracticeProject.QAClick;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.iFrameandOthers;
import Resources.Base;

public class ValidateFrameandConnectionsTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void launch() throws IOException {
		driver = initializeBrowser();
		log.info("Browser Launched successfully");
	}

	@Test
	public void validation() throws MalformedURLException, IOException {
		driver.get(prop.getProperty("url"));
		iFrameandOthers i = new iFrameandOthers(driver);
		driver.switchTo().frame(i.frame());
		driver.findElement(By.xpath("//a[@href='https://courses.rahulshettyacademy.com/courses']")).click();
		driver.switchTo().defaultContent();
		List<WebElement> li = i.footer().findElements(By.tagName("a"));
		for (int j = 0; j < li.size(); j++) {
			String url = li.get(j).getAttribute("href");
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int code = con.getResponseCode();
			// System.out.println(code);
			if (code > 200) {
				System.out.println("a broken link found with code" + code);
			}
		}
		log.info("Elements validated successfully");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
