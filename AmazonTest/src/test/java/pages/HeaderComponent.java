package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class HeaderComponent extends BasePage{

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;

    public void enterTextIntoSearchInput(String text){
        searchInput.sendKeys(text, ENTER);
    }


}
