package demo;

import java.util.List;

//import org.junit.Assert;
//import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import functions.browser;
import functions.fileUp;
import functions.input;
import functions.logInAndOff;
import functions.takeScreenShot;
import poi.XlsDto;
import poi.maintest;

public class zhongpai_creatProject_test {

	static WebDriver driver;
	static List<XlsDto> list = null;
	private boolean acceptNextAlert = true;
	static String url = "http://mtest.ictr.cn/CrowdphotoWeb/login";// 被测网页地址众拍测试环境 ַ
//	static String url="http://localhost:8080/iam/login";///被测网页地址

	static StringBuffer verificationErrors = new StringBuffer();
	static String projectname = "自动化测试项目" + System.currentTimeMillis();
//	static int tital,tital2;
	private static final Logger log = LoggerFactory.getLogger(zhongpai_creatProject_test.class);

	@BeforeClass
	public static void setUp() throws Exception {

//			初始化浏览器
//				driver=browser.openFirefox(driver,url);
//				driver=browser.openHubFirefox(driver,url);
//				driver=browser.openHubFirefoxLinux(driver, url);
		driver = browser.openChrome(driver, url);
//		        driver=browser.openChrome_silence(driver, url);

//			数据读取
		maintest xlsMain = new maintest();
		try {
			XlsDto xls = null;
			list = xlsMain.readXls();
		} catch (Exception e) {
			log.info("这是testng美化报告的一个失败测试用例");

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
	public void test1_loginTest() throws Exception {
		System.out.println("===========登录===================================");
		System.out.println(list.get(2));
//		登录用户

		logInAndOff.login(driver, list.get(2));

		// 检查点：检查是否成功登录
		String title = driver.getTitle();
//		    String welcome=driver.findElement(By.xpath("//div[@id='page-wrapper']//div/h1/text()")).getText();
		String welcome = driver.findElement(By.xpath("//div[@id='page-wrapper']//div/h1")).getText();
		System.out.println(title);
		System.out.println(welcome);
		Assert.assertEquals(welcome, "欢迎登录众拍后台管理系统!");
		// 截取屏幕
		takeScreenShot.takeScreenshot(driver, "test1_loginTest");
		browser.waitfor(driver, 100);

	}

	@Test
	public void test2_shangchuan() throws Exception {
		System.out.println("===========打开任务管理===================================");
//			System.out.println(list.get(2));
//		打开任务管理

		driver.findElement(By.xpath("//a[@href='/CrowdphotoWeb/task/taskManage']/span")).click();
		browser.waitfor(driver, 100);

//		新建任务
		driver.findElement(By.xpath("//h1//a[text()='创建任务']")).click();
		browser.waitfor(driver, 2000);

//	    基本信息 第一步
//		归属项目
//		 new Select(driver.findElement(By.id("selectPro"))).selectByIndex(278);
		new Select(driver.findElement(By.xpath("//select[@id='selectPro']"))).selectByValue("278");
//			 .selectByIndex(278);
		Thread.sleep(200);

//		任务名称（APP展示）
		driver.findElement(By.name("taskName")).clear();
		driver.findElement(By.name("taskName")).sendKeys(projectname);
		Thread.sleep(100);

//		任务名称（内部展示）
		driver.findElement(By.name("taskNameInternal")).clear();
		driver.findElement(By.name("taskNameInternal")).sendKeys(projectname);
		Thread.sleep(100);
//		任务类型 				 				 
//		任务起止时间	
		input.timeidBegin(driver, "2020-01-03");
		input.timeidEnd(driver, "2020-01-30");
		browser.waitfor(driver, 100);

//				城市
//				单个点位奖励金额
		driver.findElement(By.id("rewardId")).clear();
		driver.findElement(By.id("rewardId")).sendKeys("1");
		browser.waitfor(driver, 100);

//  下一步
		driver.findElement(By.xpath("//div[@id='rootwizard']//div[@class='modal-footer']//a[text()='下一步']")).click();
		browser.waitfor(driver, 100);

//		限制条件 第二步 
//				点位配置类型

		driver.findElement(By.xpath("//label[text()='excel配置']")).click();
		Thread.sleep(200);
//	     关闭弹窗
		driver.findElement(By.xpath("//button[text()='ok']")).click();
		Thread.sleep(2000);

//		领取个数限制
		driver.findElement(By.name("evenAllowNum")).clear();
		driver.findElement(By.name("evenAllowNum")).sendKeys("100");
		browser.waitfor(driver, 100);

//		=========================================================================================
// 点击上传文件
//				driver.findElement(By.id("uploadBtn")).click();
		System.out.println("===========准备上传=========================");
// 上传文件		
		fileUp.shangchuan(driver, "D:\\job\\众拍\\候车亭点位表MAX - 10个.xlsx", "uploadBtn");

		Thread.sleep(2000);
// 打开构建点位
		driver.findElement(By.id("createPointId")).click();

//				Selector checkElement=new Selector();
		By seletor = new By.ByXPath("//div/button[@class='btn btn-zp']");

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
		String a = driver.findElement(By.xpath("//div[@id='excelContrastStepDrag']//a[@id='importExcelField']"))
				.getText();
		driver.findElement(By.xpath("//div[@id='excelContrastStepDrag']//a[text()='导入Excel字段']")).click();
		// div[@id="excelContrastStepDrag"]//a[text()="导入Excel字段"]
		System.out.println("===========结束===================================");
		System.out.println(a);
		Thread.sleep(2000);
//				  关闭弹窗
		driver.findElement(By.xpath(
				"//div[@class='jconfirm-box jconfirm-hilight-shake jconfirm-type-default jconfirm-type-animated']//button[text()='确定']"))
				.click();
		Thread.sleep(200);
//				点击锁定  
		driver.findElement(By.xpath("//a[text()='点击锁定']")).click();
		Thread.sleep(2000);
		System.out.println("===========下一步===================================");
//			  下一步
//			 JavascriptExecutor js = (JavascriptExecutor) driver;

//			 js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[@class='modal-footer']//a[text()='下一步']")));

		driver.findElement(By.xpath(
				"//div[@id='excelContrastStepDrag']//div[@id='excelContrastRootwizard']//li[3]/a[@href='javascript:void(0);']"))
				.click();
//		    driver.findElement(By.xpath("//div[@class='modal-footer']//a[text()='下一步']")).click();  
		Thread.sleep(200);

//	构建点位	    第二步
//		   选择点位
		new Select(driver.findElement(By.id("point_show"))).selectByIndex(1);
		Thread.sleep(200);

//		   设置比例列
		driver.findElement(By.xpath(" //tr[@id='station_radio']/td[1]/a[@class='btn btn-sm btn-primary']")).click();
		Thread.sleep(200);
//			  下一步
		driver.findElement(By.xpath(
				"//div[@id='excelContrastStepDrag']//div[@id='excelContrastRootwizard']//li[3]/a[@href='javascript:void(0);']"))
				.click();

		Thread.sleep(200);

//	构建点位 第三步
//		    设置比例	  下一步
		driver.findElement(By.xpath(
				"//div[@id='excelContrastStepDrag']//div[@id='excelContrastRootwizard']//li[3]/a[@href='javascript:void(0);']"))
				.click();
		Thread.sleep(200);

//		构建点位 第四步    
//		    点位转化 
//			 关闭
		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"//div[@id='excelContrastStepDrag']//div[@id='excelContrastRootwizard']//li[4]/a[@href='javascript:;']"))
				.click();
		Thread.sleep(2000);

//		    关闭弹窗
		driver.findElement(By.xpath("//div/button[@class='btn btn-zp']")).click();
		Thread.sleep(1000);

//=================================================================================================				

		System.out.println("===========下一步===================================");
//		任务创建  第二步
//	限制条件	  下一步
//		driver.findElement(By.xpath("//form[@id='editTaskForm']//li[3]/a[@href='javascript:void(0);']")).click();
		driver.findElement(By
				.xpath("//form[@id='newAddTaskId']//div[@class='modal-footer']//li[3]/a[@href='javascript:void(0);']"))
				.click();
		Thread.sleep(500);

//		任务创建  第三步
//	点位列表	  下一步
		driver.findElement(By
				.xpath("//form[@id='newAddTaskId']//div[@class='modal-footer']//li[3]/a[@href='javascript:void(0);']"))
				.click();
		Thread.sleep(200);

//		任务创建  第四步
//	描述页结构	  
//		添加样例图  
//		点击添加
		driver.findElement(By.xpath("//div[@class='model_div']//a[text()='添加']")).click();
		Thread.sleep(1000);

// 点击上传文件		
//		driver.findElement(By.id("exampic_1")).click();
		Thread.sleep(2000);
		System.out.println("===========准备上传===================================");
//上传文件		
		fileUp.shangchuan(driver, "D:\\job\\众拍\\QQ截图20190912163432.png", "exampic_1");

		Thread.sleep(2000);

//	输入操作步骤
		driver.findElement(By.id("executeStepId")).clear();
		driver.findElement(By.id("executeStepId")).sendKeys("输入操作步骤");
		browser.waitfor(driver, 100);
//	输入执行要求
		driver.findElement(By.id("executeReqId")).clear();
		driver.findElement(By.id("executeReqId")).sendKeys("输入执行要求");
		browser.waitfor(driver, 100);
//	输入特别提醒
		driver.findElement(By.id("specialReminderId")).clear();
		driver.findElement(By.id("specialReminderId")).sendKeys("输入特别提醒");
		Thread.sleep(200);

//		# 欲点击的未显示的控件在页面底部（顶部略）时，将页面滚动至底部
//		ActionChains(driver).send_keys(Keys.END).perform()
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

//		下一步
//		driver.findElement(By.xpath("//form[@id='newAddTaskId']//div[@class='modal-footer']//li[3]/a[@href='javascript:void(0);']")).click();  
		driver.findElement(By.xpath("//form[@id='newAddTaskId']//div[@class='modal-footer']//li[3]/a[text()='下一步']"))
				.click();
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
		driver.findElement(By.xpath("//label[text()='文本']/parent::div/following-sibling::div/input"))
				.sendKeys("自动化文本测试");
		Thread.sleep(200);

//		切换异常页 
		driver.findElement(By.id("abNormalConfig")).click();
		Thread.sleep(2000);
//		添加异常人员 
//	           打开人员列表
		driver.findElement(By.xpath("//div[@id='execPersonAddBtn']/a[text()='添加']")).click();
		Thread.sleep(3000);

		// 判断是否在iframe中
//		if(window.self!=windowtop){
//			parent.window.location.replace(window.location.href);
//		}

//		var frameEl = Window.frameElement;
//		// 如果当前窗口被包含在一个框架里面,则将该框架的地址跳到'http://mozilla.org/'
//		if (frameEl)
//		  frameEl.src = "http://mozilla.org/";
//		driver.switchTo().frame("taskAddMsgPersonModal");

//		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='execPersonAddBtn']/a[text()='添加']")));
//		点击添加//div[@id='taskAddMsgPersonModal']//tr[1]/td[5]/a[@href='javascript:void(0);']
//		driver.findElement(By.xpath("//div[@id='taskAddMsgPersonModal']//tr[1]/td[5]/a[text()='添加']")).click();
		driver.findElement(
				By.xpath("//div[@id='taskAddMsgPersonModal']//td[text()='王璐']//following-sibling::*/a[text()='添加']"))
				.click();
		Thread.sleep(200);
//		保存
//		driver.findElement(By.xpath("//div[@class='modal-footer']//following-sibling::*/a[text()='保存']")).click();

		driver.findElement(By.xpath("//div[@class='modal-footer']//a[text()='保存']")).click();
		Thread.sleep(1000);
//		提交
		driver.findElement(
				By.xpath("//form[@id='newAddTaskId']//div[@class='modal-footer']//li[4]/a[@href='javascript:;']"))
				.click();
		Thread.sleep(3000);
//	    关闭弹窗
		driver.findElement(By.xpath("//div/button[@class='btn btn-zp']")).click();
		Thread.sleep(2000);
		browser.waitfor(driver, 100);

		// 检查点：检查是否成功登录
//			String title=driver.getTitle();
		String check = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
//		    String check=driver.findElement(By.xpath("//tbody//td[text='"+projectname+"']")).getText();
//		    System.out.println(title);
		System.out.println(check);
		Assert.assertEquals(check, projectname);
		takeScreenShot.takeScreenshot(driver, "test2_shangchuan");
		browser.waitfor(driver, 100);

	}

}
