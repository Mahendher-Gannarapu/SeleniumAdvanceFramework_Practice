package com.mahendhergannarapu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    //Data Properties will fetched by the Properties Reader
    //We will create utility

    //readKey() method which automatically read data from test->resources->data.properties file
    //data.properties file
    // # App.vwo.com
    //url=https://app.vwo.com ---Here url is a key. Whatever key will give in readKey() function that value give
    //orange_hr_url=https://awesomeqa.com/hr/web/index.php/auth/login
    //qa_url=https://app.vwo.com
    //username=contact+atb7x@thetestingacademy.com
    //password=Wingify@1234
    //invalid_username=admin@admin.com
    //invalid_password=Test@2024
    //expected_username=Aman Ji
    public static String readKey(String key){
        //Checked Exception handled by try catch
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/data.properties");
            Properties p = new Properties();
            p.load(fileInputStream);
            return p.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
