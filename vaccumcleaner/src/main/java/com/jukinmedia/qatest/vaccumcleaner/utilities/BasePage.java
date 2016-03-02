package com.jukinmedia.qatest.vaccumcleaner.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.base.Function;

public class BasePage extends VaccumDriver {
	

	private final static String xpath="xpath";
	private final static String id ="id";
	private final static String cssSelector="css";
	private final static String name="name";
	public static FluentWait<WebDriver> wait = null;
	public static Function<WebDriver, WebElement> fwait = null;
	
	
	
	public static String getXpath() {
		return xpath;
	}
	
	public static String getID(){
		return id;
	}
	
	
	
	public static String getCssSelector(){
		return cssSelector;
	}
	
	public static String getName(){
		return name;
	}
	//click on button
		public void clickOnButton(String locator, String attributeOfLocator) {
			try {
				WebElement ele = getElement(locator, attributeOfLocator);
				ele.click();
				Reporter.log("Clicked on button");
				
			} catch (NoSuchElementException | TimeoutException e) {
				Reporter.log("Unable to click");
				
			}
		}
		//enter data into text field
		public void enterDataIntoTextField(String locator,
				String attributeOfLocator, String value){

			try {
				WebElement ele = getElement(locator, attributeOfLocator);
				ele.sendKeys(value);
				Reporter.log("Data entered into text field");
				
			} catch (NoSuchElementException | TimeoutException e) {
				Reporter.log("Unable to enter data");
				
			}
		}
		
		// This method is use assert value from web Page
		public  void assertValue (WebElement expected, String actualResult) {
			Assert.assertEquals(expected, actualResult);
		}

		public void assertValue(String expected, String actualResult) {
			Assert.assertEquals(expected, actualResult);
		}

		public void assertValue(boolean expected, String actualResult) {
			Assert.assertEquals(expected, actualResult);
		}
		public void assertValue(boolean expected) {
			Assert.assertTrue(expected);
		}
		public void assertValue(int expected, int actualResult) {
			Assert.assertEquals(expected, actualResult);
		}
		
	

}


		
