package beetle.json.handlebar;

import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StemSearchInputJSON extends PaggingJSON {
    private String angle;
    private Double handlebarDiameter;
    private Long tubeDiameterId;
    private String length;
    private Long manufacturerId;
}
