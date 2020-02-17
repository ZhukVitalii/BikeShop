package beetle.json.handlebar;

import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeadsetSearchInputJSON extends PaggingJSON {
    private Long headsetTypeId;
    private Long tubeDiameterId;
    private String size;
    private Long manufacturerId;
}
