package beetle.json.wheel;

import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TireSearchInputJSON extends PaggingJSON{
    private Long wheelsDiamId;
    private String tireType;
    private Double tireWide;
    private Long manufacturerId;
}
