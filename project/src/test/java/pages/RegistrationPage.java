package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            clickGender = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            subjectInput = $("input#subjectsInput"),
            clickHobbies = $("#hobbiesWrapper"),
            picturesInput = $("#uploadPicture"),
            adressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            closeButton = $("#closeLargeModal");

    public void openPage() {

        open("https://demoqa.com/automation-practice-form");
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void setEmail(String value) {
        emailInput.setValue(value);
    }

    public void clickGender(String genter) {
        clickGender.$(byText(genter)).click();
    }

    public void setNumber(String value) {
        numberInput.setValue(value);
    }

    public void setBirthDay(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
    }

    public void setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
    }

    public void setHobbies(String hobbies) {
        clickHobbies.$(byText(hobbies)).click();
    }

    public void setPictures(File file) {
        picturesInput.uploadFile(file);
    }

    public void setAdress(String value) {
        adressInput.setValue(value);
    }

    public void setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
    }

    public void setcity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void verifyResultsModal() {
        registrationResultsModal.submittingForm();
    }

    public void verifyResults(String key, String value) {
        registrationResultsModal.formResults(key, value);
    }

    public void closeModal() {

        $("#closeLargeModal")
                .shouldBe(visible, enabled)
                .scrollIntoView("{block: 'center'}")
                .click();
    }
}

