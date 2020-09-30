package com.westpac.extentreports;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.westpac.testcases.BaseClass;

public class Listener extends BaseClass implements ITestListener {

	WebDriver driver;
	ExtentReports extent = ExtentReport.getReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
     
	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
	
	
	
	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

			extentTest.get().log(Status.PASS, "Test Passed");
		  Object testClass = result.getInstance();
		  WebDriver webDriver = ((BaseClass) testClass).driver; //Take base64Screenshot screenshot.
		  String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
		  getScreenshotAs(OutputType.BASE64);
		  //Extentreports log and screenshot operations for passed tests.
		  extentTest.get().addScreenCaptureFromBase64String(base64Screenshot);
		  System.out.println("Screenshots for passed test " +  getTestMethodName(result) + " Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		extentTest.get().log(Status.FAIL, "Test Failed");
		// capture screenshot on failure

		
		  Object testClass = result.getInstance(); WebDriver webDriver =
		  ((BaseClass) testClass).driver; //Take base64Screenshot screenshot.
		  String base64Screenshot =
		  "data:image/png;base64,"+((TakesScreenshot)webDriver).
		  getScreenshotAs(OutputType.BASE64);
		  //Extentreports log and screenshot operations for failed tests.
		  extentTest.get().addScreenCaptureFromBase64String(base64Screenshot);
		  System.out.println("Screenshots for failed test " +  getTestMethodName(result) + " Failed");
		 
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}
}
