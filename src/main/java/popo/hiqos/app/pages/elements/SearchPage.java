package popo.hiqos.app.pages.elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import popo.hiqos.app.pages.ProductPage;
import popo.hiqos.framework.base.WebPage;
import popo.hiqos.framework.helpers.Locators;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class SearchPage extends WebPage {

    private final SelenideElement
            searchPageIFrame = $(Locators.get("topActions.searchIFrame")).shouldBe(Condition.visible),
            searchPage = $(Locators.get("topActions.searchPage"));

    public SearchPage() {
        switchTo().frame(searchPageIFrame);
    }

    @Step
    public int getVisibleResultsCount(String containedText) {
        return searchPage.$$(By.tagName("li"))
                .shouldBe(CollectionCondition.sizeGreaterThan(0), 4000)
                .filter(Condition.text(containedText))
                .size();
    }

    @Step
    public ProductPage clickToFirstResultOffer(String containedText) {
        searchPage.$$(By.tagName("li"))
                .shouldBe(CollectionCondition.sizeGreaterThan(0), 4000)
                .first()
                .shouldHave(Condition.text(containedText))
                .$(By.tagName("a"))
                .click();
        return new ProductPage();
    }
}
