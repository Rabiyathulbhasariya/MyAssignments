package maranthon.testcase1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AbhiBus {

	public static void main(String[] args) {
		
		//01) Launch  Chrome
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//add  implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//02) Load https://www.abhibus.com/
		driver.get("https://www.abhibus.com/");
		
		//	03) Click on Bus
		driver.findElement(By.linkText("Bus")).click();
		
		//04) Type "Chennai" in the FROM text box
		driver.findElement(By.id("source")).sendKeys("Chennai");
		
		//05) Click the first option from the pop up box
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		
		//06) Type "Bangalore" in the TO text box
		driver.findElement(By.id("destination")).sendKeys("Bangalore");
		
		//07) Click the first option from the pop up box
		driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
		
		//08) Select tomorrow s date in the Date field
		driver.findElement(By.id("datepicker1")).click();
		driver.findElement(By.xpath("(//a[text()='26'])[1]")).click();
		
		//09) Click Search Buses
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		//10) Print the name of the first resulting bus
		String bus1 = driver.findElement(By.xpath("(//div[@class='search-column1']/h2)[1]")).getText();
		System.out.println("Bus Name - '"+bus1+"'");
		
		//11) Choose SLEEPER in the left menu from Bus Type
		driver.findElement(By.xpath("//input[@title='SLEEPER']")).click();
		
		//12) Print the first resulting bus seat count
		String seat = driver.findElement(By.xpath("(//div[@class='search-column2-col1']/p)[1]")).getText();
		System.out.println("Available Seat in Sleeper Class - '"+seat+"'");
		
		//13) Click SelectSeat
		driver.findElement(By.xpath("(//span[text()='Select Seat'])[1]")).click();
		
		//14) Choose any one Available seat
		driver.findElement(By.xpath("//a[contains (@href,'DU6')]")).click();
		
		//15) Print Seats Selected ,Total Fare
		String selectedseat = driver.findElement(By.xpath("//span[@id= 'seatnos']")).getText();
		System.out.println("The Selected Seat Number - '"+selectedseat+"'");
		
		String totalfare = driver.findElement(By.xpath("//span[@id= 'ticketfare']")).getText();
		System.out.println("Total Fare - '"+totalfare+"'");
		
		//16) Select Boarding Point  and Dropping Point (Select class)
		//Boarding Point
		WebElement board = driver.findElement(By.id("boardingpoint_id"));
		Select bpt = new Select(board);
		bpt.selectByIndex(10);
						
		//Dropping Point
		WebElement drop = driver.findElement(By.id("droppingpoint_id"));
		Select dpt = new Select(drop);
		dpt.selectByIndex(10);
		
		//17) Get the Title of the page(use .getTitle())
		String title = driver.getTitle();
		System.out.println("The title of the Web page is - '"+title+"'");
		
		//18) Close the browser 
		driver.close();
	}

}
