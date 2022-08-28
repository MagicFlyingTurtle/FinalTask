package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Rozetka {
    private static final By SEARCH_FIELD = By.cssSelector("[name='search']");
    private static final By SEARCH_BUTTON = By.cssSelector(".button.search-form__submit");
    private static final By BUY_BUTTON = By.cssSelector(".buy-button__label.ng-star-inserted");

    public SelenideElement getSearchField() {
        return $(SEARCH_FIELD);
    }

    public SelenideElement getSearchButton() {
        return $(SEARCH_BUTTON);
        }

    public SelenideElement getBuyButton() {
        return $(BUY_BUTTON);
    }
}


