package tests;

import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    private static final String SEARCH_WORD = "skirt";

    @Test
    public void checkThatUrlContainsSearchWord() {
        getHeaderComponent().enterTextIntoSearchInput(SEARCH_WORD);
        assertTrue(getDriver().getCurrentUrl().contains(SEARCH_WORD));
    }


}
