package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configreader.FrameworkProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.BaseTest;
import static com.codeborne.selenide.Selenide.open;

public class RozetkaSearch extends BaseTest {
    @BeforeClass
    public void setUp() {
        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(false));
    }

    @Test(description = "Search on Rozetke")
    public void search() {
        open(getBaseUrl());
        StepsRozetkaSearch stepsRozetkaSearch = new StepsRozetkaSearch();
        stepsRozetkaSearch.productSearch();
        stepsRozetkaSearch.clickSearchButton();
        stepsRozetkaSearch.checkBuyButton();
    }

    @Override
    public String getBaseUrl() {
        FrameworkProperties frameworkProperties = ConfigFactory.create(FrameworkProperties.class);
        return frameworkProperties.getUrlRozetka();
    }
}

