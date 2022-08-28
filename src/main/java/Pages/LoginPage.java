package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
 private static final By ACCOUNT_LOGIN = By.cssSelector(".header__button.ng-star-inserted");
 private static final By REMIND_PASSWORD = By.cssSelector(".link-dotted.auth-modal__restore-link");

 private static final By EMAIL = By.cssSelector("#auth_email");

 private static final By PASSWORD = By.cssSelector("#auth_pass");

 private static final By SIGN_IN = By.cssSelector(".button.auth-modal__submit");

    public SelenideElement findAccountElement() {
        return $(ACCOUNT_LOGIN);
    }

    public SelenideElement checkOpenAccountElement() {
        return $(REMIND_PASSWORD);
    }

    public SelenideElement checkEmailElement() {
        return $(EMAIL);
    }

    public SelenideElement checkPasswordElement() {
        return $(PASSWORD);
    }

    public SelenideElement signInElement() {
        return $(SIGN_IN);
    }
}




