package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseOptionsPopUpComponent extends BasePage {

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='a-popover-wrapper']//h4")
    private WebElement chooseOptionsPopUpTitle;

    public ChooseOptionsPopUpComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getChooseOptionsPopUpTitle() {
        return chooseOptionsPopUpTitle;
    }

}
