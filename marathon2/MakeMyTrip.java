package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notification");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Actions act = new Actions(driver);

		// 1. Open the MakeMyTrip Website. https://www.makemytrip.com/
		driver.get("https://www.makemytrip.com/");

		//2. Close the Sweet Alert.
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='webengage-notification-container']/iframe")));
		//System.out.println("Inside Frame");
		driver.findElement(By.className("close")).click();
		driver.switchTo().defaultContent();

		//3. Click on the website logo.

		WebElement logo = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
		driver.executeScript("arguments[0].click();",logo);

		// 4. Navigate to the "Holiday Packages" section.
		driver.findElement(By.xpath("//span[text()='Holiday Packages']")).click();

		// 5. Input "Chennai" as the departure city.

		driver.findElement(By.id("fromCity")).click();

		// 6. Select the first suggested city.
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();

		// 7. Specify "Goa" as the destination city.
		driver.findElement(By.id("toCity")).click();

		// 8. Choose the first city suggestion.
		driver.findElement(By.xpath("(//div[@class='dest-city-name'])[2]")).click();

		// 9. Pick a date from the calendar.
		driver.findElement(By.xpath("(//div[@class='DayPicker-Day'])[1]")).click();

		// 10. Adjust the number of adults to the maximum allowed.
		driver.findElement(By.xpath("//div[@data-testid='adult-increment-counter']")).click();

		// 11. Click on the apply button. 
		driver.findElement(By.className("applyBtn")).click();

		// 12. Set the trip duration to 3-5 nights.
		WebElement start = driver.findElement(By.xpath("//div[@class='rc-slider-handle rc-slider-handle-1']"));
		act.dragAndDropBy(start, 66, 0).build().perform();
		WebElement end = driver.findElement(By.xpath("//div[@class='rc-slider-handle rc-slider-handle-2']"));
		act.dragAndDropBy(end, -198, 0).build().perform();

		// 13. Click on the apply button
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();

		// 14. Click on the search button.
		driver.findElement(By.xpath("//button[text()='Search']")).click();

		// 15. Skip an automated assistance prompt.
		driver.findElement(By.xpath("//button[text()='SKIP']")).click();
		driver.findElement(By.xpath("//span[@class='close closeIcon']")).click();

		// 16. Capture a screenshot of the first vacation package.
		act.scrollToElement(driver.findElement(By.xpath("//h2[text()='Go for Land Only Goa Packages!']"))).build().perform();
		File source1 = driver.getScreenshotAs(OutputType.FILE);
		File target1 = new File("./snap/allpackages.png");
		FileUtils.copyFile(source1, target1);

		driver.findElement(By.xpath("(//div[@class='sliderCard'])[1]//img")).click();
		driver.findElement(By.xpath("//div[text()='With Flight']")).click();
		Set<String> packages = driver.getWindowHandles();
		List<String> lpack = new ArrayList<String>(packages);
		driver.switchTo().window(lpack.get(1));
		driver.findElement(By.xpath("//button[text()='SKIP']")).click();

		File source2 = driver.getScreenshotAs(OutputType.FILE);
		File target2 = new File("./snap/firstpackage.png");
		FileUtils.copyFile(source2, target2);

		// 17. Print the current page title.
		System.out.println("Title - " + driver.getTitle());

		// 18. Close the web browser.
		driver.close();
		driver.switchTo().window(lpack.get(0));
		driver.close();


	}

}
