package beetle.service;

import beetle.enums.ComponentType;

import java.util.List;
import java.util.Map;

public interface CartService {
    void addToCart(ComponentType component, Long id);

    Map<ComponentType, List<Long>> getAllComponentsFromCart();

    List<Long> getComponentsFromCart(ComponentType componentType);

}
