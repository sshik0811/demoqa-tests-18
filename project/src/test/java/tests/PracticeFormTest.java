package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void regFormTest() {
        Configuration.holdBrowserOpen = true;
        String userName = "Sergey";

        registrationPage.openPage();
        registrationPage.setFirstName(userName);
        registrationPage.setLastName("Shikanov");
        registrationPage.setEmail("sshik@mail.ru");
        registrationPage.clickGender("Male");
        registrationPage.setNumber("9779571011");
        registrationPage.setBirthDay("13", "March", "1980");
        registrationPage.setSubject("Maths");
        registrationPage.setSubject("Biology");
        registrationPage.setHobbies("Sports");
        registrationPage.setPictures(new File("C:\\Users\\serg_\\Downloads\\AAVEUSDT_2024-12-03_07-49-26.png"));
        registrationPage.setAdress("Moscow");
        registrationPage.setState("Uttar Pradesh");
        registrationPage.setcity("Agra");
        registrationPage.clickSubmit();
        registrationPage.verifyResultsModal();
        registrationPage.verifyResults("Student Name", userName + " " + "Shikanov");
        registrationPage.verifyResults("Student Email", "sshik@mail.ru");
        registrationPage.verifyResults("Gender", "Male");
        registrationPage.verifyResults("Mobile", "9779571011");
        registrationPage.verifyResults("Date of Birth", "13" + " " + "March" + "," + "1980");
        registrationPage.verifyResults("Subjects", "Maths, Biology");
        registrationPage.verifyResults("Hobbies", "Sports");
        registrationPage.verifyResults("Address", "Moscow");
        registrationPage.verifyResults("State and City", "Uttar Pradesh" + " " + "Agra");

        registrationPage.closeModal();

    }
}
