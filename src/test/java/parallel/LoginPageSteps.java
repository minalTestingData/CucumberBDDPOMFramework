package parallel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private String title, accPageUrl;
	private ConfigReader configReader;
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on Home page")
	public void user_is_on_home_page() {
		configReader = new ConfigReader();
		DriverFactory.getDriver().get(configReader.init_prop().getProperty("url"));
	}

	@When("user clicks on Sign in button")
	public void user_clicks_on_sign_in_button() {
		DriverFactory.getDriver().findElement(By.linkText("Sign in")).click();
	}

	@Then("user should be on login page")
	public void user_should_be_on_login_page() {
		Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}


	@When("user gets the title of page")
	public void user_gets_the_title_of_page() {
		title=loginPage.getLoginPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedtitle) {
		Assert.assertEquals(expectedtitle, title);
	}


	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters email address {string}")
	public void user_enters_email_address(String email) {
		loginPage.enterUserName(email);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginPage.enterPassword(pwd);
	}

	@When("click on Sign in button")
	public void click_on_sign_in_button() {
		loginPage.clickOnLogin();
	}


	@Given("User is on My account page")
	public void user_is_on_my_account_page() {
		accPageUrl=DriverFactory.getDriver().getCurrentUrl();

	}

	@When("user clicks on Sign out")
	public void user_clicks_on_sign_out() {
		if(accPageUrl.equals("http://automationpractice.com/index.php?controller=my-account")) {
			loginPage.clickOnSignout();
		}
	}

	@When("clicks on Create an account button")
	public void clicks_on_create_an_account_button() {
		loginPage.clickOnCreateAnAccount();
	}

}
