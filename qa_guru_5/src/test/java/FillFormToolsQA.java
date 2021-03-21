import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.xml.xpath.XPath;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class FillFormToolsQA {

    String firstName = "Автотест";
    String lastName = "Селенидов";
    String userEmail = "Stable@autotests.com";
    String userNumber = "1234567890";
    String monthSelect = "June";
    String yearSelect = "1969";
    String subjectsInput = "Maths";
    String currentAddress = "Kazakhstan, Almaty, Autotester str.";
    String userState = "Haryana";
    String userCity = "Karnal";

    @Test
    void selenideSearchTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").shouldBe(visible).setValue(lastName);
        $("#userEmail").shouldBe(visible).setValue(userEmail);
        $x("//label[contains(text(),'Other')]").shouldBe(visible).click();
        $("#userNumber").shouldBe(visible).setValue(userNumber);
        $("#dateOfBirthInput").click();
        $x("//select[@class='react-datepicker__month-select']").selectOption(monthSelect);
        $x("//select[@class='react-datepicker__year-select']").selectOption(yearSelect);
        $x("//div[@aria-label='Choose Tuesday, June 10th, 1969']").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $x("//label[contains(text(),'Sports')]").click();
        $("#uploadPicture").scrollTo().uploadFile(new File("src/test/resources/Test.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(userState).pressEnter();
        $("#react-select-4-input").setValue(userCity).pressEnter();
        $("#submit").click();
        $(By.xpath("//div[@class=\"table-responsive\"]")).shouldHave(
                text(firstName + " " +lastName),
                text(userEmail),
                text("Other"),
                text(userNumber),
                text("10 June,1969"),
                text(subjectsInput),
                text("Sports"),
                text("Test.jpg"),
                text(currentAddress),
                text(userState + " " + userCity));
    }
}
