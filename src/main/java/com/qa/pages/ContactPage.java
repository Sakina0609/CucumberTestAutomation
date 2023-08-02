package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ContactPage {

    WebDriver driver;

    private By sideBar = By.id("main-nav");
    private By createBtn = By.xpath("//*[@id=\"main-nav\"]/div[3]/button");
    private By firstName = By.xpath("//input[@name='first_name']");
    private By lastName = By.xpath("//input[@name='last_name']");
    private By recordStatus = By.name("status");
    private By selectNew = By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[5]/div[1]/div/div/div[2]/div[2]/span");
    private By saveBtn = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]");
    private By contactName = By.tagName("a");
    private By contactMenu = By.xpath("//*[@id=\"main-nav\"]/div[3]/a/span");
    private By homeBtn = By.xpath("//*[@id=\"main-nav\"]/div[1]/a/span");
    private By activityBox = By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/div[2]");
    private By userList = By.className("user");

    public ContactPage(WebDriver driver){
        this.driver=driver;
    }
    public void setSideBar() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement clickSideBar = driver.findElement(sideBar);
        action.moveToElement(clickSideBar).build().perform();
        Thread.sleep(1000);
    }

    public void clickCreate() throws InterruptedException {
        driver.findElement(createBtn).click();
        Thread.sleep(1000);
    }

    public void enterName(String enterFirstName, String enterLastName){
        driver.findElement(firstName).sendKeys(enterFirstName);
        driver.findElement(lastName).sendKeys(enterLastName);
    }

    public void setRecordStatus(String rStatus) throws InterruptedException {
        WebElement status = driver.findElement(recordStatus);
        status.click();
        Thread.sleep(800);
        Actions select = new Actions(driver);
        if(status.getText().contains(rStatus)) {
            WebElement newStatus = driver.findElement(selectNew);
            select.moveToElement(newStatus).click().build().perform();
            Thread.sleep(1000);
        }
    }

    public void clickSave() throws InterruptedException {
       driver.findElement(saveBtn).click();
       Thread.sleep(1000);
    }

    public void clickHomeBtn(){
        driver.findElement(homeBtn).click();
    }


    public void ActivityBox(){
        WebElement moveToActivityBox = driver.findElement(activityBox);
        Actions activity = new Actions(driver);
        activity.moveToElement(moveToActivityBox).build().perform();
    }

    public void clickContactMenu() throws InterruptedException {
        driver.findElement(contactMenu).click();
        Thread.sleep(1000);
    }
    public List<String> validateContactName(){
        List<String> listOfContacts = new ArrayList<>();
        List<WebElement> contactList = driver.findElements(contactName);
        for (WebElement names:contactList){
            String cName = names.getText();
            listOfContacts.add(cName);
        }
        return listOfContacts;
    }

    public List<String> getUserList(){
        List<String> listOfUsers = new ArrayList<>();
        List<WebElement> users = driver.findElements(userList);
        for (WebElement link:users){
            String uName = link.getText();
            listOfUsers.add(uName);
        }
        return listOfUsers;
    }



}
