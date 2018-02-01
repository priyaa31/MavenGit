package fileCopy;

import java.io.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFile
{
	
	public static void main(String[] args) throws IOException
	{
		String[][] a=null;
		FileInputStream f=new FileInputStream("D:/Book1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet sh=wb.getSheetAt(0);
		Row r=sh.getRow(0);
		int rownum=sh.getLastRowNum();
		int colnum=r.getLastCellNum();
		//System.out.println(rownum);
		a=new String[rownum][colnum];
		for(int i=1;i<=rownum;i++)
		{
			r=sh.getRow(i);
			for(int j=0;j<colnum;j++)
			{
			a[i-1][j]=r.getCell(j).toString();
			System.out.println(a[i-1][j]);
			}
			
		}
		
		FileOutputStream fout=new FileOutputStream("D:/Book2.xlsx");
		wb.write(fout);
		
	}

}
