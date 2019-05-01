package popo.hiqos.app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import popo.hiqos.framework.helpers.Locators;

import static com.codeborne.selenide.Selenide.$;
import static popo.hiqos.app.Constants.DOUBLE_NUMBERS_REG_EXP;

public class ProductPage extends BaseOnlinerWebPage {

    private final SelenideElement header = $(Locators.get("productPage.header")).shouldBe(Condition.visible);
    private final SelenideElement offerDescription = $(Locators.get("productPage.offer"));

    public double getArithmeticOfferPrice() {
        String offerPrices = offerDescription.$(Locators.get("productPage.offer.price")).getText();
        String offerPricesReplacing = offerPrices
                .replaceAll(DOUBLE_NUMBERS_REG_EXP, " ")
                .replaceAll(",", ".");
        String[] prices = offerPricesReplacing.split(" ");
        return (Double.parseDouble(prices[0]) + Double.parseDouble(prices[1])) / 2;
    }
}
