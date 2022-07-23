package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    private final Locator edtUsername;
    private final Locator edtPassword;
    private final Locator btnLogin;

    public LoginPage(Page page) {
        this.page = page;
        this.edtUsername = page.locator("#user-name");
        this.edtPassword = page.locator("#password");
        this.btnLogin = page.locator("#login-button");
    }

    public void navigateToPage(){
        String url = System.getProperty("url");
        page.navigate(url);
    }

    public void loginWithUserAndPassword(String username, String password){
        this.edtUsername.fill(username);
        this.edtPassword.fill(password);
        this.btnLogin.click();
    }
}
