package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class StartUpProjectController {
//	项目启动
	
	
//	进入 项目启动
	public static void start(WebDriver driver,String projectname) throws InterruptedException
	{
		 driver.findElement(By.xpath("//div[1]/dl[//span[@title='"+projectname+"']]//i[@title='启动项目']")).click();
	
	}
	
	
//	主审
	public static void referee(WebDriver driver) throws InterruptedException
	{
		
		new Select(driver.findElement(By.cssSelector("#dataTable1")).findElement(By.cssSelector("select.form-control"))).selectByVisibleText("主审");
		
	}
	
	
	
//	下一步按钮
	public static void next(WebDriver driver) throws InterruptedException
	{
      driver.findElement(By.cssSelector("a.btn.btn-primary.button-next")).click();
	
	}
	

	
//	启动按钮
	public static void startButton(WebDriver driver) throws InterruptedException
	{
       driver.findElement(By.cssSelector("a.btn.green.button-submit")).click();
	
	}
	
	

}
