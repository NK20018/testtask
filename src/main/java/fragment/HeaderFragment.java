package fragment;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class HeaderFragment extends BasePage<HeaderFragment> {
    private static final String SEARCH_FIELD = "//input[@name='search_query']";
    private static final String SEARCH_RESULTS = "//div[@role='presentation']";

    public HeaderFragment(WebDriver driver) {
        super(driver);
    }

    @Step("Input {text} in search field")
    public HeaderFragment inputTextInSearchField(String text){
        waitElementIsVisible(xpath(SEARCH_FIELD)).sendKeys(text);
        return this;
    }

    @Step("Click on search result by index {index}")
    public HeaderFragment clickSearchResultByIndex(int index) {
        waitElementToBeClickable(xpath(format("(%s)[%d]", SEARCH_RESULTS, index))).click();
        return this;
    }
}
