package stepDefinitions;

import com.microsoft.playwright.Page;
import core.Core;
import org.junit.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest {

    private Page page;
    private final LoginPage loginPage;
    private final ProductsPage productsPage;

    public LoginTest() {
        Core.initialize();
        this.page = Core.getPage();
        this.loginPage = new LoginPage(this.page);
        this.productsPage = new ProductsPage(this.page);

    }

    @Test
    public void successfulLoginWithStandardUser(){
        String username = System.getProperty("standar_user");
        String password = System.getProperty("password");
        this.loginPage.navigateToPage();
        this.loginPage.loginWithUserAndPassword(username, password);
        this.productsPage.validateProductTitleIsPresent();
    }

}
