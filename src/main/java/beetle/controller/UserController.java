package beetle.controller;

import beetle.entity.forks.BrakesType;
import beetle.entity.forks.Fork;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.frame.BikeType;
import beetle.entity.frame.Frame;
import beetle.entity.handlebars.*;
import beetle.entity.transmission.*;
import beetle.entity.wheels.*;
import beetle.mapper.FrameMapper;
import beetle.service.*;
import beetle.entity.brake.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static beetle.enums.ComponentType.*;

/**
 * Created by VitaliiZhuk on 07.07.2017.
 */
@Controller
@CrossOrigin
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
    @Autowired
    private FrameMapper frameMapper;

    //Return HOME-PAGE
    @RequestMapping("/")
    @GetMapping
    @ResponseBody
    public List<Long> index() {
        return Arrays.asList(1l,2l);
    }




// Select Forks
     @RequestMapping("/chooseFork/{id}")
    public String listForkForBike(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addChosenId(FRAME,id);
        Frame frame = frameService.findFrame(userService.getChosenId(FRAME));
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
        userService.addChosenId(FORK,id);
        Frame frame = frameService.findFrame(userService.getChosenId(FRAME));
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
        userService.addChosenId(WHEEL,id);
        Frame frame = frameService.findFrame(userService.getChosenId(FRAME));
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
        userService.addChosenId(BRACKET,id);
        Bracket bracket = transmissionService.findBracket(userService.getChosenId(BRACKET));
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
        userService.addChosenId(CRANK,id);
        Crank crank = transmissionService.findCrank(userService.getChosenId(CRANK));
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
        userService.addChosenId(BACK_GEAR_KAS,id);
        BackGearKas backGearKas = transmissionService.findBackGearKas(userService.getChosenId(BACK_GEAR_KAS));
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
        userService.addChosenId(BACK_DERAILLEUR,id);
        Crank crank = transmissionService.findCrank(userService.getChosenId(CRANK));
        BackGearKas backGearKas = transmissionService.findBackGearKas(userService.getChosenId(BACK_GEAR_KAS));
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
        userService.addChosenId(FRONT_DERAILLEUR,id);
        BackGearKas backGearKas = transmissionService.findBackGearKas(userService.getChosenId(BACK_GEAR_KAS));
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
        userService.addChosenId(CHAIN,id);
        List<Pedal> pedals = transmissionService.
                findAllSeven(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("pedals", pedals);
        return "pedalToBike";
    }
//    @RequestMapping("/chooseBrakes/{id}")
//    public String listBrakesForBike(
//            @PathVariable(value = "id") Long id,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model) {
//        userService.addChosenId(PEDAL,id);
//        Frame frame = frameService.findFrame(userService.getChosenId(FRAME));
//        BrakesType brakesType = frame.getBrakesType();
//        int a = (int)brakesType.getId();
//        Location location = brakeService.findLication(1);
//        List<BrakeVBrake> brakeVBrakes = brakeService
//                .findByLocationVBrake(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("brakeVBrakes", brakeVBrakes);
//        if (a == 1) {
//            return "brakesDiscSelect";
//        } else if (a == 2) {
//            return "brakesVBrakeFrontToBike";
//        } else {
//            return "brakesSelectType";
//        }
//    }
//    @RequestMapping("/chooseDiscHydraulic")
//    public String listDiscHydraulicFront(
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model) {
//        if (page < 0) page = 0;
//        Location location = brakeService.findLication(1);
//        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeService
//                .findByLocationHydraulic(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);
//        return "brakesHydraulicFrontToBike";
//    }
//    @RequestMapping("/chooseDiscHydraulicBack/{id}")
//    public String listDiscHydraulicBack(
//            @PathVariable(value = "id") Long id,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model)
//    {
//        if (page < 0) page = 0;
//        userService.addChosenId(BRAKE_DISC_HYDRAULIC_FRONT,id);
//        Location location = brakeService.findLication(2);
//        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeService
//                .findByLocationHydraulic(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);
//
//        return "brakesHydraulicBackToBike";
//    }
//    @RequestMapping("/chooseDiscMechanik")
//    public String listDiscMechanik(
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model) {
//        if (page < 0) page = 0;
//        Location location = brakeService.findLication(1);
//        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeService
//                .findByLocationMechanik(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
//        return "brakesMechanikFrontToBike";
//    }
//    @RequestMapping("/chooseDiscMechanikBack/{id}")
//    public String listDiscMechanikBack(
//            @PathVariable(value = "id") Long id,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model)
//    {
//        if (page < 0) page = 0;
//        userService.addChosenId(BRAKE_DISC_MECHANIK_FRONT,id);
//        Location location = brakeService.findLication(2);
//        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeService
//                .findByLocationMechanik(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
//        return "brakesMechanikBackToBike";
//    }
//    @RequestMapping("/chooseVBrakeFront")
//    public String listVBrakeFront(
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model) {
//        if (page < 0) page = 0;
//        Location location = brakeService.findLication(1);
//        List<BrakeVBrake> brakeVBrakes = brakeService
//                .findByLocationVBrake(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("brakeVBrakes", brakeVBrakes);
//        return "brakesVBrakeFrontToBike";
//    }
//    @RequestMapping("/chooseVBrakeBack/{id}")
//    public String listVBrakeBack(
//            @PathVariable(value = "id") Long id,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model)
//    {
//        if (page < 0) page = 0;
//        userService.addChosenId(BRAKE_DISC_MECHANIK_FRONT,id);
//        Location location = brakeService.findLication(2);
//        List<BrakeVBrake> brakeVBrakes = brakeService
//                .findByLocationVBrake(location, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("brakeVBrakes", brakeVBrakes);
//        return "brakesVBrakeBackToBike";
//    }
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
            userService.addChosenId(BRAKE_DISC_HYDRAULIC_BACK,id);
            System.out.println("hydro" + id +" " + type);
        } else if (type.equals(mechanik)) {
            userService.addChosenId(BRAKE_DISC_MECHANIK_BACK,id);
            System.out.println("mech" + id +" " + type);
        } else {
            userService.addChosenId(BRAKE_V_BRAKE_BACK,id);
            System.out.println("VBrake" + id +" " + type);
        }
        Frame frame = frameService.findFrame(userService.getChosenId(FRAME));
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
        userService.addChosenId(HANDLEBAR,id);
        Handlebar handlebar = handlebarService.findHandlebar(userService.getChosenId(HANDLEBAR));
        Fork fork = forkService.findFork(userService.getChosenId(FORK));
        HandlebarDiameter handlebarDiameter = handlebar.getHandlebarDiameter();
        TubeDiameter tubeDiameter = fork.getTubeDiameter();
        List<Stem> stems = handlebarService
                .findByHandlebarDiamAndTubeDiam(handlebarDiameter,tubeDiameter,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("stems", stems);
        return "stemsToHandlebar";
    }
//    @RequestMapping("/chooseBrakeHandle/{id}")
//    public String listBrakeHandleForHandlebar(
//            @PathVariable(value = "id") Long id,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model)
//    {
//        if (page < 0) page = 0;
//        userService.addChosenId(STEM,id);
//        // If user chose Hydraulic Brakes - Brake Handle are in the brakes kit
//        if(userService.getChosenId(BRAKE_DISC_HYDRAULIC_FRONT)!= 0) {
//            List<Grips> gripss = handlebarService.
//                    findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//            model.addAttribute("gripss", gripss);
//            return "gripsToHandlebar";
//        } else if (userService.getChosenId(BRAKE_DISC_MECHANIK_FRONT) != 0) {
//            // 2 is Id of Mechanik Disc Brake in DB
//            BrakeHandleCompatibilityEnum brakeHandleCompatibility = brakeService.
//                    findBrakeHandleCompatibility(2);
//            List<BrakeHandle> brakeHandles = brakeService.
//                    findByBrakeHandleCompatibility(brakeHandleCompatibility,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//            model.addAttribute("brakeHandles", brakeHandles);
//            return "brakesHandleToHandlebar";
//        } else {
//            // 3 is Id of V-Brake in DB
//            BrakeHandleCompatibilityEnum brakeHandleCompatibility = brakeService.
//                    findBrakeHandleCompatibility(3);
//            List<BrakeHandle> brakeHandles = brakeService.
//                    findByBrakeHandleCompatibility(brakeHandleCompatibility,new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//            model.addAttribute("brakeHandles", brakeHandles);
//            return "brakesHandleToHandlebar";
//        }
//    }
    @RequestMapping("/chooseGrips/{id}")
    public String listGripsForHandlebar(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        userService.addChosenId(BRAKE_HANDLE,id);
        List<Grips> gripss = handlebarService.
                findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("gripss", gripss);
        return "gripsToHandlebar";
    }

}


