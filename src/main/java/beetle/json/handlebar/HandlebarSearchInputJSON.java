package beetle.json.handlebar;

import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandlebarSearchInputJSON extends PaggingJSON {
    private Long bikeTypeId;
    private String handlebarWide;
    private Double handlebarDiameter;
    private String handlebarHeight;
    private Long manufacturerId;
}
