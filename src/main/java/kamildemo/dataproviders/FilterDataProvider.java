package kamildemo.dataproviders;

import kamildemo.components.SearchResultsFilterComponent;
import kamildemo.enums.Amenities;
import kamildemo.models.FilterModel;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

public class FilterDataProvider {

    @DataProvider
    public static Object[][] filtersProvider() {
        return new Object[][]{
                {
                        FilterModel.builder().priceFrom(100).priceTo(130)
                                .amenities(List.of(
                                        Amenities.FREE_WIFI.getValue(),
                                        Amenities.AIR_CONDITIONING.getValue(),
                                        Amenities.WASHING_MACHINE.getValue()))
                                .roomFacilities(Map.of(
                                        SearchResultsFilterComponent.RoomFacilities.BEDS, 4,
                                        SearchResultsFilterComponent.RoomFacilities.BATHROOMS, 1,
                                        SearchResultsFilterComponent.RoomFacilities.BEDROOMS, 2))
                                .build()
                },
                {
                        FilterModel.builder().priceFrom(300).priceTo(800)
                                .amenities(List.of(
                                        Amenities.WASHING_MACHINE.getValue()))
                                .roomFacilities(Map.of(
                                        SearchResultsFilterComponent.RoomFacilities.BEDS, 1,
                                        SearchResultsFilterComponent.RoomFacilities.BATHROOMS, 10,
                                        SearchResultsFilterComponent.RoomFacilities.BEDROOMS, 0))
                                .build()
                },
                {
                        FilterModel.builder().priceFrom(300).priceTo(800)
                                .roomFacilities(Map.of(
                                        SearchResultsFilterComponent.RoomFacilities.BEDS, 0,
                                        SearchResultsFilterComponent.RoomFacilities.BATHROOMS, 0,
                                        SearchResultsFilterComponent.RoomFacilities.BEDROOMS, 0))
                                .build()
                }
        };
    }
}
