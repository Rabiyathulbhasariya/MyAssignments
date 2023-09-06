package week5.day14;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps");
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//img[contains(@src,'images/fieldlookup')])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindow = new ArrayList<String>(windowHandles);
		
			driver.switchTo().window(listWindow.get(1));
			driver.findElement(By.xpath("((//table[@class='x-grid3-row-table'])[1]//a)[1]")).click();
			driver.switchTo().window(listWindow.get(0));
		
		driver.findElement(By.xpath("(//img[contains(@src,'images/fieldlookup')])[2]")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listWindow1 = new ArrayList<String>(windowHandles1);
		
			driver.switchTo().window(listWindow1.get(1));
			driver.findElement(By.xpath("((//table[@class='x-grid3-row-table'])[2]//a)[1]")).click();
			driver.switchTo().window(listWindow1.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
		String title = driver.getTitle();
		System.out.println("Title of the page - "+title);
		
		
	}

}
