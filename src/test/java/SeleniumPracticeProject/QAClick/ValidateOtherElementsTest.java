package SeleniumPracticeProject.QAClick;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.OtherExamplesHP;
import Resources.Base;

public class ValidateOtherElementsTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void launch() throws IOException {
		driver = initializeBrowser();
		log.info("Browser Launched successfully");
	}

	@Test
	public void validateMoreElements() {
		driver.get(prop.getProperty("url"));
		OtherExamplesHP o = new OtherExamplesHP(driver);
		o.childWindow().click();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> i = s.iterator();
		String parentid = i.next();
		String childid = i.next();
		System.out.println(driver.switchTo().window(childid).getTitle());
		driver.switchTo().window(parentid);
		o.alert().sendKeys("indrani");
		o.alertButton().click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		List<WebElement> row = o.table().findElements(By.cssSelector("tr td:nth-child(2)"));
		for (int j = 0; j < row.size(); j++) {
			System.out.println(row.get(j).getText());
		}
		List<WebElement> row1 = o.table2().findElements(By.cssSelector("tr td:nth-child(4)"));
		int sum = 0;
		for (int j = 0; j < row1.size(); j++) {
			int Amount = Integer.parseInt(row1.get(j).getText());
			sum = sum + Amount;
		}
		System.out.println(sum);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("document.querySelector(\".tableFixHead\").scroll(0,500)");
		Actions a = new Actions(driver);
		a.moveToElement(o.hover()).build().perform();
		a.moveToElement(o.content()).click().build().perform();
		log.info("Elements validated successfully");

	}

	
	  @AfterTest public void tearDown() { driver.quit(); }
	 
}
