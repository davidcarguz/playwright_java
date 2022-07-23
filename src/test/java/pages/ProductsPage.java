package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsPage {

    private Page page;
    private final Locator lblProducts;

    public ProductsPage(Page page) {
        this.page = page;
        this.lblProducts = page.locator(".title");
    }

    public void validateProductTitleIsPresent(){
        assertThat(this.lblProducts).isVisible();
        assertThat(this.lblProducts).containsText("Products");
        assertThat(this.page).hasURL("https://www.saucedemo.com/inventory.html");
    }
}
