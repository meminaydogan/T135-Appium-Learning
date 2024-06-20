import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DAY1_HesapMakinası {


    // Driver Oluşturmanın 4 çeşidi

    AndroidDriver<AndroidElement> androidDriver;
 // IOSDriver <IOSElement> iosDriver;
 // AppiumDriver<IOSElement> appiumIOS;
 // AppiumDriver<AndroidElement> appiumAndroid;



    @Test
    public void deneme1 () throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\muhammed\\IdeaProjects\\T135_Appium\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk");


        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }





}
