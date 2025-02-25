package org.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.logging.Logger;

public class CartPage extends CommonActionPages {

    private static final Logger logger = Logger.getLogger(CartPage.class.getName());
    @FindBy(xpath = "//a[@class='cart_quantity_delete' and @data-product-id='1']")
    private WebElement deleteProductTop;

    @FindBy(xpath = "//tr[@id='product-1']" )
    private WebElement productTop;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean deleteProductTop(){
        waitExplicitTime(deleteProductTop);
        selectElement(deleteProductTop);
        return isElementInvisible(deleteProductTop);
    }
}
