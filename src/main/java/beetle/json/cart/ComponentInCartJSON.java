package beetle.json.cart;

import beetle.entity.BaseEntity;
import beetle.enums.ComponentType;

public class ComponentInCartJSON {
    private ComponentType componentType;
    private BaseEntity component;
    private int quantity;

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public BaseEntity getComponent() {
        return component;
    }

    public void setComponent(BaseEntity component) {
        this.component = component;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
