package com.jukinmedia.qatest.vaccumcleaner;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import com.jukinmedia.qatest.vaccumcleaner.utilities.VaccumDriver;

public class Ts001TC001_VerifyLoginFunctionality extends VaccumDriver{
	
	
	private String userId="jukinmedia";
	private String password="qatest";
	
	@Test (description="Verify Login Functionality")
	
	public void verifyLogin() throws InterruptedException{
		
		loginPage().enterUserName(userId);
		loginPage().enterPassword(password);
		loginPage().clickOnLogin();
		
		
	}
	
	

}
