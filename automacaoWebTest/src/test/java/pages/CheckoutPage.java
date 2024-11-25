package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Step("Preenchendo o formulário de checkout")
    public void preencherFormularioCheckout(String nome, String sobrenome, String endereco,
                                            String cidade, String cep, String telefone,
                                            String email) {
        Allure.step("Preenchendo informações do cliente");
        driver.findElement(By.id("billing_first_name")).sendKeys(nome);
        driver.findElement(By.id("billing_last_name")).sendKeys(sobrenome);
        driver.findElement(By.id("billing_address_1")).sendKeys(endereco);
        driver.findElement(By.id("billing_city")).sendKeys(cidade);
        driver.findElement(By.id("billing_postcode")).sendKeys(cep);
        driver.findElement(By.id("billing_phone")).sendKeys(telefone);
        driver.findElement(By.id("billing_email")).sendKeys(email);
    }

    @Step("Selecionando o método de pagamento")
    public void selecionarMetodoPagamento() {
        WebElement metodoPagamento = driver.findElement(By.cssSelector("input#payment_method_cod"));
        metodoPagamento.click();
        Allure.step("Método de pagamento selecionado com sucesso.");
    }

    @Step("Selecionando o método para submeter Pedido")
    public void submeterPedido() {
        WebElement placeOrderBtn = driver.findElement(By.cssSelector("placeOrderButton"));
        placeOrderBtn.click();
        Allure.step("Método submeter pedido com sucesso.");
    }
}
