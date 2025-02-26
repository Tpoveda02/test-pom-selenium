import baseTest.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CartTest extends BaseTest {

    @Test
    void testDeleteProduct() {
        homePage.addProducts();
        homePage.goToCart();
        assertTrue(cartPage.deleteProductTop());
    }

    @Test
    void testSearchProductsAndVerifyCartAfterLogin(){
        homePage.goToProducts();

        Integer initialProducts = productPage.searchProduct("Jeans");
        productPage.addProductsToCart();

        homePage.goToCart();
        assertEquals(cartPage.getAllProducts().size(), initialProducts);

        homePage.goToLoginPage();

        loginPage.sendLogin("taniazoelpoveda@gmail.com", "password");
        homePage.goToCart();
        assertEquals(cartPage.getAllProducts().size(), initialProducts);
    }
}
