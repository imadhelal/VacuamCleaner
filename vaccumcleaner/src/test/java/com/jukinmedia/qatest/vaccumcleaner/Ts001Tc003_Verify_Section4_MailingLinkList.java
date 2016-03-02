package com.jukinmedia.qatest.vaccumcleaner;

import org.testng.annotations.Test;

import com.jukinmedia.qatest.vaccumcleaner.utilities.VaccumDriver;

public class Ts001Tc003_Verify_Section4_MailingLinkList extends VaccumDriver {
	
	@Test (description="Verify mailing list")
	
	public void verifyMailingList() {
		homePage().verifyMailingList();
		homePage().clickOnMailingList();
		homePage().verifyModalPopupTitle();
		homePage().verifyemailAddressInputField();
		homePage().enterEmailAddress("local@domain.ld");
		homePage().clickOnChkBoxIam18Yrs();
		homePage().submitSignUp();
		homePage().closeEmailPopup();
	}
	
	
	
}
