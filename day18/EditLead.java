package week6.day18;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends ProjectSpecificMethod{

	@Test(dataProvider = "editdata")
	public void testCase2(String phno, String cname) throws InterruptedException {

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phno);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.name("submitButton")).click();
	}
	
	@DataProvider (name = "editdata")
	public String[][] editlead()
	{
		String[][] data = new String[2][2];
		data[0][0]="8056094313";
		data[0][1]="CapGemini";
		
		data[1][0]="8056094312";
		data[1][1]="Infosys";

		return data;
		
	}
}






