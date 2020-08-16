package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class FilterAndSortTest extends BaseTest {

    @Test
    public void checkSortByPriceLowToHigh() {
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);

        getDealsAndPromotionsPage().clickOnTheSortByButton();
        getBasePage().waitForElementVisibility(10, getDealsAndPromotionsPage().getSortByPriceLowToHighButton());

        getDealsAndPromotionsPage().clickOnTheSortByPriceLowToHighButton();
        getBasePage().waitForElementVisibility(10, getDealsAndPromotionsPage().getSortByButton());

        List<Double> prices = getDealsAndPromotionsPage().getPriceLabels().stream()
                .map(WebElement::getText)
                .map(element -> element.split("-")[0])
                .map(element -> element.replaceAll("[^\\d.]", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 1; i < prices.size(); i++) {
            assertTrue(prices.get(i - 1) <= prices.get(i));
        }
    }
}
