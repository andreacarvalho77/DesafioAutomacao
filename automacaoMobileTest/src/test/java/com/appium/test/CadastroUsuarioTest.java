package com.appium.test;

import com.appium.core.BaseTest;
import com.appium.page.CadastroUsuarioPage;
import com.appium.page.MenuPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CadastroUsuarioTest extends BaseTest  {
    MenuPage menu = new MenuPage();
    CadastroUsuarioPage cup = new CadastroUsuarioPage();

    @Test
    public void cadastrarNovousuario() {

        menu.selecionaSeuBarrigaHibrido();
        // Digitar o nome
        cup.nome(("andrea"));
        // Digitar email
        cup.email("andrea@teste.com");
        // Digitar Senha
        cup.senha("andreateste");
        // Botão Entrar
        cup.entrar();
        assertEquals("Bem vindo, andrea!", cup.verificaTextoBoasVindas());

    }
}

