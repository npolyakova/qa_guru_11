package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DesktopHeader extends TestBase {

    @Test
    @DisplayName("Логотип отображается")
    public void checkLogo(){
        $(".header__wrap .logo-desktop .icon-logo").shouldBe(visible);
    }

    @Test
    @DisplayName("Вкладки ведут на соответствующие названиям разделы на странице")
    public void checkTabs(){
        $(".header__menu").$(byText("О компании")).shouldHave(attribute("href","#about"));
        $(".header__menu").$(byText("Доход")).shouldHave(attribute("href","#income"));
        $(".header__menu").$(byText("Кому выгодно")).shouldHave(attribute("href","#who-benefits"));
    }

    @Test
    @DisplayName("Номер телефона кликабелен")
    public void checkPhone(){
        $(".header__menu .phone").shouldHave(text("88003024674")).shouldHave(attribute("href","tel:88003024674"));
    }

    @Test
    @DisplayName("Кнопка заказать звонок ведет на форму создания заявки")
    public void checkCallButton(){
        $(".header__wrap .btn").shouldHave(attribute("href","#order"));
    }
}
