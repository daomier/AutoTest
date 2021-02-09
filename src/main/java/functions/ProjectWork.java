package functions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import poi.XlsDto;
import webdriver.publicTest;

public class ProjectWork {
//	项目作业
	
//	得到项目名称
//	period表示项目作业表中的阶段，1-未启动，2-准备阶段，3-实施阶段，4-报告阶段，5-结项阶段，6-已关闭，7-已归档
//	number表示该项目阶段中的项目数，若只有1个项目，number默认为0
	public static String getProjectName(WebDriver driver,int period,int number) throws InterruptedException
	{
		String projectname=null;
		switch(period)
		{
		   case 1: projectname=driver.findElements(By.xpath("//dl[@phasecode='PhaseUnOpened']//span[@title]")).get(number).getText();break;
		   case 2: projectname=driver.findElements(By.xpath("//dl[@phasecode='PhasePrepare']//span[@title]")).get(number).getText();break;
		   case 3: projectname=driver.findElements(By.xpath("//dl[@phasecode='PhaseExecute']//span[@title]")).get(number).getText();break;
		   case 4: projectname=driver.findElements(By.xpath("//dl[@phasecode='PhaseReport']//span[@title]")).get(number).getText();break;
		   case 5: projectname=driver.findElements(By.xpath("//dl[@phasecode='PhaseFinsh']//span[@title]")).get(number).getText();break;
		   case 6: projectname=driver.findElements(By.xpath("//dl[@phasecode='PhaseClosed']//span[@title]")).get(number).getText();break;
		   default : projectname=driver.findElements(By.xpath("//dl[@phasecode='PhaseArchived']//span[@title]")).get(number).getText();break;
			   
		}
		
	     return projectname;
	}
	
//	得到项目阶段数目
//  period表示项目作业表中的阶段，1-未启动，2-准备阶段，3-实施阶段，4-报告阶段，5-结项阶段，6-已关闭，7-已归档
	public static String getPeriodTotal(WebDriver driver,int period) throws InterruptedException
	{
		String PeriodTotal=null;
		switch(period)
		{
		   case 1: PeriodTotal=driver.findElement(By.xpath("//th[@phasename='PhaseUnOpened']/span")).getText();break;
		   case 2: PeriodTotal=driver.findElement(By.xpath("//th[@phasename='PhasePrepare']/span")).getText();break;
		   case 3: PeriodTotal=driver.findElement(By.xpath("//th[@phasename='PhaseExecute']/span")).getText();break;
		   case 4: PeriodTotal=driver.findElement(By.xpath("//th[@phasename='PhaseReport']/span")).getText();break;
		   case 5: PeriodTotal=driver.findElement(By.xpath("//th[@phasename='PhaseFinsh']/span")).getText();break;
		   case 6: PeriodTotal=driver.findElement(By.xpath("//th[@phasename='PhaseClosed']/span")).getText();break;
		   default : PeriodTotal=driver.findElement(By.xpath("//th[@phasename='PhaseArchived']/span")).getText();break;
		   
		}
	     return PeriodTotal;
	}
	
	
//	得到项目阶段数目整型
	public static int getNumber(WebDriver driver,String str) throws InterruptedException
	{
		System.out.println(str);	
		String[] strs = str.split ("");		
		String[] result = new String[strs.length - 1];		
		System.arraycopy (strs, 1, result, 0, result.length);		
		System.out.println (Arrays.toString (result));
		int number= Integer.parseInt(strs[2]);
		return number;
		
//		Integer.parseInt(strs[2]) string转换成Integer整型数组
//		Integer.toString(10)      Integer整型10转换成string

	      
	}
	
//		关闭项目
//	    number 关闭项目序数 ，从1开始，
	public static void closedProject(WebDriver driver,int number) throws InterruptedException
	{
		
		 new Actions(driver).dragAndDrop(driver.findElement(By.xpath("//td[@phasecode='PhaseFinsh']/div["+number+"]//span")),driver.findElement(By.xpath("//td[@phasecode='PhaseClosed']"))).perform();
	      
			Thread.sleep(5000);
			button.determine(driver);
			Thread.sleep(3000);
	}	
	
//	归档项目
//    number 归档项目序数 ，从1开始，
    public static void archivedProject(WebDriver driver,int number) throws InterruptedException
{
    	 ((JavascriptExecutor)driver).executeScript("$(\".my-project.autoHeight\").scrollLeft(400);");
	 new Actions(driver).dragAndDrop(driver.findElement(By.xpath("//td[@phasecode='PhaseClosed']/div["+number+"]//span")),driver.findElement(By.xpath("//td[@phasecode='PhaseArchived']"))).perform();
    	 
     
//	 new Actions(driver).dragAndDropBy(driver.findElement(By.xpath("//td[@phasecode='PhaseClosed']/div["+number+"]//span")),getPosition(driver,phasecode)[0]+200, getPosition(driver,phasecode)[1]).perform();
		Thread.sleep(5000);
		button.determine(driver);
		Thread.sleep(3000);
}	
	
    
//  获取位置
 
  public static int[] getPosition(WebDriver driver,String phasecode) throws InterruptedException
{
	
	//获取位置
      JavascriptExecutor js = (JavascriptExecutor) driver;  
     
     Long positionX = (  Long) js.executeScript("var positionX = "  
                + "$(\"td[phasecode='"+phasecode+"'] div:first\").offset().left; "  
                + "return positionX") ;
      
          int X =(new  Long(positionX)).intValue();
      Double  positionY = (Double) js.executeScript("var positionY = "  
                + "$(\"td[phasecode='"+phasecode+"'] div:first\").offset().top; "  
                + "return positionY");
      System.out.println(positionX+"       "+positionY);
        int Y =(new Double(positionY)).intValue();
//       System.out.println( X +  Y);
       System.out.println(positionX+"       "+ Y);
       int position[]={X,Y};
       
       return  position;
}	
    
    
    
    
	
	
	
//	 进入项目作业
	public static void intoWork(WebDriver driver,String projectname) throws InterruptedException
	{
		
//		driver.findElement(By.cssSelector("i.fa.fa-file-text")).click();
		driver.findElement(By.xpath("//dl[dt//span[contains(text(),'"+projectname+"')]]//i[@title='进入审计作业']")).click();
		 Thread.sleep(3000);
	}
	
	
//	 打开项目作业目录
	public static void openProjectList(WebDriver driver,XlsDto data) throws InterruptedException
	{
		  driver.findElement(By.linkText(data.getProjectlist())).click();
		  driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);	
		  Thread.sleep(3000);
	}
	
	
	
//	 切换项目阶段
	public static void changePeriod(WebDriver driver) throws InterruptedException
	{
		  driver.findElement(By.cssSelector("i.glyphicon.glyphicon-retweet.changePRELevel")).click();
		  button.determine(driver);
		  Thread.sleep(3000);
		
	}
	
	
//	发布项目作业
	public static void publishBtn(WebDriver driver) throws InterruptedException
	{
	   driver.findElement(By.cssSelector("i.glyphicon.glyphicon-saved.openProcessSubmit")).click(); 
//	   button.determine(driver);
		  browser.waitfor(driver,100);
	}

	
	
//	项目内部提交审批
	public static void submitInsideApprove(WebDriver driver) throws InterruptedException
	{
		publishBtn(driver);
//		 审批.内部发起流程(driver); 
		 ApproveController.startInsideProcess(driver);
	 
	}
	

//
//	
////	发布项目作业AuditNotifyController
////	发布审计通知书
//	public static void publishAuditNotify(WebDriver driver) throws InterruptedException
//	{
//	   driver.findElement(By.cssSelector("i.glyphicon.glyphicon-saved.listsubmit")).click(); 
//	   button.determine(driver);
//		  browser.waitfor(driver,100);
//	}
//	
////	发布项目作业
////	发送审计快报
//	public static void sendAuditLetters(WebDriver driver) throws InterruptedException
//	{
//	   driver.findElement(By.cssSelector("i.glyphicon.glyphicon-log-out")).click(); 
//	   button.determine(driver);
//		  browser.waitfor(driver,100);
//	}
//	
//	
	 

}
