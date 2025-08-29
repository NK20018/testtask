package fragment;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static org.openqa.selenium.By.xpath;

public class SubscribePopupFragment extends BasePage<SubscribePopupFragment> {
    private static final String SIGN_IN_BUTTON = "//ytd-button-renderer[@id='button']";

    public SubscribePopupFragment(WebDriver driver) {
        super(driver);
    }

    @Step("Get text from sign in button")
    public String getTextFromSignInButton(){
        return waitElementIsVisible(xpath(SIGN_IN_BUTTON)).getText();
    }
}
