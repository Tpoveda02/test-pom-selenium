import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.test.pages.CartPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest {
    protected CartPage cartPage;

    @Test
    public void testIncorrectUser() {
        homePage.addProducts();
        homePage.goToCart();
        cartPage = new CartPage(driver);
        assertTrue(cartPage.deleteProductTop());
    }
}
