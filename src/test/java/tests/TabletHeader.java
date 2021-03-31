package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TabletHeader{

    @BeforeAll
    public static void browserSize(){
        Configuration.browserSize="920x788";
        Configuration.baseUrl="https://pvz.kazanexpress.ru/";
        open("");
        String currentSize=String.valueOf(WebDriverRunner.getWebDriver().manage().window().getSize());
        String formattedCurrentSize=currentSize.substring(1,4)+"x"+currentSize.substring(6,9);
        assert(formattedCurrentSize.equals(browserSize));
    }

    @Test
    @DisplayName("Логотип отображается")
    public void checkLogo(){
        $(".header__wrap .logo-desktop .icon-logo").shouldBe(visible);
    }

    @Test
    @DisplayName("Номер телефона кликабелен")
    public void checkPhone(){
        $(".header__menu .phone").shouldHave(text("8 800 302-46-74")).shouldHave(attribute("href","tel:88003024674"));
    }

    @Test
    @DisplayName("Кнопка заказать звонок ведет на форму создания заявки")
    public void checkCallButton(){
        $(".header__wrap .btn").shouldHave(attribute("href",baseUrl+"#order"));
    }
}
