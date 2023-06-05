package selenide.heroku;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragNDropTest {


    @BeforeAll
    static void init(){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void BlockAChangesReplacedByBlockBTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //drag and drop squares
        $("#column-a").dragAndDropTo("#column-b");
        //assert that they've changed their places
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));


    }
}
