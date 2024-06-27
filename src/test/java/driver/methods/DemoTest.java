package driver.methods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoTest {
    @Test
	public void tc1() throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "12");
		dc.setCapability(MobileCapabilityType.UDID, "97d179ec");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus 7");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability("appPackage","com.androidsample.generalstore" );
		dc.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		
	
		//driver.activateApp("io.appium.android.apis");
		driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/continue_button")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Thread.sleep(2000);
		//scroll into view 
		String av="WebView";
		String an="text";
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))"));
		
	driver.findElement(AppiumBy.accessibilityId("WebView")).click();
//	AndroidElement element = driver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"WebView"+"\"))");
		int j=1;
		String web=null;
	Set<String> s = driver.getContextHandles();
	for(String h:s) 
	{
		if(j==s.size()) 
		{
			web=h;
		}
		j++;
		//System.out.println(h);
		
	}
	driver.context(web);
		//System.out.println(web);
		//driver.openNotifications();
		driver.navigate().back();
		
 //  driver.activateApp("com.androidsample.generalstore");
  // driver.terminateApp("com.androidsample.generalstore"); // It will close any app based on the appPackage
//   driver.runAppInBackground(Duration.ofSeconds(10));
//   Thread.sleep(3000);
//  System.out.println(driver.queryAppState("com.androidsample.generalstore"));
   
//   driver.closeApp(); // Close the app which was provided in the capabilities at session creation   
//
//   driver.close(); // from *RemoteWebDriver.java*, used to close the current browser page  
//
//   driver.quit(); // quits the session created between the client and the server
	}
}
