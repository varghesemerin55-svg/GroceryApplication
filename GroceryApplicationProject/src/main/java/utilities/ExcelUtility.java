package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;
	
	public static String getStringData(int a,int b, String sheet) throws IOException 
	{
		f=new FileInputStream(Constant.TESTDATA);
		//f=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\GroceryApplicationProject\\src\\test\\resources\\TestDataGroceryApplication.xlsx");
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue();
	}
	
	public static int getIntegerData(int a,int b, String sheet) throws IOException 
	{
		//f=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\GroceryApplicationProject\\src\\test\\resources\\TestDataGroceryApplication.xlsx");
		f=new FileInputStream(Constant.TESTDATA);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		int y= (int) c.getNumericCellValue();//type casting
		return y;
		
	}

}
