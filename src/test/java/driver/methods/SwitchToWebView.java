package driver.methods;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class SwitchToWebView {
 
	@Test
	public void tc1() throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "10");
		dc.setCapability(MobileCapabilityType.UDID, "052653206K003609");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Infinix HOT 9 pro");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		//dc.setCapability("appium:chromeOptions", ImmutableMap.of("JSON wire", false));
		//dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "appium");
		//dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_AUTO_DOWNLOAD, true);
		//dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE_DIR, "D:\\chrome\\chromedriver-win32\\chromedriver.exe");
	
		dc.setCapability("appPackage","com.androidsample.generalstore" );
		dc.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Archit is a bad person");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
		
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(2000);
		Set<String> w = driver.getContextHandles();
		System.out.println(w);
		Thread.sleep(3000);
				for(String s:w) 
				{
					if(s.trim().equals("WEBVIEW_com.androidsample.generalstore")) {
					driver.context(s);
					System.out.println("=============================================");
				}
					Thread.sleep(3000);
				}
				
				
				
			Thread.sleep(2000);
			driver.findElement(By.className("gLFyf")).sendKeys("mobile"+Keys.ENTER);
			Thread.sleep(3000);
			driver.context("NATIVE_APP");
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	}
	
}
