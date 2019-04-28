package popo.hiqos.app.pages;

import lombok.Getter;
import popo.hiqos.app.pages.elements.Header;
import popo.hiqos.framework.base.WebPage;

public class BaseOnlinerWebPage extends WebPage {

    @Getter private final Header header = new Header();
}
