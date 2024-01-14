package SwagLabs_Product_Sorting.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    private WebDriverWait wait;

    @FindBy(css = "#user-name")
    private WebElement UsernameInput;

    @FindBy(css = "#password")
    private WebElement UserpassInput;

    @FindBy(css = "#login-button")
    public WebElement LoginButton;

    @FindBy(css = "#inventory_filter_container > div")
    public WebElement PageTitle;

    @FindBy(css = "div[class='bm-burger-button']")
    public WebElement PageMenuButton;

    @FindBy(css = "#logout_sidebar_link")
    public WebElement LogoutButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean LogIn() {
        UsernameInput.clear();
        UserpassInput.clear();
        UsernameInput.sendKeys(USERNAME);
        UserpassInput.sendKeys(PASSWORD);
        LoginButton.click();
        return checkLogIn();
    }

    public boolean checkLogIn() {
        wait.until(ExpectedConditions.visibilityOf(PageTitle));
        return PageTitle.isDisplayed();
    }

    public boolean LogOut() {
        PageMenuButton.click();
        wait.until(ExpectedConditions.visibilityOf(LogoutButton));
        LogoutButton.click();
        return checkLogOut();
    }

    public boolean checkLogOut() {
        wait.until(ExpectedConditions.visibilityOf(UsernameInput));
        return UsernameInput.isDisplayed();
    }
}
