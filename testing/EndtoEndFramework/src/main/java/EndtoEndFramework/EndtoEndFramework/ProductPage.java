package EndtoEndFramework.EndtoEndFramework;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {
	AndroidDriver<AndroidElement>testDriver;
	
	public ProductPage(AndroidDriver<AndroidElement> driver)
	{
		this.testDriver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(testDriver), this);
	}
	
	//@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))")  
	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector().resource-id(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\").instance(0))")
	AndroidElement selectPdt;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	List<AndroidElement> ls;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	List<AndroidElement> addCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	AndroidElement btnCart;
	
	public AndroidElement productSelection()
	{
		return selectPdt;
	}
	
	public List<AndroidElement> productNamesinPage()
	{
		
//		for(int i=0;i<ls.size();i++)
//		{
//			String value=ls.get(i).getText();
//			if(value.equalsIgnoreCase("Jordan 6 Rings"))
//			{
//				addCart.get(i).click();
//			}
//		}
		
	return addCart;	
	}
	
	public AndroidElement btnCartSelection()
	{
		return btnCart;
	}

}
