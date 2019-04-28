package popo.hiqos.app.pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import popo.hiqos.app.pages.ProductPage;
import popo.hiqos.framework.base.WebPage;
import popo.hiqos.framework.helpers.Locators;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage extends WebPage {

    private final SelenideElement
            searchPage = $(Locators.get("topActions.searchIFrame")).shouldBe(Condition.visible);

    public SearchPage() {
        switchTo().frame(searchPage);
    }

    public int getVisibleResultsCount() {
        return $$(By.tagName("li")).size();
    }

    public ProductPage clickToFirstResultOffer() {
        $$(By.tagName("li")).first().$(By.tagName("a")).click();
        return new ProductPage();
    }
}
