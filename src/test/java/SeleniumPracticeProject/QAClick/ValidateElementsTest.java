package SeleniumPracticeProject.QAClick;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.HomePage;
import Resources.Base;

public class ValidateElementsTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void launch() throws IOException {
		driver = initializeBrowser();
		log.info("Browser Launched successfully");
	}

	@Test
	public void validateElements() {
		driver.get(prop.getProperty("url"));
		HomePage hp = new HomePage(driver);
		hp.radio().click();
		hp.dropdown().click();
		Select s = new Select(hp.dropdown());
		s.selectByValue("option2");
		hp.suggestion().sendKeys("ind");
		for (int i = 0; i < hp.options().size(); i++) {
			if (hp.options().get(i).getText().equalsIgnoreCase("India")) {
				hp.options().get(i).click();
			}
		}
		log.info("Elements validated successfully");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
