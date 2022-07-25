package stepDefinitions;
import com.microsoft.playwright.Page;
import core.Core;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps {

    private  final LoginPage loginPage;
    private  final ProductsPage productsPage;

    public LoginSteps() {
        Page page = Core.getPage();
        this.loginPage = new LoginPage(page);
        this.productsPage = new ProductsPage(page);
    }

    @Given("User logins as {string} with {string}")
    public void iLoginWith(String userType, String userPassword) {
        String username = System.getProperty(userType);
        String password = System.getProperty(userPassword);
        this.loginPage.navigateToPage();
        this.loginPage.loginWithUserAndPassword(username, password);

    }

    @Then("User validates I am in inventory page")
    public void iValidateIAmInInventoryPage() {
        this.productsPage.validateProductTitleIsPresent();
    }

    @Then("User validates error message for {string}")
    public void userValidatesErrorMessageFor(String wrong_data) {
        this.loginPage.validateloginErrorMessage(wrong_data);
    }

}
