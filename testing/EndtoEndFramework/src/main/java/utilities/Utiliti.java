package utilities;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Utiliti {
	public static AndroidDriver testDriver;

	public Utiliti(AndroidDriver driver)
	{
		this.testDriver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void scrollText(String test)
	{
		testDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+test+"\"))");
	}
}
