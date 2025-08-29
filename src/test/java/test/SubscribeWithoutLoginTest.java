package test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import pages.ChannelPage;
import pages.HomePage;
import pages.SearchResultsPage;

import static constant.Constant.Owners.NAZAR;
import static org.testng.AssertJUnit.*;
import static utils.DataGenerator.generateRandomDigits;

public class SubscribeWithoutLoginTest extends BaseTest {
    private String expectedPageTitle = "YouTube";
    private String expectedSubscribeMessage = "Sign in";

    @Test
    @Description("Task #3: Verify that subscribing without login shows a popup with ‘Sign in")
    @Owner(NAZAR)
    public void subscribeWithoutLogin() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ChannelPage channelPage = new ChannelPage(driver);

        assertEquals(homePage.openHomePage()
                .getPageTitle(), expectedPageTitle, "Page title is incorrect!");

        homePage.getHeaderFragment()
                .inputTextInSearchField(generateRandomDigits())
                .clickSearchResultByIndex(2);
        searchResultsPage.scrollToVideoByIndex(4)
                .clickVideoByIndex(4)
                .clickOnChannelAvatar();

        assertEquals(channelPage.clickSubscribeButton()
                .getSubscribePopupFragment()
                .getTextFromSignInButton(), expectedSubscribeMessage , "Subscribe popup message is incorrect!");

        channelPage.closeCurrentTab();
    }
}
