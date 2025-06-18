package com.mahendhergannarapu.driver;

import com.mahendhergannarapu.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    //Responsible by WebDriver is providing the drivers
    //DriverManager basically decide which driver we want to run

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init(){
        String browser = null;
        browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();
        if(driver == null){ //if driver null create new driver according to user response
            switch (browser){
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--incognito");
                    driver= new EdgeDriver(edgeOptions);
                    break;

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver= new ChromeDriver(chromeOptions);
                    break;

                case "firfox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    System.out.println("Browser Not Found!!");

            }
        }
    }

    //Close the driver
    public static void down(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
