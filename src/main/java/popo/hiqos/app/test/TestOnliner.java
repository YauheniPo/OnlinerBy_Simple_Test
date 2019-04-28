package popo.hiqos.app.test;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import popo.hiqos.app.TestGroup;
import popo.hiqos.app.pages.OnlinerMainPage;
import popo.hiqos.framework.base.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

@Log4j2
public class TestOnliner extends BaseTest {

    private final String xiaomiMiSearch = "xiaomi Mi";

    @Test(groups = {TestGroup.SEARCH, TestGroup.MOBILE})
    public void testSearchProductItems() {
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
        int results = onlinerMainPage.getHeader().getTopActions().search(xiaomiMiSearch).getVisibleResultsCount();

        assertThat("",
                results, greaterThan(1));
    }

    @Test(groups = {TestGroup.PRICE, TestGroup.MOBILE, TestGroup.PRODUCT})
    public void testPrice() {
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
        int offerPrice = onlinerMainPage.getHeader().getTopActions().search(xiaomiMiSearch).clickToFirstResultOffer().getArithmeticOfferPrice();

        assertThat("",
                offerPrice, greaterThan(100));
    }

}
