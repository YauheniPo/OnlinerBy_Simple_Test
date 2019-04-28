package popo.hiqos.app.pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import popo.hiqos.framework.base.WebPage;
import popo.hiqos.framework.helpers.Locators;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class TopActions extends WebPage {

    private final SelenideElement
            searchInput = $(Locators.get("topActions.search")).waitUntil(Condition.exist, 4000);

    public SearchPage search(String text) {
        log.info(String.format("Set value '%s' to SEARCH input field", text));
        searchInput.setValue(text);
        return new SearchPage();
    }
}
