package pages;

import components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {

    public void setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    public void setLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void setEmail(String email) {
        $("#userEmail").setValue(email);
    }

    public void setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }

    public void setMobile(String mobile) {
        $("#userNumber").setValue(mobile);
    }

    public void setDate(String day, String month, String year) {
        new CalendarComponent().setDate(day, month, year);
    }

    public void setSubjects(String[] subjects) {
        for (String subject : subjects) {
            $("#subjectsInput").setValue(subject).pressEnter();
        }
    }

    public void setHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            $("#hobbiesWrapper").$(byText(hobby)).click();
        }
    }

    public void uploadPicture(String patch) {
        $("#uploadPicture").uploadFile(new File(patch));
    }

    public void setCurrentAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    public void setState(String state) {
        // на сайте появилась реклама, теперь заполнение идет по другому
        // $("#state").click();
        // $("#state").setValue(state).pressEnter();
        $("#react-select-3-input").setValue(state).pressEnter();

    }

    public void setCity(String city) {
        // на сайте появилась реклама, теперь заполнение идет по другому
        // $("#city").click();
        // $("#city").setValue(city).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
    }

    public void clickSubmit() {
        $("#submit").click();
    }

    public void checkDataInTable(String firstName, String lastName, String email, String gender,
                                 String mobile, String day, String month, String year,
                                 String[] subjects, String[] hobbies, String namePicture,
                                 String address, String state, String city) {
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(day + " " + month + "," + year));
        for (String subject : subjects) {
            $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
        }
        for (String hobby : hobbies) {
            $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
        }
        $x("//td[text()='Picture']").parent().shouldHave(text(namePicture));
        $x("//td[text()='Address']").parent().shouldHave(text(address));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }
}