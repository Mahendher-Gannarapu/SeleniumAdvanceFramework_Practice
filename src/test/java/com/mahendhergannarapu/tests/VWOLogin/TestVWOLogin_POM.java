package com.mahendhergannarapu.tests.VWOLogin;

import com.mahendhergannarapu.pages.pageObjectModel.LoginPage_POM;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_POM {

    @Owner("Mahendher")
    @Description("Verify that invalid creds give error Message")
    @Test
    public void testLoginNegativeVWO()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

        LoginPage_POM loginPagePom = new LoginPage_POM(driver);
        String error_msg = loginPagePom.loginToVWOInvalidCreds("admin@gmail.com","12234");

        assertThat(error_msg).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

    driver.quit();
    }
}
