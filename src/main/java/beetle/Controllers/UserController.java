package beetle.Controllers;

import beetle.Entities.Brakes.*;
import beetle.Entities.Forks.BrakesType;
import beetle.Entities.Forks.Fork;
import beetle.Entities.Forks.TubeDiameter;
import beetle.Entities.Forks.WheelsDiam;
import beetle.Entities.Frames.BikeType;
import beetle.Entities.Frames.Frame;
import beetle.Entities.Handlebars.*;
import beetle.Entities.Transmission.*;
import beetle.Entities.Wheels.*;
import beetle.Services.*;
import beetle.Entities.Frames.FrameSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Stream;

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
    private UserService userService;

    Map<Long, Integer> productsNumber = new HashMap<Long, Integer>();
    double totalPrice = 0; // total Price in cart
    int total = 0; // number of product in cart


    @RequestMapping("/upNumber/{article}")
    public String upNumber(Model model,
            @PathVariable(value = "article") Long article) {
            int number = productsNumber.get(article);
            productsNumber.put(article, number +1);
            int count = productsNumber.get(article);
            model.addAttribute("count",count);
            return "counting";
    }
    @RequestMapping("/downNumber/{article}")
    public String downNumber(Model model,
            @PathVariable(value = "article") Long article) {
        int number = productsNumber.get(article);
        if (number > 1) {
            productsNumber.put(article, number - 1);
        }
        int count = productsNumber.get(article);
        model.addAttribute("count",count);
        return "counting";        }
    //Return HOME-PAGE
    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        return "index";
    }

    //Select from database bike type MTB
    @RequestMapping("/MTB_page")
    public String mtbVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        BikeType bikeType = frameService.findBikeType(1);
        List<Frame> frames = frameService.
                findByBikeType(bikeType, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        return "mtbBike";
    }

    //Select from database bike type Shosse
    @RequestMapping("/Shosse_page")
    public String shosseVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        BikeType bikeType = frameService.findBikeType(2);
        List<Frame> frames = frameService.
                findByBikeType(bikeType, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        return "shosseBike";
    }

    //Select from database bike type City
    @RequestMapping("/City_page")
    public String cityVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        BikeType bikeType = frameService.findBikeType(3);
        List<Frame> frames = frameService.
                findByBikeType(bikeType, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        return "cityBike";
    }

    //select from database frame by size for MTB
    @RequestMapping("/chooseMTBSize")
    public String chooseMTBSizeVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<FrameSize> frameSizes = frameService.findFrameSize();
        model.addAttribute("framesizes", frameSizes);
        return "chooseMTBSize";
    }

    //select from database frame by size for Shosse
    @RequestMapping("/chooseShosseSize")
    public String chooseShosseSizeVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<FrameSize> frameSizes = frameService.findFrameSize();
        model.addAttribute("framesizes", frameSizes);
        return "chooseShosseSize";
    }

    //select from database frame by size for city
    @RequestMapping("/chooseCitySize")
    public String chooseCitySizeVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<FrameSize> frameSizes = frameService.findFrameSize();
        model.addAttribute("framesizes", frameSizes);
        return "chooseCITYSize";
    }

    // Select Bike By Type and Size
    @RequestMapping("/framesMTB/{id}")
    public String listFrameMTBSize(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model) {
        if (page < 0) page = 0;
        BikeType bikeType = frameService.findBikeType(1);
        FrameSize frameSize = frameService.findFrameSize(id);
        List<Frame> frames = frameService
                .findByTypeAndSize(bikeType, frameSize, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        return "mtbBike";
    }

    // Select Bike By Type and Size
    @RequestMapping("/framesShosse/{id}")
    public String listFrameShosseSize(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model) {
        if (page < 0) page = 0;
        BikeType bikeType = frameService.findBikeType(2);
        FrameSize frameSize = frameService.findFrameSize(id);
        List<Frame> frames = frameService
                .findByTypeAndSize(bikeType, frameSize, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        return "shosseBike";
    }
    // Select Bike By Type and Size
    @RequestMapping("/framesCity/{id}")
    public String listFrameCitySize(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model) {
        if (page < 0) page = 0;
        BikeType bikeType = frameService.findBikeType(3);
        FrameSize frameSize = frameService.findFrameSize(id);
        List<Frame> frames = frameService
                .findByTypeAndSize(bikeType, frameSize, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        return "cityBike";
    }

    @RequestMapping("/cartDel/{name}/{article}/{quantity}")
    public ResponseEntity<Void> delete(
            @PathVariable(value = "name") String name,
            @PathVariable(value = "article") Long article,
            @PathVariable(value = "quantity") int quantity) {
        switch (name) {
            case "Frame" :
                frameService.deleteArticle(article);
                Frame frame = frameService.findFrameByArticle(article);
                totalPrice -= frame.getPrice()*quantity;
                break;
            case "Fork" :
                forkService.deleteArticle(article);
                Fork fork = forkService.findForkByArticle(article);
                totalPrice -= fork.getPrice()*quantity;
                break;
            case "Handlebar" :
                handlebarService.deleteArticleHandlebar(article);
                Handlebar handlebar = handlebarService.findHandlebarByArticle(article);
                totalPrice -= handlebar.getPrice()*quantity;
                break;
            case "Winding" :
                handlebarService.deleteArticleWinding(article);
                Winding winding = handlebarService.findWindingByArticle(article);
                totalPrice -= winding.getPrice()*quantity;
                break;
            case "Headset" :
                handlebarService.deleteArticleHeadset(article);
                Headset headset = handlebarService.findHeadsetByArticle(article);
                totalPrice -= headset.getPrice()*quantity;
                break;
            case "Grips" :
                handlebarService.deleteArticleGrips(article);
                Grips grips = handlebarService.findGripsByArticle(article);
                totalPrice -= grips.getPrice()*quantity;
                break;
            case "Stem" :
                handlebarService.deleteArticleStem(article);
                Stem stem = handlebarService.findStemByArticle(article);
                totalPrice -= stem.getPrice()*quantity;
                break;
            case "Wheel" :
                wheelService.deleteArticleWheel(article);
                Wheel wheel= wheelService.findWheelByArticle(article);
                totalPrice -= wheel.getPrice()*quantity;
                break;
            case "Tire" :
                wheelService.deleteArticleTire(article);
                Tire tire = wheelService.findTireByArticle(article);
                totalPrice -= tire.getPrice()*quantity;
                break;
            case "Spoke" :
                wheelService.deleteArticleSpoke(article);
                Spoke spoke= wheelService.findSpokeByArticle(article);
                totalPrice -= spoke.getPrice()*quantity;
                break;
            case "Rim" :
                wheelService.deleteArticleRim(article);
                Rim rim= wheelService.findRimByArticle(article);
                totalPrice -= rim.getPrice()*quantity;
                break;
            case "FrontHub" :
                wheelService.deleteArticleFrontHub(article);
                FrontHub frontHub= wheelService.findFrontHubByArticle(article);
                totalPrice -= frontHub.getPrice()*quantity;
                break;
            case "BackHub" :
                wheelService.deleteArticleBackHub(article);
                BackHub backHub= wheelService.findBackHubByArticle(article);
                totalPrice -= backHub.getPrice()*quantity;
                break;
            case "BrakeHandle" :
                brakeService.deleteArticleBrakeHandle(article);
                BrakeHandle brakeHandle= brakeService.findBrakeHandleByArticle(article);
                totalPrice -= brakeHandle.getPrice()*quantity;
                break;
            case "BrakeVBrake" :
                brakeService.deleteArticleBrakeVBrake(article);
                BrakeVBrake brakeVBrake= brakeService.findBrakeVBrakeByArticle(article);
                totalPrice -= brakeVBrake.getPrice()*quantity;
                break;
            case "BrakeDiscMechanik" :
                brakeService.deleteArticleBrakeDiscMechanik(article);
                BrakeDiscMechanik brakeDiscMechanik= brakeService.findBrakeDiscMechanikByArticle(article);
                totalPrice -= brakeDiscMechanik.getPrice()*quantity;
                break;
            case "BrakeDiscHydraulic" :
                brakeService.deleteArticleBrakeDiscHydraulic(article);
                BrakeDiscHydraulic brakeDiscHydraulic= brakeService.findBrakeDiscHydraulicByArticle(article);
                totalPrice -= brakeDiscHydraulic.getPrice()*quantity;
                break;
            case "Pedal" :
                transmissionService.deleteArticlePedal(article);
                Pedal pedal= transmissionService.findPedalByArticle(article);
                totalPrice -= pedal.getPrice()*quantity;
                break;
            case "FrontDerailleur" :
                transmissionService.deleteArticleFrontDerailleur(article);
                FrontDerailleur frontDerailleur = transmissionService.findFrontDerailleurByArticle(article);
                totalPrice -= frontDerailleur.getPrice()*quantity;
                break;
            case "Crank" :
                transmissionService.deleteArticleCrank(article);
                Crank crank = transmissionService.findCrankByArticle(article);
                totalPrice -= crank.getPrice()*quantity;
                break;
            case "Chain" :
                transmissionService.deleteArticleChain(article);
                Chain chain= transmissionService.findChainByArticle(article);
                totalPrice -= chain.getPrice()*quantity;
                break;
            case "Bracket" :
                transmissionService.deleteArticleBracket(article);
                Bracket bracket= transmissionService.findBracketByArticle(article);
                totalPrice -= bracket.getPrice()*quantity;
                break;
            case "BackGearTr" :
                transmissionService.deleteArticleBackGearTr(article);
                BackGearTr backGearTr= transmissionService.findBackGearTrByArticle(article);
                totalPrice -= backGearTr.getPrice()*quantity;
                break;
            case "BackGearKas" :
                transmissionService.deleteArticleBackGearKas(article);
                BackGearKas backGearKas = transmissionService.findBackGearKasByArticle(article);
                totalPrice -= backGearKas.getPrice()*quantity;
                break;
            case "BackDerailleur" :
                transmissionService.deleteArticleBackDerailleur(article);
                BackDerailleur backDerailleur = transmissionService.findBackDerailleurByArticle(article);
                totalPrice -= backDerailleur.getPrice()*quantity;
                break;
        }
        productsNumber.remove(article);
        total -= quantity;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAdd/{name}/{article}")
    public ResponseEntity<Void> addToCart(
            @PathVariable(value = "name") String name,
            @PathVariable(value = "article") Long article) {
        switch (name) {
            case "Frame" :
                if (frameService.getArticles().stream().noneMatch(article::equals)) {
                    frameService.addToArticle(article);
                    productsNumber.put(article, 1);
                    Frame frame = frameService.findFrameByArticle(article);
                    totalPrice += frame.getPrice();
                    total++;
                }
                break;
            case "Fork" :
                if (forkService.getArticles().stream().noneMatch(article::equals)) {
                    forkService.addToArticle(article);
                    productsNumber.put(article, 1);
                    Fork fork = forkService.findForkByArticle(article);
                    totalPrice += fork.getPrice();
                    total++;
                }
                break;
            case "Handlebar" :
                if (handlebarService.getArticlesHandlebar().stream().noneMatch(article::equals)) {
                    handlebarService.addToArticleHandlebar(article);
                    productsNumber.put(article, 1);
                    Handlebar handlebar = handlebarService.findHandlebarByArticle(article);
                    double price = handlebar.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "Winding" :
                if (handlebarService.getArticlesWinding().stream().noneMatch(article::equals)) {
                    handlebarService.addToArticleWinding(article);
                    productsNumber.put(article, 1);
                    Winding winding = handlebarService.findWindingByArticle(article);
                    double price = winding.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "Headset" :
                if (handlebarService.getArticlesHeadset().stream().noneMatch(article::equals)) {
                    handlebarService.addToArticleHeadset(article);
                    productsNumber.put(article, 1);
                    Headset headset = handlebarService.findHeadsetByArticle(article);
                    double price = headset.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "Grips" :
                if (handlebarService.getArticlesGrips().stream().noneMatch(article::equals)) {
                    handlebarService.addToArticleGrips(article);
                    productsNumber.put(article, 1);
                    Grips grips = handlebarService.findGripsByArticle(article);
                    double price = grips.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "Stem" :
                if (handlebarService.getArticlesStem().stream().noneMatch(article::equals)) {
                    handlebarService.addToArticleStem(article);
                    productsNumber.put(article, 1);
                    Stem stem = handlebarService.findStemByArticle(article);
                    double price = stem.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "Wheel" :
                if (!wheelService.getArticlesWheel().contains(article)) {
                    wheelService.addToArticleWheel(article);
                    productsNumber.put(article, 1);
                    Wheel wheel= wheelService.findWheelByArticle(article);
                    double price = wheel.getPrice();
                    totalPrice += price;
                    total++;
                }

                break;
            case "Tire" :
                if (wheelService.getArticlesTire().contains(article)) {
                    wheelService.addToArticleTire(article);
                    productsNumber.put(article, 1);
                    Tire tire = wheelService.findTireByArticle(article);
                    double price = tire.getPrice();
                    totalPrice += price;
                    total++;
                }

                break;
            case "Spoke" :
                if (!wheelService.getArticlesSpoke().contains(article)) {
                    wheelService.addToArticleSpoke(article);
                    productsNumber.put(article, 1);
                    Spoke spoke= wheelService.findSpokeByArticle(article);
                    double price = spoke.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "Rim" :
                if (!wheelService.getArticlesRim().contains(article)) {
                    wheelService.addToArticleRim(article);
                    productsNumber.put(article, 1);
                    Rim rim= wheelService.findRimByArticle(article);
                    double price = rim.getPrice();
                    totalPrice += price;
                    total++;
                }

                break;
            case "FrontHub" :
                if (!wheelService.getArticlesFrontHub().contains(article)) {
                    wheelService.addToArticleFrontHub(article);
                    productsNumber.put(article, 1);
                    FrontHub frontHub= wheelService.findFrontHubByArticle(article);
                    double price = frontHub.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "BackHub" :
                if (!wheelService.getArticlesBackHub().contains(article)) {
                    wheelService.addToArticleBackHub(article);
                    productsNumber.put(article, 1);
                    BackHub backHub= wheelService.findBackHubByArticle(article);
                    double price = backHub.getPrice();
                    totalPrice += price;
                    total++;
                }

                break;
            case "BrakeHandle" :
                if (!brakeService.articlesBrakeHandle.contains(article)) {
                    brakeService.addToArticleBrakeHandle(article);
                    productsNumber.put(article, 1);
                    BrakeHandle brakeHandle = brakeService.findBrakeHandleByArticle(article);
                    double price = brakeHandle.getPrice();
                    totalPrice += price;
                    total++;
                }

                break;
            case "BrakeVBrake" :
                if (!brakeService.getArticlesBrakeVBrake().contains(article)) {
                    brakeService.addToArticleBrakeVBrake(article);
                    productsNumber.put(article, 1);
                    BrakeVBrake brakeVBrake= brakeService.findBrakeVBrakeByArticle(article);
                    double price = brakeVBrake.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "BrakeDiscMechanik" :
                if (!brakeService.getArticlesBrakeDiscMechanik().contains(article)) {
                    brakeService.addToArticleBrakeDiscMechanik(article);
                    productsNumber.put(article, 1);
                    BrakeDiscMechanik brakeDiscMechanik = brakeService.findBrakeDiscMechanikByArticle(article);
                    double price = brakeDiscMechanik.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "BrakeDiscHydraulic" :
                if (brakeService.getArticlesBrakeDiscHydraulic().stream().noneMatch(article::equals)) {
                    brakeService.addToArticleBrakeDiscHydraulic(article);
                    productsNumber.put(article, 1);
                    BrakeDiscHydraulic brakeDiscHydraulic = brakeService.findBrakeDiscHydraulicByArticle(article);
                    double price = brakeDiscHydraulic.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "Pedal" :
                if (!transmissionService.getArticlesPedal().contains(article)) {
                    transmissionService.addToArticlePedal(article);
                    productsNumber.put(article, 1);
                    Pedal pedal= transmissionService.findPedalByArticle(article);
                    double price = pedal.getPrice();
                    totalPrice += price;
                    total++;
                }

                break;
            case "FrontDerailleur" :
                if (!transmissionService.getArticlesFrontDerailleur().contains(article)) {
                    transmissionService.addToArticleFrontDerailleur(article);
                    productsNumber.put(article, 1);
                    FrontDerailleur frontDerailleur = transmissionService.findFrontDerailleurByArticle(article);
                    double price = frontDerailleur.getPrice();
                    totalPrice += price;
                    total++;
                }

                break;
            case "Crank" :
                if (!transmissionService.getArticlesCrank().contains(article)) {
                    transmissionService.addToArticleCrank(article);
                    productsNumber.put(article, 1);
                    Crank crank = transmissionService.findCrankByArticle(article);
                    double price = crank.getPrice();
                    totalPrice += price;
                    total++;
                }

                break;
            case "Chain" :
                if (!transmissionService.getArticlesChain().contains(article)) {
                    transmissionService.addToArticleChain(article);
                    productsNumber.put(article, 1);
                    Chain chain= transmissionService.findChainByArticle(article);
                    double price = chain.getPrice();
                    totalPrice += price;
                    total++;
                }

                break;
            case "Bracket" :
                if (!transmissionService.getArticlesBracket().contains(article)) {
                    transmissionService.addToArticleBracket(article);
                    productsNumber.put(article, 1);
                    Bracket bracket= transmissionService.findBracketByArticle(article);
                    double price = bracket.getPrice();
                    totalPrice += price;
                    total++;
                }

                break;
            case "BackGearTr" :
                if (!transmissionService.getArticlesBackGearTr().contains(article)) {
                    transmissionService.addToArticleBackGearTr(article);
                    productsNumber.put(article, 1);
                    BackGearTr backGearTr= transmissionService.findBackGearTrByArticle(article);
                    double price = backGearTr.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "BackGearKas" :
                if (!transmissionService.getArticlesBackGearKas().contains(article)) {
                    transmissionService.addToArticleBackGearKas(article);
                    productsNumber.put(article, 1);
                    BackGearKas backGearKas = transmissionService.findBackGearKasByArticle(article);
                    double price = backGearKas.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
            case "BackDerailleur" :
                if (!transmissionService.getArticlesBackDerailleur().contains(article)) {
                    transmissionService.addToArticleBackDerailleur(article);
                    productsNumber.put(article, 1);
                    BackDerailleur backDerailleur = transmissionService.findBackDerailleurByArticle(article);
                    double price = backDerailleur.getPrice();
                    totalPrice += price;
                    total++;
                }
                break;
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/upPrice/{price}")
    public ResponseEntity<Void> upPrice(
                            @PathVariable(value = "price") Double price) {
        totalPrice += price;
        total ++;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/downPrice/{price}")
    public ResponseEntity<Void> downPrice(
            @PathVariable(value = "price") Double price) {
        if (total>=1) {
            totalPrice -= price;
            total--;
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/price")
    public String price(Model model) {
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String price = decimalFormat.format(totalPrice);
        model.addAttribute("totalPrice", price);
        return "price";
    }

    @RequestMapping("/counting/{article}")
    public String counting(Model model,
                           @PathVariable(value = "article") Long article) {
        int count = productsNumber.get(article);
        model.addAttribute("count",count);
        return "counting";
    }

    @RequestMapping("/totalNumber")
    public String totalNumber(Model model) {
        model.addAttribute("total", total);
        return "totalNumber";
    }


    // Cart
    @RequestMapping("/cart")
    public String cartVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Object> objects = new ArrayList<>();
        //Lists with components, that user added to cart
        List<Frame> frames = new ArrayList<>();
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
        List<BackDerailleur> backDerailleurs = new ArrayList<>();
        List<BackGearKas> backGearKass = new ArrayList<>();
        List<BackGearTr> backGearTrs = new ArrayList<>();
        List<Bracket> brackets = new ArrayList<>();
        List<Chain> chains = new ArrayList<>();
        List<Crank> cranks = new ArrayList<>();
        List<FrontDerailleur> frontDerailleurs = new ArrayList<>();
        List<Pedal> pedals = new ArrayList<>();

//Select components from database by article, that user added to cart, and add this components to List

        for (int i = 0; i < frameService.getSize(); i++){
            Frame frame = frameService.findFrameByArticle(frameService.getArticleFromCart(i));
            frames.add(frame);
        }
        for (int i = 0; i < forkService.getSize(); i++){
            Fork fork = forkService.findForkByArticle(forkService.getArticleFromCart(i));
            forks.add(fork);
        }
        for (int i = 0; i < handlebarService.getSizeHandlebar(); i++) {
            Handlebar handlebar = handlebarService.findHandlebarByArticle(handlebarService.getArticleHandlebarFromCart(i));
            handlebars.add(handlebar);
        }
        for (int i = 0; i < handlebarService.getSizeStem(); i++) {
            Stem stem = handlebarService.findStemByArticle(handlebarService.getArticleStemFromCart(i));
            stems.add(stem);
        }
        for (int i = 0; i < handlebarService.getSizeGrips(); i++) {
            Grips gripss = handlebarService.findGripsByArticle(handlebarService.getArticleGripsFromCart(i));
            grips.add(gripss);
        }
        for (int i = 0; i < handlebarService.getSizeHeadset(); i++) {
            Headset headset = handlebarService.findHeadsetByArticle(handlebarService.getArticleHeadsetFromCart(i));
            headsets.add(headset);
        }
        for (int i = 0; i < handlebarService.getSizeWinding(); i++) {
            Winding winding = handlebarService.findWindingByArticle(handlebarService.getArticleWindingFromCart(i));
            windings.add(winding);
        }
        for (int i = 0; i < brakeService.getSizeBrakeDiscHydraulic(); i++) {
            BrakeDiscHydraulic brakeDiscHydraulic = brakeService.
                    findBrakeDiscHydraulicByArticle(brakeService.getArticleBrakeDiscHydraulicFromCart(i));
            brakeDiscHydraulics.add(brakeDiscHydraulic);
        }
        for (int i = 0; i < brakeService.getSizeBrakeDiscMechanik(); i++) {
            BrakeDiscMechanik brakeDiscMechanik = brakeService.
                    findBrakeDiscMechanikByArticle(brakeService.getArticleBrakeDiscMechanikFromCart(i));
            brakeDiscMechaniks.add(brakeDiscMechanik);
        }
        for (int i = 0; i < brakeService.getSizeBrakeVBrake(); i++) {
            BrakeVBrake brakeVBrake = brakeService.findBrakeVBrakeByArticle(brakeService.getArticleBrakeVBrakeFromCart(i));
            brakeVBrakes.add(brakeVBrake);
        }
        for (int i = 0; i < brakeService.getSizeBrakeHandle(); i++) {
            BrakeHandle brakeHandle = brakeService.findBrakeHandleByArticle(brakeService.getArticleBrakeHandleFromCart(i));
            brakeHandles.add(brakeHandle);
        }
        for (int i = 0; i < wheelService.getSizeBackHub(); i++) {
            BackHub backHub = wheelService.findBackHubByArticle(wheelService.getArticleBackHubFromCart(i));
            backHubs.add(backHub);
        }
        for (int i = 0; i < wheelService.getSizeFrontHub(); i++) {
            FrontHub frontHub = wheelService.findFrontHubByArticle(wheelService.getArticleFrontHubFromCart(i));
            frontHubs.add(frontHub);;
        }
        for (int i = 0; i < wheelService.getSizeRim(); i++) {
            Rim rim = wheelService.findRimByArticle(wheelService.getArticleRimFromCart(i));
            rims.add(rim);
        }
        for (int i = 0; i < wheelService.getSizeSpoke(); i++) {
            Spoke spoke = wheelService.findSpokeByArticle(wheelService.getArticleSpokeFromCart(i));
            spokes.add(spoke);;
        }
        for (int i = 0; i < wheelService.getSizeTire(); i++) {
            Tire tire = wheelService.findTireByArticle(wheelService.getArticleTireFromCart(i));
            tires.add(tire);
        }
        for (int i = 0; i < wheelService.getSizeWheel(); i++) {
            Wheel wheel = wheelService.findWheelByArticle(wheelService.getArticleWheelFromCart(i));
            wheels.add(wheel);
        }
        for (int i = 0; i < transmissionService.getSizeBackDerailleur(); i++) {
            BackDerailleur backDerailleur = transmissionService.findBackDerailleurByArticle(transmissionService.getArticleBackDerailleurFromCart(i));
            backDerailleurs.add(backDerailleur);
        }
        for (int i = 0; i < transmissionService.getSizeBackGearKas(); i++) {
            BackGearKas backGearKas = transmissionService.findBackGearKasByArticle(transmissionService.getArticleBackGearKasFromCart(i));
            backGearKass.add(backGearKas);
        }
        for (int i = 0; i < transmissionService.getSizeBackGearTr(); i++) {
            BackGearTr backGearTr = transmissionService.findBackGearTrByArticle(transmissionService.getArticleBackGearTrFromCart(i));
            backGearTrs.add(backGearTr);
        }
        for (int i = 0; i < transmissionService.getSizeBracket(); i++) {
            Bracket bracket = transmissionService.findBracketByArticle(transmissionService.getArticleBracketFromCart(i));
            brackets.add(bracket);
        }
        for (int i = 0; i < transmissionService.getSizeChain(); i++) {
            Chain chain = transmissionService.findChainByArticle(transmissionService.getArticleChainFromCart(i));
            chains.add(chain);
        }
        for (int i = 0; i < transmissionService.getSizeCrank(); i++) {
            Crank crank = transmissionService.findCrankByArticle(transmissionService.getArticleCrankFromCart(i));
            cranks.add(crank);
        }
        for (int i = 0; i < transmissionService.getSizeFrontDerailleur(); i++) {
            FrontDerailleur frontDerailleur = transmissionService.findFrontDerailleur(transmissionService.getArticleFrontDerailleurFromCart(i));
            frontDerailleurs.add(frontDerailleur);
        }
        for (int i = 0; i < transmissionService.getSizePedal(); i++) {
            Pedal pedal = transmissionService.findPedalByArticle(transmissionService.getArticlePedalFromCart(i));
            pedals.add(pedal);
        }

        objects.add(frames);
        objects.add(forks);
        objects.add(handlebars);
        objects.add(stems);
        objects.add(grips);
        objects.add(headsets);
        objects.add(windings);
        objects.add(brakeDiscHydraulics);
        objects.add(brakeDiscMechaniks);
        objects.add(brakeVBrakes);
        objects.add(brakeHandles);
        objects.add(backHubs);
        objects.add(frontHubs);
        objects.add(rims);
        objects.add(spokes);
        objects.add(tires);
        objects.add(wheels);
        objects.add(backDerailleurs);
        objects.add(backGearKass);
        objects.add(backGearTrs);
        objects.add(brackets);
        objects.add(chains);
        objects.add(cranks);
        objects.add(frontDerailleurs);
        objects.add(pedals);
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String price = decimalFormat.format(totalPrice);
        //models for cart
        model.addAttribute("total", total);
        model.addAttribute("totalPrice", price );
        model.addAttribute("objects", objects);
        model.addAttribute("productsNumber",productsNumber);

            return "cart";
        }

// Select Forks
     @RequestMapping("/chooseFork/{id}")
    public String listForkForBike(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdFrame(id);
        Frame frame = frameService.findFrame(userService.getIdFrame());
        BikeType bikeType = frame.getBikeType();
        TubeDiameter tubeDiameter = frame.getTubeDiameter();
        WheelsDiam wheelsDiam = frame.getWheelsDiam();
        BrakesType brakesType = frame.getBrakesType();
        List<Fork> forks = forkService.
                findByTypeAndWhDiamAndTubeDiamAndBrType(bikeType,wheelsDiam,tubeDiameter,brakesType,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("forks", forks);
        return "forksToFrame";
    }

    // Select Wheels
    @RequestMapping("/chooseWheel/{id}")
    public String listWheelForFork(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdFork(id);
        Frame frame = frameService.findFrame(userService.getIdFrame());
        BikeType bikeType = frame.getBikeType();
        WheelsDiam wheelsDiam = frame.getWheelsDiam();
        BrakesType brakesType = frame.getBrakesType();
        List<Wheel> wheels = wheelService.
                findByTypeAndWhDiamAndBrType(bikeType,wheelsDiam,brakesType,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("wheels", wheels);
        return "wheelsToFork";
    }

    // Select Brackets
    @RequestMapping("/chooseBracket/{id}")
    public String listBracketForBike(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdWheel(id);
        Frame frame = frameService.findFrame(userService.getIdFrame());
        BracketWide bracketWide = frame.getBracketWide();
        List<Bracket> brackets = transmissionService.
                findByBracketWide(bracketWide,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brackets", brackets);
        return "bracketsToFork";
    }

    // Select Cranks
    @RequestMapping("/chooseCrank/{id}")
    public String listCrankForBracket(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdBracket(id);
        Bracket bracket = transmissionService.findBracket(userService.getIdBracket());
        BracketType bracketType = bracket.getBracketType();
        List<Crank> cranks = transmissionService.
                findByBracketTypeCrank(bracketType,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("cranks", cranks);
        return "cranksToBracket";
    }

    @RequestMapping("/chooseBackGearKas/{id}")
    public String listBackSprocketKasForCrank(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdCrank(id);
        Crank crank = transmissionService.findCrank(userService.getIdCrank());
        BackSprocketNumber backSprocketNumber = crank.getBackSprocketNumber();
        List<BackGearKas> backGearKass = transmissionService.
                findByBackSprocketNumberBackGearKas(backSprocketNumber,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("backGearKass", backGearKass);
        return "backGearKassToCrank";
    }

    @RequestMapping("/chooseBackDerailleur/{id}")
    public String listBackDeraileurForKas(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdBackGearKas(id);
        BackGearKas backGearKas = transmissionService.findBackGearKas(userService.getIdBackGearKas());
        BackSprocketNumber backSprocketNumber = backGearKas.getBackSprocketNumber();
        BackSprocketMax backSprocketMax = backGearKas.getBackSprocketMax();
        BackSprocketMin backSprocketMin = backGearKas.getBackSprocketMin();

        List<BackDerailleur> backDerailleurs = transmissionService.
                findBySprNumberAndSprMaxAndSprMin(backSprocketNumber,backSprocketMax,backSprocketMin,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("backDerailleurs", backDerailleurs);
        return "backDerailleursToBackGear";
    }

    @RequestMapping("/chooseFrontDerailleur/{id}")
    public String listFrontDeraileurForCrank(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdBackDerailleur(id);
        Crank crank = transmissionService.findCrank(userService.getIdCrank());
        BackGearKas backGearKas = transmissionService.findBackGearKas(userService.getIdBackGearKas());
        FrontSprocketNumber frontSprocketNumber = crank.getFrontSprocketNumber();
        BackSprocketNumber backSprocketNumber = backGearKas.getBackSprocketNumber();
        FrontSprocketMax frontSprocketMax = crank.getFrontSprocketMax();
        FrontSprocketMin frontSprocketMin = crank.getFrontSprocketMin();

        List<FrontDerailleur> frontDerailleurs = transmissionService.
                findByFrSprNumberAndBackSprNumberAndFrSprMaxAndFrSprMin(
                        frontSprocketNumber,
                        backSprocketNumber,
                        frontSprocketMax,
                        frontSprocketMin,
                        new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frontDerailleurs", frontDerailleurs);
        return "frontDerailleursToCrank";
    }

    @RequestMapping("/chooseChain/{id}")
    public String listChainForKas(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdFrontDerailleur(id);
        BackGearKas backGearKas = transmissionService.findBackGearKas(userService.getIdBackGearKas());
        BackSprocketNumber backSprocketNumber = backGearKas.getBackSprocketNumber();
        List<Chain> chains = transmissionService.
                findByBackSprocketNumberChain(backSprocketNumber,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("chains", chains);
        return "chainsToBackGear";
    }

    @RequestMapping("/choosePedal/{id}")
    public String listPedalForBike(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdChain(id);
        List<Pedal> pedals = transmissionService.
                findAllSeven(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("pedals", pedals);
        return "pedalToBike";
    }

    @RequestMapping("/chooseBrakes/{id}")
    public String listBrakesForBike(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model) {
        userService.addIdPedal(id);
        Frame frame = frameService.findFrame(userService.getIdFrame());
        BrakesType brakesType = frame.getBrakesType();
        int a = (int)brakesType.getId();
        Location location = brakeService.findLication(1);
        List<BrakeVBrake> brakeVBrakes = brakeService
                .findByLocationVBrake(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeVBrakes", brakeVBrakes);
        if (a == 1) {
            return "brakesDiscSelect";
        } else if (a == 2) {
            return "brakesVBrakeFrontToBike";
        } else {
            return "brakesSelectType";
        }
    }

    @RequestMapping("/chooseDiscHydraulic")
    public String listDiscHydraulicFront(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model) {
        if (page < 0) page = 0;
        Location location = brakeService.findLication(1);
        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeService
                .findByLocationHydraulic(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);
        return "brakesHydraulicFrontToBike";
    }

    @RequestMapping("/chooseDiscHydraulicBack/{id}")
    public String listDiscHydraulicBack(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdBrakeDiscHydraulicFront(id);
        Location location = brakeService.findLication(2);
        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeService
                .findByLocationHydraulic(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);

        return "brakesHydraulicBackToBike";
    }

    @RequestMapping("/chooseDiscMechanik")
    public String listDiscMechanik(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model) {
        if (page < 0) page = 0;
        Location location = brakeService.findLication(1);
        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeService
                .findByLocationMechanik(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
        return "brakesMechanikFrontToBike";
    }
    @RequestMapping("/chooseDiscMechanikBack/{id}")
    public String listDiscMechanikBack(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdBrakeDiscMechanikFront(id);
        Location location = brakeService.findLication(2);
        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeService
                .findByLocationMechanik(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
        return "brakesMechanikBackToBike";
    }

    @RequestMapping("/chooseVBrakeFront")
    public String listVBrakeFront(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model) {
        if (page < 0) page = 0;
        Location location = brakeService.findLication(1);
        List<BrakeVBrake> brakeVBrakes = brakeService
                .findByLocationVBrake(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeVBrakes", brakeVBrakes);
        return "brakesVBrakeFrontToBike";
    }
    @RequestMapping("/chooseVBrakeBack/{id}")
    public String listVBrakeBack(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdBrakeDiscMechanikFront(id);
        Location location = brakeService.findLication(2);
        List<BrakeVBrake> brakeVBrakes = brakeService
                .findByLocationVBrake(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeVBrakes", brakeVBrakes);
        return "brakesVBrakeBackToBike";
    }

    @RequestMapping("/chooseHandlebar/{type}/{id}")
    public String listHandlebarForBike(
            @PathVariable(value = "id") Long id,
            @PathVariable(value = "type") String type,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        String hydraulic = "hydraulic";
        String mechanik = "mechanik";
        if (type.equals(hydraulic)) {
            userService.addIdBrakeDiscHydraulicBack(id);
            System.out.println("hydro" + id +" " + type);
        } else if (type.equals(mechanik)) {
            userService.addIdBrakeDiscMechanikBack(id);
            System.out.println("mech" + id +" " + type);
        } else {
            userService.addIdBrakeVBrakeBack(id);
            System.out.println("VBrake" + id +" " + type);
        }
        Frame frame = frameService.findFrame(userService.getIdFrame());
        BikeType bikeType = frame.getBikeType();
        List<Handlebar> handlebars = handlebarService.
                findByBikeType(bikeType, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("handlebars", handlebars);
        return "handlebarsToBike";
    }

    @RequestMapping("/chooseStem/{id}")
    public String listStemForHandlebar(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdHandlebar(id);
        Handlebar handlebar = handlebarService.findHandlebar(userService.getIdHandlebar());
        Fork fork = forkService.findFork(userService.getIdFork());
        HandlebarDiameter handlebarDiameter = handlebar.getHandlebarDiameter();
        TubeDiameter tubeDiameter = fork.getTubeDiameter();
        List<Stem> stems = handlebarService
                .findByHandlebarDiamAndTubeDiam(handlebarDiameter,tubeDiameter,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("stems", stems);
        return "stemsToHandlebar";
    }

    @RequestMapping("/chooseBrakeHandle/{id}")
    public String listBrakeHandleForHandlebar(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdStem(id);
        // If user chose Hydraulic Brakes - brake Handle are in the brakes kit
        if(userService.getIdBrakeDiscHydraulicFront()!= 0) {
            List<Grips> gripss = handlebarService.
                    findAllGrips(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            model.addAttribute("gripss", gripss);
            return "gripsToHandlebar";
        } else if (userService.getIdBrakeDiscMechanikFront() != 0) {
            // 2 is Id of Mechanik Disc Brake in DB
            BrakeHandleCompatibility brakeHandleCompatibility = brakeService.
                    findBrakeHandleCompatibility(2);
            List<BrakeHandle> brakeHandles = brakeService.
                    findByBrakeHandleCompatibility(brakeHandleCompatibility,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            model.addAttribute("brakeHandles", brakeHandles);
            return "brakesHandleToHandlebar";
        } else {
            // 3 is Id of V-Brake in DB
            BrakeHandleCompatibility brakeHandleCompatibility = brakeService.
                    findBrakeHandleCompatibility(3);
            List<BrakeHandle> brakeHandles = brakeService.
                    findByBrakeHandleCompatibility(brakeHandleCompatibility,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            model.addAttribute("brakeHandles", brakeHandles);
            return "brakesHandleToHandlebar";
        }
    }

    @RequestMapping("/chooseGrips/{id}")
    public String listGripsForHandlebar(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addIdBrakeHandle(id);
        List<Grips> gripss = handlebarService.
                findAllGrips(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("gripss", gripss);
        return "gripsToHandlebar";
    }

}


