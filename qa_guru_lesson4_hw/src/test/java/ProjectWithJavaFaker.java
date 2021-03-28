import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ProjectWithJavaFaker {

    PageObjects po = new PageObjects();

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1366x768";

    }

    @Test
    void selenideSearchTest() {
        // Открываем страницу
        po.openPage();

        // Заполняем форму
        po.fillForm();

        // Валидируем данные
        po.checkData();

    }
}