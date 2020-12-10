package EndtoEndFramework.EndtoEndFramework;

import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {
	public static AndroidDriver<AndroidElement> testDriver;
	
	public CartPage(AndroidDriver<AndroidElement> driver)
	{
		this.testDriver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	List<AndroidElement> price;
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	AndroidElement totAmount;
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	AndroidElement btn;
	
	public void totalAmountcalculation()
	{Double sum=0.0;
		for(int i=0;i<price.size();i++)
		{
			String amount1=price.get(i).getText();
			amount1=amount1.substring(1);
			amount1.trim();
			System.out.println(amount1);
			Double amount=getAmount(amount1);
			sum=sum+amount;
		}
		String total=totAmount.getText();
		//total.replace("[^0-9&&[.]]", "");
		total=total.substring(1);
		total.trim();
		System.out.println(total);
		Double tot=getAmount(total);
		Assert.assertEquals(sum, tot);
		
		btn.click();
	}
	
	public Double getAmount(String a)
	{
		Double amt=Double.valueOf(a);
		return amt;
	}

}
