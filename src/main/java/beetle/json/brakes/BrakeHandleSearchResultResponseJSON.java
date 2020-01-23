package beetle.json.brakes;

import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BrakeHandleSearchResultResponseJSON extends PaggingJSON {
    private List<BrakeHandleJSON> brakeHandles;
}
