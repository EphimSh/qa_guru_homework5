package selenide.heroku;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragNDropTest {


    @BeforeAll
    static void init(){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void blockAShouldBeReplacedByBlockBTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement blockA = $("#column-a");
        SelenideElement blockB = $("#column-b");
        //drag and drop squares
        blockA.dragAndDropTo(blockB);
        //assert that they've changed their places
        blockA.shouldHave(text("B"));
        blockB.shouldHave(text("A"));

        //by actions() somehow it's not working
        actions().clickAndHold(blockA).moveToElement(blockB).release().perform();
        actions().dragAndDrop(blockA, blockB).perform();



    }
}
