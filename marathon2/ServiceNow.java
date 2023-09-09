package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNow {

	public static void main(String[] args) throws IOException {

		//Initialization
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// 1.Launch ServiceNow application - URL: https://dev124621.service-now.com
		driver.get("https://dev124621.service-now.com");

		// 2.Login with valid credentials username as admin and password 
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Ak^x88vhDMV=");
		driver.findElement(By.id("sysverb_login")).click();

		// 3.Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();

		// 4.Click on  mobiles
		shadow.setImplicitWait(10);
		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("(//div[@class='homepage_category_only'])[8]/a")).click();


		// 5.Select Apple iPhone 13 Pro 
		driver.findElement(By.xpath("((//table[@role='presentation']//table)[8]//a)[1]")).click();

		// 6.Choose yes in lost or broken iphone. And enter original phNo as 99

		driver.findElement(By.xpath("(//div[@class='row sc-row']//label)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='row sc-row']//input)[6]")).sendKeys("99");

		// 7.Choose monthly data allowance as unlimited 
		WebElement drop = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select opt = new Select(drop);
		opt.selectByValue("unlimited");

		// 8.Update color field to Sierra Blue and storage field to 512GB
		driver.findElement(By.xpath("(//div[@class='sc-radio'])[7]//label")).click();
		driver.findElement(By.xpath("(//span[@class='input-group-radio'])[10]/label")).click();

		// 9.Click on Order now option
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();

		// 10.Verify order is placed and copy the request number"
		String request = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
		System.out.println("Request Id - "+request);

		// 11.Take a Snapshot of order placed page.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snap/servicenow.png");
		FileUtils.copyFile(source, target);
		driver.close();

	}

}
