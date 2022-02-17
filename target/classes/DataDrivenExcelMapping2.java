package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenExcelMapping2 {
	
	public ArrayList<String> getExcelData(String credentialHeader) throws IOException
	{
		FileInputStream fis= new FileInputStream("C://Selenium//E2EProject1//src//main//java//resources//data.xlsx");
		XSSFWorkbook xs= new XSSFWorkbook(fis);
		XSSFSheet sheet= xs.getSheet("Sheet1");	

		int rowCount= sheet.getLastRowNum()-sheet.getFirstRowNum();
		ArrayList<String> al= new ArrayList<String>();
		
		for(int i=0;i<=rowCount;i++)
		{
			int colCount=(sheet.getRow(i).getLastCellNum())-1;
			String header= sheet.getRow(i).getCell(0).getStringCellValue();
			if(header.equalsIgnoreCase(credentialHeader))
			{
				for(int j=1;j<=colCount;j++)
				{
					al.add(sheet.getRow(i).getCell(j).getStringCellValue());
				}
					break;
			}
		}
		return al;
	}
}
