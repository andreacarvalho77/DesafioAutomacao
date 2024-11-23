package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores para os campos do formulário de checkout
    private By firstNameField = By.id("billing_first_name");
    private By lastNameField = By.id("billing_last_name");
    private By addressField = By.id("billing_address_1");
    private By cityField = By.id("billing_city");
    private By postcodeField = By.id("billing_postcode");
    private By phoneField = By.id("billing_phone");
    private By emailField = By.id("billing_email");
    private By paymentMethod = By.id("payment_method_cod");
    private By placeOrderButton = By.id("place_order");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void preencherFormularioCheckout(String firstName, String lastName, String address, String city,
                                            String postcode, String phone, String email) {
        // Preencher campos de nome e sobrenome
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        lastNameInput.sendKeys(lastName);

        // Preencher endereço
        WebElement addressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(addressField));
        addressInput.sendKeys(address);

        // Preencher cidade e código postal
        WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(cityField));
        cityInput.sendKeys(city);

        WebElement postcodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(postcodeField));
        postcodeInput.sendKeys(postcode);

        // Preencher telefone e email
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField));
        phoneInput.sendKeys(phone);

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.sendKeys(email);
    }

    // Selecionar método de pagamento
    public void selecionarMetodoPagamento() {
        WebElement paymentMethodOption = wait.until(ExpectedConditions.elementToBeClickable(paymentMethod));
        paymentMethodOption.click();
    }

    // Submeter o pedido
    public void submeterPedido() {
        WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderBtn.click();
    }
}

