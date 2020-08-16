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

    public DealsAndPromotionsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAllAddToCartButtons() {
        for (WebElement webElement : addToCartButtons) {
            //webElement.findElement(By.xpath("xpath"));
            scrollToElement(webElement);
            webElement.click();
        }
    }

    public int getNumberOfAddToCartButtonsOnThePage() {
        return addToCartButtons.size();
    }

    public void clickOnTheFirstAddToCardButton() {
        firstAddToCartButton.click();
    }

    public void clickOnTheFirstChooseOptionsButton() {
        firstChooseOptionsButton.click();
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

}
