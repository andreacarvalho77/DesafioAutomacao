package com.appium.page;

import com.appium.core.BasePage;
import org.openqa.selenium.By;

public class CadastroUsuarioPage extends BasePage{

    public void nome(String nome) {
        waitForPresenceOfElement("//*[@resource-id='nome']");
        inputTextXpathResourceId("email", nome);
    }

    public void email(String email) {
        waitForPresenceOfElement("//*[@resource-id='email']");
        inputTextXpathResourceId("email", email);
    }

    public void senha(String senha) {
        waitForPresenceOfElement("//*[@resource-id='senha']");
        inputTextXpathResourceId("senha", senha);
    }

    public void entrar() {
        click(By.xpath("//*[@text='Entrar']"));
        implicitWaitInMilisec(500);
    }

    public String verificaTextoBoasVindas() {
        String txt = "Bem vindo, andrea!";
        waitForPresenceOfElement("//*[@text='" + txt + "']");
        return getTextByAttribute(txt);
    }

}

