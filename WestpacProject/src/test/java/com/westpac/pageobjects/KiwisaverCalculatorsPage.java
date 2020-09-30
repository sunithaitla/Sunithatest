package com.westpac.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiwisaverCalculatorsPage {
	
	

	WebDriver ldriver;//local driver
	
	public KiwisaverCalculatorsPage(WebDriver rdriver)//remote driver and constructor
	{
		ldriver=rdriver;// initiate the driver
		PageFactory.initElements(rdriver, this);
		
		
	}
	// Elements on Kiwisaver Calculators Page
	
	@FindBy(xpath="//a[@href='/kiwisaver/calculators/kiwisaver-calculator/']")
	@CacheLookup
	WebElement getStarted;
	
	
	// Action menthods
	
	// Click on "Click Here to Get Started Button
	public void clickGetStarted()
	
	{
		
		getStarted.click();
	}

	
	
	
}