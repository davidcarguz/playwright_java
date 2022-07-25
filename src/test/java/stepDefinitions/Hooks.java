package stepDefinitions;
import com.microsoft.playwright.Page;
import core.Core;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {

    @Before
    public void before(){
        Core.initialize();
    }

    @After
    public void after(Scenario scenario) {
        String screenshotPath = "target/cucumber-reports/"+scenario.getName()+".png";
        Page page = Core.getPage();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)).setFullPage(true));
        File screenshotFile = new File(screenshotPath);
        try {
            byte[] screenshotBytes = Files.readAllBytes(screenshotFile.toPath());
            scenario.attach(screenshotBytes,"image/png",scenario.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
