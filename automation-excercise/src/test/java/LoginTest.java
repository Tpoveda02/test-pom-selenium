import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.test.pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

    protected LoginPage loginPage;

    @Test
    public void testIncorrectUser() {
        homePage.goToLoginPage();
        loginPage = new LoginPage(driver);
        String errorMessage = loginPage.verifyUserIncorrect();
        assertEquals("Your email or password is incorrect!", errorMessage);
    }
}