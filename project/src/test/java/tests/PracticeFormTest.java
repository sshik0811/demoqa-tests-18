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
import static tests.TestData.*;
import static utils.RandomUtils.*;

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
                gender = getRandomItemFromArray(genders),
                phoneNumber = faker.phoneNumber().subscriberNumber(10),
                userSubjects = getRandomValue(subjects),
                userHobby = getRandomValue(hobby),
                userState = getRandomValue(state),
                userCity = getRandomCity(userState);



        registrationPage.openPage();
        registrationPage.setFirstName(userName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(userEmail);
        registrationPage.clickGender(gender);
        registrationPage.setNumber(phoneNumber);
        registrationPage.setBirthDay("13", "March", "1980");
        registrationPage.setSubject(userSubjects);
        registrationPage.setHobbies(userHobby);
        registrationPage.setPictures(new File("C:\\Users\\serg_\\Downloads\\AAVEUSDT_2024-12-03_07-49-26.png"));
        registrationPage.setAddress(currentAddress);
        registrationPage.setState(userState);
        registrationPage.setCity(userCity);
        registrationPage.clickSubmit();
        registrationPage.verifyResultsModal();
        registrationPage.verifyResults("Student Name", userName + " " + lastName);
        registrationPage.verifyResults("Student Email", userEmail);
        registrationPage.verifyResults("Gender", gender);
        registrationPage.verifyResults("Mobile", phoneNumber);
        registrationPage.verifyResults("Date of Birth", "13" + " " + "March" + "," + "1980");
        registrationPage.verifyResults("Subjects", userSubjects);
        registrationPage.verifyResults("Hobbies", userHobby);
        registrationPage.verifyResults("Address", currentAddress);
        registrationPage.verifyResults("State and City", userState + " " + userCity);

        registrationPage.closeModal();

    }
}
