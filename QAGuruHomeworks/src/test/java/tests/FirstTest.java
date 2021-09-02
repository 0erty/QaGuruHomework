package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
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
        $("#firstName").shouldBe(Condition.visible).setValue("Elon");
        $("#lastName").shouldBe(Condition.visible).setValue("Musk");
        $("#userEmail").shouldBe(Condition.visible).setValue("musk@tesla.com");
        $(".custom-control-label").shouldBe(Condition.exist).click();
        $("#userNumber").shouldBe(Condition.visible).setValue("79000000000");
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
    }
}
