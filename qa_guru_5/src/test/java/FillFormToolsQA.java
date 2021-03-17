import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.xml.xpath.XPath;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class FillFormToolsQA {

    @Test
    void selenideSearchTest() {
        open("https://demoqa.com/automation-practice-form");

        $(By.xpath("//input[@id='firstName']")).waitUntil(visible, 20000).setValue("Автотест");
        $(By.xpath("//input[@id='lastName']")).shouldBe(visible).setValue("Селенидов");
        $(By.xpath("//input[@id='userEmail']")).shouldBe(visible).setValue("Stable@autotests.com");
        $(By.xpath("//label[contains(text(),'Other')]")).shouldBe(visible).click();
        $(By.xpath("//input[@id='userNumber']")).shouldBe(visible).setValue("1234567890");
        $(By.xpath("//input[@id='dateOfBirthInput']")).click();
        $(By.xpath("//select[@class='react-datepicker__month-select']")).selectOption("June");
        $(By.xpath("//select[@class='react-datepicker__year-select']")).selectOption("1969");
        $(By.xpath("//div[@aria-label='Choose Tuesday, June 10th, 1969']")).click();
        $(By.xpath("//input[@id='subjectsInput']")).setValue("math").pressEnter();
        $(By.xpath("//label[contains(text(),'Sports')]")).click();
        $(By.xpath("//input[@id='uploadPicture']")).scrollTo().uploadFile(new File("src/test/files/Test.jpg"));
        $(By.xpath("//textarea[@id='currentAddress']")).setValue("Kazakhstan, Almaty, Autotester str.");
        $(By.xpath("//input[@id='react-select-3-input']")).setValue("Haryana").pressEnter();
        $(By.xpath("//input[@id='react-select-4-input']")).shouldBe(enabled).setValue("Karnal").pressEnter();
        $(By.xpath("//button[@id='submit']")).click();
        $(By.xpath("//div[@class=\"table-responsive\"]")).shouldHave(text("Автотест"), text("Селенидов"), text("Stable@autotests.com"));
    }
}
