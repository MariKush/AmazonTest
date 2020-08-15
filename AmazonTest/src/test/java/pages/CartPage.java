package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//span[@data-a-class='quantity']")
    private WebElement quantityButton;

    @FindBy(xpath = "//div[@class='a-popover-wrapper']")
    private WebElement quantityDropDownList;

    @FindBy(xpath = "//a[@id='dropdown1_3']")
    private WebElement threeItemsFromTheDropDownListOfQuantity;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    private WebElement valueQuantityOfItemsField;

    @FindBy(xpath = "//p[@class='a-spacing-small']/span")
    private WebElement pricePerUnitField;

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/span")
    private WebElement pricePerAllField;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTheQuantityButton(){
        quantityButton.click();
    }

    public WebElement getQuantityDropDownList(){
        return quantityDropDownList;
    }

    public void clickOnTheThreeItemsFromTheDropDownListOfQuantity(){
        threeItemsFromTheDropDownListOfQuantity.click();
    }

    public String getValueQuantityOfItems(){
        return valueQuantityOfItemsField.getText();
    }

    public String getPricePerUnit(){
        return pricePerUnitField.getText().replaceAll("\\$", "").replaceAll(".","");
    }

    public String getPricePerAll(){
        return pricePerAllField.getText().replaceAll("\\$", "").replaceAll(".","");
    }
}
