package beetle.controller;

import beetle.enums.ComponentType;
import beetle.json.cart.AddToCartInputJSON;
import beetle.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    public ResponseEntity addToCart(@RequestBody AddToCartInputJSON input) {
        cartService.addToCart(input.getComponent(), input.getArticle());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/get-cart", method = RequestMethod.GET)
    public ResponseEntity getCart() {
        Map<ComponentType, List<Long>> cart =  cartService.getAllComponentsFromCart();
        return ResponseEntity.ok(cart);
    }

}
