package demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;




import functions.takeScreenShot;
import junit.framework.TestCase;


public class demo {
	
	WebDriver driver = new ChromeDriver();

	@BeforeClass
	
	public void setup() throws InterruptedException
    {
        System.out.println("begin test");
//        System.setProperty("webdriver.chrome.driver", "D://python//chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "D://jdk//chromedriver.exe");
//        chromedriver需要放在chrome根目录下，不然会因绿色版本出现问题
        System.setProperty("webdriver.chrome.driver", "C://Users//wanglu//AppData//Local//Google//Chrome//Application//chromedriver.exe");
//        C:\Users\wanglu\AppData\Local\Google\Chrome\Application\chrome.exe
    	driver.get("http://www.baidu.com");

    	Thread.sleep(500);
    }
	
	
	@Test
	public  void main() throws InterruptedException {

//	setup();
	
	for (int i = 0; i <3; i++){

	   driver.findElement(By.id("kw")).clear();

	   Thread.sleep(500);

	   driver.findElement(By.id("kw")).sendKeys("第" + i + "次");

	   Thread.sleep(500);

	   driver.findElement(By.id("su")).click();

	   Thread.sleep(5000);

	  }
	
	Thread.sleep(300);
	
         teardown();
        
		 
    
    }
	
//	@AfterClass
	
	public void teardown() throws InterruptedException
    {
        System.out.println("end test");
   
		String a = null;
	    try {
	        a = driver.findElement(By.className("nums_text")).getText();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    //断言-校验是否登录成功
	    Thread.sleep(300);
	    AssertJUnit.assertEquals(a,"百度为您找到相关结果约100,000,000个");
	    //截取屏幕
	    takeScreenShot.takeScreenshot(driver, "main");
	    Thread.sleep(300);
	    
	    //关闭浏览器进程及驱动
	    driver.close();
    }
	
	}


