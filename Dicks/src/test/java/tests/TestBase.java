package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestBase
{
	ExtentReports report;
	ExtentTest logger;
	public static WebDriver driver;
	
	  
	@BeforeSuite
	public void Extent()
	{
		report=new ExtentReports("D:/Luna/Dicks/Reports/ExtentReport.html");
		logger=report.startTest("Verifylog");
	}
	
	 @BeforeTest
	 @Parameters("Browser")
	 public void setup(String Browser)
	 {
		 if(Browser.equalsIgnoreCase("Chrome"))
		 {
		 System.setProperty("webdriver.chrome.driver","D:/Testing/chromedriver.exe");
		 driver=new ChromeDriver();
		 }
		 else if(Browser.equalsIgnoreCase("Firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver","D:/Testing/geckodriver.exe");
			 DesiredCapabilities caps = new DesiredCapabilities();
		     caps.setCapability("marionette", true);
			 driver=new FirefoxDriver();
			
		 }
		 else
		 {
			 System.out.println("You have choose some other browser");
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	 }
	 
	 @Test
	 public void url() throws FileNotFoundException
	 {
		 Properties property = new Properties();
		 FileInputStream objFile = new FileInputStream("D:/Luna/Dicks/src/test/java/utils/config.properties");

		 try {
			 property.load(objFile);
			 
			 } catch (IOException e) {
			 System.out.println(e.getMessage());
			 e.printStackTrace();
			 }

		 driver.get(property.getProperty("url"));

	 }
	 
	 @AfterTest
	 public void teardown()
	 {
		
		 report.endTest(logger);
		 report.flush();
		 driver.get("D:/Luna/Dicks/Reports/ExtentReport.html");
		 driver.quit();
	 }
		 
	    
}
