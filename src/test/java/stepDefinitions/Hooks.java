package stepDefinitions;
import core.Core;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before(){
        Core.initialize();
    }
}
