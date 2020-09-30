package com.westpac.testcases;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.westpac.pageobjects.RetirementCalculatorPage;

public class KiwiSaverUserStory2Test extends BaseClass{


	@BeforeMethod
	public void setup() throws IOException
	{					
		driver.get(url);
	}	

	@Test(description="Age30")	
	public void whenAge30(){			
		RetirementCalculatorPage retirementcalculator = new RetirementCalculatorPage(driver);
		retirementcalculator.navigateToCalculatorPage();
		retirementcalculator.calculateFor30();			
	}

	@Test(dataProvider="Calculate")
	public void calculateForAge(String age, String Balance, String contribution, String goalretirement) {

		RetirementCalculatorPage retirementcalculator = new RetirementCalculatorPage(driver);
		retirementcalculator.navigateToCalculatorPage();
		retirementcalculator.calculateForAge(age,Balance,contribution,goalretirement);		    	
	}

	@DataProvider(name = "Calculate") public static Iterator<Object[]>
	fetchData1() throws InvalidFormatException, IOException,
	EncryptedDocumentException,
	org.apache.poi.openxml4j.exceptions.InvalidFormatException {

		ArrayList<Object[]> myData = new ArrayList<Object[]>(); FileInputStream fis =
				new FileInputStream(System.getProperty("user.dir") + "/ExcelFile/Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis); 
		Sheet sh = wb.getSheet("Sheet1"); 
		Cell cell;
		CellType celtype = null;
		int numOfRows = sh.getLastRowNum(); 
		String age, Balance, contribution, goalretirement;

		for (int i = 1; i <= numOfRows; i++)
		{	  						  
			age = Double.toString(sh.getRow(i).getCell(0).getNumericCellValue()); 
			Balance =	Double.toString(sh.getRow(i).getCell(1).getNumericCellValue());
			contribution = Double.toString(sh.getRow(i).getCell(2).getNumericCellValue());
			goalretirement = Double.toString(sh.getRow(i).getCell(3).getNumericCellValue());					  
			myData.add(new Object[] { age, Balance, contribution,goalretirement });
		}
		return myData.iterator();

	}
	
	@AfterTest
	public void tearDown() throws IOException
	{	
		driver.close();
	}	


}
