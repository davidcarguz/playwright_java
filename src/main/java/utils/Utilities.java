package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import core.Hooks;

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

    public static Browser initBrowser(String browserOption){
        Browser browser;
        Playwright playwright = Hooks.getPlaywright();
        if(browserOption.equals("chrome")){
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
        }else if(browserOption.equals("firefox")){
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
        }else if(browserOption.equals("edge")){
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(true));
        }else if(browserOption.equals("safari")){
            browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
        }else{
            throw new Error("Browser specified not supported.");
        }
        return browser;
    }

}
