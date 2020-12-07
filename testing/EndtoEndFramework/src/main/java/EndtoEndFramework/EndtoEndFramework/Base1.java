package EndtoEndFramework.EndtoEndFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base1{
public static AppiumDriverLocalService service;
public static AndroidDriver driver;
	public static AndroidDriver Capabilities() throws Exception {
		String dir=System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream(dir+"\\src\\main\\java\\EndtoEndFramework\\EndtoEndFramework\\config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		Object v=prop.get("appName");
		prop.get("device");
		File f=new File("src");
		File fs=new File(f,(String) prop.get("appName"));
		
		
//				File f=new File("src");
//				File fs=new File(f,appName);
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("MobileCapabilityType.Device_Name", "device");//deviceName
		
//										if(device.equalsIgnoreCase("real"))
//										{
//										cap.setCapability("deviceName", "real");
//										}
//										else if(device.equalsIgnoreCase("emulator"))
//										{
//											startEmulator();
//											cap.setCapability("deviceName", "emulator");
//											
//										}
		cap.setCapability("App",fs.getAbsolutePath());//It doesn't work
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
				//System.getProperty("user.dir");//IT doesnot work
		//cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
		
		//cap.setCapability(MobileCapabilityType.APP, "C://Users//nazim//workspace4//UdemyAndroidShetty2//src//ApiDemos-debug.apk");
		//cap.setCapability("appPackage", "io.appium.android.apis");
		//cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		cap.setCapability("automationName", "UiAutomator2");
				//		cap.setCapability("skipDeviceInitialization", false);// This may be used to install Appium Settings app in real device which is used to interact with device automation tests. These are the services offered by appium server, thru adb to automatically install Appium settings to the device. 
				//		cap.setCapability("skipServerInstallation", "false");
		cap.setCapability("newCommandTimeout", "14");
		//cap.setCapability("noreset", "false");
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		
	}
	public static void startEmulator() throws IOException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\emu.bat");
		
	}
	public static AppiumDriverLocalService startServer()
	{
		boolean flag=checkifServerIsRunning(4723);
		if(!flag)
		{
			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
		
	}
	private static boolean checkifServerIsRunning(int port) {
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try 
		{
			serverSocket=new ServerSocket(port);
			serverSocket.close();
		}
		catch(Exception e)
		{
			isServerRunning=true;
		}
		finally
		{
			serverSocket=null;
		}
		return isServerRunning;
	}
public static void getScreenshot(String s) throws Exception
{
	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\src\\"+s+".png"));
	FileUtils.copyFile(srcfile, new File("C:\\Users\\nazim\\workspace4\\EndtoEndFramework\\src\\"+s+".png"));
}
}
