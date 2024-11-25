package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By btn1 = By.id("btn1");
    private By emailField = By.cssSelector("input[placeholder='E mail']");
    private By passwordField = By.cssSelector("input[placeholder='Password']");
    private By enterButton = By.id("enterbtn");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions with Allure Steps
    @Step("Clicando no botão inicial")
    public void clickBtn1() {
        driver.findElement(btn1).click();
    }

    @Step("Inserindo e-mail: {email}")
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Inserindo senha")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Clicando no botão 'Enter'")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Realizando login com e-mail: {email}")
    public void performLogin(String email, String password) {
        clickBtn1();
        enterEmail(email);
        enterPassword(password);
        clickEnterButton();
        Allure.step("Login realizado com sucesso.");
    }
}
