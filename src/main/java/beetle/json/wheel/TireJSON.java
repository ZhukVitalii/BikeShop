package beetle.json.wheel;

import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TireJSON extends BaseJSON {
    private long id;
    private String wheelsDiam;
    private Long wheelsDiamId;
    private String tireType;
    private String cordType;
    private Double tireWide;
}
