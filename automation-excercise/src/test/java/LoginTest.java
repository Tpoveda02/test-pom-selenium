import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.test.pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTest extends BaseTest {

    protected LoginPage loginPage;

    @Test
    void testIncorrectUser() {
        homePage.goToLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.sendLogin("taniazoelpoveda@gmail.com", "password123");
        assertEquals("Your email or password is incorrect!", loginPage.getIncorrectUser());
    }
}