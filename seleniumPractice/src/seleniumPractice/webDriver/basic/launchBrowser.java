package seleniumPractice.webDriver.basic;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class launchBrowser {
	
	public static WebDriver driver= null; //object variable for web driver

	public static void main(String[] args) throws InterruptedException  //exceptions can be added here
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe"); //set driver path
		driver= new ChromeDriver(); // launch driver object
	//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  //Different wait functions??
			
		driver.navigate().to("https://Amazon.in");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("Amazon.in"))
				System.out.println("Title Matches");
		
		else
			System.out.println(title);
		
		//Identify the web element
		String tagName=" ";
		tagName= driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)")).getText();
		System.out.println(tagName);
		
		//Action on the web element 
		WebElement category = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
		Actions action=  new Actions(driver);
		action.moveToElement(category).perform(); // why use perform class here??
		Thread.sleep(2000);
		action.click();
		action.perform();
		
		
	/*	WebElement categoryAll= driver.findElement(By.cssSelector("#nav-hamburger-menu > i"));
		action.moveToElement(categoryAll);
		Thread.sleep(2000);
		action.click();
		action.perform();*/
		
		//Click on Amazon Launchpad
		driver.findElement(By.linkText("Amazon Launchpad")).click(); 
		Thread.sleep(2000);
		System.out.println("Amazon Launchpad");
		
		//Search a product on the search bar
		WebElement myElement = driver.findElement(By.id("twotabsearchtextbox"));
		myElement.sendKeys("niacinamide serum");
		System.out.println(myElement);
		
		//click on the search button
		//driver.findElement(By.className("nav-input nav-progressive-attribute")).click();
		driver.findElement(By.id("nav-search-submit-button")).click(); //nav-input nav-progressive-attribute
		Thread.sleep(2000);
		
		//Click on the selected product
		driver.findElement(By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.sg-row > div.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(1) > div > span > div > div > div:nth-child(2) > div.sg-col-4-of-12.sg-col-4-of-16.sg-col.sg-col-4-of-20 > div > div > span > a > div > img")).click();
		Thread.sleep(2000);
		
		//Switch to new window
		String parent=driver.getWindowHandle();
		System.out.println("Parent window : "+parent);
		
		Set<String> allWindows=driver.getWindowHandles();
		int count=allWindows.size();
		System.out.println(count);
		
		for (String child:allWindows)
		{
			if (!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.findElement(By.id("add-to-cart-button")).click();
			}
		}
		

	}

}
