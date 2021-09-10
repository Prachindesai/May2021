package Actions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertsDemo2 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Prachi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		
		Actions actions=new Actions(driver);
		
		WebElement ClickHere=driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		
		ClickHere.click();  
		
	    String MainWindow=driver.getWindowHandle();
	    
	    Set<String> ChildWindows=driver.getWindowHandles();
	    
	    Iterator<String> iterator=ChildWindows.iterator();
	    
	    while(iterator.hasNext())
	    {
	    	String childWindow=iterator.next();
	    	if(!MainWindow.equalsIgnoreCase(childWindow))
	    			{
	    		       driver.switchTo().window(childWindow);
	    			}
	    }
		
		WebElement UserName= driver.findElement(By.name("emailid"));
		UserName.sendKeys("abcd@gmail.com");
		actions.pause(2000);
		actions.sendKeys(Keys.TAB);
		actions.pause(2000);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
		
		WebElement ClickHere2=driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		ClickHere2.click();
		
		actions.pause(2000);
		
		WebElement ClickHere3=driver.findElement(By.xpath("//p[@style='text-align:center']/child::a"));
		ClickHere3.click();
		
		driver.close();
		
		driver.quit();
	}

}
