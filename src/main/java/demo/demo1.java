package demo;


import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class demo1 {
    @BeforeClass
    public void setup()
    {
        System.out.println("begin test");
    }
    @Test
    public void test()
    {
        System.out.println("at test");
        Reporter.log("这是testng美化报告的一个失败测试用例");
    }
    
    @Test
    public void test2()
    {
        System.out.println("at test");
        Reporter.log("这是testng美化报告的一个失败测试用例");
    }
    @AfterClass
    public void teardown()
    {
        System.out.println("end test");
    }

}




	
	
	
	


