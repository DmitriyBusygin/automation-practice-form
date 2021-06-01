package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPageObjectTests extends Configurator {

    RegistrationPage regPage = new RegistrationPage();

    String firstName = "Dima",
            lastName = "Busygin",
            email = "dima@mail.ru",
            gender = "Male",
            mobile = "9171111111",
            dayOfBirth = "18",
            monthOfBirth = "March",
            yearOfBirth = "1991",
            patchPicture = "src/test/resources/",
            namePicture = "testJPEG.jpeg",
            currentAddress = "Russia, Kazan.",
            state = "Rajasthan",
            city = "Jaiselmer";
    String[] subjects = {"Computer Science", "Biology"},
            hobbies = {"Sports", "Reading"};

    @Test
    void registrationTest() {
        open("https://demoqa.com/automation-practice-form");
        regPage.setFirstName(firstName);
        regPage.setLastName(lastName);
        regPage.setEmail(email);
        regPage.setGender(gender);
        regPage.setMobile(mobile);
        regPage.setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        regPage.setSubjects(subjects);
        regPage.setHobbies(hobbies);
        regPage.uploadPicture(patchPicture + namePicture);
        regPage.setCurrentAddress(currentAddress);
        regPage.setState(state);
        regPage.setCity(city);
        regPage.clickSubmit();
        regPage.checkDataInTable(firstName, lastName, email, gender, mobile,
                dayOfBirth, monthOfBirth, yearOfBirth, subjects, hobbies,
                namePicture, currentAddress, state, city);
    }
}