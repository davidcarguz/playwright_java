package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;

    private final Locator edtUsername;
    private final Locator edtPassword;
    private final Locator btnLogin;
    private final Locator lblLoginError;

    public LoginPage(Page page) {
        this.page = page;
        this.edtUsername = page.locator("#user-name");
        this.edtPassword = page.locator("#password");
        this.btnLogin = page.locator("#login-button");
        this.lblLoginError = page.locator("h3[data-test='error']");
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

    public void validateloginErrorMessage(String errorType){
        String expectedMessage;
        if(errorType.equals("wrong_password")){
            expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        }else{
            throw new Error("Error message not supported");
        }
        assertThat(this.lblLoginError).hasText(expectedMessage);
    }
}
