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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TataCliq {

	public String prices(List<WebElement> prices)

	{
		String secondprice=null;
		for(int i=0; i<prices.size();i++)
		{

			String p = prices.get(i).getText();
			String num = p.replaceAll("\\D", "");
			System.out.println(num);
			if(i==1)
			{
				secondprice = num;	
			}

		}

		return secondprice;
	}

	public static void main(String[] args) throws IOException {


		// 1.Lanuch the browser and Handle the Notification

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);

		// 2.Maximize the window and add wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		

		// 3. Load the Url(https://www.tatacliq.com/)
		driver.get("https://www.tatacliq.com/");        

		// 4.MouseHover on Brands
		Actions act = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//div[text()='Brands']"));
		act.moveToElement(brands).perform();

		// 5.click Watches & Accessories
		WebElement watch = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		act.click(watch).perform();

		// 6.Choose the first option from the Brand display
		driver.findElement(By.xpath("(//div[text()='Featured brands']/following-sibling::div)[1]")).click();

		// 7.Select sort by-New Arrivals
		WebElement sort = driver.findElement(By.className("SelectBoxDesktop__hideSelect"));
		Select options = new Select(sort);
		options.selectByVisibleText("New Arrivals");

		// 8.Click Men check box
		driver.findElement(By.xpath("(//div[@class='FilterDesktop__newFilCheckbox'])[1]")).click();

		// 9.Print all price of watches(take only numbers)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		wait.until(ExpectedConditions.visibilityOfAllElements(prices));
		System.out.println(prices.size());
		System.out.println("Watch prices");
		// 10.Print the watches price
		TataCliq pp = new TataCliq();
		String secondprice =pp.prices(prices);
		System.out.println("The Price of second watch - " +secondprice);
		// 11.click the second loaded result
		WebElement select = driver.findElement(By.xpath("(//div[@class='ProductDescription__content']/h2)[2]"));
		act.click(select).perform();
		// 12.Handle the window and Print the price of the watch
		Set<String> watchwindow = driver.getWindowHandles();
		List<String> listwatch = new ArrayList<String>(watchwindow);
		driver.switchTo().window(listwatch.get(1));
		String selectedprice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText();
		String sp = selectedprice.replaceAll("\\D", "");
		System.out.println("The Price of selected watch - " +sp);
		// 13.Compare two price and print Both price are equal
		if(secondprice.equals(sp))
		{
			System.out.println("Price is Matched");
		}
		else
			System.out.println("Price is not Matched");

		// 14.Click Add to Bag
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();

		// 15.Check the bag count
		String count = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
		System.out.println("Bag count - " +count);

		// 16.Click the cart bag
		driver.findElement(By.className("DesktopHeader__myBagShow")).click();

		// 17.Take snapshot of result 
		WebElement visible = driver.findElement(By.xpath("//span[text()='Checkout']"));
		wait.until(ExpectedConditions.visibilityOf(visible));
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File ("./snap/tata.png");
		FileUtils.copyFile(source, target);

		// 18.Close the open window
		driver.close();
		//  19.Close the browser
		driver.quit();


	}

}


