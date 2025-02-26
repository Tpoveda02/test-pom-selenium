package org.test.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class CommonActionPages {

    protected WebDriver driver;

    public CommonActionPages(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public void viewPage(String link){
        driver.get(link);
        driver.manage().window().maximize();
    }

    public void selectElement(WebElement element){
        element.click();
    }

    public void clearInput(WebElement element){
        element.clear();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void writeText(WebElement element, String text){
        element.sendKeys(text);
    }

    public void sendForm(WebElement element){
        element.submit();
    }

    public void waitExplicitTime(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void uploadFile(String path, WebElement element){
        String filePath = Paths.get(path).toAbsolutePath().toString();
        element.sendKeys(filePath);
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public boolean isElementInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForSelector(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

}