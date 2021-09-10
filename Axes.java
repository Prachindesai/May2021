package Axes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Axes {

	public static void main(String[] args) 
	{
		//launch chrome browser
         System.setProperty("webdriver.chrome.driver","C:\\Users\\Prachi\\Downloads\\chromedriver_win32\\chromedriver.exe");
         WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
         
         System.out.println("-------SELF AXES------");
         System.out.println("");
         
         //driver.findElement(By.xpath("//a[contains(text(),'Tata Chemicals')]")).click(); //tata chemicals //using only contains method 
         
         String text= driver.findElement(By.xpath("//a[contains(text(),'Tata Chemicals')]/self::a")).getText();
         
         System.out.println(text);
         
         System.out.println("-------PARENT AXES------");
         
         String byparent= driver.findElement(By.xpath("//a[contains(text(),'Tata Chemicals')]/parent::td")).getText();
         
         System.out.println(byparent);
         
         System.out.println("");
         
         System.out.println("using descendant");
         
         String abc=driver.findElement(By.xpath("//a[contains(text(),'Tata Chemicals')]/ancestor::tbody/descendant::tr[9]")).getText();
         
         System.out.println(abc);
         
         System.out.println("using child");
         
         String chl=driver.findElement(By.xpath("//a[contains(text(),'Tata Chemicals')]/ancestor::tbody/child::tr[9]")).getText();
         
         //or you can write like that //*[contains(text(),'Tata Chemicals')]
         
         System.out.println(chl);
         
         System.out.println("----Using following axes-----");
         
         String mix=driver.findElement(By.xpath("//*[contains(text(),'Tata Chemicals')]/ancestor::tbody/child::tr[5]/following-sibling::tr[4]")).getText();
         System.out.println(mix);
	}

}
