package com.westpac.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.westpac.pageobjects.RetirementCalculatorPage;

public class infoIconTest extends BaseClass {

	@BeforeMethod
	public void setup() throws IOException
	{					
		driver.get(url);
	}	

	@Test(description="Get Info text")
	public void getCurrentAgeInformationText() throws Exception {
		RetirementCalculatorPage retirementcalculator = new RetirementCalculatorPage(driver);
		retirementcalculator.navigateToCalculatorPage();
		retirementcalculator.clickOnCurrentAgeInfoIcon();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		retirementcalculator.getCurrentAgeInfoText();
		
		
	}
	
	

	
	  @AfterTest public void tearDown() throws IOException { 
		  driver.close();
		  }
	 

}

