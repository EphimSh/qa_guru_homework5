package selenide.git;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterprizeTest {


    @BeforeAll
    static void init(){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void giHubSolutionsDropdownHoverAndEnterprizePageTest(){
        open("https://github.com");

        //hover on Solutions and goto Enterprize
        $$(".header-menu-wrapper ul ")
                .findBy(text("Solutions")).hover()
                .$$("ul[aria-labelledby='solutions-for-heading']")
                .first().find("a").click();

        //assert that "GitHub for enterprises" is visible
        $(byTagAndText("h4", "GitHub for enterprises")).shouldBe(visible);
        //assert that "Build like the best" title is visible
        $(byTagAndText("h1", "Build like the best")).shouldBe(visible);
    }


}
