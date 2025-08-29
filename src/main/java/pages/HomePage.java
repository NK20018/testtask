package pages;

import fragment.HeaderFragment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage<HomePage> {
    private static final String HOME_URL = BASE_URL;
    private final HeaderFragment headerFragment;

    public HomePage(WebDriver driver) {
        super(driver);
        this.headerFragment = new HeaderFragment(driver);
    }

    public HeaderFragment getHeaderFragment() {
        return headerFragment;
    }

    @Step("Open home page")
    public HomePage openHomePage() {
        driver.get(HOME_URL);
        return this;
    }
}
