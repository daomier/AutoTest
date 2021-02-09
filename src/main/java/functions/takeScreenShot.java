package functions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.*;
import org.apache.commons.*;

import junit.framework.TestCase;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.imageio.ImageIO;

import org.testng.log4testng.Logger;



public class takeScreenShot {
	

		
		static WebDriver driver;
		private static String fileName;
//		private static final String SCREENSHOT_PATH = "D:\\job\\workspacework\\ScreenShort\\";
		private static final String SCREENSHOT_PATH = "D:\\job\\workspace\\MavenTest\\test-output\\img\\";
		private static Logger logger = Logger.getLogger(takeScreenShot.class);
		

		public  static  void takeScreenshot(WebDriver driver, String testMethodName){
			//creating screenshot folder for test
//			创建保存截图文件夹
//					String folder = SCREENSHOT_PATH;
//					File dir = new File(folder);
//					if (!dir.exists()) {
//						dir.mkdir();
//					}
					
					try {
						
						// Pause because sometimes webdriver takes previous page screenshot
						
						Thread.sleep(3000);
						// 截图
						driver=new Augmenter().augment(driver);  
						File screenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
						
						//创建截图文件名
						SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd_'at'_HH''mm''ss");
						fileName = formater.format(Calendar.getInstance().getTime()) + "_"+testMethodName +".png";
					
						// Put screen file to appropriate folder
						String aaa=SCREENSHOT_PATH + fileName;
						
						System.out.println (aaa);
						FileUtils.copyFile(screenFile, new File(aaa));
						
						
						logImgLink.logImgLink(driver, fileName);
//						logImgLink.logImgLink(driver, aaa);
						
						System.out.println(fileName);
						
					} catch (WebDriverException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					return fileName;
				}
		
		public static byte[] takeScreenshot2(WebDriver driver) throws IOException {  
	        WebDriver augmentedDriver = new Augmenter().augment(driver);  
	      return ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BYTES);  
	        //TakesScreenshot takesScreenshot = (TakesScreenshot) driver;  
	        //return takesScreenshot.getScreenshotAs(OutputType.BYTES);  
	        }  
		
		public static BufferedImage createElementImage(WebDriver driver,WebElement webElement)  
	            throws IOException {  
	            // 获得webElement的位置和大小。  
	            Point location = webElement.getLocation();  
	            Dimension size = webElement.getSize();  
	            // 创建全屏截图。  
	            BufferedImage originalImage =  
	            ImageIO.read(new ByteArrayInputStream(takeScreenshot2(driver)));  
	            // 截取webElement所在位置的子图。  
	            BufferedImage croppedImage = originalImage.getSubimage(  
	            location.getX(),  
	            location.getY(),  
	            size.getWidth(),  
	            size.getHeight());  
	            return croppedImage;  
	            }  
		 

		

		public void screenShort(WebDriver driver, int arg0)throws IOException{
			String imagePath = "D:\\work\\screenshort" + File.separator+arg0 +"_"  
	                +arg0+".png";
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(imagePath));
		}
		
		
		public void testScreenShort(){
			try{
//				WebElement webElement= getElement(driver,By.id(""));
//				scrollToView(driver,webElement);
				screenShort(driver,1);	
			}catch (IOException e){
				logger.error("screenShort has got an problem " 
			            + e.getMessage()+";current time:"
			            + new Time(System.currentTimeMillis()));
			}
			
			
		}
	

	
	
	

}
