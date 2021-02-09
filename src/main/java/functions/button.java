package functions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import poi.XlsDto;

public class button {
	
//	初始新建按钮
	public static void createPlanclear(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@id='noContent']//button[@id='createPlanBtn']")).click();
		
	}

//	初始新建项目按钮
	public static void createProjectclear(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@id='noContent']//button[@id='addProjectBtn']")).click();

	}
	
	
//	 新建计划按钮
	public static void createPlan(WebDriver driver) throws InterruptedException
	{
		 
	   driver.findElement(By.id("createPlanBtn")).click();
		
	}

//	新建项目按钮
	public static void createProject(WebDriver driver) throws InterruptedException
	{
	   driver.findElement(By.id("addProjectBtn")).click();
		
	}
	
//	 项目提交按钮
	public static void projectSubmit(WebDriver driver) throws InterruptedException
	{
//		选择项目
		driver.findElement(By.cssSelector("div.well > strong")).click();
//		提交
		driver.findElement(By.id("submitBtn")).click();
		determine(driver);
	}
	
//	计划提交按钮
	public static void simbit(WebDriver driver) throws InterruptedException
	{
     driver.findElement(By.id("submitPlanBtn")).click();
 
	}
	
//	 保存按钮
	public static void save(WebDriver driver) throws InterruptedException
	{
      driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
      Thread.sleep(3000);
//    driver.findElement(By.id("saveBtn")).click();
	}
	
	
	
//	 取消按钮 =
	public static void cancel(WebDriver driver) throws InterruptedException
	{
    driver.findElement(By.cssSelector("button.btn.default")).click();
	
	}
	
	
	
//	点击按钮id
	public static void click(WebDriver driver,XlsDto data) throws InterruptedException
	{
		
	   driver.findElement(By.id(data.getElement())).click();
	   Thread.sleep(3000);
	}
	
//	点击按钮css
	public static void clickCSS(WebDriver driver,XlsDto data) throws InterruptedException
	{
		
	   driver.findElement(By.cssSelector(data.getElement())).click();
	   Thread.sleep(3000);
	}
	
//	点击按钮xpath
	public static void clickXpath(WebDriver driver,XlsDto data) throws InterruptedException
	{
		
	   driver.findElement(By.xpath(data.getElement())).click();
	   Thread.sleep(3000);
	}
	
	
//	 确认框确定钮
	public static void determine(WebDriver driver) throws InterruptedException
	{
      driver.findElement(By.cssSelector("button.btn.btn-danger.okbtn")).click();
	
	}
	
	
//	 确认框取消钮
	public static void cancelDetermine(WebDriver driver) throws InterruptedException
	{
     driver.findElement(By.cssSelector("button.btn.btn-default.canclebtn")).click();
	}
	
	

	
	
}
