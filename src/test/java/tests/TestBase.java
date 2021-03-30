package tests;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    public static void openPage(){
        open("https://pvz.kazanexpress.ru/");
    }

}
