package beetle.json.fork;

import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ForkSearchResultResponseJSON extends PaggingJSON {
    private List<ForkJSON> forks;
}
