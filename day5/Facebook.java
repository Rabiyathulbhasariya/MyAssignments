package week2.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Rabiya");
		driver.findElement(By.name("lastname")).sendKeys("Abubakkar");
		driver.findElement(By.name("reg_email__")).sendKeys("rabiyathulbhasariya@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("rabiyathulbhasariya@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("newfacebook");
		
		//Date of Birth selection
		
		WebElement drop1 = driver.findElement(By.id("day"));
		Select day = new Select(drop1);
		day.selectByValue("25");
		
		WebElement drop2 = driver.findElement(By.id("month"));
		Select month = new Select(drop2);
		month.selectByValue("9");
		
		WebElement drop3 = driver.findElement(By.id("year"));
		Select year = new Select(drop3);
		year.selectByValue("1991");
		
		//Select Gender
		
		driver.findElement(By.xpath("//input[@value='1']")).click();
	}

}
