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
    private UserService userService;

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
        ;
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

    //Add frame to cart
    @RequestMapping("/cartAddFrame/{article}")
    public void listArticleFrame(
            @PathVariable(value = "article") Long article) {
        // for checking if article exist in cart
        if (!frameService.getArticles().contains(article)) {
        frameService.addToArticle(article);
        }

    }
    //delete frame from cart
    @RequestMapping("/cartDelFrame/{article}")
    public ResponseEntity<Void> listArticleFrameToDel(
            @PathVariable(value = "article") Long article) {
            frameService.deleteArticle(article);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    //Add fork to cart
    @RequestMapping("/cartAddFork/{article}")
    public void  listArticleFork(
            @PathVariable(value = "article") Long article)
    {
        // for checking if article exist in cart
        if (!forkService.getArticles().contains(article)) {
         forkService.addToArticle(article);
        }
    }
    @RequestMapping("/cartDelFork/{article}")
    public ResponseEntity<Void> listArticleForkToDel(
            @PathVariable(value = "article") Long article) {
        forkService.deleteArticle(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Add handlebars component to cart
    @RequestMapping("/cartAddHandlebar/{article}")
    public void  listArticleHandlebar(
            @PathVariable(value = "article") Long article)
    {
        if (!handlebarService.getArticlesHandlebar().contains(article)) {
            handlebarService.addToArticleHandlebar(article);
        }
    }

    @RequestMapping("/cartDelHandlebar/{article}")
    public ResponseEntity<Void> listArticleHandlebarToDel(
            @PathVariable(value = "article") Long article) {
        handlebarService.deleteArticleHandlebar(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddStem/{article}")
    public void  listArticleStem(
            @PathVariable(value = "article") Long article)
    {
        // for checking if article exist in cart
        if (!handlebarService.getArticlesStem().contains(article)) {
            handlebarService.addToArticleStem(article);
        }
    }

    @RequestMapping("/cartDelStem/{article}")
    public ResponseEntity<Void> listArticleStemToDel(
            @PathVariable(value = "article") Long article) {
        handlebarService.deleteArticleStem(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddGrips/{article}")
    public void listArticleGrips(
            @PathVariable(value = "article") Long article)
    {
        // for checking if article exist in cart
        if (!handlebarService.getArticlesHandlebar().contains(article)) {
            handlebarService.addToArticleGrips(article);
        }
    }

    @RequestMapping("/cartDelGrips/{article}")
    public ResponseEntity<Void> listArticleGripsToDel(
            @PathVariable(value = "article") Long article) {
        handlebarService.deleteArticleGrips(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddHeadset/{article}")
    public void listArticleHeadset(
            @PathVariable(value = "article") Long article)
    {
        // for checking if article exist in cart
        if (!handlebarService.getArticlesHeadset().contains(article)) {
            handlebarService.addToArticleHeadset(article);
        }
    }

    @RequestMapping("/cartDelHeadset/{article}")
    public ResponseEntity<Void> listArticleHeadsetToDel(
            @PathVariable(value = "article") Long article) {
        handlebarService.deleteArticleHeadset(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddWinding/{article}")
    public void listArticleWinding(
            @PathVariable(value = "article") Long article)
    {
        // for checking if article exist in cart
        if (!handlebarService.getArticlesWinding().contains(article)) {
            handlebarService.addToArticleWinding(article);
        }
    }

    @RequestMapping("/cartDelWinding/{article}")
    public ResponseEntity<Void> listArticleWindingToDel(
            @PathVariable(value = "article") Long article) {
        handlebarService.deleteArticleWinding(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Add Brakes component to cart
    @RequestMapping("/cartAddBrakeDiscHydraulic/{article}")
    public void listArticleBrakeDiscHydraulic(
            @PathVariable(value = "article") Long article)
    {
        // for checking if article exist in cart
        if (!brakeService.getArticlesBrakeDiscHydraulic().contains(article)) {
            brakeService.addToArticleBrakeDiscHydraulic(article);
        }
    }

    @RequestMapping("/cartDelBrakeDiscHydraulic/{article}")
    public ResponseEntity<Void> listArticleBrakeDiscHydraulicToDel(
            @PathVariable(value = "article") Long article) {
        brakeService.deleteArticleBrakeDiscHydraulic(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddBrakeDiscMechanik/{article}")
    public void listArticleBrakeDiscMechanik(
            @PathVariable(value = "article") Long article)
    {
        // for checking if article exist in cart
        if (!brakeService.getArticlesBrakeDiscMechanik().contains(article)) {
            brakeService.addToArticleBrakeDiscMechanik(article);
        }
    }

    @RequestMapping("/cartDelBrakeDiscMechanik/{article}")
    public ResponseEntity<Void> listArticleBrakeDiscMechanikToDel(
            @PathVariable(value = "article") Long article) {
        brakeService.deleteArticleBrakeDiscMechanik(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddBrakeVBrake/{article}")
    public void listArticleBrakeVBrake(
            @PathVariable(value = "article") Long article)
    {
        // for checking if article exist in cart
        if (!brakeService.getArticlesBrakeVBrake().contains(article)) {
            brakeService.addToArticleBrakeVBrake(article);
        }
    }

    @RequestMapping("/cartDelBrakeVBrake/{article}")
    public ResponseEntity<Void> listArticleBrakeVBrakeToDel(
            @PathVariable(value = "article") Long article) {
        brakeService.deleteArticleBrakeVBrake(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddBrakeHandle/{article}")
    public void listArticleBrakeHandle(
            @PathVariable(value = "article") Long article)
    {
        if (!brakeService.articlesBrakeHandle.contains(article)) {
            brakeService.addToArticleBrakeHandle(article);
        }
    }

    @RequestMapping("/cartDelBrakeHandle/{article}")
    public ResponseEntity<Void> listArticleBrakeHandleToDel(
            @PathVariable(value = "article") Long article) {
        brakeService.deleteArticleBrakeHandle(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Add whells components to cart
    @RequestMapping("/cartAddWheel/{article}")
    public void listArticleWheel(
            @PathVariable(value = "article") Long article)
    {
        if (!wheelService.getArticlesWheel().contains(article)) {
            wheelService.addToArticleWheel(article);
        }
    }

    @RequestMapping("/cartDelWheel/{article}")
    public ResponseEntity<Void> listArticleWheelToDel(
            @PathVariable(value = "article") Long article) {
        wheelService.deleteArticleWheel(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddBackHub/{article}")
    public void listArticleBackHub(
            @PathVariable(value = "article") Long article)
    {
        if (!wheelService.getArticlesBackHub().contains(article)) {
            wheelService.addToArticleBackHub(article);
        }
    }

    @RequestMapping("/cartDelBackHub/{article}")
    public ResponseEntity<Void> listArticleBackHubToDel(
            @PathVariable(value = "article") Long article) {
        wheelService.deleteArticleBackHub(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddFrontHub/{article}")
    public void listArticleFrontHub(
            @PathVariable(value = "article") Long article)
    {
        if (!wheelService.getArticlesFrontHub().contains(article)) {
            wheelService.addToArticleFrontHub(article);
        }
    }

    @RequestMapping("/cartDelFrontHub/{article}")
    public ResponseEntity<Void> listArticleFrontHubToDel(
            @PathVariable(value = "article") Long article) {
        wheelService.deleteArticleFrontHub(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddRim/{article}")
    public void listArticleRim(
            @PathVariable(value = "article") Long article)
    {
        if (!wheelService.getArticlesRim().contains(article)) {
            wheelService.addToArticleRim(article);
        }
    }

    @RequestMapping("/cartDelRim/{article}")
    public ResponseEntity<Void> listArticleRimToDel(
            @PathVariable(value = "article") Long article) {
        wheelService.deleteArticleRim(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddSpoke/{article}")
    public void listArticleSpoke(
            @PathVariable(value = "article") Long article)
    {
        if (!wheelService.getArticlesSpoke().contains(article)) {
            wheelService.addToArticleSpoke(article);
        }
    }

    @RequestMapping("/cartDelSpoke/{article}")
    public ResponseEntity<Void> listArticleSpokeToDel(
            @PathVariable(value = "article") Long article) {
        wheelService.deleteArticleSpoke(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddTire/{article}")
    public void listArticleTire(
            @PathVariable(value = "article") Long article)
    {
        if (wheelService.getArticlesTire().contains(article)) {
            wheelService.addToArticleTire(article);
        }
    }

    @RequestMapping("/cartDelTire/{article}")
    public ResponseEntity<Void> listArticleTireToDel(
            @PathVariable(value = "article") Long article) {
        wheelService.deleteArticleTire(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //For Transmission to cart
    @RequestMapping("/cartAddBackDerailleur/{article}")
    public void listArticleBackDerailleur(
            @PathVariable(value = "article") Long article)
    {
        if (!transmissionService.getArticlesBackDerailleur().contains(article)) {
            transmissionService.addToArticleBackDerailleur(article);
        }
    }

    @RequestMapping("/cartDelBackDerailleur/{article}")
    public ResponseEntity<Void> listArticleBackDerailleurToDel(
            @PathVariable(value = "article") Long article) {
        transmissionService.deleteArticleBackDerailleur(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddBackGearKas/{article}")
    public void listArticleBackGearKas(
            @PathVariable(value = "article") Long article)
    {
        if (!transmissionService.getArticlesBackGearKas().contains(article)) {
            transmissionService.addToArticleBackGearKas(article);
        }
    }

    @RequestMapping("/cartDelBackGearKas/{article}")
    public ResponseEntity<Void> listArticleBackGearKasToDel(
            @PathVariable(value = "article") Long article) {
        transmissionService.deleteArticleBackGearKas(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddBackGearTr/{article}")
    public void listArticleBackGearTr(
            @PathVariable(value = "article") Long article)
    {
        if (!transmissionService.getArticlesBackGearTr().contains(article)) {
            transmissionService.addToArticleBackGearTr(article);
        }
    }

    @RequestMapping("/cartDelBackGearTr/{article}")
    public ResponseEntity<Void> listArticleBackGearTrToDel(
            @PathVariable(value = "article") Long article) {
        transmissionService.deleteArticleBackGearTr(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddBracket/{article}")
    public void listArticleBracket(
            @PathVariable(value = "article") Long article)
    {
        if (!transmissionService.getArticlesBracket().contains(article)) {
            transmissionService.addToArticleBracket(article);
        }
    }

    @RequestMapping("/cartDelBracket/{article}")
    public ResponseEntity<Void> listArticleBracketToDel(
            @PathVariable(value = "article") Long article) {
        transmissionService.deleteArticleBracket(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddChain/{article}")
    public void listArticleChain(
            @PathVariable(value = "article") Long article)
    {
        if (!transmissionService.getArticlesChain().contains(article)) {
            transmissionService.addToArticleChain(article);
        }
    }

    @RequestMapping("/cartDelChain/{article}")
    public ResponseEntity<Void> listArticleChainToDel(
            @PathVariable(value = "article") Long article) {
        transmissionService.deleteArticleChain(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddCrank/{article}")
    public void listArticleCrank(
            @PathVariable(value = "article") Long article)
    {
        if (!transmissionService.getArticlesCrank().contains(article)) {
            transmissionService.addToArticleCrank(article);
        }
    }

    @RequestMapping("/cartDelCrank/{article}")
    public ResponseEntity<Void> listArticleCrankToDel(
            @PathVariable(value = "article") Long article) {
        transmissionService.deleteArticleCrank(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddFrontDerailleur/{article}")
    public void listArticleFrontDerailleur(
            @PathVariable(value = "article") Long article)
    {
        if (!transmissionService.getArticlesFrontDerailleur().contains(article)) {
            transmissionService.addToArticleFrontDerailleur(article);
        }
    }

    @RequestMapping("/cartDelFrontDerailleur/{article}")
    public ResponseEntity<Void> listArticleFrontDerailleurToDel(
            @PathVariable(value = "article") Long article) {
        transmissionService.deleteArticleFrontDerailleur(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cartAddPedal/{article}")
    public void listArticlePedal(
            @PathVariable(value = "article") Long article)
    {
        if (!transmissionService.getArticlesPedal().contains(article)) {
            transmissionService.addToArticlePedal(article);
        }
    }

    @RequestMapping("/cartDelPedal/{article}")
    public ResponseEntity<Void> listArticlePedalToDel(
            @PathVariable(value = "article") Long article) {
        transmissionService.deleteArticlePedal(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }


// Cart
    @RequestMapping("/cart")
    public String cartVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        //Lists with components, that user added to cart
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
        List<BackDerailleur> backDerailleurs = new ArrayList<>();
        List<BackGearKas> backGearKass = new ArrayList<>();
        List<BackGearTr> backGearTrs = new ArrayList<>();
        List<Bracket> brackets = new ArrayList<>();
        List<Chain> chains = new ArrayList<>();
        List<Crank> cranks = new ArrayList<>();
        List<FrontDerailleur> frontDerailleurs = new ArrayList<>();
        List<Pedal> pedals = new ArrayList<>();

        double totalPrice = 0; //Total price in cart
        int total = 0; // number of product in cart

//Select components from database by article, that user added to cart, and add this components to List
        for (int i = 0; i < frameService.getSize(); i++) {
            Frame frame = frameService.findFrameByArticle(frameService.getArticleFromCart(i));
            double price = frame.getPrice();
            frames.add(frame);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < forkService.getSize(); i++) {
            Fork fork = forkService.findForkByArticle(forkService.getArticleFromCart(i));
            double price = fork.getPrice();
            forks.add(fork);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < handlebarService.getSizeHandlebar(); i++) {
            Handlebar handlebar = handlebarService.findHandlebarByArticle(handlebarService.getArticleHandlebarFromCart(i));
            double price = handlebar.getPrice();
            handlebars.add(handlebar);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < handlebarService.getSizeStem(); i++) {
            Stem stem = handlebarService.findStemByArticle(handlebarService.getArticleStemFromCart(i));
            double price = stem.getPrice();
            stems.add(stem);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < handlebarService.getSizeGrips(); i++) {
            Grips gripss = handlebarService.findGripsByArticle(handlebarService.getArticleGripsFromCart(i));
            double price = gripss.getPrice();
            grips.add(gripss);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < handlebarService.getSizeHeadset(); i++) {
            Headset headset = handlebarService.findHeadsetByArticle(handlebarService.getArticleHeadsetFromCart(i));
            double price = headset.getPrice();
            headsets.add(headset);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < handlebarService.getSizeWinding(); i++) {
            Winding winding = handlebarService.findWindingByArticle(handlebarService.getArticleWindingFromCart(i));
            double price = winding.getPrice();
            windings.add(winding);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < brakeService.getSizeBrakeDiscHydraulic(); i++) {
            BrakeDiscHydraulic brakeDiscHydraulic = brakeService.
                    findBrakeDiscHydraulicByArticle(brakeService.getArticleBrakeDiscHydraulicFromCart(i));
            double price = brakeDiscHydraulic.getPrice();
            brakeDiscHydraulics.add(brakeDiscHydraulic);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < brakeService.getSizeBrakeDiscMechanik(); i++) {
            BrakeDiscMechanik brakeDiscMechanik = brakeService.
                    findBrakeDiscMechanikByArticle(brakeService.getArticleBrakeDiscMechanikFromCart(i));
            double price = brakeDiscMechanik.getPrice();
            brakeDiscMechaniks.add(brakeDiscMechanik);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < brakeService.getSizeBrakeVBrake(); i++) {
            BrakeVBrake brakeVBrake = brakeService.findBrakeVBrakeByArticle(brakeService.getArticleBrakeVBrakeFromCart(i));
            double price = brakeVBrake.getPrice();
            brakeVBrakes.add(brakeVBrake);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < brakeService.getSizeBrakeHandle(); i++) {
            BrakeHandle brakeHandle = brakeService.findBrakeHandleByArticle(brakeService.getArticleBrakeHandleFromCart(i));
            double price = brakeHandle.getPrice();
            brakeHandles.add(brakeHandle);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < wheelService.getSizeBackHub(); i++) {
            BackHub backHub = wheelService.findBackHubByArticle(wheelService.getArticleBackHubFromCart(i));
            double price = backHub.getPrice();
            backHubs.add(backHub);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < wheelService.getSizeFrontHub(); i++) {
            FrontHub frontHub = wheelService.findFrontHubByArticle(wheelService.getArticleFrontHubFromCart(i));
            double price = frontHub.getPrice();
            frontHubs.add(frontHub);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < wheelService.getSizeRim(); i++) {
            Rim rim = wheelService.findRimByArticle(wheelService.getArticleRimFromCart(i));
            double price = rim.getPrice();
            rims.add(rim);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < wheelService.getSizeSpoke(); i++) {
            Spoke spoke = wheelService.findSpokeByArticle(wheelService.getArticleSpokeFromCart(i));
            double price = spoke.getPrice();
            spokes.add(spoke);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < wheelService.getSizeTire(); i++) {
            Tire tire = wheelService.findTireByArticle(wheelService.getArticleTireFromCart(i));
            double price = tire.getPrice();
            tires.add(tire);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < wheelService.getSizeWheel(); i++) {
            Wheel wheel = wheelService.findWheelByArticle(wheelService.getArticleWheelFromCart(i));
            double price = wheel.getPrice();
            wheels.add(wheel);
            totalPrice += price;
            total++;
        }
        //For transmission
        for (int i = 0; i < transmissionService.getSizeBackDerailleur(); i++) {
            BackDerailleur backDerailleur = transmissionService.findBackDerailleurByArticle(transmissionService.getArticleBackDerailleurFromCart(i));
            double price = backDerailleur.getPrice();
            backDerailleurs.add(backDerailleur);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < transmissionService.getSizeBackGearKas(); i++) {
            BackGearKas backGearKas = transmissionService.findBackGearKasByArticle(transmissionService.getArticleBackGearKasFromCart(i));
            double price = backGearKas.getPrice();
            backGearKass.add(backGearKas);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < transmissionService.getSizeBackGearTr(); i++) {
            BackGearTr backGearTr = transmissionService.findBackGearTrByArticle(transmissionService.getArticleBackGearTrFromCart(i));
            double price = backGearTr.getPrice();
            backGearTrs.add(backGearTr);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < transmissionService.getSizeBracket(); i++) {
            Bracket bracket = transmissionService.findBracketByArticle(transmissionService.getArticleBracketFromCart(i));
            double price = bracket.getPrice();
            brackets.add(bracket);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < transmissionService.getSizeChain(); i++) {
            Chain chain = transmissionService.findChainByArticle(transmissionService.getArticleChainFromCart(i));
            double price = chain.getPrice();
            chains.add(chain);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < transmissionService.getSizeCrank(); i++) {
            Crank crank = transmissionService.findCrankByArticle(transmissionService.getArticleCrankFromCart(i));
            double price = crank.getPrice();
            cranks.add(crank);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < transmissionService.getSizeFrontDerailleur(); i++) {
            FrontDerailleur frontDerailleur = transmissionService.findFrontDerailleur(transmissionService.getArticleFrontDerailleurFromCart(i));
            double price = frontDerailleur.getPrice();
            frontDerailleurs.add(frontDerailleur);
            totalPrice += price;
            total++;
        }
        for (int i = 0; i < transmissionService.getSizePedal(); i++) {
            Pedal pedal = transmissionService.findPedalByArticle(transmissionService.getArticlePedalFromCart(i));
            double price = pedal.getPrice();
            pedals.add(pedal);
            totalPrice += price;
            total++;
        }
//models for cart
        model.addAttribute("total", total);
        model.addAttribute("totalPrice", totalPrice);
        //Forks
        model.addAttribute("forks", forks);
        //Frames
        model.addAttribute("frames", frames);
        // Handlebar Components
        model.addAttribute("handlebars", handlebars);
        model.addAttribute("stems", stems);
        model.addAttribute("grips", grips);
        model.addAttribute("headsets", headsets);
        model.addAttribute("windings", windings);
        //Brakes Components
        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);
        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
        model.addAttribute("brakeVBrakes", brakeVBrakes);
        model.addAttribute("brakeHandles", brakeHandles);
        //Wheels Components
        model.addAttribute("backHubs", backHubs);
        model.addAttribute("frontHubs", frontHubs);
        model.addAttribute("rims", rims);
        model.addAttribute("spokes", spokes);
        model.addAttribute("tires", tires);
        model.addAttribute("wheels", wheels);
        //Transmission Components
        model.addAttribute("backDerailleurs", backDerailleurs);
        model.addAttribute("backGearKass", backGearKass);
        model.addAttribute("backGearTrs", backGearTrs);
        model.addAttribute("brackets", brackets);
        model.addAttribute("chains", chains);
        model.addAttribute("cranks", cranks);
        model.addAttribute("frontDerailleurs", frontDerailleurs);
        model.addAttribute("pedals", pedals);
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
                    findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
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
                findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("gripss", gripss);
        return "gripsToHandlebar";
    }

}


