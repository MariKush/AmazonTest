package tests;

import org.testng.annotations.Test;

public class ChooseOptionsTest extends BaseTest {

    @Test
    public void checkActivationAddToCartButtonAfterSelectingOption(){
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);
        getDealsAndPromotionsPage().clickOnTheFirstChooseOptionsButton();
        //getBasePage().waitForElementVisibility();
    }

}
