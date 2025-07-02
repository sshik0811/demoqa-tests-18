import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void bestContributorToSelenideTest() {

        Configuration.holdBrowserOpen = true;

        open("https://github.com/selenide/selenide");
        $("div.Layout-sidebar").$(Selectors.byText("Contributors")).closest("h2").sibling(0).$$("li").first().hover();
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }
}
