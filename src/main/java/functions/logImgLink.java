package functions;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class logImgLink {
	
//	日志输出图片链接
	public  static  void logImgLink(WebDriver driver, String imgName){
	
	//Link
	Reporter.log("<a href=./img/" + imgName + " target=_blank>"+ imgName +"</a>", true);
//	Reporter.log("<a href=./img/" + imgName + " target=_blank>Failed Screen Shot</a>", true);
	 
	//Img
//	Reporter.log("<img src=./img/" + imgName + " /img>", true);

  }
}
