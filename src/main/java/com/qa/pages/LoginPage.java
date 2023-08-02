package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    private By email = By.name("email");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]");
    private By errorMsg = By.xpath("/html/body/div[1]/div/div/form/div/div[3]/p");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String emailID) {
        WebElement enterEmail = driver.findElement(email);
        enterEmail.sendKeys(emailID);
    }

    public void enterPassword(String pwd) {
        WebElement enterPwd = driver.findElement(password);
        enterPwd.sendKeys(pwd);
    }

    public void clickButton() {
        WebElement btn = driver.findElement(loginBtn);
        btn.click();
    }

    public String validateTitle() throws InterruptedException {
        Thread.sleep(1000);
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public String errorMsg() throws InterruptedException {
        Thread.sleep(3000);
        WebElement err = driver.findElement(errorMsg);
        return err.getText();
    }

    public ContactPage login(String usrName,String pwd) throws InterruptedException {
        driver.findElement(email).sendKeys(usrName);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginBtn).click();
        Thread.sleep(1000);
        return new ContactPage(driver);

    }


}
