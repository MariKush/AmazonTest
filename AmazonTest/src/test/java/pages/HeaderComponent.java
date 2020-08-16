package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class HeaderComponent extends BasePage {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@id='nav-xshop']/a[contains(text(),'Deals')]")
    private WebElement dealsLink;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement amountOfProductsInCart;

    @FindBy(xpath = "//a[@id='nav-cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement accountButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void enterTextIntoSearchInput(String text) {
        searchInput.sendKeys(text, ENTER);
    }

    public void clickOnTheDealsLink() {
        dealsLink.click();
    }

    public String getAmountOfProductsInCart() {
        return amountOfProductsInCart.getText();
    }

    public WebElement getWebElementWithAmountOfProductsInCart() {
        return amountOfProductsInCart;
    }

    public void clickOnTheCartButton() {
        cartButton.click();
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public void clickOnTheAccountButton() {
        accountButton.click();
    }

}
