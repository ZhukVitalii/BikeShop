package beetle.json;

import java.util.List;

public class SearchResultResponseJSON extends PaggingJSON {
    private List<? extends BaseJSON> resultResponse;

    public List<? extends BaseJSON> getResultResponse() {
        return resultResponse;
    }

    public void setResultResponse(List<? extends BaseJSON> resultResponse) {
        this.resultResponse = resultResponse;
    }
}
