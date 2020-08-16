package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class SignInTest extends BaseTest {

    private static final String INVALID_EMAIL = "qwerty";
    private static final String ERROR_MESSAGE_FORE_INVALID_EMAIL = "We cannot find an account with that email address";

    private static final String INVALID_MOBILE = "1234567";
    private static final String ERROR_MESSAGE_FORE_INVALID_MOBILE = "We cannot find an account with that mobile number";


    @Test
    public void checkImpossibilityToSignInWithInvalidEmail(){
        getHeaderComponent().clickOnTheAccountButton();
        getBasePage().waitForPageReadyState(10);
        getSignInPage().enterEmailOrMobile(INVALID_EMAIL);
        getBasePage().waitForElementVisibility(10,getSignInPage().getErrorMessageBox());

        assertTrue(getSignInPage().getErrorContentLabelText().contains(ERROR_MESSAGE_FORE_INVALID_EMAIL));

    }

    @Test
    public void checkImpossibilityToSignInWithInvalidMobile(){
        getHeaderComponent().clickOnTheAccountButton();
        getBasePage().waitForPageReadyState(10);
        getSignInPage().enterEmailOrMobile(INVALID_MOBILE);
        getBasePage().waitForElementVisibility(10,getSignInPage().getErrorMessageBox());

        assertTrue(getSignInPage().getErrorContentLabelText().contains(ERROR_MESSAGE_FORE_INVALID_MOBILE));

    }




}
