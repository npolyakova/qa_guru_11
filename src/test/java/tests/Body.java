package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class Body extends TestBase{

    @BeforeAll
    public static void openPage(){
        Configuration.baseUrl="https://pvz.kazanexpress.ru/";
        open("");
    }

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

    @Test
    @DisplayName("Слайдер работает корректно")
    public void slider(){
        $(".design").scrollIntoView(true);
        $(".slick-track [aria-hidden=false]").shouldHave(Condition.attribute("data-slick-index", String.valueOf(0)));
        $(".design__arrow.next").click();
        $(".slick-track [aria-hidden=false]").shouldHave(Condition.attribute("data-slick-index", String.valueOf(1)));
        $(".design__arrow.prev").click();
        $(".slick-track [aria-hidden=false]").shouldHave(Condition.attribute("data-slick-index", String.valueOf(0)));
    }

    @Test
    @DisplayName("Чат появляется при прокрутке страницы")
    public void chatIsVisibleAndClickable() {
        $(".hero__info").scrollIntoView(true);
        $(".ko-container").shouldHave(attribute("ko-show-later", "0.5"));
        $("#about").scrollIntoView(true);
        sleep(1000);
        $(".ko-container").shouldHave(attribute("ko-show-later", "0"));
        $(".ko-container").click();
        $(".ko-container.ko-turn").shouldBe(visible);
    }
}
