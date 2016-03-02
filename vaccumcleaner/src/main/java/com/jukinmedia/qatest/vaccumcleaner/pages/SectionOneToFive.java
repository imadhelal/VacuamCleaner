package com.jukinmedia.qatest.vaccumcleaner.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jukinmedia.qatest.vaccumcleaner.utilities.BasePage;

public class SectionOneToFive extends BasePage {
	
	public static WebDriver driver=null; 
	public SectionOneToFive(WebDriver driver) {
		this.driver=driver;
	}
	
	private String logo="//div[@class='col-xs-2 logo']/img";
	private String header="//header[@class='header ng-scope']";
	private String companyMoto="//div[@class='col-xs-8 align-center']/p";
	private String companyName="//div[@class='col-xs-8 align-center']/h1";
	private String mailingList="//a[@class='pointer']";
	private String modalTitel="//h4[@id='myModalLabel']";
	private String emailInPopup="//input[@type='email']";
	private String iAm18ChkBox="//input[@type='checkbox']";
	private String popUpSubmit="//div[@class='modal-footer']/button";
	private String popUpClose="//h3[@class='modal-title']/button";
	private String aboutAcmeVC="//div[@class='form-group'][1]/label";
	private String acmeVcRadioList="//div[@class='form-group'][1]/div/descendant::span";
	private String acmeVcOther="html/body/div[1]/div[2]/form/div[1]/div/div[5]/label/input";
	private String acmeOtherInput="html/body/div[1]/div[2]/form/div[1]/div/div[5]/input";
	
	public void verifyAcmeVcOtherRadio(){
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
		
	}
	
	
	public void verifyemailAddressInputField(){
		WebElement email = driver.findElement(By.xpath(emailInPopup));
	
		String ghostText=email.getAttribute("placeholder");
		String maxLength=email.getAttribute("maxlength");
	
		assertValue("Email Addres *", ghostText);
		assertValue("255", maxLength);	
	}
	
	public void closeEmailPopup(){
		clickOnButton(getXpath(), popUpClose);
	}
	
	public void submitSignUp(){
	
		clickOnButton(getXpath(), popUpSubmit);
	}
	
	
	public void clickOnChkBoxIam18Yrs(){
		clickOnButton(getXpath(), iAm18ChkBox);
	}
	//This method enter email address
	public void enterEmailAddress(String emailAddress){
		enterDataIntoTextField(getXpath(), emailInPopup, emailAddress);
	}

	public void verifyModalPopupTitle(){
		
		driver.switchTo().window(driver.getWindowHandle());	
		WebElement popupTitle = driver.findElement(By.xpath(modalTitel));
		String title=popupTitle.getText();		
		String fontFamily=popupTitle.getCssValue("font-family");
		String fontSize=popupTitle.getCssValue("font-size");
		String titleAlignment=popupTitle.getCssValue("text-align");
		
		assertValue("Sign Up for Out Newsleter", title);
		assertValue(fontFamily.contains("Arial"));
		assertValue("18px", fontSize);
		assertValue("center", titleAlignment);
	}
	
	
	public void verifyMailingList(){
		Actions action=new Actions(driver);
		WebElement mList= driver.findElement(By.xpath(mailingList));
		String fontFamily=mList.getCssValue("font-family");
		String fontSize=mList.getCssValue("font-size");
		WebElement hov= driver.findElement(By.xpath("html/body/div[1]/header/div/div[3]/a/span"));
		action.moveToElement(hov).build().perform();
		String hovColor=hov.getCssValue("color");
		
		assertValue(fontFamily.contains("Arial"));
		assertValue("21px", fontSize);
	   assertValue("rgba(255, 255, 0, 1)", hovColor);
   }
	 public void clickOnMailingList(){
		   clickOnButton(getXpath(), mailingList);
		
	}
	public void verifyCompanyMoto(){
		WebElement comMoto= driver.findElement(By.xpath(companyMoto));
		String fontFamily=comMoto.getCssValue("font-family");
		String fontSize=comMoto.getCssValue("font-size");
		String fontStyle=comMoto.getCssValue("font-style");
		String motoAlignment=comMoto.getCssValue("text-align");
		boolean motoInHeader=checkElementInHeader(header, companyMoto);
		boolean motoBelowTheCompanyName=checkMotoAndCompanyNamePosition(companyName, companyMoto);
		
		assertValue(fontFamily.contains("Arial"));
		assertValue("21px", fontSize);
		assertValue("italic", fontStyle);
		assertValue("center", motoAlignment);
		assertValue(motoInHeader);
		assertValue(motoBelowTheCompanyName);
	}
	
	public void verifyCompanyName(){
		WebElement comName= driver.findElement(By.xpath(companyName));
		String fontFamily=comName.getCssValue("font-family");
		String fontSize=comName.getCssValue("font-size");
		String comAlignment=comName.getCssValue("text-align");
		boolean comInHeader=checkElementInHeader(header, companyName);
		boolean comAboveTheCompanyMoto=checkMotoAndCompanyNamePosition(companyName, companyMoto);
		
		assertValue(fontFamily.contains("Arial"));
		assertValue("30px", fontSize);
		assertValue("center", comAlignment);
		assertValue(comInHeader);
		assertValue(comAboveTheCompanyMoto);
	}
	
	public boolean checkMotoAndCompanyNamePosition(String cName, String mName){
				
		WebElement comName= driver.findElement(By.xpath(cName));
		int comPosition=comName.getLocation().getY();
		
		WebElement motoName= driver.findElement(By.xpath(mName));
		int motoPosition=motoName.getLocation().getY();
		
		if (comPosition<motoPosition){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public void verifyLogoPosition(int expectedLogoPosition){
		WebElement headerLogo= driver.findElement(By.xpath(logo));
		int logoPosition=headerLogo.getLocation().getX();
		
		assertValue(expectedLogoPosition, logoPosition);
		
	}
	
	public void verifyLogoAlignmentInHeader(String alignment){
		String logoAlignment=driver.findElement(By.xpath(logo)).getCssValue("text-align");     
		boolean logoInHeader = checkElementInHeader(header, logo);
      
        assertValue(logoInHeader);
        assertValue(alignment, logoAlignment);
		
	}
	
	public boolean checkElementInHeader(String header, String ele ){
		
		 WebElement head=driver.findElement(By.xpath(header));
	     boolean logoInHeader=head.findElement(By.xpath(ele)).isDisplayed();
	     return logoInHeader;
	}
	
	

}
