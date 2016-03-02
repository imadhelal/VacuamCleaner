package com.jukinmedia.qatest.vaccumcleaner.utilities;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.jukinmedia.qatest.vaccumcleaner.pages.SectionOneToFive;
import com.jukinmedia.qatest.vaccumcleaner.pages.LoginPage;
import com.jukinmedia.qatest.vaccumcleaner.pages.SectionSixToEleven;

public class VaccumDriver {
	public static WebDriver driver =null;
	public static String url="http://qatest.jukinmedia.com";
	
	@BeforeSuite
	@Parameters("browser")
	public void setUp(String browser){
		
		if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
			
			//Rename chrome driver extention to .exe
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", new File("chrome").getAbsolutePath()+"/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("safari")){
			driver=new SafariDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	@AfterSuite
	public void tearDown(){
		driver.close();
	}
  
	
	public static WebElement getElement(String locator, String attributeOfLocator){
		if(locator.equalsIgnoreCase("id")){
			return driver.findElement(By.id(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("className")){
			return driver.findElement(By.className(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("name")){
			return driver.findElement(By.name(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("xpath")){
			return driver.findElement(By.xpath(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("css")){
			return driver.findElement(By.cssSelector(attributeOfLocator));
		}else
			throw new NoSuchElementException("No Such Element" + attributeOfLocator);
	}
	
	public LoginPage loginPage(){
		LoginPage login= new LoginPage(driver);
		return login;
	}
	public SectionOneToFive homePage(){
		SectionOneToFive home= new SectionOneToFive(driver);
		return home;
	}
	public SectionSixToEleven  secSixtoEleven(){
		SectionSixToEleven sectionSixtoEleven= new SectionSixToEleven(driver);
		return sectionSixtoEleven;
	}
}
