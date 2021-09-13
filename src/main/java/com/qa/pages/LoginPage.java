package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(id ="email")
	WebElement emailid;
	
	@FindBy(id ="passwd")
	WebElement password;
	
	@FindBy(id ="SubmitLogin")
	WebElement SignInButton;
	
	@FindBy(linkText="Sign out")
	WebElement SignOutBtn;
	
	@FindBy (linkText ="Forgot your password?")
	WebElement forgotpwd;
	
	@FindBy(id = "SubmitCreate")
	WebElement CreateAnAccnt;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return forgotpwd.isDisplayed();		
	}

	public void enterUserName(String email) {
		emailid.sendKeys(email);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickOnLogin() {
		SignInButton.click();
	}

	public void clickOnSignout() {
		SignOutBtn.click();
	}
	public void clickOnCreateAnAccount() {
		CreateAnAccnt.click();
	}
	
	public AccountPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		emailid.sendKeys(un);
		password.sendKeys(pwd);
		SignInButton.click();
		return new AccountPage(driver);
	}
	
	public RegisterPage CreateAccount(String un) {
		CreateAnAccnt.click();
		return new RegisterPage(driver);
	}
}
