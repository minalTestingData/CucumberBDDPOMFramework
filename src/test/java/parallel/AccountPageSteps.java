package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.qa.factory.DriverFactory;
import com.qa.pages.AccountPage;
import com.qa.pages.LoginPage;
import com.qa.utils.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountPageSteps {
    
	private ConfigReader configReader;
	private String acctPageHeading;
	LoginPage lognPage = new LoginPage(DriverFactory.getDriver());
	AccountPage accountPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		
	  List<Map<String,String>> creddata = credTable.asMaps();
	  String username = creddata.get(0).get("username");
	  String password = creddata.get(0).get("password");
	  configReader = new ConfigReader();
	  DriverFactory.getDriver().get(configReader.init_prop().getProperty("url"));
	  DriverFactory.getDriver().findElement(By.linkText("Sign in")).click();	  
	  accountPage = lognPage.doLogin(username, password);
	} 
		
	@Given("user is on Account Page")
	public void user_is_on_account_page() {
		accountPage.getAccountPageTitle();
	}

	
	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable accSecTable) {
		List <String> expectedList = accSecTable.asList();
		List <String> actualList = accountPage.accountSectionDetails();
		Assert.assertTrue(expectedList.containsAll(actualList));		
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSize) {
		Integer acctualSize = accountPage.accountSectionSize();
		Assert.assertTrue(acctualSize.equals(expectedSize));
	}
	
	@When("user gets heading of page")
	public void user_gets_heading_of_page() {
	   acctPageHeading = accountPage.getAccountPageHeading();	   
	}
	
	@Then("page heading should be {string}")
	public void page_heading_should_be(String expectedPageHeading) {
	   Assert.assertEquals(expectedPageHeading, acctPageHeading);
	}
}
