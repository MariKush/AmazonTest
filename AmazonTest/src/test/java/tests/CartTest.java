package tests;

import org.testng.annotations.Test;
import pages.BasePage;

import java.math.BigInteger;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    private static final String COUNT_OF_ITEMS_IN_THE_CART_AFTER_ADDED_ONE_ITEM_TO_THE_CART = "1";

    @Test
    public void checkAbilityToAddItemToCart(){
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);
        getDealsAndPromotionsPage().clickOnTheFirstAddToCardButton();
        getBasePage().scrollToElement(getHeaderComponent().getWebElementWithAmountOfProductsInCart());
        assertEquals(getHeaderComponent().getAmountOfProductsInCart(), COUNT_OF_ITEMS_IN_THE_CART_AFTER_ADDED_ONE_ITEM_TO_THE_CART);
    }

    @Test
    public void checkAbilityToAddDifferentItemsToCart(){
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);
        getDealsAndPromotionsPage().clickOnAllAddToCartButtons();

        String expectedNumberInTheCart = String.valueOf(getDealsAndPromotionsPage().getNumberOfAddToCartButtonsOnThePage());

        getBasePage().waitForElementTextBePresented(30, getHeaderComponent().getWebElementWithAmountOfProductsInCart(), expectedNumberInTheCart);

        assertEquals(getHeaderComponent().getAmountOfProductsInCart(), expectedNumberInTheCart);
    }

    @Test
    public void checkChangeNumberOfItemsInTheBasket(){
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);
        getDealsAndPromotionsPage().clickOnTheFirstAddToCardButton();
        getBasePage().scrollToElement(getHeaderComponent().getCartButton());

        getHeaderComponent().clickOnTheCartButton();
        getBasePage().waitForPageReadyState(10);
        getCartPage().clickOnTheQuantityButton();

        getBasePage().waitForElementVisibility(10, getCartPage().getQuantityDropDownList());
        getCartPage().clickOnTheThreeItemsFromTheDropDownListOfQuantity();


        String expectedPricePerTwoUnits = new BigInteger(getCartPage().getPricePerUnit()).multiply(new BigInteger(getCartPage().getValueQuantityOfItems())).toString();

        //getBasePage().waitForElementTextBePresented(10, getCartPage().getPricePerAll(), "");

        String actualPricePerAll = getCartPage().getPricePerAll();

        assertEquals(actualPricePerAll, expectedPricePerTwoUnits);

    }
}
