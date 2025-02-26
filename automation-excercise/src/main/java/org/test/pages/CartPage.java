package org.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends CommonActionPages {


    @FindBy(xpath = "//a[@class='cart_quantity_delete' and @data-product-id='1']")
    private WebElement deleteProductTop;

    @FindBy(xpath = "//tr[@id='product-1']" )
    private WebElement productTop;

    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    private List<WebElement> allProducts;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean deleteProductTop(){
        waitExplicitTime(productTop);
        selectElement(deleteProductTop);
        return isElementInvisible(productTop);
    }

    public List<WebElement> getAllProducts(){
        return allProducts;
    }



}
