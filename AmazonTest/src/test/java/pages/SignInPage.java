package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailOrMobileInput;

    @FindBy(xpath = "//div[@id='auth-error-message-box']")
    private WebElement errorMessageBox;

    @FindBy(xpath = "//div[@class='a-alert-content']//span")
    private WebElement errorContentLabel;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailOrMobile(String text){
        emailOrMobileInput.sendKeys(text, ENTER);
    }

    public WebElement getErrorMessageBox(){
        return errorMessageBox;
    }

    public String getErrorContentLabelText() {
        return errorContentLabel.getText();
    }
}
