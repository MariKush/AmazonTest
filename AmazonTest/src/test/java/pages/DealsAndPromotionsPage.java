package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DealsAndPromotionsPage extends BasePage {

    @FindBy(xpath = "(//button[contains(text(),'Add to Cart')])[1]")
    private WebElement firstAddToCartButton;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "(//button[contains(text(),'Choose options')])[1]")
    private WebElement firstChooseOptionsButton;

    @FindBy(xpath = "//div[@id='FilterItemView_sortOrder_dropdown']//span[@data-action='a-dropdown-button']")
    private WebElement sortByButton;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[contains(text(),'Price - Low to High')]")
    private WebElement sortByPriceLowToHighButton;

    @FindBy(xpath = "//span[contains(@class,'dealPriceText')]")
    private List<WebElement> priceLabels;

    @FindBy(xpath = "//div[@data-value='50-100']/a")
    private WebElement from50To100DollarsButton;

    public DealsAndPromotionsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstChooseOptionsButton() {
        return firstChooseOptionsButton;
    }

    public void clickOnTheFirstChooseOptionsButton() {
        scrollToElement(firstChooseOptionsButton);
        firstChooseOptionsButton.click();
    }

    public void clickOnTheFirstAddToCardButton() {
        firstAddToCartButton.click();
    }

    public WebElement getFirstAddToCardButton(){
        return firstAddToCartButton;
    }

    public void clickOnTheSortByButton() {
        sortByButton.click();
    }

    public WebElement getSortByPriceLowToHighButton() {
        return sortByPriceLowToHighButton;
    }

    public void clickOnTheSortByPriceLowToHighButton() {
        sortByPriceLowToHighButton.click();
    }

    public List<WebElement> getPriceLabels() {
        return priceLabels;
    }

    public WebElement getSortByButton() {
        return sortByButton;
    }

    public void clickOnTheFrom50To100DollarsButton() {
        from50To100DollarsButton.click();
    }

    public WebElement getFrom50To100DollarsButton() {
        return from50To100DollarsButton;
    }

}
