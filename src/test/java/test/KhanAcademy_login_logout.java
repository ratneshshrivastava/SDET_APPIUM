package test;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class KhanAcademy_login_logout {
	AndroidDriver driver;
  @Test
  public void Login_Logout() throws InterruptedException, IOException {
	  
	  File xlx = new File("C:\\MyWork\\forgot\\Manipal\\Testing.xlsx");
	
	FileInputStream finput = new FileInputStream(xlx);
	
	XSSFWorkbook wb = new XSSFWorkbook(finput);
	XSSFSheet sheet = wb.getSheetAt(0);
	int rowcnt = sheet.getLastRowNum();
	for (int i=1;i<=rowcnt;i++)
	{
		String user=sheet.getRow(i).getCell(0).getStringCellValue();
		String pwd = sheet.getRow(i).getCell(1).getStringCellValue();
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
	    driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Continue with Facebook\")")).click();
	      
	    Thread.sleep(5000);
	    driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys(user);
	    driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Facebook password\")")).sendKeys(pwd);
	    driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log In\")")).click();
	    Thread.sleep(5000);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
	}
	  
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException, MalformedURLException {
	  DesiredCapabilities capability= new DesiredCapabilities();
      capability.setCapability("deviceName", "Manzoor");
      capability.setCapability(MobileCapabilityType.NO_RESET, true);  
      capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
      capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
      capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
      driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
      Thread.sleep(25000);
      driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
