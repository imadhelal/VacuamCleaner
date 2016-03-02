package com.jukinmedia.qatest.vaccumcleaner.pages;

import org.openqa.selenium.WebDriver;

import com.jukinmedia.qatest.vaccumcleaner.utilities.BasePage;

public class LoginPage extends BasePage {
	public static WebDriver driver=null;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private String userName="//input[@id='username']";
	private String password="//input[@id='password']";
	private String logIn="//button[@class='btn btn-danger']";
	
	public void enterUserName(String userId){
		enterDataIntoTextField(getXpath(), userName, userId);
	}
	
	public void enterPassword(String userPass){
		enterDataIntoTextField(getXpath(), password, userPass);
	}
	
	public void clickOnLogin ( ){
		clickOnButton(getXpath(), logIn);
	}

}
