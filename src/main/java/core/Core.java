package core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import utils.Utilities;

public class Core {

     private static Playwright playwright;
     private static Browser browser;
     private static Page page;

    public static void initialize(){
        Utilities.setProjectProperties();
        playwright = Playwright.create();
        browser = Utilities.initBrowser(System.getProperty("browser"));
        page = browser.newContext().newPage();
    }

    public static Playwright getPlaywright(){
        return playwright;
    }

    public static Browser getBrowser(){
        return browser;
    }

    public static Page getPage(){
        return page;
    }
}
