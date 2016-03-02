package com.jukinmedia.qatest.vaccumcleaner;

import org.testng.annotations.Test;

import com.jukinmedia.qatest.vaccumcleaner.utilities.VaccumDriver;

public class Ts001Tc002_VerifySection_1to3_CompanyLogoMotoName extends VaccumDriver{
	
	@Test (priority=1, description="Verify logo")
	
	public void verifyLogo(){
		
		homePage().verifyLogoAlignmentInHeader("center");
		homePage().verifyLogoPosition(15);
		
	}
	
	@Test(priority=2, description="verify company moto")
	public void verifyComMoto(){
	
		homePage().verifyCompanyMoto();
		
	}
	
	@Test(priority=3, description="verify company name")
	public void verifyComName(){
	
		homePage().verifyCompanyName();
		
	}

}
