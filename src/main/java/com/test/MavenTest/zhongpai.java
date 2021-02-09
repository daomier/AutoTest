package com.test.MavenTest;

import java.util.List;

import org.eclipse.jetty.util.log.Log;
//import org.junit.Assert;
//import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

 

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import functions.Selector;
import functions.browser;
import functions.fileUp;
import functions.input;
import functions.logInAndOff;
import poi.XlsDto;
import poi.maintest;

public class zhongpai {

	static WebDriver driver;
	static List<XlsDto> list = null; 
	private boolean acceptNextAlert = true;
	static String url="http://mtest.ictr.cn/CrowdphotoWeb/login";//被测网页地址众拍测试环境 ַ
//	static String url="http://localhost:8080/iam/login";///被测网页地址
	
	static StringBuffer verificationErrors = new StringBuffer();
	static String projectname="自动化测试项目"+System.currentTimeMillis();
//	static int tital,tital2;
	
	
	@BeforeClass
	public static void setUp() throws Exception {

//			初始化浏览器
//				driver=browser.openFirefox(driver,url);
//				driver=browser.openHubFirefox(driver,url);
//				driver=browser.openHubFirefoxLinux(driver, url);
				driver=browser.openChrome(driver, url);
//			数据读取
			  maintest xlsMain = new maintest();  
		        try {
					XlsDto xls = null;  
					list = xlsMain.readXls();
				} catch (Exception e) {
					org.eclipse.jetty.util.log.Logger log = Log.getLog();
					
					log.info("one.java --  login --- file not found。");
//					Reporter.log("这是testng美化报告的一个失败测试用例");
					e.printStackTrace();
				}  
		        
		      
//	      数据打印
//		        for (int i = 0; i < list.size(); i++) {  
//		            xls = (XlsDto) list.get(i);  
//		            System.out.println(xls.getUsename() + "    " + xls.getPassword() + "    " + xls.getName() + "    " + xls.getDepartment() + "    " + xls.getCompany()+ "    "
//		            		+xls.getMainlist() +"    " + xls.getProjectlist() +"    " +xls.getButton_submit()+"    "
//		            		+xls.getStep() +"    " + xls.getFindway() +"    " + xls.getElement() + "    " +xls.getText()+"   "+xls.getType()+ "    "+ xls.getNumber()+"    "+xls.getSelect_text()
//		            		);     
//		}   
		        System.out.println(list.get(0).getPassword());
	}  	

	@Test
	 public  void test1_loginTest() throws Exception
		{
			System.out.println("===========登录===================================");
			System.out.println(list.get(2));
//		登录用户
	
			logInAndOff.login(driver,list.get(2));
			
	//  检查点：检查是否成功登录
			String title=driver.getTitle();
//		    String welcome=driver.findElement(By.xpath("//div[@id='page-wrapper']//div/h1/text()")).getText();
		    String welcome=driver.findElement(By.xpath("//div[@id='page-wrapper']//div/h1")).getText();
		    System.out.println(title);
		    System.out.println(welcome);		
			Assert.assertEquals(welcome, "欢迎登录众拍后台管理系统!");	
			browser.waitfor(driver,100);
		 
		}
	
	@Test
	 public  void test2_shangchuan() throws Exception
		{
			System.out.println("===========打开任务管理===================================");
//			System.out.println(list.get(2));
//		打开任务管理
	
			driver.findElement(By.xpath("//a[@href='/CrowdphotoWeb/task/taskManage']/span")).click();
			browser.waitfor(driver,100);
			
//		进入编辑任务
			driver.findElement(By.xpath("//a[@href='/CrowdphotoWeb/task/editTaskManage?taskId=8221&type=editTask']")).click();
			browser.waitfor(driver,200);
			
//	    关闭弹窗
				driver.findElement(By.xpath("//div/button[@class='btn btn-zp']")).click();
				browser.waitfor(driver,100);
				
//	  输入时间
//				
				
//				input.timeidBegin(driver, "2020-01-03");
				
				input.timeidBegin(driver, "2020-01-03");
				input.timeidEnd(driver, "2020-01-05");
				browser.waitfor(driver,100);
//  下一步
				driver.findElement(By.xpath("//div[@id='modalEditViewPage']//li[@class='next']/a[@href='javascript:void(0);']")).click();
				browser.waitfor(driver,100);
			
// 点击上传文件
//				driver.findElement(By.id("uploadBtn")).click();
				System.out.println("===========准备上传=========================");
// 上传文件		
				fileUp.shangchuan(driver,"D:\\job\\众拍\\候车亭点位表MAX - 10个.xlsx","uploadBtn");
				
				Thread.sleep(2000);
// 打开构建点位
				driver.findElement(By.id("createPointId")).click();
				
//				Selector checkElement=new Selector();
				By seletor=new By.ByXPath("//div/button[@class='btn btn-zp']") ;
			
//				if(Selector.check(driver, seletor)) {
//				              //此元素存在
//					driver.findElement(seletor).click();
//					Thread.sleep(2000);
//				        }
//				   else{
//				              //此元素不存在
//					   Thread.sleep(2000);
//					   driver.findElement(By.id("createPointId")).click(); 
//					  
//				        }
//				
			System.out.println("===========构建点位===================================");
//	构建点位	第一步  导入excel
//				  driver.findElement(By.id("excelContrastRootwizard")).click(); 
			  Thread.sleep(2000);
			String a=driver.findElement(By.xpath("//div[@id='excelContrastStepDrag']//a[@id='importExcelField']")).getText();
		     driver.findElement(By.xpath("//div[@id='excelContrastStepDrag']//a[text()='导入Excel字段']")).click();
			//div[@id="excelContrastStepDrag"]//a[text()="导入Excel字段"]
			System.out.println("===========结束===================================");
			System.out.println(a);
				  Thread.sleep(2000);
//				  关闭弹窗
		    driver.findElement(By.xpath("//div[@class='jconfirm-box jconfirm-hilight-shake jconfirm-type-default jconfirm-type-animated']//button[text()='确定']")).click(); 
		    Thread.sleep(200);
//				点击锁定  
		    driver.findElement(By.xpath("//a[text()='点击锁定']")).click();  
		    Thread.sleep(200);
//			  下一步
		    driver.findElement(By.xpath("//div[@class='modal-footer']//a[text()='下一步']")).click();  
		    Thread.sleep(200);
		    
//	构建点位	    第二步
//		   选择点位
		   new Select(driver.findElement(By.id("point_show"))).selectByIndex(1);
		   Thread.sleep(200);

//		   设置比例列
		   driver.findElement(By.xpath(" //tr[@id='station_radio']/td[1]/a[@class='btn btn-sm btn-primary']")).click();  
		   Thread.sleep(200);
//			  下一步
		    driver.findElement(By.xpath("//div[@class='modal-footer']//a[text()='下一步']")).click();  
		    Thread.sleep(200);	
		    
//	构建点位 第三步
//		    设置比例	  下一步
		    driver.findElement(By.xpath("//div[@class='modal-footer']//a[text()='下一步']")).click();  
		    Thread.sleep(200);	
		    
//		构建点位 第四步    
//		    点位转化 
//			 关闭
		    Thread.sleep(5000);	
		    driver.findElement(By.xpath("//div[@class='modal-footer']//a[text()='关闭']")).click();  
		    Thread.sleep(200);	  
		    
//		    关闭弹窗
				driver.findElement(By.xpath("//div/button[@class='btn btn-zp']")).click();
				browser.waitfor(driver,100);  
				
				
				
//		任务创建  第二步
//	限制条件	  下一步
		driver.findElement(By.xpath("//div[@class='modal-footer borderCss clearCss']//a[text()='下一步']")).click();  
		Thread.sleep(1000);	
		
//		任务创建  第三步
//	点位列表	  下一步
		driver.findElement(By.xpath("//div[@class='modal-footer borderCss clearCss']//a[text()='下一步']")).click();  
		Thread.sleep(200);	
		
//		任务创建  第四步
//	描述页结构	  
//		添加样例图  
//		点击添加
		driver.findElement(By.xpath("//div[@class='model_div']//a[text()='添加']")).click();  
		Thread.sleep(1000);
		
// 点击上传文件		
//		driver.findElement(By.id("exampic_2")).click();
		System.out.println("===========准备上传===================================");
//上传文件		
		fileUp.shangchuan(driver,"D:\\job\\众拍\\QQ截图20190912163432.png","exampic_2");
		
		Thread.sleep(2000);
		
		
//		下一步
		driver.findElement(By.xpath("//div[@class='modal-footer borderCss clearCss']//a[text()='下一步']")).click();  
		Thread.sleep(200);	
		
		
//		任务创建  第五步
//	执行页结构	  
//		添加控件类型  
//		添加文本
		 new Select(driver.findElement(By.id("selectRunModelType"))).selectByIndex(1);
		   Thread.sleep(200);
//		点击添加	
		driver.findElement(By.id("addCurrentRunModelId")).click();
		System.out.println("===========添加文本控件===================================");
//输入文本内容		
		driver.findElement(By.xpath("//label[text()='文本']/parent::div/following-sibling::div/input")).clear();
		driver.findElement(By.xpath("//label[text()='文本']/parent::div/following-sibling::div/input")).sendKeys("自动化文本测试");
		Thread.sleep(2000);
		
		
//		提交
		driver.findElement(By.xpath("//div[@class='modal-footer borderCss clearCss']//a[text()='提交']")).click();  
		Thread.sleep(3000);	
			
		
		
		
				
	//  检查点：检查是否成功登录
//			String title=driver.getTitle();
////		    String welcome=driver.findElement(By.xpath("//div[@id='page-wrapper']//div/h1/text()")).getText();
//		    String welcome=driver.findElement(By.xpath("//div[@id='page-wrapper']//div/h1")).getText();
//		    System.out.println(title);
//		    System.out.println(welcome);		
//			Assert.assertEquals(welcome, "欢迎登录众拍后台管理系统!");	
//			browser.waitfor(driver,100);
		 
		}
	
	

}
