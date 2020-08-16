package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[@data-a-class='quantity']")
    private WebElement quantityButton;

    @FindBy(xpath = "//div[@class='a-popover-wrapper']")
    private WebElement quantityDropDownList;

    @FindBy(xpath = "//a[@id='dropdown1_2']")
    private WebElement twoItemsFromTheDropDownListOfQuantity;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    private WebElement valueQuantityOfItemsField;

    @FindBy(xpath = "//p[@class='a-spacing-small']/span")
    private WebElement pricePerUnitField;

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/span")
    private WebElement pricePerAllField;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//h2[contains(text(),'Your Amazon Cart is empty')]")
    private WebElement emptyCartLabel;

    @FindBy(xpath = "//input[@value='Save for later']")
    private WebElement saveForLaterButton;

    @FindBy(xpath = "//div[@id='sc-saved-cart-list-caption-text']")
    private WebElement savedForLaterLabel;

    @FindBy(xpath = "//div[@data-itemtype='active']//span[contains(@class,'sc-product-title')]")
    private WebElement productTitleInCart;

    @FindBy(xpath = "//div[@data-itemtype='saved']//span[contains(@class,'sc-product-title')]")
    private WebElement productTitleInSaved;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTheQuantityButton() {
        quantityButton.click();
    }

    public WebElement getQuantityButton() {
        return quantityButton;
    }

    public WebElement getQuantityDropDownList() {
        return quantityDropDownList;
    }

    public void clickOnTheTwoItemsFromTheDropDownListOfQuantity() {
        twoItemsFromTheDropDownListOfQuantity.click();
    }

    public String getValueQuantityOfItems() {
        return valueQuantityOfItemsField.getText();
    }

    public String getPricePerUnit() {
        return pricePerUnitField.getText().replaceAll("[^\\d.]", "");
    }

    public String getPricePerAll() {
        return pricePerAllField.getText().replaceAll("[^\\d.]", "");
    }

    public WebElement getPricePerAllWebElement() {
        return pricePerAllField;
    }

    public void clickOnTheDeleteButton() {
        deleteButton.click();
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getEmptyCartLabel() {
        return emptyCartLabel;
    }

    public void clickOnTheSaveForeLaterButton() {
        saveForLaterButton.click();
    }

    public WebElement getSavedForLaterLabel() {
        return savedForLaterLabel;
    }

    public String getProductTitleInCartText() {
        return productTitleInCart.getText();
    }

    public String getProductTitleInSavedText() {
        return productTitleInSaved.getText();
    }
}
