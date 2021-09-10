import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Google {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Prachi\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
     
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        
        driver.get("https://www.google.com");
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        
        String instagramurl="https://www.instagram.com";
        driver.navigate().to(instagramurl);
        //driver.get(instagramurl);
        
        driver.navigate().back();  ///html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input
        
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/div/div[2]/a")).click(); //image
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("India");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Olympics 2021");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
	}                               

}
