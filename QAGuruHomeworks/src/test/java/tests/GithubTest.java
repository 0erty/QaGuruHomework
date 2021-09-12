import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized = true;
    }

    @Test
    void githubTest() {
        open("https://github.com/");

        $("[data-test-selector=nav-search-input]").shouldBe(visible).setValue("selenide").pressEnter();
        $("[href='/selenide/selenide']").shouldBe(exist).click();
        $("#wiki-tab").shouldBe(visible).click();
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $("[start='3']").shouldHave(text("Using JUnit5 extend test class"));
    }
}
