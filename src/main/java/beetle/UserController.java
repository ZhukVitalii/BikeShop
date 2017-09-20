package beetle;

import beetle.Bakes.BikeService;
import beetle.Bakes.BikeType;
import beetle.Bakes.CartRepository;
import beetle.Bakes.CartService;
import beetle.Brakes.*;
import beetle.Forks.Fork;
import beetle.Forks.ForkService;
import beetle.Frames.Frame;
import beetle.Frames.FrameService;
import beetle.Frames.FrameSize;
import beetle.Handlebars.*;
import beetle.Transmissions.TransmissionService;
import beetle.Wheels.*;
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

        model.addAttribute("frames", frames);

        return "mtbBike";
    }
    @RequestMapping("/Shosse_page")
    public String shosseVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        BikeType bikeType = frameService.findBikeType(2);

        List<Frame> frames = frameService.
                findByBikeType(bikeType ,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("frames", frames);

        return "shosseBike";
    }
    @RequestMapping("/City_page")
    public String cityVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        BikeType bikeType = frameService.findBikeType(3);

        List<Frame> frames = frameService.
                findByBikeType(bikeType ,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);

        return "cityBike";
    }


    @RequestMapping("/chooseMTBSize")
    public String chooseMTBSizeVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<FrameSize> frameSizes = frameService.findFrameSize();
        model.addAttribute("framesizes", frameSizes);
        return "chooseMTBSize";
    }
    @RequestMapping("/chooseShosseSize")
    public String chooseShosseSizeVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<FrameSize> frameSizes = frameService.findFrameSize();
        model.addAttribute("framesizes", frameSizes);
        return "chooseShosseSize";
    }
    @RequestMapping("/chooseCitySize")
    public String chooseCitySizeVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<FrameSize> frameSizes = frameService.findFrameSize();
        model.addAttribute("framesizes", frameSizes);
        return "chooseCITYSize";
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
        ;
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

        handlebarService.addToArticleHandlebar(article);
        return "redirect:/show_handlebars";
    }
    @RequestMapping("/cartAddStem/{article}")
    public String listArticleStem(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        handlebarService.addToArticleStem(article);
        return "redirect:/show_stems";
    }
    @RequestMapping("/cartAddGrips/{article}")
    public String listArticleGrips(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        handlebarService.addToArticleGrips(article);
        return "redirect:/show_grips";
    }
    @RequestMapping("/cartAddHeadset/{article}")
    public String listArticleHeadset(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        handlebarService.addToArticleHeadset(article);
        return "redirect:/show_headsets";
    }
    @RequestMapping("/cartAddWinding/{article}")
    public String listArticleWinding(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        handlebarService.addToArticleWinding(article);
        return "redirect:/show_windings";
    }
    @RequestMapping("/cartAddBrakeDiscHydraulic/{article}")
    public String listArticleBrakeDiscHydraulic(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        brakeService.addToArticleBrakeDiscHydraulic(article);
        return "redirect:/show_brakesHydro";
    }
    @RequestMapping("/cartAddBrakeDiscMechanik/{article}")
    public String listArticleBrakeDiscMechanik(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        brakeService.addToArticleBrakeDiscMechanik(article);
        return "redirect:/show_brakesMech";
    }
    @RequestMapping("/cartAddBrakeVBrake/{article}")
    public String listArticleBrakeVBrake(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        brakeService.addToArticleBrakeVBrake(article);
        return "redirect:/show_brakesVBrake";
    }
    @RequestMapping("/cartAddBrakeHandle/{article}")
    public String listArticleBrakeHandle(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        brakeService.addToArticleBrakeHandle(article);
        return "redirect:/show_brakesHandle";
    }
    @RequestMapping("/cartAddWheel/{article}")
    public String listArticleWheel(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        wheelService.addToArticleWheel(article);
        return "redirect:/show_wheels";
    }
    @RequestMapping("/cartAddBackHub/{article}")
    public String listArticleBackHub(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        wheelService.addToArticleBackHub(article);
        return "redirect:/show_backHubs";
    }
    @RequestMapping("/cartAddFrontHub/{article}")
    public String listArticleFrontHub(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        wheelService.addToArticleFrontHub(article);
        return "redirect:/show_frontHubs";
    }
    @RequestMapping("/cartAddRim/{article}")
    public String listArticleRim(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        wheelService.addToArticleRim(article);
        return "redirect:/show_rims";
    }
    @RequestMapping("/cartAddSpoke/{article}")
    public String listArticleSpoke(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        wheelService.addToArticleSpoke(article);
        return "redirect:/show_spokes";
    }
    @RequestMapping("/cartAddTire/{article}")
    public String listArticleTire(
            @PathVariable(value = "article") Long article,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        wheelService.addToArticleTire(article);
        return "redirect:/show_tires";
    }





    @RequestMapping("/cart")

    public String cartVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Frame> frames = new ArrayList<Frame>();
        List<Fork> forks = new ArrayList<Fork>();
        List<Handlebar> handlebars = new ArrayList<Handlebar>();
        List<Stem> stems = new ArrayList<Stem>();
        List<Grips> grips = new ArrayList<Grips>();
        List<Headset> headsets = new ArrayList<Headset>();
        List<Winding> windings = new ArrayList<Winding>();
        List<BrakeDiscHydraulic> brakeDiscHydraulics = new ArrayList<BrakeDiscHydraulic>();
        List<BrakeDiscMechanik> brakeDiscMechaniks = new ArrayList<>();
        List<BrakeVBrake> brakeVBrakes = new ArrayList<BrakeVBrake>();
        List<BrakeHandle> brakeHandles = new ArrayList<BrakeHandle>();
        List<BackHub> backHubs = new ArrayList<>();
        List<FrontHub> frontHubs = new ArrayList<>();
        List<Rim> rims = new ArrayList<>();
        List<Spoke> spokes = new ArrayList<>();
        List<Tire> tires = new ArrayList<>();
        List<Wheel> wheels = new ArrayList<>();

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
        for (int i = 0; i < handlebarService.getSizeHandlebar(); i++) {
            System.out.println("артиклі рулів в корзині" + " " + handlebarService.getArticleHandlebarFromCart(i));
            List<Handlebar> handlebar = handlebarService
                    .findHandlebarByArticle(handlebarService.getArticleHandlebarFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            handlebars.add(handlebar.get(0));
        }
        for (int i = 0; i < handlebarService.getSizeStem(); i++) {
            System.out.println("артиклі виносів в корзині" + " " + handlebarService.getArticleStemFromCart(i));
            List<Stem> stem = handlebarService
                    .findStemByArticle(handlebarService.getArticleStemFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            stems.add(stem.get(0));
        }
        for (int i = 0; i < handlebarService.getSizeGrips(); i++) {
            System.out.println("артиклі грипсів в корзині" + " " + handlebarService.getArticleGripsFromCart(i));
            List<Grips> gripss = handlebarService
                    .findGripsByArticle(handlebarService.getArticleGripsFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            grips.add(gripss.get(0));
        }
        for (int i = 0; i < handlebarService.getSizeHeadset(); i++) {
            System.out.println("артиклі рульових в корзині" + " " + handlebarService.getArticleHeadsetFromCart(i));
            List<Headset> headset = handlebarService
                    .findHeadsetByArticle(handlebarService.getArticleHeadsetFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            headsets.add(headset.get(0));
        }
        for (int i = 0; i < handlebarService.getSizeWinding(); i++) {
            System.out.println("артиклі обмоток в корзині" + " " + handlebarService.getArticleWindingFromCart(i));
            List<Winding> winding = handlebarService
                    .findWindingByArticle(handlebarService.getArticleWindingFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            windings.add(winding.get(0));
        }
        for (int i = 0; i < brakeService.getSizeBrakeDiscHydraulic(); i++) {
            System.out.println("артиклі дискових гідравлічних в корзині" + " " + brakeService.getArticleBrakeDiscHydraulicFromCart(i));
            List<BrakeDiscHydraulic> brakeDiscHydraulic = brakeService
                    .findBrakeDiscHydraulicByArticle(brakeService.getArticleBrakeDiscHydraulicFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            brakeDiscHydraulics.add(brakeDiscHydraulic.get(0));
        }
        for (int i = 0; i < brakeService.getSizeBrakeDiscMechanik(); i++) {
            System.out.println("артиклі вилок в корзині" + " " + brakeService.getArticleBrakeDiscMechanikFromCart(i));
            List<BrakeDiscMechanik> brakeDiscMechaniks1 = brakeService
                    .findBrakeDiscMechanikByArticle(brakeService.getArticleBrakeDiscMechanikFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            brakeDiscMechaniks.add(brakeDiscMechaniks1.get(0));
        }
        for (int i = 0; i < brakeService.getSizeBrakeVBrake(); i++) {
            System.out.println("артиклі ободних гальм в корзині" + " " + brakeService.getArticleBrakeVBrakeFromCart(i));
            List<BrakeVBrake> brakeVBrake = brakeService
                    .findBrakeVBrakeByArticle(brakeService.getArticleBrakeVBrakeFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            brakeVBrakes.add(brakeVBrake.get(0));
        }
        for (int i = 0; i < brakeService.getSizeBrakeHandle(); i++) {
            System.out.println("артиклі гальмівних ручок в корзині" + " " + brakeService.getArticleBrakeHandleFromCart(i));
            List<BrakeHandle> brakeHandle = brakeService
                    .findBrakeHandleByArticle(brakeService.getArticleBrakeHandleFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            brakeHandles.add(brakeHandle.get(0));
        }
        for (int i = 0; i < wheelService.getSizeBackHub(); i++) {
            System.out.println("артиклі задніх перекидок в корзині" + " " + wheelService.getArticleBackHubFromCart(i));
            List<BackHub> backHub = wheelService
                    .findBackHubByArticle(wheelService.getArticleBackHubFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            backHubs.add(backHub.get(0));
        }
        for (int i = 0; i < wheelService.getSizeFrontHub(); i++) {
            System.out.println("артиклі передніх перекидок в корзині" + " " + wheelService.getArticleFrontHubFromCart(i));
            List<FrontHub> frontHub = wheelService
                    .findFrontHubByArticle(wheelService.getArticleFrontHubFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            frontHubs.add(frontHub.get(0));
        }
        for (int i = 0; i < wheelService.getSizeRim(); i++) {
            System.out.println("артиклі ободів в корзині" + " " + wheelService.getArticleRimFromCart(i));
            List<Rim> rim = wheelService
                    .findRimByArticle(wheelService.getArticleRimFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            rims.add(rim.get(0));
        }
        for (int i = 0; i < wheelService.getSizeSpoke(); i++) {
            System.out.println("артиклі  спиць в корзині" + " " + wheelService.getArticleSpokeFromCart(i));
            List<Spoke> spoke = wheelService
                    .findSpokeByArticle(wheelService.getArticleSpokeFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            spokes.add(spoke.get(0));
        }
        for (int i = 0; i < wheelService.getSizeTire(); i++) {
            System.out.println("артиклі  покришок в корзині" + " " + wheelService.getArticleTireFromCart(i));
            List<Tire> tire = wheelService
                    .findTireByArticle(wheelService.getArticleTireFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            tires.add(tire.get(0));
        }
        for (int i = 0; i < wheelService.getSizeWheel(); i++) {
            System.out.println("артиклі  колес в корзині" + " " + wheelService.getArticleWheelFromCart(i));
            List<Wheel> wheel = wheelService
                    .findWheelByArticle(wheelService.getArticleWheelFromCart(i), new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            wheels.add(wheel.get(0));
        }

        model.addAttribute("handlebars", handlebars);
        model.addAttribute("forks", forks);
        model.addAttribute("frames", frames);
        model.addAttribute("stems", stems);
        model.addAttribute("grips", grips);
        model.addAttribute("headsets", headsets);
        model.addAttribute("windings", windings);
        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);
        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
        model.addAttribute("brakeVBrakes", brakeVBrakes);
        model.addAttribute("brakeHandles", brakeHandles);
        model.addAttribute("backHubs", backHubs);
        model.addAttribute("frontHubs", frontHubs);
        model.addAttribute("rims", rims);
        model.addAttribute("spokes", spokes);
        model.addAttribute("tires", tires);
        model.addAttribute("wheels", wheels);
        System.out.println("всього рам в корзині в корзині" +" = "+ frames.size());
        System.out.println("всього вилок в корзині в корзині"+" = " + forks.size());
        System.out.println("всього рулів в корзині в корзині" +" = "+ handlebars.size());
        System.out.println("всього виносів в корзині в корзині" +" = "+ stems.size());
        System.out.println("всього грипсів в корзині в корзині" +" = "+ grips.size());
        System.out.println("всього рульових в корзині в корзині" +" = "+ headsets.size());
        System.out.println("всього обмоток в корзині в корзині" +" = "+ windings.size());
        System.out.println("всього гідравлічних дискових в корзині в корзині" +" = "+ brakeDiscHydraulics.size());
        System.out.println("всього механічних дискових в корзині в корзині" +" = "+ brakeDiscMechaniks.size());
        System.out.println("всього ободних гальм в корзині в корзині" +" = "+ brakeVBrakes.size());
        System.out.println("всього гальмівних ручок в корзині в корзині" +" = "+ brakeHandles.size());
        System.out.println("всього задніх перекидок в корзині в корзині" +" = "+ backHubs.size());
        System.out.println("всього передніх перекидок в корзині в корзині" +" = "+ frontHubs.size());
        System.out.println("всього ободів в корзині в корзині" +" = "+ rims.size());
        System.out.println("всього спиць ручок в корзині в корзині" +" = "+ spokes.size());
        System.out.println("всього покришок в корзині в корзині" +" = "+ tires.size());
        System.out.println("всього колес в корзині в корзині" +" = "+ wheels.size());

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


