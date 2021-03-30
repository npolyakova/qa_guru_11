package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Footer extends TestBase{

    @Test
    @DisplayName("Логотип отображается")
    public void checkLogo(){
        $(".footer").scrollIntoView(true);
        $(".footer .footer__logo .logo-desktop .icon").shouldBe(visible);
    }

    @Test
    @DisplayName("Блок 'Остались вопросы' отображается корректно")
    public void checkQuestionsDiv(){
        $(".footer__questions .footer__title").shouldHave(text("Остались вопросы?"));
        $(".footer__questions .footer__link").shouldHave(attribute("href","https://t.me/pvz_kazanexpress"));
    }

    @Test
    @DisplayName("Блок контактов отображается корректно")
    public void checkContacts(){
        $(".footer__phone .footer__title").shouldHave(text("8 800 302-46-74")).shouldHave(attribute("href","tel:88003024674"));
        $(".footer__phone").$(byText("Служба поддержки KazanExpress Business")).shouldBe(visible);
    }

}
