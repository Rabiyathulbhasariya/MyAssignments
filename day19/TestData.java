package week6.day19;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData 
{

	public static String[][] excelData(String fileName) throws IOException 
	{
		XSSFWorkbook workbook = new XSSFWorkbook("./data/TestData.xlsx");
		XSSFSheet sheet = workbook.getSheet(fileName);
		int rowCount = sheet.getLastRowNum();
		short colCount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][colCount];
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				data[i-1][j]= sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		workbook.close();
		return data;
		
	}
}

