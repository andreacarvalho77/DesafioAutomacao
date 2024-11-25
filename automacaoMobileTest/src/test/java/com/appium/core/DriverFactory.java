package com.appium.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

    protected static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() throws InterruptedException {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private static void createDriver() throws InterruptedException {

        String APP = Utils.returnCurrentDir() + "/src/test/java/resources/CTAppium_2_0.apk";

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Android Emulator");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");

        desiredCapabilities.setCapability("appPackage", "com.ctappium");//
        desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
