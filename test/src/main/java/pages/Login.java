package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	WebDriver driver;	
	
	@FindBy(xpath = "//label[text()='Username']/../input[@name='loginUsername']")
	public static WebElement userName;

	@FindBy(xpath = "//label[text()='Password']/../input[@name='loginPassword']")
	public static WebElement password;

	@FindBy(xpath = "//button[text()='Login'][@type='submit']")
	public static WebElement login;
	
	@FindBy(xpath = "//label[text()='Username']/../div[contains(text(),'Error message')]")
	public static WebElement userNameErrorMsg;
	
	@FindBy(xpath = "//label[text()='Password']/../div[contains(text(),'Error message')]")
	public static WebElement passwordErrorMsg;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void enterUserName(String userNameValue) {
		userName.clear();
		userName.sendKeys(userNameValue);
	}
	
	public static void enterPassword(String passwordValue) {
		password.clear();
		password.sendKeys(passwordValue);
	}
	
	public static void login() {
		login.click();
	}


}
