package week6.day18;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DuplicateLead extends ProjectSpecificMethod{
	@Test(dataProvider = "duplicatedata", invocationCount = 2, invocationTimeOut = 2000, threadPoolSize = 2)
	public void testCase3(String phno) throws InterruptedException {

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phno);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
		
	}
	
	@DataProvider (name = "duplicatedata")
	public String[][] dupdata()
	
	{
		String[][] data = new String[2][1];
		data[0][0]="8056094313";
		data[1][0]="8056094312";
		return data;	
	}
}






