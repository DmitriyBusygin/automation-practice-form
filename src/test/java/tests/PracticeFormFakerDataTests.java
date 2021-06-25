package tests;

import configuration.Configurator;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class PracticeFormFakerDataTests extends Configurator {

    RegistrationPage regPage = new RegistrationPage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobile = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth = "18",
            monthOfBirth = "March",
            yearOfBirth = "1991",
            patchPicture = "src/test/resources/img",
            namePicture = "testJPEG.jpeg",
            currentAddress = faker.address().toString(),
            state = "Rajasthan",
            city = "Jaiselmer";
    String[] subjects = {"Computer Science", "Biology"},
            hobbies = {"Sports", "Reading"};

    @Test
    void registrationFakerTest() {
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