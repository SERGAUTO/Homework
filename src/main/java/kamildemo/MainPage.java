package kamildemo;

import kamildemo.components.MainPageFilterComponent;
import lombok.Getter;

public class MainPage {

    @Getter
    private final MainPageFilterComponent filterComponent;

    public MainPage() {
        this.filterComponent = new MainPageFilterComponent();
    }
}
