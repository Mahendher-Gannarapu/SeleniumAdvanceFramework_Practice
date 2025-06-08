package com.mahendhergannarapu.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCode {

    @Test
    public void test()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.quit();
    }
}
