package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityAddNewUser {
	static FileInputStream f; //excel file 
	static XSSFWorkbook w; //Book1
	static XSSFSheet s;// sheets
  public static String getStringData(int a,int b,String sheet) throws IOException // a is row ,b is column or cell
	{
		f=new FileInputStream("C:\\Users\\Lajitha Hareendralal\\eclipse-workspace\\GroceryApplicationProject\\src\\main\\resources\\AddNewUser.xlsx");
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue(); //inbuilt method for excelsheet connection
	}
	public static String getIntegerData(int a,int b,String sheet) throws IOException { 
		f=new FileInputStream("C:\\Users\\Lajitha Hareendralal\\eclipse-workspace\\GroceryApplicationProject\\src\\main\\resources\\AddNewUser.xlsx");
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);//10
		int y=(int) c.getNumericCellValue();// string - integer  = typecasting, getNumericCellValue()-return a double value.
		return String.valueOf(y);//convert to string , otherwise it will return double.
	}

}
