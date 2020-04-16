package beetle.service.impl;

import beetle.bo.Cart;
import beetle.enums.ComponentType;
import beetle.service.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class CartServiceImpl implements CartService {
    @Override
    public void addToCart(ComponentType component, Long id) {
        List<Long> ids = Cart.getComponentsInCart().get(component);
        if (ids == null)
            ids = new ArrayList<>();
        ids.add(id);
        Cart.getComponentsInCart().put(component,ids);
    }

    @Override
    public Map<ComponentType, List<Long>> getAllComponentsFromCart() {
        return Cart.getComponentsInCart();
    }

    @Override
    public List<Long> getComponentsFromCart(ComponentType componentType) {
        return Cart.getComponentsInCart().get(componentType);
    }
}
