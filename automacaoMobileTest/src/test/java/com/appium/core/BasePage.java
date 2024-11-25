package com.appium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage extends DriverFactory {

    public void click(By by) {
        try {
            waitBy(by);
            getDriver().findElement(by).click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void waitBy(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForPresenceOfElement(String fullXpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fullXpath)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void implicitWaitInMilisec(long milisec) {
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public void clickByText(String text) {
        try {
            waitForPresenceOfElement("//*[@text='" + text + "']");
            MobileElement el = driver.findElement(By.xpath("//*[@text='" + text + "']"));
            el.click();
        } catch (Exception e) {
            WebElement el = driver.findElement(By.xpath("//*[@text='" + text + "']"));
            el.click();
        }
    }

    public void tap(int x, int y) {
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(x, y)).perform();
    }
    public void inputTextXpathResourceId(String resource_id, String text) {
        driver.findElement(By.xpath("//*[@resource-id='" + resource_id + "']")).sendKeys(text);
    }
    public String getTextByAttribute(String text) {
        return driver.findElement(By.xpath("//*[@text='" + text + "']")).getText();
    }

}

