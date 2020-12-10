package EndtoEndFramework.EndtoEndFramework;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainPage {
	AndroidDriver testDriver;

	public MainPage(AndroidDriver driver) {
		this.testDriver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(testDriver),this);
	}

	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	AndroidElement name;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	AndroidElement dropdown;
	
	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))")
	AndroidElement citySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	AndroidElement radiobtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	AndroidElement btnShop;
	
	public AndroidElement getName()
	{
		return name;
	}
	public AndroidElement selectCityDropDown()
	{
		return dropdown;
		
	}
	public AndroidElement clickCitySelection()
	{
		return citySelection;
	}
	public AndroidElement radioSelection()
	{
		return radiobtn;
	}
	public AndroidElement buttonClick()
	{
		return btnShop;
	}
	
}
