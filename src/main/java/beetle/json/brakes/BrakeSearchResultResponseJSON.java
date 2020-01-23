package beetle.json.brakes;

import beetle.json.PaggingJSON;

import java.util.List;

public class BrakeSearchResultResponseJSON extends PaggingJSON {
    private List<BrakeJSON> brakes;

    public List<BrakeJSON> getBrakes() {
        return brakes;
    }

    public void setBrakes(List<BrakeJSON> brakes) {
        this.brakes = brakes;
    }
}
