package org.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends CommonActionPages {

    @FindBy(xpath = "//div[@class='contact-form']/h2")
    private WebElement titleForm;

    @FindBy(xpath = "//input[@data-qa='name']")
    private WebElement name;
    @FindBy(xpath = "//input[@data-qa='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@data-qa='subject']")
    private WebElement subject;
    @FindBy(xpath = "//textarea[@data-qa='message']")
    private WebElement message;
    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement fileUpload;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    private WebElement submit;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement successMessage;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    private WebElement home;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String sendFormContactUs(){
        waitExplicitTime(titleForm);
        clearInput(name);
        clearInput(email);
        clearInput(subject);
        clearInput(message);
        writeText(name, "Taniah Poveda");
        writeText(email, "taniazoelpoveda@gmail.com");
        writeText(subject, "Password incorrect");
        writeText(message, "my password is incorrect");
        uploadFile("src/test/resources/password_invalid.txt",fileUpload);
        sendForm(submit);
        waitForAlert();
        acceptAlert();
        waitExplicitTime(successMessage);
        return getText(successMessage);
    }

    public String goToHome(){
        waitExplicitTime(home);
        selectElement(home);
        return getCurrentURL();
    }
}
