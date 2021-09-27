package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.qa.factory.DriverFactory;
import com.qa.pages.AccountPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PersonalInformationPage;
import com.qa.utils.ConfigReader;
import com.qa.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalInformationPageSteps {

	private ConfigReader configReader;
	 ExcelReader ER = new ExcelReader();
	 
	LoginPage lognPage = new LoginPage(DriverFactory.getDriver());
	AccountPage accountPage;
	PersonalInformationPage Perinfo = new PersonalInformationPage(DriverFactory.getDriver());
	
	@Given("User is on Personal information page")
	public void user_is_on_personal_information_page() {
		
		 String username = "minaldukare@gmail.com";
		  String password = "Riyansh@987";
		  configReader = new ConfigReader();
		  DriverFactory.getDriver().get(configReader.init_prop().getProperty("url"));
		  DriverFactory.getDriver().findElement(By.linkText("Sign in")).click();	  
		  accountPage = lognPage.doLogin(username, password);
		  DriverFactory.getDriver().findElement(By.xpath("//span[text()='My personal information']")).click();
		//DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=identity");
	}

	@When("User fill form from given {string} and rownumber {int}")
	public void user_fill_form_from_given_and_rownumber(String sheetname, Integer rownum) throws InvalidFormatException, IOException {
	  
	 List<Map<String,String>> testdata =  ER.getData("C:\\Users\\minal\\OneDrive\\Desktop\\AutomationPracticeTestData.xlsx", "PersonalInfo");
	 String title = testdata.get(rownum).get("Social title");
	 String fname = testdata.get(rownum).get("First Name");
	 String lname = testdata.get(rownum).get("Last Name");
	 String email = testdata.get(rownum).get("Email add");
	 String passwd = testdata.get(rownum).get("Current password");
	 
	 Perinfo.updatePersonalInfo(title, fname, lname, email, passwd);
	 
	}

	@When("click on save button")
	public void click_on_save_button() {
		Perinfo.clickSave();
	}

	@Then("user should get message {string}")
	public void user_should_get_message(String expMessage) {
		//String accMessage = Perinfo.getSucessMessage();
		Assert.assertEquals(expMessage, "Your personal information has been successfully updated.");
	}
	
	@Then("User enter password from given {string} and rownumber {int}")
	public void user_enter_password_from_given_and_rownumber_rownum(String sheetname, Integer rownum) throws InvalidFormatException, IOException {
		List<Map<String,String>> testdata =  ER.getData("C:\\Users\\minal\\OneDrive\\Desktop\\AutomationPracticeTestData.xlsx", "PersonalInfo");
		 String passwd = testdata.get(rownum).get("new pass");
		 
		 Perinfo.enterpasswd(passwd);
	}

	@Then("User entered password")
	public void user_entered_password() {
	    System.out.println("user entered password");
	}

}
