package kamildemo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Amenities {

    FREE_WIFI("Free WiFi"),
    AIR_CONDITIONING("Air conditioning"),
    SWIMMING_POOL("Swimming pool"),
    SUITABLE_FOR_CHILDREN("Suitable for children"),
    WASHING_MACHINE("Washing Machine");

    @Getter
    private String value;
}
