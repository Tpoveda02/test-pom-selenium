package baseTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import org.test.pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected CartPage cartPage;
    protected ProductPage productPage;
    protected LoginPage loginPage;
    protected ContactUsPage contactUsPage;

    @BeforeEach
    public void setUp(){
        CommonActionPages commonActionPages = new CommonActionPages(driver);
        driver = commonActionPages.chromeDriverConnection();

        homePage = new HomePage(driver);
        homePage.viewPage("http://automationexercise.com");
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}