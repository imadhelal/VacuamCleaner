package com.jukinmedia.qatest.vaccumcleaner.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jukinmedia.qatest.vaccumcleaner.utilities.BasePage;

public class SectionSixToEleven extends BasePage {
	public static WebDriver driver=null;
	public SectionSixToEleven(WebDriver driver) {
		this.driver=driver;
	}
	private String rateOverallExpi="//div[@class='form-group'][2]/label";
	private String rateRadioList="//div[@class='form-group'][2]/div/descendant::span";
	private String recommendFriend="//div[@class='form-group'][3]/label";
	private String radioRecommendFriend="//div[@class='form-group'][3]/div/descendant::span";
	private String whyNot="html/body/div[1]/div[2]/form/div[4]/label";
	private String radioButtonNo="//div[@class='form-group'][3]/div/descendant::input[2]";
	private String enterReasonTextArea="html/body/div[1]/div[2]/form/div[4]/textarea";
	private String firstName="//input[@placeholder='First Name *']";
	private String lastName="//input[@placeholder='Last Name *']";
	private String emailAddress="//input[@placeholder='Email Addres *']";
	private String phoneNumber="//input[@placeholder='Phone Number *']";
	
	
	public void verifyPhoneNumberInputField(){
		WebElement phone = driver.findElement(By.xpath(phoneNumber));
		String ghostText=phone.getAttribute("placeholder");
		
		
		String maxLength=phone.getAttribute("maxlength");
		
		
		String fontFamily=phone.getCssValue("font-family");
		String fontSize=phone.getCssValue("font-size");
		
		assertValue("Phone Number *", ghostText);
		assertValue("32", maxLength);	
		assertValue(fontFamily.contains("Arial"));
		assertValue("14px", fontSize);
		//Numeric values only (0-9).
	}
	
	public void verifyEmailInputField(){
		WebElement emailAdd = driver.findElement(By.xpath(emailAddress));
		String ghostText=emailAdd.getAttribute("placeholder");
		
		
		String maxLength=emailAdd.getAttribute("maxlength");
		
		
		String fontFamily=emailAdd.getCssValue("font-family");
		String fontSize=emailAdd.getCssValue("font-size");
		
		assertValue("Email Addres *", ghostText);
		assertValue("32", maxLength);	
		assertValue(fontFamily.contains("Arial"));
		assertValue("14px", fontSize);
	}
	public void verifyLastNameInputField(){
		WebElement lName = driver.findElement(By.xpath(lastName));
		String ghostText=lName.getAttribute("placeholder");
		
		
		String maxLength=lName.getAttribute("maxlength");
		
		
		String fontFamily=lName.getCssValue("font-family");
		String fontSize=lName.getCssValue("font-size");
		
		assertValue("Last Name *", ghostText);
		assertValue("32", maxLength);	
		assertValue(fontFamily.contains("Arial"));
		assertValue("14px", fontSize);
	}
	public void verifyFirstNameInputField(){
		WebElement fName = driver.findElement(By.xpath(firstName));
		String ghostText=fName.getAttribute("placeholder");
	
		
		String maxLength=fName.getAttribute("maxlength");
		
		
		String fontFamily=fName.getCssValue("font-family");
		String fontSize=fName.getCssValue("font-size");
		
		assertValue("First Name *", ghostText);
		assertValue("32", maxLength);	
		assertValue(fontFamily.contains("Arial"));
		assertValue("14px", fontSize);
		
	}
	
	public void verifyEnterReasonTextArea(){
	 clickOnButton(getXpath(), radioButtonNo);
	 WebElement textArea=driver.findElement(By.xpath(enterReasonTextArea));
	 assertValue("100", textArea.getAttribute("maxlength"));
	 
	}
	

	public void verifyRecommendWhyNot(){
		WebElement whyNotrecommend = driver.findElement(By.xpath(whyNot));
		String fontFamily=whyNotrecommend.getCssValue("font-family");
		String fontSize=whyNotrecommend.getCssValue("font-size");
		assertValue(fontFamily.contains("Arial"));
		assertValue("18px", fontSize);
		
	}
		
	public void verifyRecommendFriend(){
		WebElement recommendYourFriend = driver.findElement(By.xpath(recommendFriend));
		String fontFamily=recommendYourFriend.getCssValue("font-family");
		String fontSize=recommendYourFriend.getCssValue("font-size");
		assertValue(fontFamily.contains("Arial"));
		assertValue("18px", fontSize);
		
		List <WebElement> radioRecommend=driver.findElements(By.xpath(radioRecommendFriend));
		for(WebElement rButton: radioRecommend){
			String rFontFamily=rButton.getCssValue("font-family");
			String rFontSize=rButton.getCssValue("font-size");
			assertValue(rFontFamily.contains("Arial"));
			assertValue("14px", rFontSize);
		}
	}
	
	public void verifyRateOverallExp(){
		WebElement overallExpi = driver.findElement(By.xpath(rateOverallExpi));
		String fontFamily=overallExpi.getCssValue("font-family");
		String fontSize=overallExpi.getCssValue("font-size");
		assertValue(fontFamily.contains("Arial"));
		assertValue("18px", fontSize);
		
		List <WebElement> rateRadiolst=driver.findElements(By.xpath(rateRadioList));
		for(WebElement rButton: rateRadiolst){
			String rFontFamily=rButton.getCssValue("font-family");
			String rFontSize=rButton.getCssValue("font-size");
			assertValue(rFontFamily.contains("Arial"));
			assertValue("14px", rFontSize);
			
		}
		
		
	}
	
	

	/*public void verifyAcmeVcOtherRadio(){
		clickOnButton(getXpath(), acmeVcOther);
		WebElement acmeOther=driver.findElement(By.xpath(acmeVcOther));
		WebElement acmeOtherInp=driver.findElement(By.xpath(acmeOtherInput));
		assertValue("other", acmeOther.getAttribute("value"));
		assertValue("true", acmeOtherInp.getAttribute("required"));
		assertValue("32", acmeOtherInp.getAttribute("maxlength"));
	}
	
	public void verifyAcmeVC(){
		WebElement acmeVClabel = driver.findElement(By.xpath(aboutAcmeVC));
		String fontFamily=acmeVClabel.getCssValue("font-family");
		String fontSize=acmeVClabel.getCssValue("font-size");
		assertValue(fontFamily.contains("Arial"));
		assertValue("18px", fontSize);
		
		List <WebElement> acmeRadioList=driver.findElements(By.xpath(acmeVcRadioList));
		for(WebElement rButton: acmeRadioList){
			String rFontFamily=rButton.getCssValue("font-family");
			String rFontSize=rButton.getCssValue("font-size");
			assertValue(rFontFamily.contains("Arial"));
			assertValue("14px", rFontSize);
		}
		
	}*/
}
