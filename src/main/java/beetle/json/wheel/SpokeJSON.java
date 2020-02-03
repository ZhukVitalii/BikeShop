package beetle.json.wheel;

import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpokeJSON extends BaseJSON {
    private String length;
    private String diameter;
}
