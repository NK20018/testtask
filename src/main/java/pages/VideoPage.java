package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class VideoPage extends BasePage<VideoPage>{
    public static final String CHANNEL_AVATAR = "//div[@id='owner']//img";

    public VideoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on channel avatar")
    public VideoPage clickOnChannelAvatar(){
        waitElementToBeClickable(xpath(CHANNEL_AVATAR)).click();
        return this;
    }
}
