package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class grid {
//	指定Node节点计算机执行测试用例
//	hub：http://10.20.4.170:5566
//	node：http://10.20.4.170:5577
	
	 WebDriver driver;
	    @BeforeTest
	    public void BeforeTest() throws MalformedURLException{
	        //创建一个DesiredCapabilities类型
	        
	        DesiredCapabilities ChromeGrid=DesiredCapabilities.chrome();
	        //实例化一个driver
	        driver=new RemoteWebDriver(new URL("http://10.20.4.170:5566/wd/hub"),ChromeGrid);    
	        driver.get("https://www.baidu.com/");
	    }
	    
	    @Test
	    public void gridTest() throws InterruptedException{
	        
	        driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("selenium");
	        driver.findElement(By.xpath("//*[@id='su']")).click();    
	        Thread.sleep(3000);    
	        //获取页面上的资源
	        String sourcetext=driver.getPageSource();
	        //校验搜索结果是否包含 selenium
	        Assert.assertTrue(sourcetext.contains("selenium"));
	        Thread.sleep(3000);    
	    }
	    @AfterMethod
	    public void aftermethod(){
	        driver.quit();
	    }


}
