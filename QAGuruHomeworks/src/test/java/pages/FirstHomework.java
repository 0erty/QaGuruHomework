package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;
import static utils.RandomUtils.getRandomPhone;
import static utils.RandomUtils.getRandomSubject;

public class FirstHomework {

    public CalendarComponent calendar = new CalendarComponent();
    Faker faker = new Faker();

    private SelenideElement formTitle = $("h5"),
                            firstNameField = $("#firstName"),
                            lastNameFiled = $("#lastName"),
                            emailField = $("#userEmail"),
                            maleGenderRadioButton = $(".custom-control-label"),
                            mobileNumberField = $("#userNumber"),
                            subjectsField = $("#subjectsInput"),
                            firstSubjectResult = $("#react-select-2-option-0"),
                            hobbiesCheckbox = $("#hobbiesWrapper"),
                            fileForm = $("#uploadPicture"),
                            addressField = $("#currentAddress"),
                            closeAdButton = $("#close-fixedban"),
                            stateDropdown = $("#state"),
                            cityDropdown = $("#city"),
                            secondStateOption = $("#react-select-3-option-3"),
                            firstCityOption = $("#react-select-4-option-1"),
                            submitButton = $("#submit"),
                            resultTable = $ (".table"),
                            resultTableTitle = $("#example-modal-sizes-title-lg");
    private final String firstName = faker.name().firstName(),
                         lastName = faker.name().lastName(),
                         email = faker.internet().emailAddress(),
                         phoneNumber = getRandomPhone(),
                         address = faker.address().fullAddress(),
                         subject = getRandomSubject();

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
         formTitle.shouldHave(text(pageTitle));
    }

    public void fillNameFields() {
        firstNameField.setValue(firstName);
        lastNameFiled.setValue(lastName);
    }

    public void fillEmailField() {
        emailField.setValue(email);
    }

    public void chooseGender() {
        maleGenderRadioButton.shouldBe(Condition.exist).click();
    }

    public void fillMobileNumberField() {
        mobileNumberField.shouldBe(visible).setValue(phoneNumber);
    }

    public void chooseSubjects() {
        subjectsField.setValue(subject);
        firstSubjectResult.click();
    }

    public void chooseHobbies() {
        hobbiesCheckbox.$(byText("Sports")).click();
        hobbiesCheckbox.$(byText("Reading")).click();
    }

    public void uploadPicture() {
        fileForm.uploadFile(new File("src/test/java/resources/elon_musk.jpg"));
    }
    
    public void fillFullAddress() {
        addressField.setValue(address);
        closeAdButton.click();
        stateDropdown.click();
        secondStateOption.click();
        cityDropdown.click();
        firstCityOption.click();
    }
    
    public void clickSubmitButton() {
        submitButton.click();
    }
    
    public void checkResultTable() {
        resultTableTitle.shouldBe(visible).shouldHave(text(thanksTableMessage));
        resultTable.$(byText(fullNameLineTitle)).shouldBe(exist);
        resultTable.$(byText(firstName + " " + lastName)).shouldBe(exist);
        resultTable.$(byText(emailLineTitle)).shouldBe(exist);
        resultTable.$(byText(email)).shouldBe(exist);
        resultTable.$(byText(genderLineTitle)).shouldBe(exist);
        resultTable.$(byText(genderValue)).shouldBe(exist);
        resultTable.$(byText(mobileLineTitle)).shouldBe(exist);
        resultTable.$(byText(phoneNumber)).shouldBe(exist);
        resultTable.$(byText(dateOfBirthLineTitle)).shouldBe(exist);
        resultTable.$(byText("28 June,1971")).shouldBe(exist);
        resultTable.$(byText(subjectLineTitle)).shouldBe(exist);
        resultTable.$(byText(subject)).shouldBe(exist);
        resultTable.$(byText(hobbiesLineTitle)).shouldBe(exist);
        resultTable.$(byText("Sports, Reading")).shouldBe(exist);
        resultTable.$(byText(pictureLineTitle)).shouldBe(exist);
        resultTable.$(byText("elon_musk.jpg")).shouldBe(exist);
        resultTable.$(byText(addressLineTitle)).shouldBe(exist);
        resultTable.$(byText(address)).shouldBe(exist);
        resultTable.$(byText(stateAndCityLimeTitle)).shouldBe(exist);
        resultTable.$(byText("Rajasthan Jaiselmer")).shouldBe(exist);
    }
}
