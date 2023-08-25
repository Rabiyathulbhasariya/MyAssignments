package maranthon.testcase2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		//01) Launch Chrome 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//add  implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		//02) Load https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		
		//03) Type "Bags" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
					
		//04) Choose the      item in the result (bags for boys)
		driver.findElement(By.xpath("//div[@aria-label = \"bags for boys\"]")).click();
		
		//05) Print the total number of results (like 50000)
		String result = driver.findElement(By.xpath("//div[@class = 'a-section a-spacing-small a-spacing-top-small']")).getText();
		String no = result.replaceAll("\\D", "");
		String res = no.substring(3);
		System.out.println("The total number of results - "+res);
		
		//06) Select the first 2 brands in the left menu
	    driver.findElement(By.xpath("(//ul[@data-csa-c-content-id = '3837712031']//div)[1]")).click();
	    
	    driver.findElement(By.xpath("(//ul[@data-csa-c-content-id = '3837712031']//div)[2]")).click();
	    
	    
		//07) Choose New Arrivals (Sort)
	    driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
	  
	     driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
	     
	     //08) Print the first resulting bag info (name, discounted price)
	     String name = driver.findElement(By.xpath("(//div[contains(@cel_widget_id, 'MAIN-SEARCH_RESULTS')]//h2//a//span)[1]")).getText();
	     System.out.println("The Name of the first resulting bag - "+name);
	     
	     String price = driver.findElement(By.xpath("(//span[@class = 'a-price-whole'])[4]")).getText();
	     System.out.println("The Discounted price of the first resulting bag - "+price);
	     
	     //09) Get the page title and close the browser(driver.close())
	     String title = driver.getTitle();
	     System.out.println("The title of the page - "+title);
	     driver.quit();
		

	}

}
