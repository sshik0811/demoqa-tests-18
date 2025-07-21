package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.getRandomItemFromArray;

public class PracticeFormTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void regFormTest() {
        Faker faker = new Faker();
        Configuration.holdBrowserOpen = true;
        String[] genders = {"Male", "Female", "Other"};


        String userName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                currentAddress = faker.address().fullAddress(),
                gender = getRandomItemFromArray(genders);

        registrationPage.openPage();
        registrationPage.setFirstName(userName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(userEmail);
        registrationPage.clickGender(gender);
        registrationPage.setNumber("9779571011");
        registrationPage.setBirthDay("13", "March", "1980");
        registrationPage.setSubject("Maths");
        registrationPage.setSubject("Biology");
        registrationPage.setHobbies("Sports");
        registrationPage.setPictures(new File("C:\\Users\\serg_\\Downloads\\AAVEUSDT_2024-12-03_07-49-26.png"));
        registrationPage.setAdress(currentAddress);
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
