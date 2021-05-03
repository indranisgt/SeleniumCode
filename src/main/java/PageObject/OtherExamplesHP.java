package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtherExamplesHP {

	public WebDriver driver;

	public OtherExamplesHP(WebDriver driver) {
		// super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#openwindow")
	private WebElement childWindow;

	public WebElement childWindow() {
		return childWindow;
	}

	@FindBy(name = "enter-name")
	private WebElement alert;

	public WebElement alert() {
		return alert;
	}

	@FindBy(xpath = "//input[@value='Alert']")
	private WebElement alertButton;

	public WebElement alertButton() {
		return alertButton;
	}

	@FindBy(id = "product")
	private WebElement table;

	public WebElement table() {
		return table;
	}

	@FindBy(xpath = "//div[@class='tableFixHead']")
	private WebElement table2;

	public WebElement table2() {
		return table2;
	}

	@FindBy(id = "mousehover")
	private WebElement hover;

	public WebElement hover() {
		return hover;
	}

	@FindBy(css = ".mouse-hover-content a[href='#top']")
	private WebElement content;

	public WebElement content() {
		return content;
	}

}
