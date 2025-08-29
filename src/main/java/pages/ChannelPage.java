package pages;

import fragment.SubscribePopupFragment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ChannelPage extends BasePage<ChannelPage>{
    private static final String SUBSCRIBE = "//div[@class='ytFlexibleActionsViewModelAction']";
    private final SubscribePopupFragment subscribePopupFragment;

    public ChannelPage(WebDriver driver) {
        super(driver);
        this.subscribePopupFragment = new SubscribePopupFragment(driver);
    }

    public SubscribePopupFragment getSubscribePopupFragment() {
        return subscribePopupFragment;
    }

    @Step("Click on subscribe button")
    public ChannelPage clickSubscribeButton(){
        waitElementToBeClickable(xpath(SUBSCRIBE)).click();
        return this;
    }
}
