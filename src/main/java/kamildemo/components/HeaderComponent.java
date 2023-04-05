package kamildemo.components;

import com.codeborne.selenide.Condition;
import kamildemo.enums.HeaderItems;

import static com.codeborne.selenide.Selenide.$$;

public class HeaderComponent {

    public void navigate(HeaderItems headerItem) {
        $$(".hebeYX").find(Condition.text(headerItem.getValue())).click();
    }
}
