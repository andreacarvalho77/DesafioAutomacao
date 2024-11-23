package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import pages.LojaPage;
import pages.CheckoutPage;

public class TestLoja extends BaseTest {

    @Test
    public void testFluxoLoja() throws InterruptedException {
        LojaPage pageLoja = new LojaPage(driver);

        // Iniciar o teste
        driver.get("https://practice.automationtesting.in/");
        pageLoja.acessarPaginaShop();

        // Adicionar livro ao carrinho e proceder ao checkout
        pageLoja.adicionarLivroAoCarrinho();
        pageLoja.visualizarCarrinho();
        pageLoja.procederParaCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.preencherFormularioCheckout("Andrea", "Carvalho", "Rua da Esperança", "Salvador",
                "12345-678", "71987654321", "andrea@teste.com");

        checkoutPage.selecionarMetodoPagamento();
        //checkoutPage.submeterPedido();
    }
}
