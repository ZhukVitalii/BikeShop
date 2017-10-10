package beetle.Secirity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Created by VitaliiZhuk on 10.10.2017.
 */
@Controller
public class SecurityController {

    //Return page for login
    @RequestMapping("/login")
    public String login (Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        return "login";
    }

    @RequestMapping("/admin")
    public String indexAdmin (Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        return "indexAdmin";
    }
}
