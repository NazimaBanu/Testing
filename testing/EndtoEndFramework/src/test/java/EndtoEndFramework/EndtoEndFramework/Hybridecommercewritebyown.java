package EndtoEndFramework.EndtoEndFramework;
//Shop items in the list by scrolling to specific prdt & add to cart
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import resources.UtilitiScrolling;

public class Hybridecommercewritebyown extends Base1 {
	public static AndroidDriver<AndroidElement> driver;
	//public static ITestContext context;
	
//public static ITestContext setContext(ITestContext iTestContext, AndroidDriver driver) {
//    iTestContext.setAttribute("driver", driver);
//
//    return iTestContext;
//}
	
//	@BeforeClass
//    public  void setupTest(ITestContext iTestContext) throws Exception {
//        System.out.println("BeforeMethod is started. " + Thread.currentThread().getId());
//        // Set & Get ThreadLocal Driver with Browser
//       
//        this.context = setContext(iTestContext, (AndroidDriver) driver);
//        driver=Capabilities(driver);
//       
//	}
//	
	
	//public  void test1(ITestContext iTestContext) throws Exception {
	    @Test(groups= {"Smoke"},dataProvider="InputData",dataProviderClass=TestData.class)
		public static void test1(String input) throws Exception {
// AndroidDriver a = (AndroidDriver) iTestContext.getAttribute("driver");
		 driver=Capabilities();
		//It will be wrong when u specify driver.Capabilities("real"); As driver is not a Base class object to call its own Capabilities method
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//It will degrade the performance & becomes slow, when it waits 10sec for every element
		MainPage mn=new MainPage(driver);
		mn.getName().sendKeys(input);
		mn.selectCityDropDown().click();
		mn.clickCitySelection().click();
		mn.radioSelection().click();
		mn.buttonClick().click();   
	}
	@Test()//(dependsOnMethods= {"test1"})
	public static void test2() throws Exception {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		UtilitiScrolling u=new UtilitiScrolling(driver);
		u.scrollText("Jordan 6 Rings");
		ProductPage p=new ProductPage(driver);
		//p.productSelection();//The scrolling is not working when handling the operation of scrolling from other class(ProductPage)as selectPrt becoz it doesnot specify driver.findElementByAndroidUiAutoamator like above referring to the class Utiliti;
		p.productNamesinPage().get(0).click();
		p.productNamesinPage().get(1).click();
		p.btnCartSelection().click();
		Thread.sleep(1000);
		CartPage c=new CartPage(driver);
		c.totalAmountcalculation();
		
	}
	
	@BeforeTest
	public void killAllNodes() throws Exception
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(1000);
		
	}
	@BeforeMethod(alwaysRun=true)
	public static void startServerEmulator() throws Exception
	{
		 startServer();
		 startEmulator();
	}
	
	@AfterMethod
	public static void stopService()
	{
		service.stop();
	}
    }
	


