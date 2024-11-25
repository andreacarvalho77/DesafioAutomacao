package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.LojaPage;
import pages.CheckoutPage;

public class TestLoja extends BaseTest {

    @Test(description = "Teste do fluxo completo na loja: da navegação ao checkout")
    public void testFluxoLoja() {
        LojaPage lojaPage = new LojaPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        iniciarTeste();

        lojaPage.acessarPaginaShop();
        lojaPage.adicionarLivroAoCarrinho();
        lojaPage.visualizarCarrinho();
        lojaPage.procederParaCheckout();

        checkoutPage.preencherFormularioCheckout(
                "Andrea", "Carvalho", "Rua da Esperança",
                "Salvador", "12345-678", "71987654321",
                "andrea@teste.com"
        );

        checkoutPage.selecionarMetodoPagamento();
        //checkoutPage.submeterPedido();
        finalizarTeste();
    }

    @Step("Iniciando o teste do fluxo na loja")
    private void iniciarTeste() {
        Allure.step("Abrindo a página inicial da loja");
        driver.get("https://practice.automationtesting.in/");
    }

    @Step("Finalizando o teste do fluxo na loja")
    private void finalizarTeste() {
        Allure.step("Teste finalizado com sucesso.");
    }
}
