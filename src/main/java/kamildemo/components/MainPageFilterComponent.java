package kamildemo.components;

import com.codeborne.selenide.SelenideElement;
import kamildemo.SearchResults;

import static com.codeborne.selenide.Selenide.$;

public class MainPageFilterComponent {

    private final SelenideElement searchButton = $(".sc-geBCVM");

    public SearchResults clickSearch() {
        searchButton.click();
        return new SearchResults();
    }
}
