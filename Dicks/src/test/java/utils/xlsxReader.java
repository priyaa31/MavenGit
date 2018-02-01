package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsxReader
{
	public String[][] getExcelData(String filename,String sheet) throws IOException 
	{
		String[][] excelData=null;
		FileInputStream fis=new FileInputStream(filename);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet(sheet);  
		Row r=sh.getRow(0);
		int rownum=sh.getLastRowNum();
		int colnum=r.getLastCellNum();
		excelData=new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++)
		{
			r=sh.getRow(i);
			for(int j=0;j<colnum;j++)
			{
				
				excelData[i-1][j]=r.getCell(j).toString();

			}
			
		}
		return excelData;
	}


}
