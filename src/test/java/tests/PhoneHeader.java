package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PhoneHeader {

    @BeforeAll
    public static void browserSize(){
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
        Configuration.baseUrl="https://pvz.kazanexpress.ru/";
        open("");
    }

    @Test
    @DisplayName("Логотип отображается")
    public void checkLogo(){
        $(".header__wrap .logo-mobile .icon-logo--mobile ").shouldBe(visible);
    }

    @Test
    @DisplayName("Кнопка заказать звонок ведет на форму создания заявки")
    public void checkCallButton(){
        $(".header__wrap .btn").shouldHave(attribute("href",baseUrl+"#order"));
    }

}
