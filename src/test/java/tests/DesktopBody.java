package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DesktopBody extends TestBase{

    @Test
    @DisplayName("Блок открытия ПВЗ")
    public void checkPvzDiv(){
        $(".hero").scrollIntoView(true);
        $(".hero__title").shouldBe(visible);
        $(".hero__text").shouldBe(visible);
        $(".hero__img").shouldBe(visible);
        $(".hero__message").shouldBe(visible);
        $(".hero__info a").shouldHave(attribute("href","https://pvz.kazanexpress.ru/#order"));
    }

    @Test
    @DisplayName("Блок 'О компании в цифрах'")
    public void checkAboutCompanyDiv(){
        $("#about").scrollIntoView(true);
        $(".about__title").shouldBe(visible);
        $(".about__advantages").shouldBe(visible);
        $(".about__youtube").shouldHave(attribute("href","https://youtu.be/Hom-c6MRLUk"));
    }

    @Test
    @DisplayName("Блок 'Преимущества'")
    public void checkOffersDiv(){
        $("#income").scrollIntoView(true);
        $(".offers__title").shouldBe(visible);
        $(".offers__list").shouldBe(visible);
        $("#income .btn").shouldHave(attribute("href","https://pvz.kazanexpress.ru/#order"));
    }

    @Test
    @DisplayName("Блок 'Кому это выгодно'")
    public void checkBenefitsDiv(){
        $("#who-benefits").scrollIntoView(true);
        $(".benefits__title").shouldBe(visible);
        $(".benefits__list").shouldBe(visible);
        $(".benefits__info .phone").shouldHave(attribute("href","tel:88003024674"));
    }

    @Test
    @DisplayName("Блок 'Требования к помещению'")
    public void checkRequirementsDiv(){
        $(".requirements").scrollIntoView(true);
        $(".requirements__title").shouldBe(visible);
        $(".requirements__img").shouldBe(visible);
    }

    @Test
    @DisplayName("Блок с формой заявки")
    public void checkOrderDiv(){
        $("#order").scrollIntoView(true);
        $(".order__title").shouldBe(visible);
        $(".order__form").shouldBe(visible);
        $(".order__policy a").shouldHave(attribute("href","https://legal.kazanexpress.ru/"));
    }

    @Test
    @DisplayName("Блок 'Оформление ПВЗ'")
    public void checkPvzDesignDiv(){
        $(".design").scrollIntoView(true);
        $(".design__title").shouldBe(visible);
        $(".design__slider").shouldBe(visible);
    }
}
