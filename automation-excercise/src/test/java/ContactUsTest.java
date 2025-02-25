import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.test.pages.ContactUsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactUsTest extends BaseTest {

    protected ContactUsPage contactUsPage;

    @Test
    public void testIncorrectUser() {
        homePage.goToContactUsPage();
        contactUsPage = new ContactUsPage(driver);
        String successMessage = contactUsPage.sendFormContactUs();
        assertEquals("Success! Your details have been submitted successfully.", successMessage);
        assertEquals("https://automationexercise.com/", contactUsPage.goToHome());
    }


}
