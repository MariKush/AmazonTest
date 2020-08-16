package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchedPage extends BasePage{

    @FindBy(xpath = "//span[contains(text(), 'No results for')]")
    private WebElement noResultsLabel;

    public SearchedPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNoResultsLabel() {
        return noResultsLabel;
    }
}
