package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Locators;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Preenchendo informações pessoais: {firstName} {lastName}")
    public void fillPersonalInformation(String firstName, String lastName, String address, String email, String phone) {
        driver.findElement(By.xpath(Locators.FIRST_NAME)).sendKeys(firstName);
        driver.findElement(By.xpath(Locators.LAST_NAME)).sendKeys(lastName);
        driver.findElement(By.xpath(Locators.ADDRESS)).sendKeys(address);
        driver.findElement(By.xpath(Locators.EMAIL)).sendKeys(email);
        driver.findElement(By.xpath(Locators.PHONE)).sendKeys(phone);
    }

    @Step("Selecionando gênero")
    public void selectGender() {
        driver.findElement(By.xpath(Locators.FEMALE_RADIO)).click();
        Allure.step("Gênero selecionado: Feminino.");
    }

    @Step("Selecionando hobbies: Cricket e Movies")
    public void selectHobbies() {
        WebElement cricket = driver.findElement(By.xpath(Locators.CRICKET));
        WebElement movies = driver.findElement(By.xpath(Locators.MOVIES));

        if (!cricket.isSelected()) cricket.click();
        if (!movies.isSelected()) movies.click();

        Allure.step("Hobbies selecionados com sucesso.");
    }

    @Step("Selecionando skill: {skill}")
    public void selectSkills(String skill) {
        Select skillsDropdown = new Select(driver.findElement(By.xpath(Locators.SKILLS)));
        skillsDropdown.selectByVisibleText(skill);
    }

    @Step("Selecionando país: {country}")
    public void selectCountry(String country) {
        try {
            WebElement countryDropdown = driver.findElement(By.xpath(Locators.SELECT_COUNTRY));
            countryDropdown.click();

            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[@role='combobox']")
            ));

            searchField.sendKeys(country);
            searchField.sendKeys(Keys.ENTER);

            Allure.step("País selecionado com sucesso: " + country);
        } catch (Exception e) {
            Allure.step("Erro ao selecionar o país: " + e.getMessage());
        }
    }

    @Step("Selecionando data de nascimento: {day}/{month}/{year}")
    public void selectDateOfBirth(String year, String month, String day) {
        Select yearDropdown = new Select(driver.findElement(By.xpath(Locators.YEAR)));
        yearDropdown.selectByVisibleText(year);

        Select monthDropdown = new Select(driver.findElement(By.xpath(Locators.MONTH)));
        monthDropdown.selectByVisibleText(month);

        Select dayDropdown = new Select(driver.findElement(By.xpath(Locators.DAY)));
        dayDropdown.selectByVisibleText(day);

        Allure.step("Data de nascimento selecionada: " + day + "/" + month + "/" + year);
    }

    @Step("Configurando senha")
    public void setPassword(String password) {
        driver.findElement(By.xpath(Locators.PASSWORD)).sendKeys(password);
        driver.findElement(By.xpath(Locators.CONFIRM_PASSWORD)).sendKeys(password);
    }

    @Step("Submetendo formulário de registro")
    public void submitForm() {
        driver.findElement(By.xpath(Locators.SUBMIT_BUTTON)).click();
        Allure.step("Formulário enviado com sucesso.");
    }
}



/*
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Locators;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPersonalInformation(String firstName, String lastName, String address, String email, String phone) {
        driver.findElement(By.xpath(Locators.FIRST_NAME)).sendKeys(firstName);
        driver.findElement(By.xpath(Locators.LAST_NAME)).sendKeys(lastName);
        driver.findElement(By.xpath(Locators.ADDRESS)).sendKeys(address);
        driver.findElement(By.xpath(Locators.EMAIL)).sendKeys(email);
        driver.findElement(By.xpath(Locators.PHONE)).sendKeys(phone);
    }

    public void selectGender() {
        driver.findElement(By.xpath(Locators.FEMALE_RADIO)).click();
    }

    public void selectHobbies() {
        WebElement cricket = driver.findElement(By.xpath(Locators.CRICKET));
        WebElement movies = driver.findElement(By.xpath(Locators.MOVIES));

        if (!cricket.isSelected()) cricket.click();
        if (!movies.isSelected()) movies.click();
    }

    public void selectSkills(String skill) {
        Select skillsDropdown = new Select(driver.findElement(By.xpath(Locators.SKILLS)));
        skillsDropdown.selectByVisibleText(skill);
    }

    public void selectCountry(String country) {
        try {
            WebElement countryDropdown = driver.findElement(By.xpath(Locators.SELECT_COUNTRY));
            countryDropdown.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[@role='combobox']")
            ));

            searchField.sendKeys(country);
            searchField.sendKeys(Keys.ENTER);

            System.out.println("País selecionado com sucesso: " + country);
        } catch (Exception e) {
            System.err.println("Erro ao selecionar o país: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void selectDateOfBirth(String year, String month, String day) {
        Select yearDropdown = new Select(driver.findElement(By.xpath(Locators.YEAR)));
        yearDropdown.selectByVisibleText(year);

        Select monthDropdown = new Select(driver.findElement(By.xpath(Locators.MONTH)));
        monthDropdown.selectByVisibleText(month);

        Select dayDropdown = new Select(driver.findElement(By.xpath(Locators.DAY)));
        dayDropdown.selectByVisibleText(day);
    }

    public void setPassword(String password) {
        driver.findElement(By.xpath(Locators.PASSWORD)).sendKeys(password);
        driver.findElement(By.xpath(Locators.CONFIRM_PASSWORD)).sendKeys(password);
    }

    public void submitForm() {
        driver.findElement(By.xpath(Locators.SUBMIT_BUTTON)).click();
    }
}*/
