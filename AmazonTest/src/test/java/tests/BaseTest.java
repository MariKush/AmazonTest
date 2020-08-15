package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import pages.HeaderComponent;
import pages.HomePage;

public class BaseTest {

    private static final String AMAZON_URL = "https://www.amazon.com/";
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public BasePage getBasePage() {
        return new BasePage(driver);
    }

    public HeaderComponent getHeaderComponent() {
        return new HeaderComponent(driver);
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
