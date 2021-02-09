package functions;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;

import poi.XlsDto;




public class fileUp {
	
//	   private WebDriver driver;
//	   private StringBuffer verificationErrors = new StringBuffer();

	   
	  
		
//	   @Test
	   public  void autoshangchuan(WebDriver driver) throws InterruptedException {
		    String url="http://pan.baidu.com/disk/home#from=share_pan_logo";
			driver=publicTest.open(driver, url);
			
			driver.findElement(By.id("TANGRAM__PSP_4__userName")).clear();
			driver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("稻米md");
			
			driver.findElement(By.id("TANGRAM__PSP_4__password")).clear();
			driver.findElement(By.id("TANGRAM__PSP_4__password")).sendKeys("85960103wl");
		
			driver.findElement(By.id("TANGRAM__PSP_4__submit")).click();
			
			Thread.sleep(20000);
			
			driver.findElement(By.id("_disk_id_10")).click();
					   
			driver.findElement(By.id("upload")).click();
			Thread.sleep(3000);
			openExe();	  
			
			
			Thread.sleep(5000);
			
	   }
			
			  
			  //调用其他的可执行文件，例如：自己制作的exe，或是 下载 安装的软件.
	   public static void openExe() {
		   Runtime rn = Runtime.getRuntime();
		   Process p = null;
		   try {
			  p = rn.exec("\"D:/job/新建文件夹/a.exe\"");
		   } catch (Exception e) {
			  System.out.println("Error exec!");
		   }
			  
	    }
	   
	   
	   public static void shangchuan(WebDriver driver,String path,String button) throws InterruptedException, AWTException
		{
//			StringSelection SelectJPG= new StringSelection("D:\\job\\众拍\\候车亭点位表MAX - 10个.xlsx");
//			Clipboard sysc=Toolkit.getDefaultToolkit().getSystemClipboard();
//			sysc.setContents(SelectJPG, null);
			
			
			
			//指定文件路径

		    StringSelection filePath=new StringSelection(path);

		    //把文件路径复制到剪切板

		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		    System.out.println("filePath："+filePath);
		    
			browser.waitfor(driver,100);

		    // 点击上传文件
		    
			driver.findElement(By.id(button)).click();

		 
			browser.waitfor(driver,2000);
			
//			 takeScreenShot.takeScreenshot(driver, "test");
			
		    //新建一个Robot类的对象

		    Robot robot=new Robot();

		    Thread.sleep(1000);

		    //按下Ctrl+V

		    robot.keyPress(KeyEvent.VK_CONTROL);

		    robot.keyPress(KeyEvent.VK_V);

		    //释放Ctrl+V
		    
		    robot.keyRelease(KeyEvent.VK_V);

		    robot.keyRelease(KeyEvent.VK_CONTROL);

		    

		    Thread.sleep(2000);

		    //点击回车

		    robot.keyPress(KeyEvent.VK_ENTER);

		    robot.keyRelease(KeyEvent.VK_ENTER);
		    
		    Thread.sleep(2000);
		    System.out.println("================复制完成===================");

	}
}			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		  
		
		
	   
	   
	


