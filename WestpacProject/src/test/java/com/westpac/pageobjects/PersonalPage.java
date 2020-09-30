package com.westpac.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalPage {
	
	
	WebDriver ldriver;//local driver
	
	public PersonalPage(WebDriver rdriver)//remote driver and constructor
	{
		ldriver=rdriver;// initiate the driver
		PageFactory.initElements(rdriver, this);
		
		
	}
	// Elements on Personal Page
	//@FindBy(id="ubermenu-section-link-kiwisaver-ps")
	@FindBy(xpath="//a[@href='/kiwisaver/']")
	@CacheLookup
	WebElement menuKiwisaver;
	
	//@FindBy(id="ubermenu-item-cta-kiwisaver-calculators-ps")
	@FindBy(xpath="//a[@href='/kiwisaver/calculators/']")
	@CacheLookup
	WebElement btnKiwicalculator;
	

	// Action menthods
	
	// Click on Menu Kiwisaver Item
	public void clickOnKiwisaver()
	
	{
		
		menuKiwisaver.click();
	}
	//Click on Kiwi Calculator Button
public void clickOnKiwiCalculator()
	
	{
		
	btnKiwicalculator.click();
	}
	
	
	
}