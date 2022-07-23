package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Utilities {

    public static void setProjectProperties(){
        try {
            FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
            Properties p = new Properties(System.getProperties());
            p.load(propFile);
            System.setProperties(p);
        }catch (Exception e){
            throw new Error(e);
        }
    }

}
