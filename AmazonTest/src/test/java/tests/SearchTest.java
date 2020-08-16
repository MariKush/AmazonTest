package tests;

import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    private static final String EXISTENT_SEARCH_WORD = "skirt";
    private static final String NON_EXISTENT_SEARCH_WORD = "qwertyuiopasdf";


    @Test
    public void checkThatUrlContainsSearchWord() {
        getHeaderComponent().enterTextIntoSearchInput(EXISTENT_SEARCH_WORD);
        assertTrue(getDriver().getCurrentUrl().contains(EXISTENT_SEARCH_WORD));
    }

    @Test
    public void checkSearchResultWithNonExistentSearchWord(){
        getHeaderComponent().enterTextIntoSearchInput(NON_EXISTENT_SEARCH_WORD);
        getBasePage().waitForPageReadyState(10);
        assertTrue(getSearchedPage().getNoResultsLabel().isDisplayed());

    }


}
