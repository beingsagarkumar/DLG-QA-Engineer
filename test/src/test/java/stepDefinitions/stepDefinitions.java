package stepDefinitions;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.LoggedIn;
import pages.Login;
import utils.Utils;

public class stepDefinitions extends Utils{
	WebDriver driver = null;
	String url = "";
	Login login;
	LoggedIn loggedIn;

	@Before 
	public void setUp() throws IOException{
		driver = getDriver();
		
		url = getProperties("url");
		driver.manage().window().maximize();
		
		login = new Login(driver);
		loggedIn = new LoggedIn(driver);
	 } 
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    driver.get(url);
	    Assert.assertEquals(driver.getTitle().toString(), "QA Interview Test | DLG Digital");
	}
	
	@When("User enters UserName as {string} and Password as {string} and login")
	public void user_enters_user_name_as_and_password_as_and_login(String userName, String password) {
		Login.enterUserName(userName);
		Login.enterPassword(password);
		Login.login();
	}
	
	@When("User enters UserName as {string} and Password as {string}")
	public void user_enters_user_name_as_and_password_as(String userName, String password) {
		Login.enterUserName(userName);
		Login.enterPassword(password);
		Assert.assertFalse(Login.login.isEnabled());
		Login.login();
	}

	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
		System.out.println("Logged in page: " + LoggedIn.loggedIn.getText().toString().trim());
	    Assert.assertEquals(LoggedIn.loggedIn.getText().toString().trim() ,"Successfully logged in!");
	}
	
	@Then("Error Message is displayed for UserName")
	public void error_message_is_displayed_for_UserName() {
	    Assert.assertEquals(Login.userNameErrorMsg.getText().toString().trim(), "Error message");
	}
	
	@Then("Error Message is displayed for Password")
	public void error_message_is_displayed_for_Password() {
	    Assert.assertEquals(Login.passwordErrorMsg.getText().toString().trim(), "Error message");
	}
	
	@Then("Error Message is displayed for invalid Username and Password")
	public void error_message_is_displayed_for_invalid_Username_and_Password() {
		Assert.assertEquals(Login.userNameErrorMsg.getText().toString().trim(), "Error message");
	    Assert.assertEquals(Login.passwordErrorMsg.getText().toString().trim(), "Error message");
	}
	
	@Then("Login button is disabled")
	public void Login_button_is_disabled() {
		Assert.assertFalse(Login.login.isEnabled());
	}
	
}