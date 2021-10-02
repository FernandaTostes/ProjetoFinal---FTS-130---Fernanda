package mobileTests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculadoraAPK {

    private AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String ambiente = "remoto";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL remoteUrl;
        switch (ambiente) {
            case "local":
                 desiredCapabilities.setCapability("platformName", "Android");
             desiredCapabilities.setCapability("deviceName", "emulator-5554");
             desiredCapabilities.setCapability("automationName", "uiautomator2");
             desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
             desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
             desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
             remoteUrl = new URL("http://localhost:4723/wd/hub");
            break;
            case "remoto":
                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("platformVersion", "9.0");
                desiredCapabilities.setCapability("browserName", "");
                //desiredCapabilities.setCapability("appiumVersion", "1.19.2");
                desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
                desiredCapabilities.setCapability("deviceOrientation", "portrait");
                desiredCapabilities.setCapability("app", "storage:filename=Calculator_v7.8 (271241277)_apkpure.com.apk");
                desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
                desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
                desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
                desiredCapabilities.setCapability("SAUCE_USERNAME", "oauth-cristil.cal-f0174");
                desiredCapabilities.setCapability("SAUCE_ACCESS_KEY", "b0f0e7b8-261b-41bd-bf17-9542048ef92c");
                remoteUrl = new URL("https://oauth-cristil.cal-f0174:b0f0e7b8-261b-41bd-bf17-9542048ef92c@ondemand.us-west-1.saucelabs.com:443/wd/hub");
            break;
            default:
              remoteUrl = new URL("http://localhost:4723/wd/hub");
            break;
        }

        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void subtracao() {
        MobileElement btn7 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_7");
        btn7.click();
        MobileElement btnSubtrair = (MobileElement) driver.findElementByAccessibilityId("minus");
        btnSubtrair.click();
        MobileElement btn3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        btn3.click();
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();
        MobileElement lblResultado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals("4", lblResultado.getText());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}



