package uz.alpinizm.kamildemo;

import kamildemo.AllListingsPage;
import kamildemo.components.HeaderComponent;
import kamildemo.enums.HeaderItems;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ListingTests extends BaseTest {

    @Test
    public void test_listing_count() {
        new HeaderComponent().navigate(HeaderItems.ALL_LISTINGS);
        var allListingsPage = new AllListingsPage();
        var allLabelCount = allListingsPage.getAllLabelCount();
        var listingItemsCount = allListingsPage.getCountOfListingItems();
        Assertions.assertThat(allLabelCount).as("Actual number of items: %s, expected: %s",
                allLabelCount, listingItemsCount).isEqualTo(listingItemsCount);
    }
}
