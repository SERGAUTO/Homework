package kamildemo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum HeaderItems {

    ALL_LISTINGS("All listings");

    @Getter
    private final String value;
}
