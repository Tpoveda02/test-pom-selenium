package org.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonActionPages {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement linkLogin;

    @FindBy(xpath = "//a[@href='/contact_us']")
    private WebElement linkContactUs;

    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement linkCart;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement linkProducts;


    @FindBy(xpath = "//a[@data-product-id='1']")
    private WebElement addProductTop;

    @FindBy(xpath = "//a[@data-product-id='2']")
    private WebElement addProductTshirt;

    @FindBy(xpath = "//button[@data-dismiss='modal']")
    private WebElement closeModal;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
        waitExplicitTime(linkLogin);
        selectElement(linkLogin);
    }

    public void goToContactUsPage() {
        waitExplicitTime(linkContactUs);
        selectElement(linkContactUs);
    }

    public void goToCart() {
        waitExplicitTime(linkCart);
        selectElement(linkCart);
    }

    public void goToProducts() {
        waitExplicitTime(linkProducts);
        selectElement(linkProducts);
    }
    public void addProducts(){
        addProduct(addProductTop);
        addProduct(addProductTshirt);
    }

    private void addProduct(WebElement element){
        selectElement(element);
        waitForSelector(closeModal);
    }



}