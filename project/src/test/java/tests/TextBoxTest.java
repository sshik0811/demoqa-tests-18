package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.*;

public class TextBoxTest {

    //https://demoqa.com/text-box

    @BeforeAll
    public static void setup() {
        pageLoadTimeout = 60_000; // 60 секунд вместо стандартных 30
        timeout = 15_000; // Увеличьте общий таймаут
    }
    @Test
    void fillFormTest(){
        Configuration.holdBrowserOpen = true;

         open("https://demoqa.com/text-box");
         $("[id=userName]").setValue("Shikanov");
        $("[id=userEmail]").setValue("sshik@gmail.com");
        $("[id=currentAddress]").setValue("Moscow");
        $("[id=permanentAddress]").setValue("Novosib");
        $("[class='btn btn-primary']").click();
        $("[id=output]").shouldHave(text("Shikanov"),text("sshik@gmail.com"),text("Moscow"),text("Novosib"));

    }
}
