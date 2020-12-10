package resources;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import EndtoEndFramework.EndtoEndFramework.Base1;
import io.appium.java_client.android.AndroidDriver;

public class Listener implements ITestListener 
{
public static AndroidDriver driver;
//	 private static ExtentReports extent = ExtentManager.createInstance();
//	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		
//	AndroidDriver driver=(AndroidDriver) result.getTestContext().getAttribute("driver");
//     context.setAttribute("driver",driver);
//		
     		String s=result.getName();
     		System.out.println(s);
			try {
				Base1.getScreenshot(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	

}
