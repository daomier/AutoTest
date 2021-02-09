package functions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.TimeUnit;









//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Augmenter;

import poi.XlsDto;

import com.google.common.collect.Maps;



//	import poi.XlsDto;

public class browser {
	 
	
	
	 
//	 --------------------------------------------------------------------------------------------
		
//		打开火狐浏览器
		public static WebDriver openFirefox(WebDriver driver,String url)  {  
			
	//  其他地址打开浏览器方式
//		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//		driver= new FirefoxDriver();
//			linux地址
//			System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");
			
//			dr = Selenium::WebDriver.for :chrome
//			火狐刘安琪启动配置
			 ProfilesIni allProfiles = new ProfilesIni();
			 FirefoxProfile profile = allProfiles.getProfile("default");
			 FirefoxOptions options=new FirefoxOptions();
		     options.setProfile(profile);
			 driver = new FirefoxDriver(options);
			 		 
		 
//			 最大化
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			driver.get(url);
			
			String title=driver.getTitle();
			
			Assert.assertEquals(title, "审计信息平台");  //检查点：检查打开的页面标题是否和预期的一致
				
			return driver;
		}
		
		

		
//		打开火狐浏览器，hub集
		public static WebDriver openHubFirefox(WebDriver driver,String url) throws MalformedURLException  {  
			
//			 Selenium selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.google.com");		 
//			 driver = new RemoteWebDriver(new URL("http://hub的IP:端口/wd/hub"),capability);
			
////			1
//			FirefoxProfile profile = new FirefoxProfile();
//		     profile.setPreference("general.useragent.override",testData.getUserAgent());
////		     DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		     capabilities.setCapability("firefox_profile", profile);
//			
//		     
////			2
//			 WebDriver drivers = new RemoteWebDriver();
//			 
//			 ProfilesIni allProfiles = new ProfilesIni();
//			 FirefoxProfile profile = allProfiles.getProfile("default");
//			 
////			 3
////			 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		     capabilities.setCapability(CapabilityType.PROXY, getProxy());
//		     driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			 
			 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//			 capabilities.setBrowserName("firefox");
//			 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			 capabilities.setBrowserName("firefox");
			 
			 capabilities.setVersion("41");
//			 capabilities.setPlatform(Platform.LINUX);
			 capabilities.setPlatform(Platform.VISTA);
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			 
//			 driver = new FirefoxDriver(profile);
			 
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			driver.get(url);
			
			String title=driver.getTitle();
			
			Assert.assertEquals(title, "审计信息平台");  //检查点：检查打开的页面标题是否和预期的一致
			
			
			
			return driver;
		}
		
		
//		打开火狐浏览器，Linux系统
		public static WebDriver openHubFirefoxLinux(WebDriver driver,String url) throws MalformedURLException  {  
			

			
			 DesiredCapabilities capabilities = DesiredCapabilities.firefox();

//			 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			 capabilities.setBrowserName("firefox");
			 
			 capabilities.setVersion("38");
			 capabilities.setPlatform(Platform.LINUX);
			 
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			 
//			 driver = new FirefoxDriver(profile);
			 
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			driver.get(url);
			
			String title=driver.getTitle();
			
			Assert.assertEquals(title, "审计信息平台");  //检查点：检查打开的页面标题是否和预期的一致
			
			
			
			return driver;
		}
		
		
		
//		打开谷歌浏览器
		 public static WebDriver openChrome(WebDriver driver,String url)  {  
			 
//			chromedriver在安装目录下
//			 System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Chrome\\chromedriver.exe");
//			38版本
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\wanglu\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
//	       49版本
			    driver = new ChromeDriver();
				 
				 
				 driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
				driver.get(url);
				
				String title=driver.getTitle();
				
//				Assert.assertEquals(title, "基础开发平台");  //检查点：检查打开的页面标题是否和预期的一致
				
				
				return driver;
			}
		
		 
//		 打开ie浏览器
		 public static WebDriver openIE(WebDriver driver,String url)  {  
			 
//				IEdriverserver在安装目录下
			 System.setProperty("webdriver.ie.driver", "C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer.exe");
//	          降低ie安全级别
			   DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
	    	   ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	    	   driver = new InternetExplorerDriver(ieCapabilities);
					 
					 
					 driver.manage().window().maximize();
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					
					driver.get(url);
					
					String title=driver.getTitle();
					
					Assert.assertEquals(title, "基础开发平台");  //检查点：检查打开的页面标题是否和预期的一致
					
					
					
					return driver;
				}
		 
		 
//		打开目录
		public static void firstList(WebDriver driver,XlsDto data1,XlsDto data2) throws InterruptedException
		{
		 
//		  driver.findElement(By.cssSelector("div.sidebar-toggler.hidden-phone")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.linkText(data1.getMainlist())).click();
		  driver.findElement(By.linkText(data2.getMainlist())).click();
		  Thread.sleep(1000);
		  driver.findElement(By.cssSelector("div.sidebar-toggler.hidden-phone")).click();
		  Thread.sleep(3000);
		}
		
		
//		打开目录
		public static void list(WebDriver driver,XlsDto data1,XlsDto data2) throws InterruptedException
		{
		 
//		  driver.findElement(By.cssSelector("div.sidebar-toggler.hidden-phone")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.linkText(data1.getMainlist())).click();
		  driver.findElement(By.linkText(data2.getMainlist())).click();
		  Thread.sleep(1000);
		  driver.findElement(By.cssSelector("div.sidebar-toggler.hidden-phone")).click();
		  Thread.sleep(3000);
		}
		
		
//		等待
//		pageLoadTimeout方法用来设置页面完全加载的超时时间，完全加载即页面全部渲染，异步同步脚本都执行完成。
//		没有设置超时时间默认是等待页面全部加载完成才会进入下一步骤，设置超时时间3s是加载到3s时中断操作抛出异常；
		
		public static void waitfor(WebDriver driver,int number) throws InterruptedException{	
			 driver.manage().timeouts().pageLoadTimeout(number,TimeUnit.SECONDS);		
		}
		
//		转换窗口	
		public static WebDriver SwitchWindow2(WebDriver driver,String TitName) 
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
		
		
		
	//  转换窗口
		public static WebDriver SwitchWindow(WebDriver driver,String TitName) 
		{
			 String currentHandle =driver.getWindowHandle();
				  
			 System.out.println(driver.getWindowHandle());    //打印当前浏览器的当前标签页的句柄
			 
			 System.out.println(driver.getWindowHandles());    //打印当前浏览器的所有标签页的句柄
             //打印出来是一个list
			 
			 
			for(String WinHandle:driver.getWindowHandles()){
				  if(!WinHandle.equals(currentHandle)) {
				     driver.switchTo().window(WinHandle);
				  }
			}
			   
			return driver;
		}
		
		public  static  void slidePage(WebDriver driver,String element)  {

		    //移动到元素element对象的“顶端”与当前窗口的“顶部”对齐
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		    //移动到元素element对象的“底端”与当前窗口的“底部”对齐
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
		    //移动到页面最底部
		    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    //移动到指定的坐标(相对当前的坐标移动)
		    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700)");
		    
		    //结合上面的scrollBy语句，相当于移动到700+800=1600像素位置
		    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800)");
		    //移动到窗口绝对位置坐标，如下移动到纵坐标1600像素位置
		    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1600)");
		    
		    //结合上面的scrollTo语句，仍然移动到纵坐标1200像素位置
		    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1200)");
			
			
		}

		
//		打开谷歌浏览器
		 public static WebDriver openChrome_silence(WebDriver driver,String url)  {  
			 
//			chromedriver在安装目录下
//			 System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Chrome\\chromedriver.exe");
//			38版本
//			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\wanglu\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
////	       49版本
//			    driver = new ChromeDriver();
//				 
//				 
//				 driver.manage().window().maximize();
//				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
				
//				Assert.assertEquals(title, "基础开发平台");  //检查点：检查打开的页面标题是否和预期的一致
				
			 int screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
			 int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
			 System.out.println(screenWidth);
			 System.out.println(screenHeight);
			//设置浏览器参数
				ChromeOptions chromeOptions = new ChromeOptions();
				
				
//				最大化浏览器

//				chromeOptions.addArguments("start-fullscreen");
//				chromeOptions.addArguments("–-start-maximized");
//				chromeOptions.addArguments("--window-size=4000,1600");
				chromeOptions.addArguments("window-size="+screenWidth+","+screenHeight);//浏览器满屏
//				修改最大化设置多次，最终先设置最大化浏览器参数，在设置模式后最大化成功
				
				
				// 设置后台静默模式启动浏览器
				chromeOptions.addArguments("--headless");
				// 谷歌驱动生成
				driver = new ChromeDriver(chromeOptions);	

			
//				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//				capabilities.setCapability("chromeOptions", chromeOptions);
//				driver = new RemoteWebDriver(capabilities);
                driver.get(url);
				
				String title=driver.getTitle();
				
				
				return driver;
			}
		
		
		
		
}

	
	
	

