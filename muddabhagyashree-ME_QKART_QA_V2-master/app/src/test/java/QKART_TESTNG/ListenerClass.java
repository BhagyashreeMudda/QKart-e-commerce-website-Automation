package QKART_TESTNG;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends QKART_Tests implements ITestListener
{

   
    public void onTestStart(ITestResult result)
    {
        takeScreenshot(driver, "StartTestCase", "TestCase");
    }



    public void OnTestFailure(ITestResult result)
    {
        takeScreenshot(driver, "StartTestCase", "TestCase");
    }

    public void onTestSuccess(ITestResult result)
    {
        takeScreenshot(driver, "StartTestCase", "TestCase");
    }



    
}
