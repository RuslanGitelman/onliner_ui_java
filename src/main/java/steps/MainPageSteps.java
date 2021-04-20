package steps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.BaseTest;
import pageobjects.MainPage;
import utilities.CustomLogger;


public class MainPageSteps extends BaseTest {

    private final MainPage mainPage = new MainPage();

    public void open() {
        CustomLogger.info("Open onliner.by page");
        Selenide.open("/");
    }

    public void openLoginForm() {
        CustomLogger.info("Open login form");
        mainPage.clickLoginButton();
    }

    public void enterLogin(String login) {
        CustomLogger.info("Type login to the form");
        mainPage.fillInLoginField(login);
    }

    public void enterPassword(String password) {
        CustomLogger.info("Type password to the form");
        mainPage.fillInPasswordField(password);
    }

    public void submitLoginForm() {
        CustomLogger.info("Submit login form");
        mainPage.clickSubmitLoginButton();
    }

    public void verifyLogin() {
        CustomLogger.info("Verify login process");
        mainPage.getProfileImage().shouldBe(visible);
    }

    public void searchItem(String item) {
        mainPage.switchToSearchFrame();
        mainPage.setSearchOption(item);
    }

    public void verifySearchResults(String item) {
        ElementsCollection searchResults = mainPage.getSearchResults();
        searchResults.shouldHave(sizeGreaterThan(0));
        for (SelenideElement elem: searchResults) {
            elem.shouldHave(text(item));
        }
    }

}
