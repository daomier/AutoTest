package functions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;







import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;


public  class publicTest {
//这是个公共类，我把test去掉了
	
//	打开网页，验证登录页面已经打开
	public static WebDriver open(WebDriver driver,String url) throws InterruptedException {  

//		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//						
//		driver = new FirefoxDriver(new FirefoxProfile(new File("C:\\Users\\Administrator\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\apo32jk9.default\\")));

		driver= new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//Thread.sleep(20000);
		
		driver.get(url);
		
		//String title=driver.getTitle();
		
		//Assert.assertEquals(title, "审计管理平台");  //检查点：检查打开的页面标题是否和预期的一致
		
		
		
		return driver;
	}
	static StringBuffer verificationErrors = new StringBuffer();
	
//	登录1 不输入登录
	public static void login1(WebDriver driver)
	{
		System.out.println("不输入用户名和密码");
		   
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains("请输入用户名"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
		
		try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains("请输入密码"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
		
		
//		//输入用户名
//		WebElement username=driver.findElement(By.name("userName"));
//		
//		username.clear();
//		
//		username.sendKeys("wlu");
//		
//		//输入密码
//		WebElement pwd=driver.findElement(By.name("password"));
//		
//		pwd.clear();
//		
//		pwd.sendKeys("111111");
//		
//		//点击登录
//		pwd.submit();
//		
//		//检查点：检查是否成功登录
//		String getname=driver.findElement(By.xpath("//*[@id='initData']/div/ul/li[4]/a/span")).getText();
//		
//		Assert.assertEquals(getname, "王璐");
	}
	
//	登录2 没有密码
	public static void login2(WebDriver driver,String Username)
	{
		System.out.println("输入用户名不输入密码");
		
		driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys(Username);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();

	    try {
		      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains("请输入密码"));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	    
	}
	
	//	登录3 用户名和密码错误
	public static void login3(WebDriver driver,String Username,String Password)
	{
		System.out.println("用户名密码输入错误");
		
		driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys(Username);
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(Password);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();

	    try {
		      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains("无效的用户名或密码，请重新输入！"));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	    
	}
	
	
//	登录4 用户名和密码成功
	public static void login4(WebDriver driver,String Username,String Password) throws InterruptedException
	{
		System.out.println("输入用户名和密码登录");
		
		driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys(Username);
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(Password);
//	    if (!driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected()) {
//	 	   driver.findElement(By.xpath("//input[@type='checkbox']")).click();
//	    };
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//	    
//	  
	    }
	
	
	public static void logoff(WebDriver driver) throws InterruptedException
	{
	
		//不可行driver.findElement(By.xpath("//li[@class='dropdown user active']")).click();
		//driver.findElement(By.cssSelector("span.username")).click();
		driver.findElement(By.cssSelector("i.fa.fa-angle-down")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//i[@class='fa fa-key']")).click();
		//driver.findElement(By.xpath("//a[@href='#']")).click();
		driver.findElement(By.cssSelector("i.fa.fa-key")).click();
	
	}
	

	public static void Newbuild(WebDriver driver)  throws InterruptedException
	{
		driver.findElement(By.id("addProjectBtn")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("reason")).clear();
		driver.findElement(By.name("reason")).sendKeys("变更原因");
		
		driver.findElement(By.name("project.name")).clear();
		driver.findElement(By.name("project.name")).sendKeys("项目名称1");
		
		
		
//		 点击项目负责人
		driver.findElement(By.xpath("//input[@id='principalmanName']")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("selIframe");
//		点击总部
		//driver.findElement(By.id("departmentTree_1_span")).click();
		driver.findElement(By.linkText("总裁办")).click();
		
		if(3<4)
		{
			
		}
		else
		{
			
		}
		
		if(3==3)
		{
			
		}
		if(driver.findElement(By.linkText("总裁办")).getText().equals(""))
		{
			
		}
		
		Thread.sleep(1000);
		driver.findElement(By.name("吕总")).click();
//		添加
		driver.findElement(By.xpath("//button[@class='btn btn-small']")).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
//		确定
		//driver.findElement(By.linkText("确定")).click();
		driver.findElement(By.xpath("//a[@id='selSuccessButton']")).click();
		Thread.sleep(3000);
		
		
		
//		 点击项目组长
		driver.findElement(By.id("groupLeaderName")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("selIframe");
//		点击总部
		//driver.findElement(By.id("departmentTree_1_span")).click();
		driver.findElement(By.linkText("总部")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("王璐")).click();
//		添加
		driver.findElement(By.xpath("//button[@class='btn btn-small']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
//		确定
		//driver.findElement(By.linkText("确定")).click();
		driver.findElement(By.xpath("//a[@id='selSuccessButton']")).click();
		Thread.sleep(3000);
		
		
//		 点击主审机构
		driver.findElement(By.xpath("//input[@id='majorAudit']")).click();
		driver.switchTo().frame("selIframe");
//		driver.switchTo().frame(driver.findElement(By.xpath(xpathExpression)))
		Thread.sleep(1000);
		//点击总部
		//driver.findElement(By.id("departmentTree_1_span")).click();
		
		driver.findElement(By.linkText("总部")).click();
		//添加
		driver.findElement(By.xpath("//button[@class='btn btn-small']")).click();
		//确定
		//driver.findElement(By.id("selSuccessButton")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(By.linkText("确定")).click();
		Thread.sleep(3000);
	
		
//      点击被审计单位
		driver.findElement(By.xpath("//input[@id='auditedObjectsName']")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("selIframe");
//		点击总部
		//driver.findElement(By.id("departmentTree_1_span")).click();
		driver.findElement(By.linkText("总部")).click();
//		添加
		driver.findElement(By.xpath("//button[@class='btn btn-small']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
//		确定
		//driver.findElement(By.linkText("确定")).click();
		driver.findElement(By.xpath("//a[@id='selSuccessButton']")).click();
		Thread.sleep(3000);
		
		
		new Select(driver.findElement(By.id("project.organizationType"))).selectByVisibleText("本单位实施");		
//		// select | id=project.organizationType | value=SELF_IMPLEMENT
//		new Select(driver.findElement(By.id("project.organizationType"))).selectByValue("SELF_IMPLEMENT");	
//		// select | id=project.organizationType | index=2
//		new Select(driver.findElement(By.id("project.organizationType"))).selectByIndex(2);
//      new Select(driver.findElement(By.id("project.organizationType"))).selectByid(2);
		
//		审计项目类型
		driver.findElement(By.id("auditTypeName")).click();
	    driver.findElement(By.id("auditTypeTree_3_a")).click();
	    driver.findElement(By.id("GEditInfoOkButton")).click();
	    
		new Select(driver.findElement(By.id("project.auditApproach"))).selectByVisibleText("自审");
	
		
//		输入审计期间  
		String js1="document.getElementById('projectAuditStartTime').removeAttribute('readonly');document.getElementById('projectAuditStartTime').setAttribute('value','2014-09-01');";	
		  ((JavascriptExecutor)driver).executeScript(js1);
				
	    String js2="document.getElementById('projectAuditEndTime').removeAttribute('readonly');document.getElementById('projectAuditEndTime').setAttribute('value','2014-09-02');";	
		  ((JavascriptExecutor)driver).executeScript(js2);
			Thread.sleep(1000);
			System.out.println("输入审计阶段");
		
			
		driver.findElement(By.name("project.auditReason")).clear();
		driver.findElement(By.name("project.auditReason")).sendKeys("审计原因");

//
////   	日期
//	//计划准备阶段	
//		Thread.sleep(2000);
//		String js3="document.getElementsByName('project.schedules[0].predictedStartTime')[0].removeAttribute('readonly');document.getElementsByName('project.schedules[0].predictedStartTime')[0].setAttribute('value','2014-09-06');";
//		((JavascriptExecutor)driver).executeScript(js3);
//		
//		String js4="document.getElementsByName('project.schedules[0].predictedEndTime')[0].removeAttribute('readonly');document.getElementsByName('project.schedules[0].predictedEndTime')[0].setAttribute('value','2014-09-11');";
//        ((JavascriptExecutor)driver).executeScript(js4);
//		Thread.sleep(1000);
//	//计划实施阶段
//		String js5="document.getElementsByName('project.schedules[1].predictedStartTime')[0].removeAttribute('readonly');document.getElementsByName('project.schedules[1].predictedStartTime')[0].setAttribute('value','2014-09-12');";
//		((JavascriptExecutor)driver).executeScript(js5);
//		
//		String js6="document.getElementsByName('project.schedules[1].predictedEndTime')[0].removeAttribute('readonly');document.getElementsByName('project.schedules[1].predictedEndTime')[0].setAttribute('value','2014-09-20');";
//        ((JavascriptExecutor)driver).executeScript(js6);
//		Thread.sleep(1000);
//		
//	//计划报告阶段
//		String js7="document.getElementsByName('project.schedules[2].predictedStartTime')[0].removeAttribute('readonly');document.getElementsByName('project.schedules[2].predictedStartTime')[0].setAttribute('value','2014-09-21');";
//		((JavascriptExecutor)driver).executeScript(js7);
//		
//		String js8="document.getElementsByName('project.schedules[2].predictedEndTime')[0].removeAttribute('readonly');document.getElementsByName('project.schedules[2].predictedEndTime')[0].setAttribute('value','2014-09-30');";
//        ((JavascriptExecutor)driver).executeScript(js8);
//        driver.switchTo().defaultContent();
//       
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		
//	//	验证
//	try {
//	        assertEquals("项目名称", driver.findElement(By.linkText("项目名称")).getText());
//	      } catch (Error e) {
//	        verificationErrors.append(e.toString());
//	      }
//	    
	   driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
	   
	   
	  
		
	}
	
	
	
	 
	
	public static WebDriver SwitchWindow(WebDriver driver,String TitName)
	{
		   WebDriver pop=null;
		  
		  String currentHandle =driver.getWindowHandle();
		  
		  for(String WinHandle:driver.getWindowHandles())
		  {
			 if(WinHandle.equals(currentHandle))
			 {
				 continue;
			 }
			 else
				 
			 {
				 pop=driver.switchTo().window(WinHandle);
				 
				 if(pop.getTitle().contains(TitName))
				 {
					 break;
				 }
			 }
		  }
		  return pop;
	}
	
	public static void shenpi(WebDriver driver) throws InterruptedException
	{
	      //打开跟人工作台
		  driver.findElement(By.cssSelector("div.sidebar-toggler.hidden-phone")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.linkText("个人办公")).click();
		  driver.findElement(By.linkText("个人工作台")).click();
		  
		  //选择审批待办
		  Thread.sleep(3000);
		  driver.findElement(By.cssSelector("div.postMeta")).click();
		// click | css=li.mailMessage.selected > div.postDetails > div.postMeta | 
	    //driver.findElement(By.cssSelector("div.postMeta>span:contains('王璐')")).click();
		 

			driver.switchTo().frame("iframe");
			Thread.sleep(1000);
			// 验证新建项目1  
//			try {
//				assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("新建项目1"));
//			} catch (Error e) {
//				verificationErrors.append(e.toString());
//			}
//			
//			// 验证执行人：张副部长  
//			try {
//				assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("执行人：张副部长"));
//			} catch (Error e) {
//				verificationErrors.append(e.toString());
//			}
			 Thread.sleep(3000);
			 
			 driver.findElement(By.id("frmSubmitButton")).click();

			 try {
					assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("处理成功"));
				} catch (Error e) {
					verificationErrors.append(e.toString());
				}
			 driver.switchTo().defaultContent();
	}
	
	
	 public static void 提交(WebDriver driver) throws InterruptedException
		{  
		    //选择项目
			//driver.findElement(By.cssSelector("a:contains('项目名称'),span:contains('新增')")).click();
			driver.findElement(By.cssSelector("div.well > strong")).click();
			//提交
		    driver.findElement(By.id("submitBtn")).click();
		    Thread.sleep(3000);
         //确认提交
		    driver.findElement(By.cssSelector("button.btn.btn-danger.okbtn")).click();
		    //driver.findElement(By.cssSelector("button:contains('确定')")).click();
		    // driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
		    
		    
		   //页面跳转
		    driver=publicTest.SwitchWindow(driver,"流程：流程起草");
		    Thread.sleep(5000);
		    //发起流程
		    //driver.findElement(By.id("frmSubmitButton")).click();
		    driver.findElement(By.linkText("发起流程")).click();
		    try {
				assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("正在提交表单"));
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
		    
			Thread.sleep(5000);
		}
	
	
	
	public static void qidong(WebDriver driver) throws InterruptedException
	{
	//打开项目阶段
		  driver.findElement(By.cssSelector("div.sidebar-toggler.hidden-phone")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.linkText("审计项目管理")).click();
		
		  //driver.findElement(By.cssSelector("span[title='项目名称2'],i.glyphicon.glyphicon-log-out")).click();
	      // driver.findElement(By.xpath("//span[@title='项目名称2']|//i[@title='启动项目']")).click();
    //启动项目
		  driver.findElements(By.xpath("//i[@title='启动项目']")).get(1).click();
		  Thread.sleep(3000);
		  
	//审计期间
		  String js3="document.getElementsByName('project.auditStartTime')[0].removeAttribute('readonly');document.getElementsByName('project.auditStartTime')[0].setAttribute('value','2014-09-01');";
			((JavascriptExecutor)driver).executeScript(js3);
			
		  String js4="document.getElementsByName('project.auditEndTime')[0].removeAttribute('readonly');document.getElementsByName('project.auditEndTime')[0].setAttribute('value','2014-09-02');";
	        ((JavascriptExecutor)driver).executeScript(js4);
		  Thread.sleep(1000);
			
	//审计方式
		  new Select(driver.findElement(By.id("project.auditApproach"))).selectByVisibleText("自审");
		  Thread.sleep(1000);
		 
	//被审计单位
//		  driver.findElement(By.id("auditedObjectsName")).click();
//		  Thread.sleep(3000);
//		  driver.switchTo().frame("selIframe");
//		  driver.findElement(By.linkText("总部")).click();
//		  //添加
//		  driver.findElement(By.cssSelector("i.icon-arrow-right")).click();
//		  Thread.sleep(1000);
//		  driver.switchTo().defaultContent();
//		  //确定
//		  driver.findElement(By.id("selSuccessButton")).click();
//	
	//下一步				
		  driver.findElement(By.cssSelector("a.btn.btn-primary.button-next")).click();
		  Thread.sleep(3000);
		  
    //选择人员
//		  driver.findElement(By.id("selectUser3")).click();
//		  Thread.sleep(3000);
//		  driver.switchTo().frame("selIframe");
//		  
//		  driver.findElement(By.linkText("总部")).click();
//		  driver.findElement(By.name("王璐")).click();
//		  driver.findElement(By.cssSelector("i.icon-arrow-right")).click();
//		  
//		  driver.findElement(By.linkText("审计部")).click();
//		  driver.findElement(By.id("departmentTree_6_switch")).click();
//		  driver.findElement(By.linkText("深圳审计中心")).click();
//		  driver.findElement(By.name("董玉雪")).click();
//		  
//		  //添加
//		  driver.findElement(By.cssSelector("i.icon-arrow-right")).click();
//		  Thread.sleep(1000);
//		  driver.switchTo().defaultContent();
//		  //确定
//		  driver.findElement(By.id("selSuccessButton")).click();
//		  
	//确定组员主审
//		  new Select(driver.findElement(By.id("auditUsers[2].userType"))).selectByVisibleText("主审");
//		  Thread.sleep(1000);
		  
	//下一步				
		  driver.findElement(By.cssSelector("a.btn.btn-primary.button-next")).click();
		  Thread.sleep(3000);
	
    //实施阶段审计点		  
//		  driver.findElements(By.cssSelector("i.fa.fa-square-o")).get(0).click();
//		  Thread.sleep(1000);
//		  driver.findElements(By.cssSelector("i.fa.fa-square-o")).get(0).click();
//		  Thread.sleep(1000);
//		  driver.findElements(By.cssSelector("i.fa.fa-square-o")).get(0).click();
//		  Thread.sleep(1000);
//		  
	//下一步				
		  driver.findElement(By.cssSelector("a.btn.btn-primary.button-next")).click();
		  Thread.sleep(3000);
	//启动	  
		  driver.findElement(By.cssSelector("a.btn.green.button-submit")).click();
		  driver.findElement(By.cssSelector("button.btn.btn-danger.okbtn")).click();
		  Thread.sleep(3000);
	}
	

	
	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
		 new FirefoxDriver(new FirefoxProfile(new File("C:\\Users\\Administrator\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\apo32jk9.default\\")));
	}
}
