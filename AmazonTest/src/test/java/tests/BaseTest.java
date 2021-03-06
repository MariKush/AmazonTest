package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

public class BaseTest {

    private static final String AMAZON_URL = "https://www.amazon.com/";
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public BasePage getBasePage() {
        return new BasePage(driver);
    }

    public DealsAndPromotionsPage getDealsAndPromotionsPage() {
        return new DealsAndPromotionsPage(driver);
    }

    public HeaderComponent getHeaderComponent() {
        return new HeaderComponent(driver);
    }

    public CartPage getCartPage() {
        return new CartPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public SearchedPage getSearchedPage() {
        return new SearchedPage(driver);
    }

    public ChooseOptionsPopUpComponent getChooseOptionsPopUpComponent() {
        return new ChooseOptionsPopUpComponent(driver);
    }

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AMAZON_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
