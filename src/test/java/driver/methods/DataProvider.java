package driver.methods;
import org.apache.poi.ss.usermodel.*;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DataProvider {

	
	@org.testng.annotations.DataProvider(name = "testData")
    public static Object[][] testData() throws IOException {
        FileInputStream file = new FileInputStream("D:/Nysa_BreakIn/sampleforappium.xlsx");
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = cell.toString();
            }
        }

        workbook.close();
        return data;
    }

	 @Test(dataProvider = "testData")
	    public void testAppWithExcelData(String txt) throws MalformedURLException, InterruptedException {
		 System.out.println(txt);
		 DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "12");
			dc.setCapability(MobileCapabilityType.UDID, "97d179ec");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus 7");
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			dc.setCapability("appPackage","com.androidsample.generalstore" );
			dc.setCapability("appActivity",".SplashActivity");
			URL url=new URL("http://127.0.0.1:4723/wd/hub");
			AndroidDriver driver=new AndroidDriver(url,dc);
			Thread.sleep(4000);
			driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys(txt);
			
	        // Your test logic using the provided data
	        // Example: driver.findElement(By.id("username")).sendKeys(username);
	        // Example: driver.findElement(By.id("password")).sendKeys(password);
	    }

}