package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.util.List;

import static constant.Constant.TimeOutVariable.EXPLICIT_WAIT;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class BasePage<T extends BasePage<T>> {
    protected static final String BASE_URL = ConfigReader.getProperty("baseUrl");
    protected WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, ofMillis(EXPLICIT_WAIT));
    }

    public WebElement waitElementIsVisible(By locator) {
        return wait.until(visibilityOfElementLocated(locator));
    }

    public WebElement waitElementToBeClickable(By locator) {
        return wait.until(elementToBeClickable(locator));
    }

    public WebElement waitPresenceOfElement(By locator) {
        return wait.until(presenceOfElementLocated(locator));
    }

    public boolean isElementToBeInvisible(By locator) {
        return wait.until(invisibilityOfElementLocated(locator));
    }

    public List<WebElement> waitElementsAreVisible(By locator) {
        return wait.until(visibilityOfAllElementsLocatedBy(locator));
    }

    public void scrollToElement(By locator) {
        WebElement element = waitElementIsVisible(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    @Step("Get page title")
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Step("Close current browser tab")
    public void closeCurrentTab() {
        driver.close();
    }
}
