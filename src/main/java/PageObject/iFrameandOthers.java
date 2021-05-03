package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iFrameandOthers {

	public WebDriver driver;

	public iFrameandOthers(WebDriver driver) {
		// super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "courses-iframe")
	private WebElement frame;

	public WebElement frame() {
		return frame;
	}

	@FindBy(id = "gf-BIG")
	private WebElement footer;

	public WebElement footer() {
		return footer;
	}
}
