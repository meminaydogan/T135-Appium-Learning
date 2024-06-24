package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DAY3_KiwiKendiCozumum {



    AndroidDriver<AndroidElement> androidDriver;


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        // capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\muhammed\\IdeaProjects\\T135_Appium\\Apps\\Kiwi.com - Book Cheap Flights_2023.14.0_Apkpure (1).apk");
         capabilities.setCapability("appPackage","com.skypicker.main");
        // AppPackage caliscak oldugunuz uygulaminin bilgisini girdikten sonra (T.C) O uygulamayi baslatir.
        // fakat!!!!! uygulamayi basta yuklemeniz gerekmektedir!!! yuklu degilse uygulamayi BASLATMAZ !!!!!!!
         capabilities.setCapability("appActivity","com.kiwi.android.feature.splash.impl.ui.SplashActivity");
        // UYGULAMNIN HANGI SAYFASINDAN BASLAMANIZI ISTIYORSANIZ ILGILI SAYFANIN ACTIVITY DEGERINI GIRER
        // O SAYFADAN UYGULAMAYI BASLATABILIRSINIZ.
        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void kiwitesti() throws InterruptedException {
// uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(androidDriver.isAppInstalled("com.skypicker.main"));
// uygulamanin basariyla acildigi dogrulanir
        androidDriver.findElementByXPath("//android.widget.ScrollView/android.view.View[4]/android.widget.Button").isDisplayed();
// misafir olarak devam et e tiklanir
        androidDriver.findElementByXPath("//android.widget.ScrollView/android.view.View[4]/android.widget.Button").click();
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        androidDriver.findElementByXPath("//android.widget.TextView[@text=\"Continue\"]").click();
        androidDriver.findElementByXPath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.skypicker.main:id/onboarding\"]/android.view.View/android.view.View[2]/android.widget.Button").click();
        androidDriver.findElementByXPath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.skypicker.main:id/onboarding\"]/android.view.View/android.view.View[2]/android.widget.Button").click();
// Trip type,one way olarak secilir
        androidDriver.findElementByXPath("//android.widget.TextView[@text=\"Return\"]").click();
        TouchAction action=new TouchAction<>(androidDriver);
        Thread.sleep(1000);
        action.press(PointOption.point(1007,1805))
                .release()
                .perform();
        Thread.sleep(1000);
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        Thread.sleep(1000);
        action.press(PointOption.point(231,889))
                .release()
                .perform();
        Thread.sleep(1000);
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        androidDriver.findElementByXPath("//com.kiwi.android.shared.ui.view.base.picker.DialogComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.view.View/android.widget.Button").click();
        androidDriver.findElementByXPath("//com.kiwi.android.shared.ui.view.base.picker.DialogComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.Button").click();
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
      androidDriver.findElementByXPath("//android.widget.TextView[@text=\"To:\"]").click();
      androidDriver.findElementByXPath("//com.kiwi.android.shared.ui.view.base.picker.DialogComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[5]/android.view.View/android.widget.Button").click();
      androidDriver.findElementByXPath("//com.kiwi.android.shared.ui.view.base.picker.DialogComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.Button").click();
// gidis tarihi haziran ayinin 28 i olarak secilir ve set date e tiklanir
        androidDriver.findElementByXPath("//android.widget.TextView[@text=\"Departure:\"]").click();
        Thread.sleep(1000);
        action.press(PointOption.point(824,1456))
                .release()
                .perform();
        Thread.sleep(1000);
        androidDriver.findElementById("com.skypicker.main:id/saveButton").click();
// search butonuna tiklanir
        Thread.sleep(1000);
        action.press(PointOption.point(532,1330))
                .release()
                .perform();
        Thread.sleep(1000);
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
        androidDriver.findElementByXPath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.skypicker.main:id/compose_view\"]/android.view.View/android.view.View/android.view.View/android.widget.HorizontalScrollView/android.view.View[2]").click();
        androidDriver.findElementByXPath("//android.widget.ScrollView/android.view.View[2]/android.view.View").click();
        androidDriver.findElementByXPath("//android.widget.TextView[@text=\"Stops\"]").click();
        androidDriver.findElementByXPath("//com.kiwi.android.shared.ui.view.base.picker.DialogComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View").click();
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String biletfiyati = androidDriver.findElementByXPath("(//*[@class='android.widget.TextView'])[12]").getText();
        System.out.println("en ucuz bilet fiyatı =" + biletfiyati);
}

}