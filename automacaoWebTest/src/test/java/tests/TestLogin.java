package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestLogin extends BaseTest {

    @Test(description = "Teste de fluxo de login")
    public void TestFluxoLogin() {
        LoginPage loginPage = new LoginPage(driver);

        iniciarTeste();
        loginPage.performLogin("andrea@teste.com", "@andrea123");
        finalizarTeste();
    }

    @Step("Iniciando o teste de login")
    private void iniciarTeste() {
        Allure.step("Teste de login iniciado.");
    }

    @Step("Finalizando o teste de login")
    private void finalizarTeste() {
        Allure.step("Teste de login finalizado com sucesso.");
    }
}
