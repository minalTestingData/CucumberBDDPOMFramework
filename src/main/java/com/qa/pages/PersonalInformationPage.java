package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformationPage {

	private WebDriver driver;

	@FindBy(id="id_gender1")
	WebElement titleMr;

	@FindBy(id="uniform-id_gender2")
	WebElement titleMrs;

	@FindBy(id="firstname")
	WebElement firstname;

	@FindBy(id="lastname")
	WebElement lastname;

	@FindBy(id="email")
	WebElement email;

	@FindBy(id="old_passwd")
	WebElement password;

	@FindBy(xpath="//button[@name='submitIdentity']")
	WebElement save;

	@FindBy(id="//div[@id='center_column']//child::div//child::p")
	WebElement message;

	public PersonalInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void updatePersonalInfo(String title, String fname, String lname, String emailadd, String pass ) {

		if (title.equals("Mr.")){
			titleMr.click();
		}else if (title.equals("Mrs.")) {
			titleMrs.click();
		}
		firstname.clear();
		firstname.sendKeys(fname);
		lastname.clear();
		lastname.sendKeys(lname);
		email.clear();
		email.sendKeys(emailadd);
		password.clear();
		password.sendKeys(pass);
		
	}
	
	public void clickSave() {
		save.click();
	}

public String getSucessMessage() {
	return message.getText();
}

public void enterpasswd(String passwd) {
	password.clear();
	password.sendKeys(passwd);
	
}
}
