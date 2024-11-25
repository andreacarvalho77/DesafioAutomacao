package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LojaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LojaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Step("Acessando a página da loja (Shop)")
    public void acessarPaginaShop() {
        driver.get("https://practice.automationtesting.in/shop/");
        Allure.step("Página Shop acessada com sucesso.");
    }

    @Step("Adicionando o livro ao carrinho")
    public void adicionarLivroAoCarrinho() {
        driver.get("https://practice.automationtesting.in/product/android-quick-start-guide/");
        WebElement addToBasketButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.single_add_to_cart_button")
        ));
        addToBasketButton.click();
        Allure.step("Livro adicionado ao carrinho com sucesso.");
    }

    @Step("Visualizando o carrinho")
    public void visualizarCarrinho() {
        driver.get("https://practice.automationtesting.in/basket/");
        Allure.step("Carrinho visualizado com sucesso.");
    }

    @Step("Procedendo para o checkout")
    public void procederParaCheckout() {
        driver.get("https://practice.automationtesting.in/checkout/");
        Allure.step("Página de checkout acessada com sucesso.");
    }
}
