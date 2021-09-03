package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized = true;
    }

    @Test
    void firstTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").shouldBe(visible).setValue("Elon");
        $("#lastName").shouldBe(visible).setValue("Musk");
        $("#userEmail").shouldBe(visible).setValue("musk@tesla.com");
        $(".custom-control-label").shouldBe(Condition.exist).click();
        $("#userNumber").shouldBe(visible).setValue("7900000000");
        $("#dateOfBirthInput").shouldBe(Condition.exist).click();
        $(".react-datepicker__month-select").selectOption(5);
        $(".react-datepicker__year-select").selectOption(71);
        $(".react-datepicker__day.react-datepicker__day--028").click();
        $("#subjectsInput").setValue("Science");
        $("#react-select-2-option-0").click();
        $("#subjectsInput").setValue("Physics");
        $("#react-select-2-option-0").click();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label").click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/elon_musk.jpg"));
        $("#currentAddress").setValue("Boca Chica Village, Texas");
        $("#close-fixedban").click();
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-1").click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible).shouldHave(text("Thanks for submitting the form"));
        $(".table > tbody > tr:nth-child(1) > td:nth-child(1)").shouldBe(exist).shouldHave(text("Student Name"));
        $(".table > tbody > tr:nth-child(1) > td:nth-child(2)").shouldBe(exist).shouldHave(text("Elon Musk"));
        $(".table > tbody > tr:nth-child(2) > td:nth-child(1)").shouldBe(exist).shouldHave(text("Student Email"));
        $(".table > tbody > tr:nth-child(2) > td:nth-child(2)").shouldBe(exist).shouldHave(text("musk@tesla.com"));
        $(".table > tbody > tr:nth-child(3) > td:nth-child(1)").shouldBe(exist).shouldHave(text("Gender"));
        $(".table > tbody > tr:nth-child(3) > td:nth-child(2)").shouldBe(exist).shouldHave(text("Male"));
        $(".table > tbody > tr:nth-child(4) > td:nth-child(1)").shouldBe(exist).shouldHave(text("Mobile"));
        $(".table > tbody > tr:nth-child(4) > td:nth-child(2)").shouldBe(exist).shouldHave(text("7900000000"));
        $(".table > tbody > tr:nth-child(5) > td:nth-child(1)").shouldBe(exist).shouldHave(text("Date of Birth"));
        $(".table > tbody > tr:nth-child(5) > td:nth-child(2)").shouldBe(exist).shouldHave(text("28 June,1971"));
        $(".table > tbody > tr:nth-child(6) > td:nth-child(1)").shouldBe(exist).shouldHave(text("Subjects"));
        $(".table > tbody > tr:nth-child(6) > td:nth-child(2)").shouldBe(exist).shouldHave(text("Science, Physics"));
        $(".table > tbody > tr:nth-child(7) > td:nth-child(1)").shouldBe(exist).shouldHave(text("Hobbies"));
        $(".table > tbody > tr:nth-child(7) > td:nth-child(2)").shouldBe(exist).shouldHave(text("Sports, Reading"));
        $(".table > tbody > tr:nth-child(8) > td:nth-child(1)").shouldBe(exist).shouldHave(text("Picture"));
        $(".table > tbody > tr:nth-child(8) > td:nth-child(2)").shouldBe(exist).shouldHave(text("elon_musk.jpg"));
        $(".table > tbody > tr:nth-child(9) > td:nth-child(1)").shouldBe(exist).shouldHave(text("Address"));
        $(".table > tbody > tr:nth-child(9) > td:nth-child(2)").shouldBe(exist).shouldHave(text("Boca Chica Village, Texas"));
        $(".table > tbody > tr:nth-child(10) > td:nth-child(1)").shouldBe(exist).shouldHave(text("State and City"));
        $(".table > tbody > tr:nth-child(10) > td:nth-child(2)").shouldBe(exist).shouldHave(text("Rajasthan Jaiselmer"));
    }
}
