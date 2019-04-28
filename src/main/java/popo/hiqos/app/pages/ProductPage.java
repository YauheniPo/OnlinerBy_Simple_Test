package popo.hiqos.app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import popo.hiqos.framework.helpers.Locators;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends BaseOnlinerWebPage {

    private final SelenideElement header = $(Locators.get("productPage.header")).waitUntil(Condition.visible, 4000);
    private final SelenideElement offerDescription = $(Locators.get("productPage.offer"));

    public int getArithmeticOfferPrice() {
        String offerPrices = offerDescription.$(By.xpath("//*[contains(@class, 'price')]")).getText();
        String offerPricesReplacing = offerPrices.replaceAll("", "").replaceAll(",", ".");
        return Integer.parseInt(offerPrices.replaceAll("", ""));
    }
}
