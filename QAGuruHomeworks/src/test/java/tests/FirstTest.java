package tests;

import org.junit.jupiter.api.Test;
import pages.FirstHomework;

public class FirstTest extends TestBase {

    FirstHomework firstHomework = new FirstHomework();

    @Test
    void firstTest(){

        firstHomework.openPage();
        firstHomework.fillNameFields();
        firstHomework.fillEmailField();
        firstHomework.chooseGender();
        firstHomework.fillMobileNumberField();
        firstHomework.calendar.chooseDateOfBirth("28", "June", "1971");
        firstHomework.chooseSubjects();
        firstHomework.chooseHobbies();
        firstHomework.uploadPicture();
        firstHomework.fillFullAddress();

        firstHomework.clickSubmitButton();

        firstHomework.checkResultTable();
    }
}
