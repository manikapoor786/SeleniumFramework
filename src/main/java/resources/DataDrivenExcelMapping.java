package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenExcelMapping {
	
	public void exceldatadriven(String credentialHeader) throws IOException
	{
		FileInputStream fis= new FileInputStream("C://Selenium//E2EProject1//src//main//java//resources//data.xlsx");
		XSSFWorkbook xs= new XSSFWorkbook(fis);
		XSSFSheet sheet= xs.getSheet("Sheet1");	
		
		Iterator<Row> rows=sheet.iterator();
		Row firstrow= rows.next();
		Iterator<Cell> cells= firstrow.cellIterator();
		int k=0;
		int column;
		while(cells.hasNext())
		{
			Cell value=cells.next();
			if(value.getStringCellValue().equalsIgnoreCase(credentialHeader))
			{
				column=k;
			}
			k++;
		}
		
	}
	
	public static void main (String args []) throws IOException	
	{
		DataDrivenExcelMapping ddm= new DataDrivenExcelMapping();
		ddm.exceldatadriven("Login");
	}
}
