
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
public class SelenideGithub {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Поиск примера кода JUnit 5")
    void jUnitCodeExampleSearch(){
        open("https://github.com/");
        // - Откройте страницу Selenide в Github
        $("[data-test-selector='nav-search-input']").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        // - Перейдите в раздел Wiki проекта
        $("[id=wiki-tab]").click();
        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".markdown-body").shouldHave(text("Soft assertions"));
        $(byLinkText("Soft assertions")).click();
        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }

}
