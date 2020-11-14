package com.costco.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;


public class BaseTest {
	public static Properties prop;
	public static  WebDriver driver;
	public static Logger logger;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest exTest;
	public BaseTest() throws IOException{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\nafas\\Desktop\\New_Workspace_Eclipse\\com.costco1\\src\\main\\java\\com\\costco\\qa\\config\\config.properties");
	    prop.load(fis);
	   // logger=Logger.getLogger(BaseTest.class);
	   // PropertyConfigurator.configure("log4j.properties");
	    
	}  
	@BeforeMethod
	public void initialization() {
		//String browserName=prop.getProperty("browser");
		String browserName="chrome";
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nafas\\Desktop\\New_Workspace_Eclipse\\com.costco1\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\nafas\\Desktop\\New_Workspace_Eclipse\\com.costco1\\Browser\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));
		driver.get("https://www.costco.com/");
		
	}
	@BeforeTest
	public  void setExtent() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/myExtentReport.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Regression Test");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host", "Local Host");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Tester", "Muhammad Sohag");
		}
	
	@Test
	public void titleTest() {
		driver.getTitle();
		Assert.assertTrue(true);
		driver.quit();
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	@AfterMethod
	public void extentReportProducer(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			exTest.log(Status.FAIL, "Name of the Test is: "+result.getName());
			exTest.log(Status.FAIL, "Reason is: "+result.getThrowable());
			String screenshotPath=takeScreenShot(driver,result.getName());
			exTest.addScreenCaptureFromPath(screenshotPath);
			
		}else if(result.getStatus()==ITestResult.SKIP){
			exTest.log(Status.SKIP, "Name of the Test is: "+result.getName());
			
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			exTest.log(Status.PASS, "Name of the test is: "+result.getName());
		}
		
	}
	
	
	public static String takeScreenShot(WebDriver driver, String ScreenShotName) throws IOException {
		String dateName=new SimpleDateFormat("YYYYMMDDMMSS").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/Screenshot/"+ScreenShotName+dateName+".png";
		File finalDestination=new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
	}
	
	

}
