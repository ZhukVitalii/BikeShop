package beetle.json;

import java.util.List;

public class CartResponseJSON {
    private int total;
    private List<ComponentInCartJSON> components;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ComponentInCartJSON> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentInCartJSON> components) {
        this.components = components;
    }
}
