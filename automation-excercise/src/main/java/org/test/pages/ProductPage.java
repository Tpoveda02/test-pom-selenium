package org.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends CommonActionPages {

    @FindBy(xpath = "//h2[contains(@class, 'title') and contains(text(), 'Searched Products')]")
    private WebElement titleItems;

    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement search;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement submitSearch;

    @FindBy(xpath = "//div[contains(@class,'productinfo')]/a")
    private List<WebElement> allProducts;

    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement linkCart;

    @FindBy(xpath = "//button[@data-dismiss='modal']")
    private WebElement closeModal;


    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Integer searchProduct(String searchText){
        clearInput(search);
        writeText(search, searchText);
        selectElement(submitSearch);
        waitExplicitTime(titleItems);
        return allProducts.size();
    }

    public void addProductsToCart(){
        for (WebElement product : allProducts) {
            selectElement(product);
            waitForSelector(closeModal);
        }
    }
}
