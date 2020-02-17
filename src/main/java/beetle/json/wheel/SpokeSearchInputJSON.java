package beetle.json.wheel;

import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpokeSearchInputJSON extends PaggingJSON {
    private String diameter;
    private String length;
    private Long manufacturerId;
}
