package beetle.json.handlebar;

import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WindingJSON extends BaseJSON {
    private long id;
    private String length;
    private String wide;
}
