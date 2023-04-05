package kamildemo.models;

import kamildemo.components.SearchResultsFilterComponent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class FilterModel {

    private int priceFrom;
    private int priceTo;
    private Map<SearchResultsFilterComponent.RoomFacilities, Integer> roomFacilities;
    private List<String> amenities;
}
