package beetle.json.handlebar;

import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WindingSearchInputJSON extends PaggingJSON {
    private String length;
    private String wide;
    private Long manufacturerId;
}
