package uz.alpinizm.kamildemo;

import kamildemo.MainPage;
import kamildemo.components.SearchResultsFilterComponent;
import kamildemo.dataproviders.FilterDataProvider;
import kamildemo.enums.Amenities;
import kamildemo.models.FilterModel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FilterTests extends BaseTest {

    private SearchResultsFilterComponent searchResultsFilterComponent;

    @BeforeMethod(alwaysRun = true)
    public void configure() {
        searchResultsFilterComponent = new MainPage().getFilterComponent()
                .clickSearch()
                .selectDate(LocalDate.now().plusDays(3), LocalDate.now().plusDays(5))
                .clickFilter();
    }

    @Test(dataProvider = "filtersProvider", dataProviderClass = FilterDataProvider.class)
    public void testFilterResults(FilterModel filterModel) {
        var configuredFilters = searchResultsFilterComponent.filterBy(filterModel)
                .getConfiguredFilters();
        Assertions.assertThat(filterModel).usingRecursiveComparison()
                .ignoringActualNullFields()
                .ignoringExpectedNullFields()
                .isEqualTo(configuredFilters);
    }

    @Test
    public void testFilterReset() {
        var filterModel = FilterModel.builder().priceFrom(1000).priceTo(1300)
                .amenities(List.of(Amenities.FREE_WIFI.getValue(), Amenities.AIR_CONDITIONING.getValue()))
                .roomFacilities(Map.of(
                        SearchResultsFilterComponent.RoomFacilities.BEDS, 2,
                        SearchResultsFilterComponent.RoomFacilities.BATHROOMS, 3,
                        SearchResultsFilterComponent.RoomFacilities.BEDROOMS, 4))
                .build();
        searchResultsFilterComponent.filterBy(filterModel)
                .clearAll()
                .verifyFiltersCleared();
    }
}
