package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class TestRegister extends TestBase {

    @Test(description = "Teste de registro de usuário com preenchimento completo do formulário")
    public void registerUser() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        iniciarTeste();

        preencherFormulario(registrationPage);

        finalizarTeste();
    }

    @Step("Iniciando teste de registro de usuário")
    private void iniciarTeste() {
        driver.findElement(By.id("btn2")).click();
        Allure.step("Página de registro acessada com sucesso.");
    }

    @Step("Preenchendo formulário de registro")
    private void preencherFormulario(RegistrationPage registrationPage) {
        registrationPage.fillPersonalInformation(
                "Andrea", "Carvalho", "Rua da Esperança",
                "andreas@teste.com", "1111111122"
        );

        registrationPage.selectGender();
        registrationPage.selectHobbies();
        registrationPage.selectSkills("Java");
        registrationPage.selectCountry("United States");
        registrationPage.selectDateOfBirth("1977", "October", "23");
        registrationPage.setPassword("@andrea123");
        registrationPage.submitForm();
    }

    @Step("Finalizando teste de registro de usuário")
    private void finalizarTeste() {
        Allure.step("Teste finalizado com sucesso.");
    }
}
