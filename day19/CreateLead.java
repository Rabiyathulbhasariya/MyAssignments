package week6.day19;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateLead extends ProjectSpecificMethod{
	@BeforeTest
	public void sheet()
	{
		sheetName="Create Lead";
	}
	@Test(dataProvider = "createdata", priority = -1) // default is 0. if given -1, it will run first
	
	public void testCase1 (String cname, String fname, String lname, String phno) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();
		
}
	@DataProvider(name = "createdata")
	public String[][] testdataCreate() throws IOException
	{
		String[][] data = TestData.excelData(sheetName);
		return data;
	}
	
}






