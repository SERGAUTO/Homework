package kamildemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@FieldNameConstants
public class SearchResultItem {

    private int guests;
    private int bedroom;
    private int bath;
    private int price;
    private List<String> amenities;
}
