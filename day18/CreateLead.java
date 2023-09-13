package week6.day18;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateLead extends ProjectSpecificMethod{
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
	public String[][] testdataCreate()
	{
		String[][] data = new String[2][4];
		data[0][0]="TCS";
		data[0][1]="Rabiya";
		data[0][2]="Abu";
		data[0][3]="8056094313";
		
		data[1][0]="CTS";
		data[1][1]="Rabi";
		data[1][2]="Abu";
		data[1][3]="8056094312";
		return data;
	}
	
}






