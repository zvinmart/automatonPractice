import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AutomationPractice {

    @Before
    public void setup() {
        open("https://www.saucedemo.com/");
        System.out.println("swag labs should be opened");
    }

    // Login Page
    // Page title assertions

    @Test
    public void verifyPageTitleIsDisplayedAndCorrect(){
        titleIsDisplayed();
        pageTitleIsCorrect();
    }

    public void titleIsDisplayed(){
        $("#root > div > div.login_logo").shouldBe(visible);
    }

    public void pageTitleIsCorrect(){
        String pageTitleElementText = $("#root > div > div.login_logo").getText();
        Assert.assertEquals(pageTitleElementText, "Swag Labs");
    }

    // Login window assertions

    public void loginWindowElementsAreDisplayed(){
        usernameFieldIsDisplayed();
        passwordFieldIsDisplayed();
        loginButtonIsDisplayed();
    }

    public void usernameFieldIsDisplayed(){$("#user-name").shouldBe(visible);}

    public void passwordFieldIsDisplayed(){$("#password").shouldBe(visible);}

    public void loginButtonIsDisplayed(){$("#login-button").shouldBe(visible);}

    public void loginWindowElementsContainCorrectText(){
        usernameFieldPlaceholderTextIsCorrect();
        passwordFieldPlaceholderTextIsCorrect();
        loginButtonTextIsCorrect();
    }

    public void usernameFieldPlaceholderTextIsCorrect() {
        String usernameFieldPlaceholderText = $("#user-name").getAttribute("placeholder");
        Assert.assertEquals(usernameFieldPlaceholderText, "Username");
    }

    public void passwordFieldPlaceholderTextIsCorrect() {
        String passwordFieldPlaceholderText = $("#password").getAttribute("placeholder");
        Assert.assertEquals(passwordFieldPlaceholderText, "Password");
    }

    public void loginButtonTextIsCorrect(){
        String loginButtonText = $("#login-button").getValue();
        Assert.assertEquals(loginButtonText, "Login");
    }

    @Test
    public void loginWindowElementsAreDisplayedAndContainCorrectText(){
        loginWindowElementsAreDisplayed();
        loginWindowElementsContainCorrectText();
    }

    // Logging in
    // Standard user

    @Test
    public void loginWithStandardUser(){
        loginWindowElementsAreDisplayedAndContainCorrectText();
        enterStandardUserUsername();
        enterPassword();
        clickLoginButton();
    }

    public void enterStandardUserUsername(){
        $("#user-name").setValue("standard_user");
    }

    // locked out user

    @Test
    public void loginWithLockedOutUser(){
        loginWindowElementsAreDisplayedAndContainCorrectText();
        enterLockedOutUserUsername();
        enterPassword();
        clickLoginButton();
    }

    public void enterLockedOutUserUsername(){
        $("#user-name").setValue("locked_out_user");
    }

    // general steps

    public void enterPassword(){
        $("#password").setValue("secret_sauce");
    }

    public void clickLoginButton(){
        $("#login-button").click();
    }

    // errors

    @Test
    public void verifyLockedOutUserError(){
        loginWithLockedOutUser();

        redCircleElementIsDisplayedInUsernameFieldAfterUnsuccessfulLoginAttempt();
        redCircleElementIsDisplayedInPasswordFieldAfterUnsuccessfulLoginAttempt();
        errorIsDisplayed();
        verifyErrorText();
    }

    public void redCircleElementIsDisplayedInUsernameFieldAfterUnsuccessfulLoginAttempt(){
        $("#login_button_container > div > form > div:nth-child(1) > svg").shouldBe(visible);
    }

    public void redCircleElementIsDisplayedInPasswordFieldAfterUnsuccessfulLoginAttempt(){
        $("#login_button_container > div > form > div:nth-child(2) > svg").shouldBe(visible);
    }

    public void errorIsDisplayed(){
        $("#login_button_container > div > form > div.error-message-container.error").shouldBe(visible);
    }

    public void verifyErrorText(){
        String errorText = $("#login_button_container > div > form > div.error-message-container.error").getText();
        Assert.assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.");
    }

    // Product Page
    // Header

    @Test
    public void loginAndVerifyProductPageHeader(){
        loginWithStandardUser();

        burgerButtonIsDisplayed();
        productPageTitleIsDisplayedAndContainsCorrectText();
        shoppingCartButtonIsDisplayed();

    }
    // Burger button

    public void burgerButtonIsDisplayed(){
        $("#menu_button_container > div > div:nth-child(1) > div").shouldBe(visible);
    }

    public void clickBurgerButton(){
        $("#menu_button_container > div > div:nth-child(1) > div").click();
    }

    // Title

    public void productPageTitleIsDisplayedAndContainsCorrectText(){
        productPageTitleIsDisplayed();
        productPageTitleContainsCorrectText();
    }

    public void productPageTitleIsDisplayed(){
        $("#header_container > div.primary_header > div.header_label > div").shouldBe(visible);
    }

    public void productPageTitleContainsCorrectText(){
        String productPageTitleElementText = $("#header_container > div.primary_header > div.header_label > div").getText();
        Assert.assertEquals(productPageTitleElementText, "Swag Labs");
    }

    // Cart

    public void shoppingCartButtonIsDisplayed(){
        $("#shopping_cart_container").shouldBe(visible);
    }

}
