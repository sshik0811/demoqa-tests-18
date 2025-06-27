import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @Test
    void regFormTest() {
        Configuration.holdBrowserOpen = true;

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Sergey");
        $("#lastName").setValue("Shikanov");
        $("#userEmail").setValue("sshik@mail.ru");
        $("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
        $("#userNumber").setValue("9779571011");
        $("#dateOfBirthInput").click();
        $("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--select > div.react-datepicker__month-dropdown-container.react-datepicker__month-dropdown-container--select > select > option:nth-child(6)").click();
        $("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--select > div.react-datepicker__year-dropdown-container.react-datepicker__year-dropdown-container--select > select > option:nth-child(63)").click();
        $$(".react-datepicker__day")
                .findBy(text("20")) // Ищем день с текстом "20"
                .shouldBe(visible, enabled) // Проверяем что он видимый и доступный
                .click();
        $("input#subjectsInput").setValue("Math").pressEnter();
        $("input#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
        $("#uploadPicture").uploadFile(new File("C:\\Users\\serg_\\Downloads\\AAVEUSDT_2024-12-03_07-49-26.png"));
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));











    }
}
