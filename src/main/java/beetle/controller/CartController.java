package beetle.controller;

import beetle.businessObjects.Cart;
import beetle.entity.brake.BrakeDiscHydraulic;
import beetle.entity.brake.BrakeDiscMechanik;
import beetle.entity.brake.BrakeHandle;
import beetle.entity.brake.BrakeVBrake;
import beetle.entity.forks.Fork;
import beetle.entity.frame.Frame;
import beetle.entity.handlebars.*;
import beetle.entity.transmission.*;
import beetle.entity.wheels.*;
import beetle.enums.ComponentType;
import beetle.json.AddToCartInputJSON;
import beetle.mapper.JSONMapper;
import beetle.service.*;
import beetle.service.impl.FrameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.xml.ws.Response;
import java.util.ArrayList;
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
