package com.mahendhergannarapu.tests.VWOLogin;

import com.mahendhergannarapu.base.CommonToAllTest;
import com.mahendhergannarapu.driver.DriverManager;
import com.mahendhergannarapu.pages.pageObjectModel.DashBoardPage_POM;
import com.mahendhergannarapu.pages.pageObjectModel.LoginPage_POM;
import com.mahendhergannarapu.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_POM extends CommonToAllTest {

    @Owner("Mahendher")
    @Description("Verify that invalid creds give error Message")
    @Test
    public void testLoginNegativeVWO()
    {
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        String error_msg = loginPagePom.loginToVWOInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        assertThat(error_msg).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));

    }

    @Owner("Mahendher")
    @Description("Verify that valid creds navigate to dashboard")
    @Test
    public void testLoginPositiveVWO()
    {
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        loginPagePom.loginToVWOvalidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage_POM dashBoardPagePom = new DashBoardPage_POM(DriverManager.getDriver());
        String loggedInusername = dashBoardPagePom.loggedInUserName();

        assertThat(loggedInusername).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(loggedInusername, PropertiesReader.readKey("expected_username"));

    }
}
