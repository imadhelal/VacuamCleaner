package com.jukinmedia.qatest.vaccumcleaner;

import org.testng.annotations.Test;

import com.jukinmedia.qatest.vaccumcleaner.utilities.VaccumDriver;

public class Ts001Tc005_VerifySections_6to7_OverallExp_RecomFrnd_WhyNot extends VaccumDriver {

	@Test(description="Verify overallExperiance, RecommendUs and WhyNot")
	public void sectionSixToSeven(){
		secSixtoEleven().verifyRateOverallExp();
		secSixtoEleven().verifyRecommendFriend();
		secSixtoEleven().verifyEnterReasonTextArea();
	}
	
}
 