package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		// super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='radioButton']")
	private WebElement radio;

	public WebElement radio() {
		return radio;
	}

	@FindBy(id = "dropdown-class-example")
	private WebElement dropdown;

	public WebElement dropdown() {
		return dropdown;
	}

	@FindBy(css = ".inputs.ui-autocomplete-input")
	private WebElement suggestion;

	public WebElement suggestion() {
		return suggestion;
	}

	@FindBy(css = ".ui-menu-item .ui-menu-item-wrapper")
	private List<WebElement> options;

	public List<WebElement> options() {
		return options;
	}
}
