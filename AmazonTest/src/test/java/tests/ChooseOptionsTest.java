package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ChooseOptionsTest extends BaseTest {


    private static final String HEADER_TEXT = "Deal details";


    @Test
    public void checkOpenSelectingOptionPopUp() {
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);
        getBasePage().waitForElementVisibility(10, getDealsAndPromotionsPage().getFirstChooseOptionsButton());
        getDealsAndPromotionsPage().clickOnTheFirstChooseOptionsButton();
        getBasePage().waitForElementVisibility(10, getChooseOptionsPopUpComponent().getChooseOptionsPopUpTitle());

        assertTrue(getChooseOptionsPopUpComponent().getChooseOptionsPopUpTitle().getText().contains(HEADER_TEXT));

    }

}
