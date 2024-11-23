package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    public void acessarPaginaShop() {
        driver.get("https://practice.automationtesting.in/shop/");
    }

    public void adicionarLivroAoCarrinho() {
        driver.get("https://practice.automationtesting.in/product/android-quick-start-guide/");
        WebElement addToBasketButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.single_add_to_cart_button")));
        addToBasketButton.click();
    }

    public void visualizarCarrinho() {
        driver.get("https://practice.automationtesting.in/basket/");
    }

    public void procederParaCheckout() {
        driver.get("https://practice.automationtesting.in/checkout/");

    }
}
