package maranthon.testcase3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class PVRCinemas {

	public static void main(String[] args) throws InterruptedException   {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();


		//01) Launch the Url  https://www.pvrcinemas.com/
		driver.get("https://www.pvrcinemas.com/");

		//Code to handle browser notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//ChromeDriver driver1 = new ChromeDriver(options);
		//driver.get("");

		//02) Select the City -->chennai

		driver.findElement(By.name("search-cities")).sendKeys("Chennai");

		driver.findElement(By.xpath("//img[@alt='Chennai']")).click();

		//03) Click  on Movie Library
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@class='nav-icon']")).click();
		driver.findElement(By.xpath("//a[text()='Movie Library']")).click();

		//04) Select the Genre-->Animation
		WebElement genre = driver.findElement(By.name("genre"));
		Select genres = new Select(genre);
		genres.selectByVisibleText("ANIMATION");

		//05) Select the Language-->english
		WebElement language = driver.findElement(By.name("lang"));
		Select lang = new Select(language);
		lang.selectByVisibleText("ENGLISH");

		//06) Click on Apply
		driver.findElement(By.xpath("//button[text()='Apply']")).click();

		//07) Click on first resulting animation movie
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='movie-wrapper ng-star-inserted']//div)[1]")).click();

		//08) Click proceed to book
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Proceed To Book']")).click();

		//09) Enter  all  the fields  cinema , Name, date, Prefered show time, no of seats, food and beverages,Email and Mobile
		WebElement cinema = driver.findElement(By.id("cinemaName"));
		Select cini = new Select(cinema);
		cini.selectByValue("PVR Heritage RSL ECR Chennai");

		driver.findElement(By.xpath("//div[@class='datepicker-container datepicker-default']")).click();
		driver.findElement(By.xpath("//span[@class='day-unit ng-star-inserted']")).click();

		WebElement time = driver.findElement(By.name("timings"));
		Select show = new Select(time);
		show.selectByValue("09:00 AM - 12:00 PM");

		driver.findElement(By.name("name")).sendKeys("Rabiya");
		driver.findElement(By.name("email")).sendKeys("bhasariya@gmail.com");
		driver.findElement(By.name("mobile")).sendKeys("8056094313");
		driver.findElement(By.name("noOfTickets")).sendKeys("2");

		WebElement food = driver.findElement(By.name("food"));
		Select fb = new Select(food);
		fb.selectByValue("Yes");
		driver.findElement(By.name("comment")).sendKeys("No");

		//10) Click on copy to self 
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='copySelf']/following-sibling::span)[2]")).click();

		//11) Click on  Send Request
		driver.findElement(By.xpath("//button[text()='SEND REQUEST']")).click();
		//12) Click cancel 
		driver.findElement(By.xpath("(//button[text()='CANCEL'])[2]")).click();
		//13) Close the OTP dialog
		driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
		//14) Verify the ttile of the page
		String title = driver.getTitle();
		System.out.println("The title of the page is '"+title+"'");


	}

}
