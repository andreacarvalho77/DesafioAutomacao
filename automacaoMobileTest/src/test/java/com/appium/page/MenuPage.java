package com.appium.page;

import com.appium.core.BasePage;
public class MenuPage extends BasePage {
    public void selecionaSeuBarrigaHibrido() {
        clickByText("SeuBarriga Híbrido");
        implicitWaitInMilisec(500);
    }
}
