package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/elon_musk.jpg"));
        $("#currentAddress").setValue("Boca Chica Village, Texas");
        $("#close-fixedban").click();
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-1").click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible).shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).shouldBe(exist);
        $(".table").$(byText("Elon Musk")).shouldBe(exist);
        $(".table").$(byText("Student Email")).shouldBe(exist);
        $(".table").$(byText("musk@tesla.com")).shouldBe(exist);
        $(".table").$(byText("Gender")).shouldBe(exist);
        $(".table").$(byText("Male")).shouldBe(exist);
        $(".table").$(byText("Mobile")).shouldBe(exist);
        $(".table").$(byText("7900000000")).shouldBe(exist);
        $(".table").$(byText("Date of Birth")).shouldBe(exist);
        $(".table").$(byText("28 June,1971")).shouldBe(exist);
        $(".table").$(byText("Subjects")).shouldBe(exist);
        $(".table").$(byText("Computer Science, Physics")).shouldBe(exist);
        $(".table").$(byText("Hobbies")).shouldBe(exist);
        $(".table").$(byText("Sports, Reading")).shouldBe(exist);
        $(".table").$(byText("Picture")).shouldBe(exist);
        $(".table").$(byText("elon_musk.jpg")).shouldBe(exist);
        $(".table").$(byText("Address")).shouldBe(exist);
        $(".table").$(byText("Boca Chica Village, Texas")).shouldBe(exist);
        $(".table").$(byText("State and City")).shouldBe(exist);
        $(".table").$(byText("Rajasthan Jaiselmer")).shouldBe(exist);
    }
}
