package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonActionPages {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement linkLogin;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
        waitExplicitTime(linkLogin);
        selectElement(linkLogin);
    }
}