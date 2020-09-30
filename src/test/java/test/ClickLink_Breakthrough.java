package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ClickLink_Breakthrough {
	AndroidDriver driver;
  @Test
  public void KA006_Set1_ClickLink_Creakthrough() throws InterruptedException {
	  driver.findElementByAccessibilityId("Search tab").click();
      Thread.sleep(5000);
      //driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Search\")")).sendKeys("Partner content");
      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Partner content\")")).click();
      //driver.hideKeyboard();
      Thread.sleep(5000);
      TouchAction act= new TouchAction(driver);
      Dimension d=driver.manage().window().getSize();
      int width=d.width;
      int height=d.height;
      int x1=width/2;
      int y1=4*height/5;
      int x2=width/2;
      int y2=height/5;
      while(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"Breakthrough Junior Challenge\")")).size()==0)
      {

      act.press(PointOption.point(x1,y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x2,y2)).release().perform();
            
      }
      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Breakthrough Junior Challenge\")")).click();
      Thread.sleep(5000);
      String actualText=driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Partner content\")")).getText();
	  String expectedText="Partner content";
	  Assert.assertEquals(actualText, expectedText);
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities capability= new DesiredCapabilities();
      capability.setCapability("deviceName", "Manzoor");
      capability.setCapability(MobileCapabilityType.NO_RESET, true);  
      capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
      capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
      capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
      driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
      Thread.sleep(25000);
      driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
      
      //driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
      
     
      
	  
  }

  @AfterMethod
  public void afterClass() {
  }

}
