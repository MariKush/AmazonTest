package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DealsAndPromotionsPage extends BasePage{

    @FindBy(xpath = "(//button[contains(text(),'Add to Cart')])[1]")
    private WebElement firstAddToCartButton;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "(//button[contains(text(),'Choose options')])[1]")
    private WebElement firstChooseOptionsButton;

    public DealsAndPromotionsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAllAddToCartButtons(){
        for (WebElement webElement : addToCartButtons){
            //webElement.findElement(By.xpath("xpath"));
            scrollToElement(webElement);
            webElement.click();
        }
    }

    public int getNumberOfAddToCartButtonsOnThePage(){
        return addToCartButtons.size();
    }

    public void clickOnTheFirstAddToCardButton(){
        firstAddToCartButton.click();
    }

    public void clickOnTheFirstChooseOptionsButton(){
        firstChooseOptionsButton.click();
    }




}
