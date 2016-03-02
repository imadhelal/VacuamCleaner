package com.jukinmedia.qatest.vaccumcleaner;

import org.testng.annotations.Test;

import com.jukinmedia.qatest.vaccumcleaner.utilities.VaccumDriver;

public class Ts001Tc004_VerifySection5_HowAboutAcmeVc extends VaccumDriver {

	
	@Test(description="Verify How did you hear about ACME VC&A Co.?:")
	
	public void verifySectionFive(){
		homePage().verifyAcmeVC();
		homePage().verifyAcmeVcOtherRadio();
		
	}

}
