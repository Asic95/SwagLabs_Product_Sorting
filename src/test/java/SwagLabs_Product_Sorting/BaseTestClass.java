package SwagLabs_Product_Sorting;

import SwagLabs_Product_Sorting.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestClass {

    private static final String URL = "https://www.saucedemo.com/v1/index.html";
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(URL);

        // Логінимся
        LoginPage OurLoginPage = new LoginPage(driver);
        Assert.assertTrue(OurLoginPage.LogIn());
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        LoginPage OurLoginPage = new LoginPage(driver);

        // Виходимо з сайту
        Assert.assertTrue(OurLoginPage.LogOut());
        Thread.sleep(2000);
        driver.quit();
    }

}
