package baseTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.test.pages.HomePage;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.viewPage("http://automationexercise.com");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}