package org.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonActionPages {


    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//form/p")
    private WebElement paragraphAlert;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void sendLogin(String email, String password){
        clearInput(inputEmail);
        clearInput(inputPassword);
        writeText(inputEmail, email);
        writeText(inputPassword, password);
        sendForm(buttonLogin);
    }
    public String getIncorrectUser(){
        waitExplicitTime(paragraphAlert);
        return getText(paragraphAlert);
    }

}