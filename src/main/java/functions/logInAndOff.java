package functions;

//import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import poi.XlsDto;

public class logInAndOff {

	static StringBuffer verificationErrors = new StringBuffer();

	public static void login(WebDriver driver, XlsDto data) throws InterruptedException {

		driver.findElement(By.name("account")).clear();
		driver.findElement(By.name("account")).sendKeys(data.getUsename());
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(data.getPassword());
//	    driver.findElement(By.name("password")).sendKeys("123456");
//	    if (!driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected()) {
//	 	   driver.findElement(By.xpath("//input[@type='checkbox']")).click();
//	    };
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

//	    
//	    try {
//	        assertEquals("???", driver.findElement(By.xpath("//span[@class='username']")).getText());
//	      } catch (Error e) {
//	        verificationErrors.append(e.toString());
//	      }

		Thread.sleep(5000);

		String title = driver.getTitle();
//			Assert.assertEquals(title,"????????");

//	               ???????????????????????
//	      driver.findElement(By.cssSelector(".fa.fa-sign-in")).click();
//	      Thread.sleep(5000);
//			
//	      
//	      java.util.List<WebElement> lists= driver.findElements(By.cssSelector("i.fa.fa-square-o"));
//	      
//	      System.out.println(lists.size());
//	      
//	      //lists.get(2).click();
//	      
//	      for(int i =1;i<5;i++)
//	      {
//	    	  lists.get(i).click();
//	      }

	}

	public static void logoff(WebDriver driver) throws InterruptedException {
		driver.findElement(By.cssSelector("i.fa.fa-angle-down")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("i.fa.fa-key")).click();

	}

}
