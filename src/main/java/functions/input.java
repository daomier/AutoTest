package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import poi.XlsDto;

public class input {

	
// 	项目名称输入
//	public static String projectName(WebDriver driver)
//	{
//		String text="自动化测试项目"+System.currentTimeMillis();
//		driver.findElement(By.name("project.name")).clear();
//		driver.findElement(By.name("project.name")).sendKeys(text);
//		return text;
//	}
	
//	新建项目名称输入
	public static void projectName(WebDriver driver,String projectname)
	{
		driver.findElement(By.name("project.name")).clear();
		driver.findElement(By.name("project.name")).sendKeys(projectname);
	
	}
	
// 	id文本输入
	public static void textboxId(WebDriver driver,XlsDto data)
	{
		driver.findElement(By.id(data.getElement())).clear();
		driver.findElement(By.id(data.getElement())).sendKeys(data.getText());
	
	}
	
// 	name文本输入
	public static void textboxName(WebDriver driver,XlsDto data) throws InterruptedException
	{
		driver.findElement(By.name(data.getElement())).clear();
		driver.findElement(By.name(data.getElement())).sendKeys(data.getText());
		 Thread.sleep(3000);
	
		 
//		 driver.find_element_by_xpath('//td[text()="KPI"])   定位不到
//
//		 driver.find_element_by_xpath('//td[contains(text(),"KPI")])    成功定位到

		 
		 
		 
	}
	
// 		css文本输入
	public static void textboxCss(WebDriver driver,XlsDto data)
	{
		driver.findElement(By.cssSelector(data.getElement())).clear();		
		driver.findElement(By.cssSelector(data.getElement())).sendKeys(data.getText());
	
	}
	
	
//	下拉框选择
	public static void selectbox(WebDriver driver,XlsDto data)throws InterruptedException
	{
	  
		new Select(driver.findElement(By.id(data.getElement()))).selectByIndex(data.getNumber());
		Thread.sleep(3000);
//		new Select(driver.findElement(By.id(elementid))).selectByVisibleText(text);
//		new Select(driver.findElement(By.id(elementid))).selectByValue("SELF_IMPLEMENT");	
//		new Select(driver.findElement(By.id(elementid))).selectByIndex(2);
//		new Select(driver.findElement(By.id(elementid))).selectByid(2);
	
	}
	
	
//	时间选择id
	public static void timeid(WebDriver driver,XlsDto data) throws InterruptedException
	{
		Thread.sleep(2000);
		String elementId = data.getElement();
		String time = data.getText();
	   String js1="document.getElementById('" + data.getElement() +"').removeAttribute('readonly');document.getElementById('" + data.getElement() +"').setAttribute('value','" + data.getText() + "');";	
	     ((JavascriptExecutor)driver).executeScript(js1);
	     
//	     ((JavascriptExecutor)driver).executeScript(document.getElementById(elementid).removeAttribute('');document.getElementById(elementid).setAttribute('value',time));
	}
	
//	时间选择name
	public static void timename(WebDriver driver,XlsDto data) throws InterruptedException
	{   
		Thread.sleep(2000);
		String elementname = data.getElement();
		String time = data.getText();
		String js2="document.getElementsByName('"+elementname+"')[0].removeAttribute('readonly');document.getElementsByName('"+elementname+"')[0].setAttribute('value','"+time+"');";
		 ((JavascriptExecutor)driver).executeScript(js2);
	}
	
	
//	时间选择id
	public static void timeidBegin(WebDriver driver,String time) throws InterruptedException
	{
		Thread.sleep(2000);
		String elementId = "addTaskBeginDate";
	
	     String js = "document.getElementById('"+elementId+"').removeAttribute('readonly');";
			((JavascriptExecutor) driver).executeScript(js);
			/*
			 * 清空日期控件中的值，并输入目标日期值；
			 */
			WebElement datePicker = driver.findElement(By.id(elementId));
			datePicker.clear();
			Thread.sleep(1000);
			datePicker.sendKeys(time);  
	     
	     
	     
//	     ((JavascriptExecutor)driver).executeScript(document.getElementById(elementid).removeAttribute('');document.getElementById(elementid).setAttribute('value',time));
	}
	
	public static void timeidEnd(WebDriver driver,String time) throws InterruptedException
	{
		Thread.sleep(2000);
		String elementId = "addTaskEndDate";
	
	     String js = "document.getElementById('"+elementId+"').removeAttribute('readonly');";
			((JavascriptExecutor) driver).executeScript(js);
			/*
			 * 清空日期控件中的值，并输入目标日期值；
			 */
			WebElement datePicker = driver.findElement(By.id(elementId));
			datePicker.clear();
			Thread.sleep(1000);
			datePicker.sendKeys(time);  
			
	}
	
	
	
}
