package week6.day19;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends ProjectSpecificMethod{
	@BeforeTest
	public void sheet()
	{
		sheetName="Edit Lead";
	}
	//@Test(dependsOnMethods = "week6.day19.CreateLead.testCase1", dataProvider = "editdata")
	@Test(dataProvider = "editdata")
	public void testCase2(String phno, String cname) throws InterruptedException {

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phno);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.name("submitButton")).click();
	}
	
	@DataProvider (name = "editdata")
	public String[][] editlead() throws IOException
	{
		String[][] data = TestData.excelData(sheetName); 

		return data;
		
	}
}






