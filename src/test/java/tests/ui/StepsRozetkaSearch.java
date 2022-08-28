package tests.ui;

import Pages.Rozetka;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;

public class StepsRozetkaSearch {

    @Step("Product search on Rozetka")
    public void productSearch() {
        Rozetka rozetka = new Rozetka();
        rozetka.getSearchField()
                .shouldBe(visible)
                .setValue("Ноутбук Acer Aspire 5 A515-45G-R63J (NX.A8EEU.001) Charcoal Black");
    }

    @Step
    public void clickSearchButton() {
        Rozetka rozetka = new Rozetka();
        rozetka.getSearchButton()
                .shouldBe(visible)
                .pressEnter();
    }

    @Step
    public void checkBuyButton() {
        Rozetka rozetka = new Rozetka();
        rozetka.getBuyButton()
                .shouldBe(visible);
    }
}
