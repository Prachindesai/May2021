package Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Prachi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://demoqa.com/buttons");//1st way to launch
		System.out.println(driver.getCurrentUrl()); //print url in console
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Actions class call
        Actions act=new Actions(driver);
        WebElement DoubleClick=driver.findElement(By.xpath("//button[contains(text(),'Double Click Me')]"));
        WebElement RightClick=driver.findElement(By.xpath("//button[contains(text(),'Right Click Me')]"));
        WebElement DynamicClick=driver.findElement(By.xpath("//button[text()='Click Me']"));
        
        act.doubleClick(DoubleClick).perform();
        act.contextClick(RightClick).perform();
        act.click(DynamicClick).perform();
        
        Thread.sleep(5000);
        
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//div[@id='simpleDropContainer']/child::div[@id='droppable']"));
        
        act.dragAndDrop(drag, drop).build().perform();
        
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//nav[@class='nav nav-tabs']/child::a[@id='droppableExample-tab-accept']")).click();
        
        WebElement drop1=driver.findElement(By.xpath("//div[@class='accept-drop-container']/child::div[@id='droppable']"));
        WebElement dragacceptable=driver.findElement(By.xpath("//div[@id='acceptable']"));
        WebElement dragnotacceptable=driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        
        act.dragAndDrop(dragacceptable,drop1).build().perform();
        act.dragAndDrop(dragnotacceptable, drop1).build().perform();
        
        Thread.sleep(5000);
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        
        WebElement pro1=driver.findElement(By.xpath("//div[@id='products']/descendant::li[@data-id='1']"));//5000
        WebElement pro2=driver.findElement(By.xpath("//div[@id='products']/descendant::li[@data-id='2']"));//-5000
        
        WebElement pro3=driver.findElement(By.xpath("//div[@id='products']/descendant::li[@id='credit0']/child::a"));//-5000;
        WebElement pro4=driver.findElement(By.xpath("//div[@id='products']/descendant::li[4]/child::a"));//+5000
        
        WebElement bank=driver.findElement(By.xpath("//div[@id='products']/descendant::li[@data-id='5']"));
        WebElement sales=driver.findElement(By.xpath("//div[@id='products']/descendant::li[@data-id='6']"));
        WebElement equity=driver.findElement(By.xpath("//div[@id='products']/descendant::li[@data-id='7']"));
        WebElement loan=driver.findElement(By.xpath("//div[@id='products']/descendant::li[@data-id='8']"));
        
        WebElement account1=driver.findElement(By.xpath("//div[@class='ui-widget-content']/child::ol[@class='field14 ui-droppable ui-sortable']"));
        WebElement amount1=driver.findElement(By.xpath("//div[@class='ui-widget-content']/child::ol[@id='amt7']/child::li"));
        
        WebElement amount2=driver.findElement(By.xpath("//div[@class='ui-widget-content']/child::ol[@id='loan']/child::li"));
        WebElement account2=driver.findElement(By.xpath("//div[@class='ui-widget-content']/child::ol[@id='amt8']/child::li"));
        
        Thread.sleep(3000);
        
        act.dragAndDrop(bank, account1).build().perform();
        act.dragAndDrop(pro2, amount1).build().perform();
        
        act.dragAndDrop(sales, account2).build().perform();
        act.dragAndDrop(pro4, amount2).build().perform();
        
        
	}

}
