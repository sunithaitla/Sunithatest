Project: Westpac Kiwi Saver Project

Test User Story 1: 
Priority: Major
As a Product Owner 
I want that while using the KiwiSaver Retirement Calculator all fields in the calculator have got the information icon present
So that 
The user is able to get a clear understanding of what needs to be entered in the field.

Acceptance Criteria
Scenario 1 
Given User Clicks information icon besides Current age the message “This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.” is displayed below the current age field.

 
Test User Story 2:
Priority: Major
As a Product Owner 
I want that the KiwiSaver Retirement Calculator users are able to calculate what their KiwiSaver projected balance would be at retirement
So that 
The users are able to plan their investments better.

Acceptance Criteria

User whose Current age is 30 is Employed @ a Salary 82000 p/a, contributes to KiwiSaver @ 4% and chooses a Defensive risk profile can calculate his projected balances at retirement.

 User whose current aged 45 is Self-employed, current KiwiSaver balance is $100000, voluntary contributes $90 fortnightly and chooses Conservative risk profile with saving goals requirement of $290000 can calculate his projected balances at retirement.

User whose current aged 55 is not employed, current KiwiSaver balance is $140000, voluntary contributes $10 annually and chooses Balanced risk profile with saving goals requirement of $200000 is able to calculate his projected balances at retirement.



Repository URL:
https://github.com/sunithaitla/Sunithatest.git


Prerequisite Setup:
 Java, Eclipse, Chrome Browser, Maven, TestNG, GIT should be in place and installed to download and execute the project
 
 
Framework Details to run the User Stories:
Approach: Data Driven
Programming language: Java 1.8 with Selenium Webdriver	 3.141.59
IDE: Eclipse NEON
Maven: A build tool to build a maven project with the help of dependencies which are mentioned in pom.xml (jars).
IDE: Eclipse NEON
Base Class: The Webdriver, Implicit waits, Reports and creating objects for File input stream are initialized through Base class through config file. BaseClass.java is under the package “com.westpac.testcases”.
Test Cases: The java test classes of scenarios are under “com.westpac.testcases”
Element Locators: The Element Locators and the methods are defined under the package “com.westpac.pageobjects” as this is a page object design model
Utility Function: Calling Test Data from excel sheet using generic function ExcelUtil.java under “com.westpac.utilities”
Property file: Browser types, URL, browser drivers which are static throughout the framework are mentioned in config.properties file under Configurations folder
Test Data: Data is stored in the form of excel sheet under ExcelFile Folder 
TestNG: Used TestNG Annotations for assertions, grouping, priority and parallel execution, and testing.xml file is used for the running of Test Suite
Parameterization: This is handled using Excel File as a part of data driven test. Apache poi jars are used to handle excel sheets
TestNG Listener Class: To generate logs or customize the TestNG reports using different methods
Extent Reports: Beautiful html reports are generated using .To maintain logs, Pass and fail status and details are generated in extent Reports
Screenshots: Screenshots for both pass and fail scenarios are captured after each test and added into extent reports for each test
Version Control: Git Repository using Git bash 2.28.0
Instruction to execute Test cases:
The execution is performed through testng.xml file where all the testcases are configured .Open testng.xml file. Right Click and Run as Test NG Suite. Wait for the execution to complete. Verify the html report in “reports” folder. The pass and fail details of test cases are found along with the screenshots.


Tests to Execute:
No. of Test cases         : 2
Total no of scenarios  : 4
