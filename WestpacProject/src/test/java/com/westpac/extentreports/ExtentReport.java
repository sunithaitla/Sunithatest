package com.westpac.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {


	static ExtentReports extent;
	static ExtentTest test;

	public static ExtentReports getReport()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Westpac Project Automation Report");
		reporter.config().setDocumentTitle("Kiwi Saver Calculation Scenarios");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Sunitha");
		return extent;

	}
	
	

}

