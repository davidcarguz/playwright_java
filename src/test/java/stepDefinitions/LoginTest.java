package stepDefinitions;

import com.microsoft.playwright.Page;
import core.Hooks;
import org.junit.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest {

    private Page page;
    private final LoginPage loginPage;
    private final ProductsPage productsPage;

    public LoginTest() {
        Hooks.initialize();
        this.page = Hooks.getPage();
        this.loginPage = new LoginPage(this.page);
        this.productsPage = new ProductsPage(this.page);

    }

    @Test
    public void successfulLoginWithStandardUser(){
        String username = System.getProperty("standard_user");
        String password = System.getProperty("password");
        this.loginPage.navigateToPage();
        this.loginPage.loginWithUserAndPassword(username, password);
        this.productsPage.validateProductTitleIsPresent();
    }

}
