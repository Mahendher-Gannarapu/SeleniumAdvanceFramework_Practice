package com.mahendhergannarapu.pages.pageObjectModel;

import com.mahendhergannarapu.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage_POM extends CommonToAllPage {

    WebDriver driver;

    public DashBoardPage_POM(WebDriver driver) {
        this.driver =driver;
    }

    //Page Locaters
    By userNameOnDashBoard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    //Page Actions
    public String loggedInUserName()
    {
        presenceOfElement(userNameOnDashBoard);
        return getElement(userNameOnDashBoard).getText();
    }
}
