package beetle;

import beetle.Bakes.BikeService;
import beetle.Bakes.BikeType;
import beetle.Bakes.CartRepository;
import beetle.Bakes.CartService;
import beetle.Brakes.BrakeService;
import beetle.Forks.Fork;
import beetle.Forks.ForkService;
import beetle.Frames.Frame;
import beetle.Frames.FrameService;
import beetle.Frames.FrameSize;
import beetle.Handlebars.Handlebar;
import beetle.Handlebars.HandlebarService;
import beetle.Transmissions.TransmissionService;
import beetle.Wheels.WheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 07.07.2017.
 */
@Controller
public class UserController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;




    @Autowired
    private TransmissionService transmissionService;
    @Autowired
    private WheelService wheelService;
    @Autowired
    private BrakeService brakeService;
    @Autowired
    private ForkService forkService;
    @Autowired
    private FrameService frameService;
    @Autowired
    private HandlebarService handlebarService;
    @Autowired
    private BikeService bikeService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartService cartService;

    @RequestMapping("/MTB_page")
    public String mtbVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        BikeType bikeType = frameService.findBikeType(1);

        List<Frame> frames = frameService.
                findByBikeType(bikeType ,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frameMakers", frameService.findFrameMakers());
        model.addAttribute("frameSizes", frameService.findFrameSize());
        model.addAttribute("trunkBindings", frameService.findTrunkBinding());
        model.addAttribute("bikeTypes", frameService.findBikeType());
        model.addAttribute("bracketWides", frameService.findBracketWide());
        model.addAttribute("headsetTypes", frameService.findHeadsetType());
        model.addAttribute("tubeDiameters", frameService.findTubeDiameter());
        model.addAttribute("underSaddleTubes", frameService.findUnderSaddleTube());
        model.addAttribute("brakesTypes", frameService.findBrakesType());

        model.addAttribute("frames", frames);

        return "mtbBike";
    }
    @RequestMapping("/Shosse_page")
    public String shosseVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        BikeType bikeType = frameService.findBikeType(2);

        List<Frame> frames = frameService.
                findByBikeType(bikeType ,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frameMakers", frameService.findFrameMakers());
        model.addAttribute("frameSizes", frameService.findFrameSize());
        model.addAttribute("trunkBindings", frameService.findTrunkBinding());
        model.addAttribute("bikeTypes", frameService.findBikeType());
        model.addAttribute("bracketWides", frameService.findBracketWide());
        model.addAttribute("headsetTypes", frameService.findHeadsetType());
        model.addAttribute("tubeDiameters", frameService.findTubeDiameter());
        model.addAttribute("underSaddleTubes", frameService.findUnderSaddleTube());
        model.addAttribute("brakesTypes", frameService.findBrakesType());

        model.addAttribute("frames", frames);

        return "shosseBike";
    }
    @RequestMapping("/City_page")
    public String cityVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        BikeType bikeType = frameService.findBikeType(3);

        List<Frame> frames = frameService.
                findByBikeType(bikeType ,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frameMakers", frameService.findFrameMakers());
        model.addAttribute("frameSizes", frameService.findFrameSize());
        model.addAttribute("trunkBindings", frameService.findTrunkBinding());
        model.addAttribute("bikeTypes", frameService.findBikeType());
        model.addAttribute("bracketWides", frameService.findBracketWide());
        model.addAttribute("headsetTypes", frameService.findHeadsetType());
        model.addAttribute("tubeDiameters", frameService.findTubeDiameter());
        model.addAttribute("underSaddleTubes", frameService.findUnderSaddleTube());
        model.addAttribute("brakesTypes", frameService.findBrakesType());

        model.addAttribute("frames", frames);

        return "cityBike";
    }


    @RequestMapping("/chooseMTBSize")
    public String chooseMTBSizeVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<FrameSize> frameSizes = frameService.findFrameSize();

        model.addAttribute("framesizes", frameService.findFrameSize());
        model.addAttribute("framesizes", frameSizes);
        return "chooseMTBSize";
    }
    @RequestMapping("/chooseShosseSize")
    public String chooseShosseSizeVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<FrameSize> frameSizes = frameService.findFrameSize();

        model.addAttribute("framesizes", frameService.findFrameSize());
        model.addAttribute("framesizes", frameSizes);
        return "chooseShosseSize";
    }
    @RequestMapping("/chooseCitySize")
    public String chooseCitySizeVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<FrameSize> frameSizes = frameService.findFrameSize();

        model.addAttribute("framesizes", frameService.findFrameSize());
        model.addAttribute("framesizes", frameSizes);
        return "chooseCITYSize";
    }



    @RequestMapping("/frame/{url}")
    public String listFrameUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {



        if (page < 0) page = 0;

        List<Frame> frames = frameService
                .findByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));


        model.addAttribute("frameMakers", frameService.findFrameMakers());
        model.addAttribute("frameSizes", frameService.findFrameSize());
        model.addAttribute("trunkBindings", frameService.findTrunkBinding());
        model.addAttribute("bikeTypes", frameService.findBikeType());
        model.addAttribute("bracketWides", frameService.findBracketWide());
        model.addAttribute("headsetTypes", frameService.findHeadsetType());
        model.addAttribute("tubeDiameters", frameService.findTubeDiameter());
        model.addAttribute("underSaddleTubes", frameService.findUnderSaddleTube());
        model.addAttribute("brakesTypes", frameService.findBrakesType());


        model.addAttribute("frames", frames);


        return "OneFrame";
    }


    @RequestMapping("/framesMTB/{id}")
    public String listFrameMTBSize(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {


        if (page < 0) page = 0;

        BikeType bikeType = frameService.findBikeType(1);
        FrameSize frameSize = frameService.findFrameSize(id);

        List<Frame> frames = frameService
                .findByTypeAndSize(bikeType,frameSize, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));


        model.addAttribute("frameMakers", frameService.findFrameMakers());
        model.addAttribute("frameSizes", frameService.findFrameSize());
        model.addAttribute("trunkBindings", frameService.findTrunkBinding());
        model.addAttribute("bikeTypes", frameService.findBikeType());
        model.addAttribute("bracketWides", frameService.findBracketWide());
        model.addAttribute("headsetTypes", frameService.findHeadsetType());
        model.addAttribute("tubeDiameters", frameService.findTubeDiameter());
        model.addAttribute("underSaddleTubes", frameService.findUnderSaddleTube());
        model.addAttribute("brakesTypes", frameService.findBrakesType());


        model.addAttribute("frames", frames);


        return "mtbBike";
    }

    @RequestMapping("/framesShosse/{id}")
    public String listFrameShosseSize(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;

        BikeType bikeType = frameService.findBikeType(2);
        FrameSize frameSize = frameService.findFrameSize(id);

        List<Frame> frames = frameService
                .findByTypeAndSize(bikeType,frameSize, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frameMakers", frameService.findFrameMakers());
        model.addAttribute("frameSizes", frameService.findFrameSize());
        model.addAttribute("trunkBindings", frameService.findTrunkBinding());
        model.addAttribute("bikeTypes", frameService.findBikeType());
        model.addAttribute("bracketWides", frameService.findBracketWide());
        model.addAttribute("headsetTypes", frameService.findHeadsetType());
        model.addAttribute("tubeDiameters", frameService.findTubeDiameter());
        model.addAttribute("underSaddleTubes", frameService.findUnderSaddleTube());
        model.addAttribute("brakesTypes", frameService.findBrakesType());
        model.addAttribute("frames", frames);


        return "shosseBike";
    }
    @RequestMapping("/framesCity/{id}")
    public String listFrameCitySize(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {


        if (page < 0) page = 0;

        BikeType bikeType = frameService.findBikeType(3);
        FrameSize frameSize = frameService.findFrameSize(id);

        List<Frame> frames = frameService
                .findByTypeAndSize(bikeType,frameSize, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("frameMakers", frameService.findFrameMakers());
        model.addAttribute("frameSizes", frameService.findFrameSize());
        model.addAttribute("trunkBindings", frameService.findTrunkBinding());
        model.addAttribute("bikeTypes", frameService.findBikeType());
        model.addAttribute("bracketWides", frameService.findBracketWide());
        model.addAttribute("headsetTypes", frameService.findHeadsetType());
        model.addAttribute("tubeDiameters", frameService.findTubeDiameter());
        model.addAttribute("underSaddleTubes", frameService.findUnderSaddleTube());
        model.addAttribute("brakesTypes", frameService.findBrakesType());


        model.addAttribute("frames", frames);


        return "cityBike";
    }




    @RequestMapping("/cartAddFrame/{article}")
    public String listArticleFrame(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        cartService.addToArticle(article);
        return "redirect:/show_frames";
    }

    @RequestMapping("/cartAddFork/{article}")
    public String listArticleFork(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;

        forkService.addToArticle(article);
        return "redirect:/show_forks";
    }
    @RequestMapping("/cartAddHandlebar/{article}")
    public String listArticleHandlebar(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;

        handlebarService.addToArticle(article);
        return "redirect:/show_handlebars";
    }



    @RequestMapping("/cart")

    public String framesVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Frame> frames = new ArrayList<Frame>();
        List<Fork> forks = new ArrayList<Fork>();
        List<Handlebar> handlebars = new ArrayList<Handlebar>();

        for (int i = 0; i < cartService.getSize(); i++) {
            System.out.println("артиклі рами в корзині" + " " + cartService.getArticleFromCart(i));
            List<Frame> frame = frameService
                    .findByArticle(cartService.getArticleFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            frames.add(frame.get(0));
        }
        for (int i = 0; i < forkService.getSize(); i++) {
            System.out.println("артиклі вилок в корзині" + " " + forkService.getArticleFromCart(i));
            List<Fork> fork = forkService
                    .findByArticle(forkService.getArticleFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            forks.add(fork.get(0));
        }
        for (int i = 0; i < handlebarService.getSize(); i++) {
            System.out.println("артиклі рулів в корзині" + " " + handlebarService.getArticleFromCart(i));
            List<Handlebar> handlebar = handlebarService
                    .findByArticle(handlebarService.getArticleFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            handlebars.add(handlebar.get(0));
        }

        model.addAttribute("frameMakers", frameService.findFrameMakers());
        model.addAttribute("frameSizes", frameService.findFrameSize());
        model.addAttribute("trunkBindings", frameService.findTrunkBinding());
        model.addAttribute("bikeTypes", frameService.findBikeType());
        model.addAttribute("bracketWides", frameService.findBracketWide());
        model.addAttribute("headsetTypes", frameService.findHeadsetType());
        model.addAttribute("tubeDiameters", frameService.findTubeDiameter());
        model.addAttribute("underSaddleTubes", frameService.findUnderSaddleTube());
        model.addAttribute("brakesTypes", frameService.findBrakesType());
        model.addAttribute("forkMakers", forkService.findForkMakers());
        model.addAttribute("bikeTypes", forkService.findBikeType());
        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        model.addAttribute("wheelsDiams", forkService.findWheelsDiam());
        model.addAttribute("brakesTypes", forkService.findBrakesType());
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("bikeType", handlebarService.findBikeType());
        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());
        model.addAttribute("handlebars", handlebars);
        model.addAttribute("forks", forks);
        model.addAttribute("frames", frames);
        System.out.println("всього рам в корзині в корзині" +" = "+ frames.size());
        System.out.println("всього вилок в корзині в корзині"+" = " + forks.size());
        System.out.println("всього рулів в корзині в корзині" +" = "+ handlebars.size());



            return "cart";

        }
    @RequestMapping("/chooseFork/{name}/{url}")
    public String listForkForMTB(
            @PathVariable(value = "name") String name,
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {


        if (page < 0) page = 0;

     System.out.println("Вибрано тип " + name);
     System.out.println("Вибрано діаметер колес" + url);


        return "show_forks";
    }


    }


