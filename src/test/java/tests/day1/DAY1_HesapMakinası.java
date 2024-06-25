package tests.day1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
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


        androidDriver.findElementByAccessibilityId("8").click();
        androidDriver.findElementByAccessibilityId("0").click();
        androidDriver.findElementByAccessibilityId("multiply").click();
        androidDriver.findElementByAccessibilityId("2").click();
        androidDriver.findElementByAccessibilityId("0").click();
        // Eger bir uygulama ilk defa yukleniyor ise bu capability kullanilir ve uygulama yuklenir.
        // Uygulama yuklu ise bunun yuklu olup olmadigini kontrol eder yukluyse uygulamayi acar degilse uygulamayi yukler ve acar

        /*
         Eger andorid bir cihaz da test yapacaksak bununla alakali bir automationName belirlememiz gerekiyor
         Belirledimiz automationName eger ki sectigimiz platformVersion 6.0 dan buyukse UiAutomator2
         Belirledimiz automationName eger ki sectigimiz platformVersion 6.0 dan kucukse UiAutomator
        */


        String sonucActual = androidDriver.findElementById("com.google.android.calculator:id/result_preview").getText();
        int sonucExpected = 1600 ;

        Assert.assertEquals(Integer.parseInt(sonucActual),sonucExpected);


    }





}
