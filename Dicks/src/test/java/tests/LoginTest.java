package tests;

import java.io.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.Utils;



import pages.HomePage;
import pages.LoginPage;
import pages.SignoutPage;
import utils.xlsxReader;

public class LoginTest extends TestBase
{
	   @DataProvider
	   public String[][] excelReader() throws IOException
	   {
		   xlsxReader read=new xlsxReader();
		   return read.getExcelData("D:/Luna/Dicks/src/test/java/resources/Suite1.xlsx","Login");
		  // Object[][] obj=getExcelData("D:/Luna/Dicks/src/test/java/resources/Suite1.xlsx","Login");
		  // return obj;
	   }
		
	@Test
	public void Home()
	{
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.clickMyAccount();
		
	}
	
	@Test(dataProvider="excelReader")
	public void init(String User,String Pass)
	{		
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		 lp.setUsername(User);
		 lp.setPassword(Pass);
		 lp.clickNext();
		 SignoutPage so=PageFactory.initElements(driver, SignoutPage.class);
		 so.clickSignOut();
	}
	
	@AfterMethod
	public void screenShot(ITestResult Result)
	{
		if(ITestResult.FAILURE==Result.getStatus())
		{
			try
			{
				TakesScreenshot TSS=(TakesScreenshot)driver;
				File src=TSS.getScreenshotAs(OutputType.FILE);
			    Utils.copyFile(src,new File("D:\\"+Result.getName()+ "png"));
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

}
