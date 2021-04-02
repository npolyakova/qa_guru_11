package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import config.DataConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FormTest {

    final DataConfig formData = ConfigFactory.create(DataConfig.class, System.getProperties());

    @BeforeAll
    public static void openPage(){
        Configuration.baseUrl="https://pvz.kazanexpress.ru/";
        open("");
    }

    @Test
    @DisplayName("Выделение поля при вводе невалидного e-mail")
    public void invalidEmail(){
        $("#email").clear();
        $("#email").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(196, 201, 212, 1)"));

        $("#email").setValue("a");
        $(".order__form").click();
        $("#email").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));

        $("#email").setValue("a@");
        $(".order__form").click();
        $("#email").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));

        $("#email").setValue("a@d");
        $(".order__form").click();
        $("#email").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));

        $("#email").setValue("a@d.");
        $(".order__form").click();
        $("#email").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));

        $("#email").setValue("a@d.e");
        $(".order__form").click();
        $("#email").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));

        $("#email").setValue("a@d.ef");
        $(".order__form").click();
        $("#email").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(196, 201, 212, 1)"));

    }

    @Test
    @DisplayName("Выделение поля при вводе невалидного телефона")
    public void invalidPhone(){
        $("#phone").clear();
        $("#phone").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(196, 201, 212, 1)"));

        $("#phone").setValue("7");
        $(".order__form").click();
        $("#phone").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));

        $("#phone").setValue("8");
        $(".order__form").click();
        $("#phone").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));

        $("#phone").setValue("11111111");
        $(".order__form").click();
        $("#phone").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));

        $("#phone").setValue("1111111111");
        $(".order__form").click();
        $("#phone").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(196, 201, 212, 1)"));

    }

    @Test
    @DisplayName("Валидация пустых полей")
    public void emptyFieldsValidation(){
        $("#fio").clear();
        $("#fio").setValue(" ");
        $("#fio").clear();
        $(".order__form").click();
        $("#fio").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));

        $("#phone").clear();
        $("#phone").setValue(" ");
        $("#phone").clear();
        $(".order__form").click();
        $("#phone").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));

        $("#email").clear();
        $("#email").setValue(" ");
        $("#email").clear();
        $(".order__form").click();
        $("#email").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));

        $("#city").clear();
        $("#city").setValue(" ");
        $("#city").clear();
        $(".order__form").click();
        $("#city").shouldHave(Condition.cssValue("border-bottom-color" , "rgba(239, 79, 76, 1)"));
    }

    @Test
    @DisplayName("Отправка формы с пустыми полями")
    public void checkEmptyFields(){
        $("#fio").clear();
        $("#email").clear();
        $("#phone").clear();
        $("#city").clear();
        $(".order__form .btn").click();
        String alert = getWebDriver().switchTo()
                .alert().getText();
        assert(alert==null);
    }

    @Test
    @DisplayName("Отправка формы с заполненными полями")
    public void checkCorrectFields(){
        $("#fio").setValue(formData.fio());
        $("#email").setValue(formData.email());
        $("#phone").setValue(formData.phone());
        $("#city").setValue(formData.city());
        $(".order__form .btn").click();
        String alert = getWebDriver().switchTo()
                .alert().getText();
        assert(alert!=null);
    }
    }

