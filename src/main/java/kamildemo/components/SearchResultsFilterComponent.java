package kamildemo.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import kamildemo.models.FilterModel;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsFilterComponent {

    private ElementsCollection roomFacilities = $$(".sc-jdXKxY.eyBvYR");

    private static List<String> getConfiguredAmenities() {
        return $$("#id")
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .filter(Condition.checked).snapshot().asDynamicIterable().stream()
                .map(el -> el.sibling(0).text()).collect(Collectors.toList());
    }

    public SearchResultsFilterComponent filterBy(FilterModel filterModel) {
        Optional.of(filterModel.getPriceFrom())
                .ifPresent(p -> $("[placeHolder='From']").sendKeys(String.valueOf(p)));
        Optional.of(filterModel.getPriceTo())
                .ifPresent(p -> $("[placeHolder='To']").sendKeys(String.valueOf(p)));
        Optional.ofNullable(filterModel.getRoomFacilities()).ifPresent(map -> map.forEach(this::setRoomFacility));
        Optional.ofNullable(filterModel.getAmenities()).ifPresent(amenities -> {
            var amenitiesLocator = $$(".kFnlxQ~.beqNry .krkYvd").snapshot();
            amenities.forEach(amenity -> amenitiesLocator.find(Condition.text(amenity)).click());
        });
        return this;
    }

    public FilterModel getConfiguredFilters() {
        var configuredRoomFacilities = getConfiguredRoomFacilities();
        var amenities = getConfiguredAmenities();
        return FilterModel.builder()
                .priceFrom(Integer.parseInt($("[placeHolder='From']").getValue()))
                .priceTo(Integer.parseInt($("[placeHolder='To']").getValue()))
                .roomFacilities(configuredRoomFacilities)
                .amenities(amenities)
                .build();
    }

    private void setRoomFacility(RoomFacilities roomFacility, int amount) {
        var facilityLocator = roomFacilities.find(Condition.text(roomFacility.name()));
        int facilityCount = Integer.parseInt(facilityLocator.$(".gnLtVL").text());
        if (facilityCount < amount) {
            IntStream.range(0, amount).forEach(i -> facilityLocator.$(".fKwyEY").click());
        }
        if (facilityCount > amount) {
            IntStream.range(0, amount).forEach(i -> facilityLocator.$(".cnkbFD").click());
        }
    }

    public SearchResultsFilterComponent clearAll() {
        $(".sc-jHcXXw.lkkECO b").click();
        return this;
    }

    public SearchResultsFilterComponent verifyFiltersCleared() {
        $$(".sc-gstuGz.kqWUWP").should(CollectionCondition.allMatch("Should be empty", el ->
                el.getText().equalsIgnoreCase(StringUtils.EMPTY)));
        $$(".sc-gVFcvn.gnLtVL").shouldHave(CollectionCondition.texts("0", "0", "0"));
        $$(".sc-htmcrh.emRwHY").should(CollectionCondition.allMatch("Should be unchecked",
                el -> !el.isSelected()));
        return this;
    }

    private Map<RoomFacilities, Integer> getConfiguredRoomFacilities() {
        return roomFacilities.asDynamicIterable().stream().collect(Collectors.toMap(
                el -> RoomFacilities.valueOf(el.$(".bqNXll").text().toUpperCase()),
                el -> Integer.valueOf(el.$(".gnLtVL").text())));
    }

    public enum RoomFacilities {
        BEDS, BEDROOMS, BATHROOMS
    }

}
