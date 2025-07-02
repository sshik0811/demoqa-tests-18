import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @Test
    void selenideRepositorySearchTest() {
        Configuration.holdBrowserOpen = true;

        open("https://github.com/");

        $("span.flex-1").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("a[href='/selenide/selenide']").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));



    }
}
