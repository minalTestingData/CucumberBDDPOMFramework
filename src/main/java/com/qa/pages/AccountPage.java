package com.qa.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	private WebDriver driver;
	
	@FindBy(xpath="//h1[text()='My account']")
	WebElement pageheading;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public String getAccountPageHeading() {
		return pageheading.getText();
	}
	
	public int accountSectionSize() {
		return driver.findElements(By.xpath("//div[@id='center_column']//span")).size();
	}
	
	public List <String> accountSectionDetails() {
		List<String> accArrList = new ArrayList<String>();
		 List <WebElement> accSecList= driver.findElements(By.xpath("//div[@id='center_column']//span"));
		 for(WebElement e: accSecList) {
			 String text = e.getText();
			 accArrList.add(text);
		 }
		return accArrList;
	}
}
