package beetle.json.handlebar;

import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandlebarJSON extends BaseJSON {
    private Long id;
    private String bikeType;
    private Long bikeTypeId;
    private String handlebarWide;
    private Double handlebarDiameter;
    private String handlebarHeight;
}
