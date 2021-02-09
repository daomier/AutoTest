package demo;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class gridBingfa {
	
	
//	通过TestNG数据驱动的方式指定Node节点计算机上指定浏览器执行测试用例

	WebDriver driver;    
    @DataProvider(name="data")
    public Object[][] Data(){
        return new Object[][]{
            {"chrome","http://10.20.4.170:5566/wd/hub"},
            {"ie","http://10.20.4.170:5577/wd/hub"},
        };
    }
    @Test(dataProvider="data")
    public void test(String browser,String Url) throws InterruptedException, MalformedURLException{
        DesiredCapabilities BrowserGrid = null;
        if(browser.contentEquals("chrome")){
            BrowserGrid =DesiredCapabilities.chrome();
        }else{
            BrowserGrid =DesiredCapabilities.internetExplorer();            
        }
        WebDriver driver=new RemoteWebDriver(new URL(Url),BrowserGrid);
        driver.get("https://www.baidu.com/");
        driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[@id='su']")).click();    
        Thread.sleep(3000);    
        //获取页面上的资源
        String sourcetext=driver.getPageSource();
        //校验搜索结果是否包含 selenium
        Assert.assertTrue(sourcetext.contains("selenium"));
        Thread.sleep(3000);    
        driver.quit();
    }
	
	
	
}
