package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Properties prop;

    public Properties init_prop(){
        prop=new Properties();
        String fileName = "src/test/resources/Config/config.properties";
        try {
            FileInputStream is = new FileInputStream(fileName);
            prop.load(is);
        } catch (FileNotFoundException e) {
           System.out.println("File is not available" + e);
           e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Input not found");
            e.printStackTrace();
        }
        return prop;
    }
}
