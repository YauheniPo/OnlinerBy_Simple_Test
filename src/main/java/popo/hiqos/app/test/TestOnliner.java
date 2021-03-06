package popo.hiqos.app.test;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import popo.hiqos.app.TestGroup;
import popo.hiqos.app.pages.OnlinerMainPage;
import popo.hiqos.framework.base.BaseTest;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

@Log4j2
public class TestOnliner extends BaseTest {

    private final String xiaomiMiSearch = "xiaomi Mi";
    private final String containedText = "xiaomi";

    @Description(value = "Validation of search field")
    @Features(value = "Validation of search product")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = {TestGroup.SEARCH, TestGroup.MOBILE})
    public void testSearchProductItems() {
        final String searchingProduct = xiaomiMiSearch;
        final int assertedResult = 1;

        OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
        int searchingProductsCount = onlinerMainPage.getHeader().getTopActions().search(searchingProduct)
                .getVisibleResultsCount(containedText);

        assertThat(String.format("Count of searching results of '%s' product is '%d', but does not greater than '%d'",
                searchingProduct, searchingProductsCount, assertedResult),
                searchingProductsCount, greaterThan(assertedResult));
    }

    @Description(value = "Validation of price")
    @Features(value = "Validation of average price")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = {TestGroup.PRICE, TestGroup.MOBILE, TestGroup.PRODUCT})
    public void testPrice() {
        final String searchingProduct = xiaomiMiSearch;
        final double expectedArithmeticOfferPrice = 100d;

        OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
        double arithmeticOfferPrice = onlinerMainPage.getHeader().getTopActions().search(searchingProduct)
                .clickToFirstResultOffer(containedText).getArithmeticOfferPrice();

        assertThat(String.format("Arithmetic offer price fot '%s' is '%f', but does not as expected price '%f'",
                searchingProduct, arithmeticOfferPrice, expectedArithmeticOfferPrice),
                arithmeticOfferPrice, greaterThan(expectedArithmeticOfferPrice));
    }
}
