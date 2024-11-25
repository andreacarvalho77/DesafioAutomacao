package com.appium.core;

import java.io.File;
import java.io.IOException;
import org.junit.Rule;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest extends DriverFactory {

    public BaseTest() {
        super();
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void inicializaAppium() throws InterruptedException {
        DriverFactory.getDriver();
    }

    @After
    public void finalizaAppium() {
        gerarScreenShot();
        DriverFactory.killDriver();
    }

    @After
    public void gerarScreenShot() {

        try {
            File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(imagem, new File("target/screenshots/" + testName.getMethodName() + ".png"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}