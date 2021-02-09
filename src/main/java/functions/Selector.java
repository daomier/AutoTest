package functions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import poi.XlsDto;


public class Selector {
	
	
	
//	人员选择
	public static void selectpeople(WebDriver driver,XlsDto data,XlsDto data2) throws InterruptedException
	{
//		点击选择框
		button.click(driver,data2);
//		跳转表格
		driver.switchTo().frame("selIframe");
		
//       while(driver.findElement(By.linkText("总部")).isDisplayed()isEnabled()getText().equals("总部")){
    	while(isExist(driver))
    	   {
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("a.btn")).click();
			Thread.sleep(3000);
			button.click(driver,data2);	
		}
    //点击总部
//		driver.findElement(By.id("departmentTree_7_switch")).click();
//		driver.findElement(By.linkText(data.getDepartment())).click();
		Thread.sleep(1000);
		driver.findElement(By.name(data.getName())).click();
		Thread.sleep(1000);
    // 添加
		driver.findElement(By.xpath("//button[@class='btn btn-small']")).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
    //确定
		driver.findElement(By.xpath("//a[@id='selSuccessButton']")).click();
		Thread.sleep(3000);
	}
	
	
	
//	组织选择
	public static void selectcompany(WebDriver driver,XlsDto data,XlsDto data2) throws InterruptedException
	{
//		点击选择框
		button.click(driver,data2);
//		跳转表格
		driver.switchTo().frame("selIframe");
		Thread.sleep(1000);
		
		 while(isExist(driver)){
			
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("a.btn")).click();
			Thread.sleep(3000);
			button.click(driver,data2);
			
		}
//		 if(isExist(driver))
//		 { driver.switchTo().defaultContent();
//			Thread.sleep(1000);
//			driver.findElement(By.cssSelector("a.btn")).click();
//			Thread.sleep(3000);
//			button.click(driver,data2);}
			
			//点击总部
			driver.findElement(By.linkText(data.getCompany())).click();
			//添加
			driver.findElement(By.xpath("//button[@class='btn btn-small']")).click();
			//确定
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.findElement(By.linkText("确定")).click();
			Thread.sleep(3000);
		
		
	}
	
	
//	原iframe人员选择
//	public static void selectpeople(WebDriver driver,XlsDto data) throws InterruptedException
//	{
//
////		跳转表格
//		driver.switchTo().frame("selIframe");
//    // 点击总部
//		driver.findElement(By.id("departmentTree_7_switch")).click();
//		driver.findElement(By.linkText(data.getDepartment())).click();
//		Thread.sleep(1000);
//		driver.findElement(By.name(data.getName())).click();
//    // 添加
//		driver.findElement(By.xpath("//button[@class='btn btn-small']")).click();
//		Thread.sleep(1000);
//		driver.switchTo().defaultContent();
//    //添加
//		driver.findElement(By.xpath("//a[@id='selSuccessButton']")).click();
//		Thread.sleep(3000);
//	}
//	
	public static boolean isExist(WebDriver driver){

		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("loading-tab")).click();
			

		return true;

		}catch (NoSuchElementException e) { 

		   return false; 

		        } 

		}
	
	
	public static boolean check(WebDriver driver,By seletor) {
		try {
			driver.findElement(seletor);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
}
