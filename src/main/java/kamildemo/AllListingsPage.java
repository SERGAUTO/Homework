package kamildemo;

import com.codeborne.selenide.CollectionCondition;
import org.apache.commons.lang3.StringUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AllListingsPage {

    public AllListingsPage() {
        $$(".sc-tsGVs.hebieQ").shouldHave(CollectionCondition.sizeGreaterThan(1))
                .shouldHave(CollectionCondition.size(0));
    }

    public int getCountOfListingItems() {
        var items = $$("[href*=listing]");
        items.last().scrollIntoView(true);
        var allLabelCount = getAllLabelCount();
        while ($("div~.sc-bdnxRM.jFodJP").isDisplayed() || items.size() < allLabelCount) {
            items.last().scrollIntoView(true);
        }
        return items.size();
    }

    public int getAllLabelCount() {
        return Integer.parseInt($(".lkeyLH span").getText().replace("(", StringUtils.EMPTY)
                .replace(")", StringUtils.EMPTY));
    }
}
