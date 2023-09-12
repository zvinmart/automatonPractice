
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutomationPractice {

    @Before
    public void setup() {
        open("https://www.saucedemo.com/");
        System.out.println("swag labs should be opened");
        sleep(3000);
    }

    @Test
    public void verifyPageTitleIsDisplayedAndCorrect(){
        titleIsDisplayed();
        pageTitleIsCorrect();
    }

    public void titleIsDisplayed(){
        $("#root > div > div.login_logo").shouldBe(visible);
    }

    public void pageTitleIsCorrect(){
        String elementText = $("#root > div > div.login_logo").getText();
        Assert.assertEquals(elementText, "Swag Labs");
    }

    public void usernameFieldIsDisplayed(){$("#user-name").shouldBe(visible);}

    public void passwordFieldIsDisplayed(){$("#password").shouldBe(visible);}

    public void loginButtonIsDisplayed(){$("#login-button").shouldBe(visible);}

    private void assertElementText(String selector, String expectedText) {
        String actualText = $(selector).getText();
        assertEquals(expectedText, actualText, "Expected text is not equal to actual text!");
    }

}
