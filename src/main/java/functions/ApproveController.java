package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import webdriver.publicTest;

public class ApproveController {
//	审批
	
//	个人工作台审批
//	审批待办
   public static void  ApproveTodo(WebDriver driver) throws InterruptedException
	{	    
//	        选择审批待办项
	   driver.findElement(By.xpath("//span[@id='todoListSpace']/li[1]")).click();
	   Thread.sleep(3000);
	   ApproveOK(driver);
	}
   
   
//  同意审批
	public static void ApproveOK(WebDriver driver) throws InterruptedException
	{
	   driver.switchTo().frame("iframe");
	   Thread.sleep(10000);
//	     同意
	   driver.findElement(By.id("comment_textarea")).clear();
	   driver.findElement(By.id("comment_textarea")).sendKeys("同意"); 
	   ((JavascriptExecutor)driver).executeScript("$('#frmSubmitButton').click()");
//	   driver.findElement(By.id("frmSubmitButton")).click();
	   driver.switchTo().defaultContent();
	   Thread.sleep(2000);
	}
	
   
   
//	驳回审批
	public static void ApproveNO(WebDriver driver) throws InterruptedException
	{
	   driver.switchTo().frame("iframe");
	   browser.waitfor(driver,100);
	   driver.findElement(By.id("frmDirectRejectButton")).click();
	   driver.switchTo().defaultContent();
	}
		
	
//	发起流程
   public static void startProcess(WebDriver driver) throws InterruptedException
	{	    
	   Thread.sleep(10000);	
	   driver=browser.SwitchWindow(driver,"流程：");
	   Thread.sleep(1000);	   
//	   driver.navigate().refresh();
	   Thread.sleep(5000);
	   ((JavascriptExecutor)driver).executeScript("$('#frmSubmitButton').click()");
//	   driver.findElement(By.id("frmSubmitButton")).click();
	   
	   driver=browser.SwitchWindow(driver,"审计信息平台");
	}
   
//	内部发起流程 
  public static void startInsideProcess(WebDriver driver) throws InterruptedException
	{	    
	   
	   Thread.sleep(2000);	
	   driver=browser.SwitchWindow(driver,"流程："); 
	   Thread.sleep(3000);	   
	   driver.navigate().refresh();
	   Thread.sleep(6000);
	   ((JavascriptExecutor)driver).executeScript("$('#frmSubmitButton').click()");
//	   driver.findElement(By.id("frmSubmitButton")).click();
	   driver=browser.SwitchWindow(driver,"审计作业/审计项目");
	}

//  领导审批流程
  public static void  LeaderApprove(WebDriver driver,String username) throws InterruptedException
	{	    
//   退出登录
	    logInAndOff.logoff(driver);
// 领导登录
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys(username);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("1");
        driver.findElement(By.xpath("//button[@type='submit']")).click();    
        Thread.sleep(3000);
        
        driver.findElement(By.cssSelector(".fa.fa-sign-in")).click();
	      Thread.sleep(5000);
////打开个人办公页面
//        driver.findElement(By.cssSelector("div.sidebar-toggler.hidden-phone")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.linkText("个人办公)).click();
//        driver.findElement(By.linkText("个人工作台")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.cssSelector("div.sidebar-toggler.hidden-phone")).click();                    
//        browser.waitfor(driver,100);
//审批通过
	      ApproveTodo(driver);
        Thread.sleep(5000);
	}
  
//领导审批流程
 public static void LeaderApprove2(WebDriver driver,String username) throws InterruptedException
	{	    
//  退出登录
	 logInAndOff.logoff(driver);
//领导登录
       driver.findElement(By.name("userName")).clear();
       driver.findElement(By.name("userName")).sendKeys(username);
       driver.findElement(By.name("password")).clear();
       driver.findElement(By.name("password")).sendKeys("123456");
       driver.findElement(By.xpath("//button[@type='submit']")).click();    
       Thread.sleep(3000);
       driver.findElement(By.cssSelector(".fa.fa-sign-in")).click();
	      Thread.sleep(5000);
//打开个人办公页面
       driver.findElement(By.cssSelector("div.sidebar-toggler.hidden-phone")).click();
       Thread.sleep(3000);
       driver.findElement(By.linkText("个人办公")).click();
       driver.findElement(By.linkText("个人工作台")).click();
       Thread.sleep(1000);
       driver.findElement(By.cssSelector("div.sidebar-toggler.hidden-phone")).click();                    
       browser.waitfor(driver,100);
//审批通过
       ApproveTodo(driver);
       Thread.sleep(5000);
	}
		
		

}
