package ru.vasyukov.hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.vasyukov.properties.TestData;

import java.net.URL;

public class BaseTest {
    protected AppiumDriver<WebElement> driver;

    public void connect(String platform, String deviceName, String versionOS) {
        URL URL = null;
        try {
            URL = new URL(TestData.appium.baseUrl());
        } catch (Exception e) {
            Assertions.fail("Неправильный url: " + TestData.appium.baseUrl());
        }
        if (platform.equals("android")) {
            this.driver = new AndroidDriver<>(URL, getAndroidDesiredCapabilities(deviceName, versionOS));
        } else {
            Assertions.fail("Неправильная платформа: " + platform);
        }
    }

    @AfterEach
    public void disconnect() {
        if (this.driver != null) {
            this.driver.quit();
            this.driver = null;
        }
    }

    private DesiredCapabilities getAndroidDesiredCapabilities(String deviceName, String versionOS) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("avd",deviceName);
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion",versionOS);
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","E:/awa_java/Appium_sk/apps/org.wikipedia.apk");
        return capabilities;
    }
}
