package com.jukinmedia.qatest.vaccumcleaner;

import org.testng.annotations.Test;

import com.jukinmedia.qatest.vaccumcleaner.utilities.VaccumDriver;

public class Ts001Tc006_Verify_Section_8to11_FNameLNameEmailPhone extends VaccumDriver{

	@Test(description="Verify web field: FName, LName, Email and Phone Number")
	public void sectionEigtToEleven(){
		secSixtoEleven().verifyFirstNameInputField();
		secSixtoEleven().verifyLastNameInputField();
		secSixtoEleven().verifyEmailInputField();
		secSixtoEleven().verifyPhoneNumberInputField();
	}
}
