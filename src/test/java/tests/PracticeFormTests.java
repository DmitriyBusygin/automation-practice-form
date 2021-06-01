package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;
    }

    @Test
    void selenideSearchTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Dima");
        $("#lastName").setValue("Busygin");
        $("#userEmail").setValue("test@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("9171111111");
        // Filling Date Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1991");
        $("[aria-label='Choose Monday, March 18th, 1991']").click();
        // Ending Date Birth
        $("#subjectsInput").setValue("Co").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/testJPEG.jpeg"));
        $("#currentAddress").setValue("Russia, Kazan.");
        $("#react-select-3-input").setValue("Raja").pressEnter();
        $("#react-select-4-input").setValue("Jais").pressEnter();
        $("#submit").click();

        //Check data
        $(".table-responsive").shouldHave(text("Dima Busygin"), text("test@gmail.com"),
                text("Male"), text("9171111111"), text("18 March,1991"), text("Computer Science"),
                text("Sports, Reading"), text("testJPEG.jpeg"), text("Russia, Kazan."),
                text("Rajasthan Jaiselmer"));

    }
}
