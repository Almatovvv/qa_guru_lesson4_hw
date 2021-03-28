import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.xml.xpath.XPath;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubProjectWiki {

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1366x768";
    }

    @Test
    void githubSearchTest() {
        open("https://github.com/");

        $("[name=q]").setValue("selenide").pressEnter();
        $("[href='/selenide/selenide']").click();
        $(byText("Wiki")).click();
        $(byText("SoftAssertions")).click();

        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
