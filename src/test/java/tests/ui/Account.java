package tests.ui;

import Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configreader.FrameworkProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class Account extends BaseTest {
    @BeforeClass
    public void setUp() {
        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(false));
    }

 @Test(description = "Open login Form")
        public void SearchAccountForm() {
        open(getBaseUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.findAccountElement()
                    .shouldBe(visible)
                    .pressEnter();

        loginPage.checkOpenAccountElement()
                    .shouldBe(visible);

        loginPage.checkEmailElement()
                    .shouldBe(visible);

        loginPage.checkPasswordElement()
                    .shouldBe(visible);

        loginPage.signInElement()
                .shouldBe(visible);
        }

    @Override
    public String getBaseUrl() {
        FrameworkProperties frameworkProperties = ConfigFactory.create(FrameworkProperties.class);
        return frameworkProperties.getUrlRozetka();
    }
}



