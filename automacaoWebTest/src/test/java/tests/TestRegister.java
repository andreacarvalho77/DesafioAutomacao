package tests;

import org.testng.annotations.Test;
import pages.RegistrationPage;
import io.qameta.allure.Allure;

public class TestRegister extends TestBase {

    @Test
    public void registerUser() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Preencher informações pessoais
        registrationPage.fillPersonalInformation("Andrea", "Carvalho", "Rua da Esperança", "andreas@teste.com", "1111111122");

        // Selecionar gênero e hobbies
        registrationPage.selectGender();
        registrationPage.selectHobbies();

        // Selecionar habilidades, país e data de nascimento
        registrationPage.selectSkills("Java");
        registrationPage.selectCountry("United States");
        registrationPage.selectDateOfBirth("1977", "October", "23");

        // Configurar senha e enviar formulário
        registrationPage.setPassword("@andrea123");
        registrationPage.submitForm();
    }
}
