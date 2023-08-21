package week2.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("8056094313");
		driver.findElement(By.id("ext-gen334")).click();
		Thread.sleep(2000);
		WebElement leadid = driver.findElement(By.xpath("(//a[(@class = 'linktext')])[4]"));
		Thread.sleep(2000);
		String id = leadid.getText();
		System.out.println(id);
		//to delete lead
		driver.findElement(By.xpath("(//a[(@class = 'linktext')])[4]")).click();
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(id);
		driver.findElement(By.id("ext-gen334")).click();
		Thread.sleep(3000);
		WebElement records = driver.findElement(By.id("ext-gen437"));
				Thread.sleep(3000);
		String record = records.getText();
		System.out.println(record);
		if (record.equals("No records to display") )
		{
			System.out.println("Lead Id "+ id + " is deleted");
		}
		else
		{
			System.out.println("Lead Id "+ id + " is not deleted");
		}
			
		

	}

}
