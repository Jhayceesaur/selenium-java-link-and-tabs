import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintLimitOpenSeparateTabsLinks 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Print and get count of all links within the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Limiting webdriver scope (web page footer)
		WebElement footerdriver = driver.findElement(By.cssSelector(".footer_top_agile_w3ls"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//Lomiting webdriver scope (particular column)
		WebElement columndriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//Click all each link and open in new tab
		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++)
		{
			String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
			
		}
		//Get and print each title of the tabs
		Set <String> windowsTab = driver.getWindowHandles();
		Iterator <String> it = windowsTab.iterator();
			
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}
