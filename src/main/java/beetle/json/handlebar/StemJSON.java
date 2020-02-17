package beetle.json.handlebar;

import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StemJSON extends BaseJSON {
    private long id;
    private String angle;
    private Double handlebarDiameter;
    private String tubeDiameter;
    private Long tubeDiameterId;
    private String length;

}
