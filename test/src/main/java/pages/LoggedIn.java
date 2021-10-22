package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoggedIn {

	@FindBy(xpath = "//*[contains(text(),'Successfully logged in!')]")
	public static WebElement loggedIn;
	
	public LoggedIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
