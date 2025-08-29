package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class SearchResultsPage extends BasePage<SearchResultsPage> {
    public static final String VIDEO_RESULTS = "//a[@id='video-title' and not(contains(@aria-label, 'play Short'))]";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Scroll to video with index {index}")
    public SearchResultsPage scrollToVideoByIndex(int index) {
        scrollToElement(xpath(format("(%s)[%d]", VIDEO_RESULTS, index)));
        return this;
    }

    @Step("Click on video with index {index}")
    public VideoPage clickVideoByIndex(int index) {
        waitElementToBeClickable(xpath(format("(%s)[%d]", VIDEO_RESULTS, index))).click();
        return new VideoPage(driver);
    }
}
