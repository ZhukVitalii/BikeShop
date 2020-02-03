package beetle.json;

import beetle.json.BaseJSON;
import beetle.json.PaggingJSON;

import java.util.List;

public class SearchResultResponseJSON extends PaggingJSON {
    private List<? extends BaseJSON> result;

    public List<? extends BaseJSON> getResult() {
        return result;
    }

    public void setResult(List<? extends BaseJSON> result) {
        this.result = result;
    }
}
