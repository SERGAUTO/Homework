package kamildemo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DateType {

    CHECK_IN("Check-in"),
    CHECK_OUT("Check-out");

    private final String value;

}
