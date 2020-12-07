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

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utilities.Utiliti;

public class Hybridecommercewritebyown extends Base1 {
	public static AndroidDriver<AndroidElement> driver;
	@Test
	public static void test1() throws Exception {
		startServer();
		
		driver=Capabilities();//It will be wrong when u specify driver.Capabilities("real"); As driver is not a Base class object to call its own Capabilities method
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//It will degrade the performance & becomes slow, when it waits 10sec for every element
		MainPage mn=new MainPage(driver);
		//mn.getName().sendKeys("hello");
		mn.selectCityDropDown().click();
		mn.clickCitySelection().click();
		mn.radioSelection().click();
		mn.buttonClick().click();
		
	   
	}
	@Test
	public static void test2() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Utiliti u=new Utiliti(driver);
		u.scrollText("Jordan 6 Rings");
		ProductPage p=new ProductPage(driver);
		//p.productSelection();//The scrolling is not working when handling the operation of scrolling from other class(ProductPage)as selectPrt becoz it doesnot specify driver.findElementByAndroidUiAutoamator like above referring to the class Utiliti;
		p.productNamesinPage().get(0).click();
		p.productNamesinPage().get(1).click();
		p.btnCartSelection().click();
		Thread.sleep(1000);
		CartPage c=new CartPage(driver);
		c.totalAmountcalculation();
		service.stop();
		
					//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))");
		//Resource-Id is not parseable , so it giving Invalid selector exception for the below one. It works fine for him->This is to find the list of products & scroll to the particular prdt havind Add Cart visible in the component. Sometimes in the above line->the addcart is not visible (it gets cut off) as the component of selected pdt is not displayed in full size
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resource-id(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\").instance(0))");
//		List<AndroidElement> ls=driver.findElementsById("com.androidsample.generalstore:id/productName");
//		for(int i=0;i<ls.size();i++)
//		{
//			String value=ls.get(i).getText();
//			if(value.equalsIgnoreCase("Jordan 6 Rings"))
//			{
//				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
//			}
//		}
		
		//driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
	}
	@BeforeTest
	public void killAllNodes() throws Exception
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(1000);
	}
	

}
