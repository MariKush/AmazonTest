package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    private static final String COUNT_OF_ITEMS_IN_THE_CART_AFTER_ADDED_ONE_ITEM_TO_THE_CART = "1";

    @Test
    public void checkAbilityToAddItemToCart() {
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);
        getBasePage().scrollToElement(getDealsAndPromotionsPage().getFirstAddToCardButton());
        getDealsAndPromotionsPage().clickOnTheFirstAddToCardButton();
        getBasePage().scrollToElement(getHeaderComponent().getWebElementWithAmountOfProductsInCart());
        getBasePage().waitForElementTextBePresented(10, getHeaderComponent().getWebElementWithAmountOfProductsInCart(), COUNT_OF_ITEMS_IN_THE_CART_AFTER_ADDED_ONE_ITEM_TO_THE_CART);
        assertEquals(getHeaderComponent().getAmountOfProductsInCart(), COUNT_OF_ITEMS_IN_THE_CART_AFTER_ADDED_ONE_ITEM_TO_THE_CART);
    }


    @Test
    public void checkChangeNumberOfItemsInTheCart() {
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);
        getDealsAndPromotionsPage().clickOnTheFirstAddToCardButton();
        getBasePage().scrollToElement(getHeaderComponent().getCartButton());

        getHeaderComponent().clickOnTheCartButton();
        getBasePage().waitForElementVisibility(10, getCartPage().getQuantityButton());

        getCartPage().clickOnTheQuantityButton();
        getBasePage().waitForElementVisibility(10, getCartPage().getQuantityDropDownList());
        getCartPage().clickOnTheTwoItemsFromTheDropDownListOfQuantity();

        String expectedPricePerTwoUnits = new BigDecimal(getCartPage().getPricePerUnit()).multiply(new BigDecimal(getCartPage().getValueQuantityOfItems())).toString();
        getBasePage().waitForElementTextBePresented(10, getCartPage().getPricePerAllWebElement(), expectedPricePerTwoUnits);
        String actualPricePerAll = getCartPage().getPricePerAll();

        assertEquals(actualPricePerAll, expectedPricePerTwoUnits);

    }


    @Test
    public void checkDeleteItemFromTheCart() {
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);
        getDealsAndPromotionsPage().clickOnTheFirstAddToCardButton();
        getBasePage().scrollToElement(getHeaderComponent().getCartButton());
        getBasePage().waitForElementTextBePresented(10, getHeaderComponent().getWebElementWithAmountOfProductsInCart(), COUNT_OF_ITEMS_IN_THE_CART_AFTER_ADDED_ONE_ITEM_TO_THE_CART);

        getHeaderComponent().clickOnTheCartButton();
        getBasePage().waitForPageReadyState(10);
        getBasePage().waitForElementVisibility(10, getCartPage().getDeleteButton());

        getCartPage().clickOnTheDeleteButton();

        WebElement emptyCart = getCartPage().getEmptyCartLabel();
        getBasePage().waitForElementVisibility(10, emptyCart);

        assertTrue(emptyCart.isDisplayed());

    }


    @Test
    public void checkMoveItemToSaveForeLaterFromTheCart() {
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);
        getDealsAndPromotionsPage().clickOnTheFirstAddToCardButton();
        getBasePage().scrollToElement(getHeaderComponent().getCartButton());

        getHeaderComponent().clickOnTheCartButton();
        getBasePage().waitForPageReadyState(10);

        String productTitleInCartText = getCartPage().getProductTitleInCartText();
        getCartPage().clickOnTheSaveForeLaterButton();
        getBasePage().waitForElementVisibility(10, getCartPage().getSavedForLaterLabel());

        assertEquals(getCartPage().getProductTitleInSavedText(), productTitleInCartText);

    }


}
