package beetle.bo;

import beetle.enums.ComponentType;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionScope
public final class Cart {
    private Cart() {
    }

    private static Map<ComponentType, List<Long>> componentsInCart = new HashMap<>() ;

    public static Map<ComponentType, List<Long>> getComponentsInCart() {
        return componentsInCart;
    }
}
