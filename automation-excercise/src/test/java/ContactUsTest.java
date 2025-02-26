import baseTest.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactUsTest extends BaseTest {

    @Test
    void testIncorrectUser() {
        homePage.goToContactUsPage();
        String successMessage = contactUsPage.sendFormContactUs();
        assertEquals("Success! Your details have been submitted successfully.", successMessage);
        assertEquals("https://automationexercise.com/", contactUsPage.goToHome());
    }


}
