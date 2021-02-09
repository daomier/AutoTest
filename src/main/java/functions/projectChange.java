package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class projectChange {
//项目变更
	 
	
//	审计项目类型    新建
	public static void ProjectType(WebDriver driver) throws InterruptedException
	{
//	   driver.findElement(By.id("auditTypeName")).click();
	   Thread.sleep(3000);
       driver.findElement(By.id("auditTypeTree_4_span")).click();
	   Thread.sleep(3000);
       driver.findElement(By.id("GEditInfoOkButton")).click();
	}
	
	
//	项目提交按钮
	public static void submitProjectBtn(WebDriver driver) throws InterruptedException
	{
//		选择项目
		driver.findElement(By.cssSelector("div.well > strong")).click();
//		提交
		driver.findElement(By.id("submitBtn")).click();
	    button.determine(driver);
     }
	
//	计划提交按钮
	public static void submitPlanBtn(WebDriver driver) throws InterruptedException
	{

//		提交
		driver.findElement(By.id("submitPlanBtn")).click();
	    button.determine(driver);
     }
}
