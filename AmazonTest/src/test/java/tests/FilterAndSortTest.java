package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class FilterAndSortTest extends BaseTest {

    private static final Double MIN_PRICE = 50d;
    private static final Double MAX_PRICE = 100d;

    private double getPriceByString(String price) {
        return Double.parseDouble(price.replaceAll("[^\\d.]", ""));
    }

    private List<Double> getPricesFromWebElements(List<WebElement> elements) {
        return elements.stream()
                .map(WebElement::getText)
                .map(element -> element.split("-")[0])
                .map(this::getPriceByString)
                .collect(Collectors.toList());
    }

    private double[] getMinAndMaxPricesFromWebElement(WebElement webElement) {
        String[] minAndMaxPrices = webElement.getText().split("-");
        double minPrice = getPriceByString(minAndMaxPrices[0]);
        double maxPrice;
        if (minAndMaxPrices.length == 2) {
            maxPrice = getPriceByString(minAndMaxPrices[1]);
        }
        else {
            maxPrice = minPrice;
        }
        return new double[]{minPrice, maxPrice};
    }

    @Test
    public void checkSortByPriceLowToHigh() {
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);

        getDealsAndPromotionsPage().clickOnTheSortByButton();
        getBasePage().waitForElementVisibility(10, getDealsAndPromotionsPage().getSortByPriceLowToHighButton());

        getDealsAndPromotionsPage().clickOnTheSortByPriceLowToHighButton();
        getBasePage().waitForElementVisibility(10, getDealsAndPromotionsPage().getSortByButton());

        List<Double> prices = getPricesFromWebElements(getDealsAndPromotionsPage().getPriceLabels());

        for (int i = 1; i < prices.size(); i++) {
            assertTrue(prices.get(i - 1) <= prices.get(i));
        }
    }


    @Test
    public void checkFilteringByPriceRange() {
        getHeaderComponent().clickOnTheDealsLink();
        getBasePage().waitForPageReadyState(10);

        getDealsAndPromotionsPage().clickOnTheFrom50To100DollarsButton();
        getBasePage().waitForElementVisibility(10, getDealsAndPromotionsPage().getFrom50To100DollarsButton());

        for (WebElement priceLabel : getDealsAndPromotionsPage().getPriceLabels()) {
            double[] prices = getMinAndMaxPricesFromWebElement(priceLabel);
            assertTrue(prices[0] < MAX_PRICE);
            assertTrue(prices[1] > MIN_PRICE);
        }


    }
}
