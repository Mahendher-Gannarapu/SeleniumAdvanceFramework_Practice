package com.mahendhergannarapu.pages.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM {

    WebDriver driver;

    public LoginPage_POM(WebDriver driver) {
        this.driver =driver;
    }

    //Page Locators
    //Make all Private
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");


    //Page Actions

    public String loginToVWOInvalidCreds(String user, String pwd) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String error_messgae_text = driver.findElement(error_message).getText();
        return error_messgae_text;
    }

}
