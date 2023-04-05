package kamildemo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import kamildemo.components.SearchResultsFilterComponent;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static kamildemo.enums.DateType.CHECK_IN;

public class SearchResults {

    private static void clickDate(ElementsCollection availableMonths, LocalDate checkIn) {
        availableMonths.find(Condition.partialText(checkIn.getMonth().name()))
                .sibling(0).$$(".CalendarDay")
                .find(Condition.text(String.valueOf(checkIn.getDayOfMonth()))).click();

    }

    private static int normalizeItem(SelenideElement parent, String expectedItem) {
        return Integer.parseInt(parent.$$(".sc-QxirK.fWxumN").find(Condition.partialText(expectedItem)).text()
                .split(StringUtils.SPACE)[0]);
    }

    /***
     * This is a draft version of calendar component, it should be designed in a more sophisticated way
     */
    public SearchResults selectDate(LocalDate checkIn, LocalDate checkOut) {
        $$(".sc-gsWcmt.fdrZCU").find(Condition.text(CHECK_IN.getValue())).click();
        var availableMonths = $$(".sc-dtLLSn.dpehyt").snapshot();
        clickDate(availableMonths, checkIn);
        clickDate(availableMonths, checkOut);
        $(".sc-tsGVs.hebieQ").should(Condition.appear).should(Condition.disappear);
        return this;
    }

 /*   public List<SearchResultItem> getSearchResults() {
        return $$(".sc-kGVuwA.kyEhLJ").asDynamicIterable().stream().map(item -> {
            SearchResultItem searchResultItem = new SearchResultItem();
            searchResultItem.setGuests(normalizeItem(item, SearchResultItem.Fields.guests));
            searchResultItem.setBedroom(normalizeItem(item, SearchResultItem.Fields.bedroom));
            searchResultItem.setBath(normalizeItem(item, SearchResultItem.Fields.bath));
            searchResultItem.setPrice(Integer.parseInt(item.$(".iWEpkn").text().split("€")[1]));
            searchResultItem.setAmenities(item.$$(".fACUIs").texts());
            return searchResultItem;
        }).collect(Collectors.toList());
    }*/

    public SearchResultsFilterComponent clickFilter() {
        $(".sc-fvNhHS").click();
        return new SearchResultsFilterComponent();
    }
}
