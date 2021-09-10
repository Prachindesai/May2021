import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Facebook {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.edge.driver","C:\\Users\\Prachi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		
        WebDriver driver=new EdgeDriver();
        
        driver.get("https://www.facebook.com/");
        
        System.out.println(driver.getCurrentUrl());
        
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Prachi123@gmail.com");
        
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("prachi123");
        
        driver.findElement(By.xpath("//*[@name=\"login\"]")).click();////*[@id="u_0_d_ZU"]
        
        //driver.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
        
	}

}
