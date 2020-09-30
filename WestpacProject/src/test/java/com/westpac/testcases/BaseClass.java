package com.westpac.testcases;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



//Common resources in the Base Class
public class BaseClass {

	public static WebDriver driver;
	public Properties prop;
	public String url;


	@BeforeClass
	public WebDriver intializeDriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fis =new FileInputStream("./configurations/config.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		url=prop.getProperty("url");

		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//driver.get(url);
		return driver;
	}


	@AfterClass
	public void closedriver(){

		//closes the browser instance
		//driver.quit();

	}




}
