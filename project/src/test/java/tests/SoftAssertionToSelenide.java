package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionToSelenide {
    @Test
    void softAssertionTest() {

        Configuration.holdBrowserOpen = true;
        open("https://github.com/selenide/selenide/wiki");
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box > div > div.js-wiki-sidebar-toggle-display > ul > li:nth-child(18) > details > summary > div > span > a").click();
        $("#wiki-body > div.markdown-body").shouldHave(text(" Using JUnit5 extend test class:"));
    }
}
