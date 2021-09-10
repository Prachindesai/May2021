package Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public static void main(String[] args) 
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Prachi\\Downloads\\chromedriver_win32\\chromedriver.exe");
	        
		 //---1
			WebDriver driver=new ChromeDriver();
			driver.navigate().to("https://demoqa.com/alerts");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			WebElement AlertBtn=driver.findElement(By.xpath("//button[@id='alertButton']"));
			AlertBtn.click();
			driver.switchTo().alert().accept();
			
			//---2
			WebElement TimerAlerBtn=driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
			TimerAlerBtn.click();
			
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent()).accept();
			
			//---3
			WebElement ConfirmBtn=driver.findElement(By.xpath("//button[@id='confirmButton']"));
			ConfirmBtn.click();
			String alertTxt=driver.switchTo().alert().getText();
			System.out.println(alertTxt);
			driver.switchTo().alert().dismiss();
			
			//---4
			//driver.findElement(By.xpath("//div[@id='ad_unit']//child::img")).click();
			
			driver.findElement(By.xpath("//a[@id='close-fixedban']")).click(); //^
			
			WebElement PromptBtn=driver.findElement(By.xpath("//button[@id='promtButton']"));
			PromptBtn.click();
			driver.switchTo().alert().sendKeys("Prachi");
			driver.switchTo().alert().accept();
			driver.close();
	}

}
