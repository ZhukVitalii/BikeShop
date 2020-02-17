package beetle.controller;

import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.Fork;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.frame.BikeType;
import beetle.entity.frame.Frame;
import beetle.entity.handlebars.*;
import beetle.entity.wheels.*;
import beetle.json.frame.FrameInputJSON;
import beetle.mapper.BrakeMapper;
import beetle.mapper.FrameMapper;
import beetle.service.ForkService;
import beetle.service.FrameService;
import beetle.service.HandlebarService;
import beetle.service.WheelService;
import beetle.service.impl.BrakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/admin")
public class AdminController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;


    @Autowired
    private FrameService frameService;
    @Autowired
    private FrameMapper frameMapper;
    @Autowired
    private BrakeServiceImpl brakeServiceImpl;
    @Autowired
    private WheelService wheelService;
    @Autowired
    private HandlebarService handlebarService;
    @Autowired
    private BrakeMapper brakeMapper;
    @Autowired
    private ForkService forkService;
    //Page for admin
    @RequestMapping("/show_framesAdmin")
    public String framesAdminVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Frame> frames = frameService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        model.addAttribute("allPages", 200);
        return "framesAdmin";
    }

    //add components from browser
    @RequestMapping("/frame_add_page")
    public String frameAddPage(Model model) {
        model.addAttribute("frameMakers", frameService.findFrameMakers());
        model.addAttribute("frameSizes", frameService.findFrameSize());
        model.addAttribute("wheelsDiams", frameService.findWheelsDiam());
        model.addAttribute("trunkBindings", frameService.findTrunkBinding());
        model.addAttribute("bikeTypes", frameService.findBikeType());
        model.addAttribute("bracketWides", frameService.findBracketWide());
        model.addAttribute("headsetTypes", frameService.findHeadsetType());
        model.addAttribute("tubeDiameters", frameService.findTubeDiameter());
        model.addAttribute("underSaddleTubes", frameService.findUnderSaddleTube());
        model.addAttribute("brakesTypes", frameService.findBrakesType());
        return "frame_add_page";
    }

    @RequestMapping("/frameMaker_add_page")
    public String frameMakerAddPage() {
        return "frameMaker_add_page";
    }

    //for delete components for admin
    @RequestMapping(value = "/frame/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            frameService.deleteFrame(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add fork to database
    @RequestMapping(value="/frame/add", method = RequestMethod.POST)
    public String frameAdd( @RequestBody FrameInputJSON input)
    {
        Frame frame = frameMapper.toFrame(input);
        frameService.addFrame(frame);
        return "redirect:/show_frames";
    }

    //Add Maker to database
    @RequestMapping(value="/frameMaker/add", method = RequestMethod.POST)
    public String groupAdd(@RequestParam String name) {
        frameService.addFrameMaker(new Manufacturer(name));
        return "redirect:/show_frames";
    }

    //for admin with all brakes components
    @RequestMapping("/show_brakes")
    public String brakesVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
//
//        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeServiceImpl
//                .findAllBrakes(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeServiceImpl
//                .findAllOne(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        List<BrakeVBrake> brakeVBrakes = brakeServiceImpl
//                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        List<BrakeHandle> brakeHandles = brakeServiceImpl
//                .findAllHandles(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
//        model.addAttribute("locations", brakeServiceImpl.findLocation());
//        model.addAttribute("brakeLiquids", brakeServiceImpl.findBrakeLiquid());
//        model.addAttribute("lengthHydrolines", brakeServiceImpl.findLengthHydroline());
//        model.addAttribute("rotorDiams", brakeServiceImpl.findRotorDiam());
//        model.addAttribute("rotorFixTypes", wheelService.findRotorFixType());
//        model.addAttribute("brakeHandleLocations", brakeServiceImpl.findBrakeHandleLocation());
//        model.addAttribute("brakeHandleCompatibilitys", brakeServiceImpl.findBrakeHandleCompatibility());
//        model.addAttribute("handlebarDiameters", handlebarService.findHandlebarDiameter());
//        model.addAttribute("brakeHandleWides", brakeServiceImpl.findBrakeHandleWide());
//        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);
//        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
//        model.addAttribute("brakeVBrakes", brakeVBrakes);
//        model.addAttribute("brakeHandles", brakeHandles);
//        model.addAttribute("allPages", getPageCountBrakeDiscHydr());
//        model.addAttribute("allPages", getPageCountBrakeDiscMech());
//        model.addAttribute("allPages", getPageCountVBrake());
//        model.addAttribute("allPages", getPageCountBrakeHandle());
        return "brakesAdmin";
    }

    //add components from browser
    @RequestMapping("/admin/brakeDiscHydr_add_page")
    public String brakeDiscHydrAddPage(Model model) {
//        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
//        model.addAttribute("locations", brakeServiceImpl.findLocation());
//        model.addAttribute("brakeLiquids", brakeServiceImpl.findBrakeLiquid());
//        model.addAttribute("lengthHydrolines", brakeServiceImpl.findLengthHydroline());
//        model.addAttribute("rotorDiams", brakeServiceImpl.findRotorDiam());
//        model.addAttribute("rotorFixTypes", wheelService.findRotorFixType());
        return "brakeDiscHydr_add_page";
    }

    @RequestMapping("/admin/brakeDiscMech_add_page")
    public String brakeDiscMechAddPage(Model model) {
//        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
//        model.addAttribute("locations", brakeServiceImpl.findLocation());
//        model.addAttribute("rotorDiams", brakeServiceImpl.findRotorDiam());
//        model.addAttribute("rotorFixTypes", wheelService.findRotorFixType());
        return "brakeDiscMech_add_page";
    }

    @RequestMapping("/admin/brakeVBrake_add_page")
    public String brakeVBrakeAddPage(Model model) {
//        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
//        model.addAttribute("locations", brakeServiceImpl.findLocation());
        return "brakeVBrake_add_page";
    }

    @RequestMapping("/admin/brakeHandle_add_page")
    public String brakeHandleAddPage(Model model) {
//        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
//        model.addAttribute("brakeHandleLocations", brakeServiceImpl.findBrakeHandleLocation());
//        model.addAttribute("brakeHandleCompatibilitys", brakeServiceImpl.findBrakeHandleCompatibility());
//        model.addAttribute("handlebarDiameters", handlebarService.findHandlebarDiameter());
//        model.addAttribute("brakeHandleWides", brakeServiceImpl.findBrakeHandleWide());
//
        return "brakeHandle_add_page";
    }

    @RequestMapping("/admin/brakeMaker_add_page")
    public String brakeMakerAddPage() {
        return "brakeMaker_add_page";
    }

    //for delete components for admin
    @RequestMapping(value = "/admin/brakeDiscHydr/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteBrakeDiscHydr(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            brakeServiceImpl.deleteBrakes(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/brakeDiscMech/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteOne(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
//        if (toDelete != null && toDelete.length > 0)
//            brakeServiceImpl.deleteBrakeDiscMechanik(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/brakeVBrake/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteTwo(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
//        if (toDelete != null && toDelete.length > 0)
//            brakeServiceImpl.deleteBrakeVBrake(toDelete);
//
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/brakeHandle/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteThree(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            brakeServiceImpl.deleteBrakeHandle(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add components to database
//    @RequestMapping(value="/admin/brakeDiscHydr/add", method = RequestMethod.POST)
//    @ResponseBody
//    public String brakeDiscHydrAdd(@RequestBody BrakeInputJSON input ){
////        BrakeDiscHydraulic brakeDiscHydraulic = brakeMapper.toBrakeDiscHydraulic(input);
////        brakeServiceImpl.addBrakeDiscHydraulic(brakeDiscHydraulic);
//        return "redirect:/show_brakesHydro";
//    }

    @RequestMapping(value="/admin/brakeDiscMech/add", method = RequestMethod.POST)
    public String brakeDiscMechAdd(
            @RequestParam(value = "brakeMaker") long brakeMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "location") long locationId,
            @RequestParam(value = "rotorDiam") long rotorDiamId,
            @RequestParam String rotorWeight,
            @RequestParam String materialBrake,
            @RequestParam String brakeWeight,
            @RequestParam(value = "rotorFixType") long rotorFixTypeId,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        //todo migrate to mapper
//        Manufacturer brakeMaker = (brakeMakerId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findBrakeMaker(brakeMakerId) : null;
//        Location location = (locationId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findLication(locationId) : null;
//        RotorDiam rotorDiam = (rotorDiamId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findRotorDiam(rotorDiamId) : null;
//        RotorFixType rotorFixType = (rotorFixTypeId != DEFAULT_GROUP_ID) ? wheelService.findRotorFixType(rotorFixTypeId) : null;
//        BrakeDiscMechanik brakeDiscMechanik = new BrakeDiscMechanik(brakeMaker,article,url,name,location,rotorDiam,rotorWeight,materialBrake,brakeWeight,
//                rotorFixType,color,description,price,way);
//        brakeServiceImpl.addBrakeDiscMechanik(brakeDiscMechanik);
        return "redirect:/show_brakesMech";
    }

    @RequestMapping(value="/admin/brakeVBrake/add", method = RequestMethod.POST)
    public String brakeVBrakeAdd(
            @RequestParam(value = "brakeMaker") long brakeMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "location") long locationId,
            @RequestParam String material,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        //todo migrate to mapper
//        Manufacturer brakeMaker = (brakeMakerId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findBrakeMaker(brakeMakerId) : null;
//        Location location = (locationId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findLication(locationId) : null;
//        BrakeVBrake brakeVBrake = new BrakeVBrake(brakeMaker,article,url, name,location,material,color,description,price,way);
//        brakeServiceImpl.addBrakeVBrake(brakeVBrake);
        return "redirect:/show_brakesVBrake";
    }

    @RequestMapping(value="/admin/brakeHandle/add", method = RequestMethod.POST)
    public String brakeHandleAdd(
            @RequestParam(value = "brakeMaker") long brakeMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "brakeHandleLocation") long brakeHandleLocationId,
            @RequestParam(value = "brakeHandleCompatibility") long brakeHandleCompatibilityId,
            @RequestParam String materialHandle,
            @RequestParam String materialCorp,
            @RequestParam(value = "handlebarDiameter") long handlebarDiameterId,
            @RequestParam(value = "brakeHandleWide") long brakeHandleWideId,
            @RequestParam String weight,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
//        Manufacturer brakeMaker = (brakeMakerId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findBrakeMaker(brakeMakerId) : null;
//        BrakeHandleLocationEnum brakeHandleLocation = (brakeHandleLocationId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findBrakeHandleLocation(brakeHandleLocationId) : null;
//        BrakeHandleCompatibilityEnum brakeHandleCompatibility = (brakeHandleCompatibilityId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findBrakeHandleCompatibility(brakeHandleCompatibilityId) : null;
//        HandlebarDiameter handlebarDiameter = (handlebarDiameterId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarDiameter(handlebarDiameterId) : null;
//        BrakeHandleWide brakeHandleWide = (brakeHandleWideId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findBrakeHandleWide(brakeHandleWideId) : null;
        //todo migrate to mapper
//        BrakeHandle brakeHandle = new BrakeHandle(brakeMaker,article,url,name,brakeHandleLocation,brakeHandleCompatibility,materialHandle,materialCorp,
//                handlebarDiameter,brakeHandleWide,weight,color,description,price,way);
//
//        brakeServiceImpl.addBrakeHandle(brakeHandle);
        return "redirect:/show_brakesHandle";
    }

    //Add Maker to database
    @RequestMapping(value="/admin/brakeMaker/add", method = RequestMethod.POST)
    public String brakeMakerAdd(@RequestParam String name) {
        brakeServiceImpl.addBrakeMaker(new Manufacturer(name));
        return "redirect:/show_brakes";
    }
//
//    private long getPageCountBrakeDiscHydr() {
//        long totalCount = brakeServiceImpl.countBrakeDiscHydr();
//        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
//    }
//    private long getPageCountBrakeDiscMech() {
//        long totalCount = brakeServiceImpl.countBrakeDiscMech();
//        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
//    }
//    private long getPageCountVBrake() {
//        long totalCount = brakeServiceImpl.countVBrake();
//        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
//    }
//    private long getPageCountBrakeHandle() {
//        long totalCount = brakeServiceImpl.countBrakeHandle();
//        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
//    }

    @RequestMapping("/admin/show_forks")
    public String forksAdminVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Fork> forks = forkService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("forkMakers", forkService.findForkMakers());
        model.addAttribute("forks", forks);
        //model.addAttribute("allPages", getPageCount());
        return "forksAdmin";
    }

    //add components from browser
    @RequestMapping("/admin/fork_add")
    public String contactAddPage(Model model) {
//        model.addAttribute("forkMakers", forkService.findForkMakers());
//        model.addAttribute("bikeTypes", forkService.findBikeType());
//        model.addAttribute("tubeDiameters", forkService.findTubeDiameter());
//        model.addAttribute("wheelsDiams", forkService.findWheelsDiam());
        //model.addAttribute("brakesTypes", forkService.findBrakesType());
        return "fork_add";
    }

    @RequestMapping("/admin/forkMaker_add_page")
    public String forkMakerAddPage() {
        return "forkMaker_add_page";
    }

    //for delete components for admin
    @RequestMapping(value = "/admin/fork/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFork(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            forkService.deleteForks(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add fork to database
    @RequestMapping(value="/admin/fork/add", method = RequestMethod.POST)
    public String forkAdd(
            @RequestParam(value = "forkMaker") long forkMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "bikeType") long bikeTypeId,
            @RequestParam(value = "wheelsDiam") long wheelsDiamId,
            @RequestParam(value = "tubeDiameter") long tubeDiameterId,
            @RequestParam String stTubeLength,
            @RequestParam(value = "brakeType") long brakesTypeId,
            @RequestParam String forkMaterial,
            @RequestParam String weight,
            @RequestParam String color,
            @RequestParam String move,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        //todo migrate to mapper
//        Manufacturer forkMaker = (forkMakerId != DEFAULT_GROUP_ID) ? forkService.findForkMaker(forkMakerId) : null;
//        BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? forkService.findBikeType(bikeTypeId) : null;
//        TubeDiameter tubeDiameter = (tubeDiameterId != DEFAULT_GROUP_ID) ? forkService.findTubeDiameter(tubeDiameterId) : null;
//        WheelsDiam wheelsDiam = (wheelsDiamId != DEFAULT_GROUP_ID) ? forkService.findWheelsDiam(wheelsDiamId) : null;
       // BrakesType brakeType = (brakesTypeId != DEFAULT_GROUP_ID) ? forkService.findBrakesType(brakesTypeId) : null;
//        Fork fork = new Fork(forkMaker,article,url,  name, bikeType,  wheelsDiam,  tubeDiameter, stTubeLength, brakeType,  forkMaterial ,
//                weight, color, move, price, description, way);
//        forkService.addFork(fork);
        return "redirect:/show_forks";
    }

    //Add Maker to database
    @RequestMapping(value="/admin/forkMaker/add", method = RequestMethod.POST)
    public String forkMakerAdd(@RequestParam String name) {
        forkService.addForkMaker(new Manufacturer(name));
        return "redirect:/show_forks";
    }

    //for admin with all brakes components
    @RequestMapping("/admin/show_wheels")
    public String wheelsAdminVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
//        List<Wheel> wheels = wheelService
//                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        List<Spoke> spokes = wheelService
//                .findAllOne(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        List<Rim> rims = wheelService
//                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        List<FrontHub> frontHubs = wheelService
//                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        List<BackHub> backHubs = wheelService
//                .findAllFor(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        List<Tire> tires = wheelService
//                .findAllFive(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
//        model.addAttribute("spokeNumber", wheelService.findSpokeNumber());
//        model.addAttribute("rimWide", wheelService.findRimWide());
//        model.addAttribute("wheelsDiam", forkService.findWheelsDiam());
        // model.addAttribute("brakeType", forkService.findBrakesType());
//        model.addAttribute("bikeType", forkService.findBikeType());
//        model.addAttribute("etrtoSize", wheelService.findEtrtoSize());
//        model.addAttribute("innerTubeDiameter", wheelService.findInnerTubeDiameter());
//        model.addAttribute("rimHeight", wheelService.findRimHeight());
//        model.addAttribute("nipple", wheelService.findNipple());
//        model.addAttribute("axisDiam", wheelService.findAxisDiam());
//        model.addAttribute("axisLength", wheelService.findAxisLength());
//        model.addAttribute("backSprocketType", wheelService.findBackSprocketType());
//        model.addAttribute("backSprocketNumber", wheelService.findBackSprocketNumber());
//        model.addAttribute("hubFixType", wheelService.findHubFixType());
//        model.addAttribute("rotorFixType", wheelService.findRotorFixType());
//        model.addAttribute("bearingType", wheelService.findBearingType());
//        model.addAttribute("wheels", wheels);
//        model.addAttribute("spokes", spokes);
//        model.addAttribute("rims", rims);
//        model.addAttribute("frontHubs", frontHubs);
//        model.addAttribute("backHubs", backHubs);
//        model.addAttribute("tires", tires);
//        model.addAttribute("allPages", getPageCount());
//        model.addAttribute("allPages", getPageCountSpoke());
//        model.addAttribute("allPages", getPageCountRim());
//        model.addAttribute("allPages", getPageCountTire());
        return "wheelsAdmin";
    }


    //add components from browser

    @RequestMapping("/admin/wheel_add_page")
    public String wheelAddPage(Model model) {
//        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
//        model.addAttribute("spokeNumber", wheelService.findSpokeNumber());
//        model.addAttribute("rimWide", wheelService.findRimWide());
//        model.addAttribute("wheelsDiam", forkService.findWheelsDiam());
        //  model.addAttribute("brakeType", forkService.findBrakesType());
//        model.addAttribute("bikeType", forkService.findBikeType());
        return "wheel_add_page";
    }

    @RequestMapping("/admin/spoke_add_page")
    public String spokeAddPage(Model model) {
//        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        return "spoke_add_page";
    }

    @RequestMapping("/admin/rim_add_page")
    public String rimAddPage(Model model) {
//        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
//        model.addAttribute("bikeType", forkService.findBikeType());
//        model.addAttribute("wheelsDiam", forkService.findWheelsDiam());
//        model.addAttribute("etrtoSize", wheelService.findEtrtoSize());
//        model.addAttribute("spokeNumber", wheelService.findSpokeNumber());
//        model.addAttribute("innerTubeDiameter", wheelService.findInnerTubeDiameter());
//        model.addAttribute("rimWide", wheelService.findRimWide());
//        model.addAttribute("rimHeight", wheelService.findRimHeight());
        //  model.addAttribute("brakeType", forkService.findBrakesType());
//        model.addAttribute("nipple", wheelService.findNipple());
        return "rim_add_page";
    }

    @RequestMapping("/admin/frontHub_add_page")
    public String frontHubAddPage(Model model) {
//        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
//        model.addAttribute("spokeNumber", wheelService.findSpokeNumber());
        //  model.addAttribute("brakeType", forkService.findBrakesType());
//        model.addAttribute("axisDiam", wheelService.findAxisDiam());
//        model.addAttribute("axisLength", wheelService.findAxisLength());
//        model.addAttribute("hubFixType", wheelService.findHubFixType());
//        model.addAttribute("rotorFixType", wheelService.findRotorFixType());
//        model.addAttribute("bearingType", wheelService.findBearingType());
        return "frontHub_add_page";
    }

    @RequestMapping("/admin/backHub_add_page")
    public String backHubAddPage(Model model) {
//        model.addAttribute("wheelMakers", wheelService.findWheelMaker
        //   model.addAttribute("brakeType", forkService.findBrakesType());
//        model.addAttribute("axisDiam", wheelService.findAxisDiam());
//        model.addAttribute("axisLength", wheelService.findAxisLength());
//        model.addAttribute("hubFixType", wheelService.findHubFixType());
//        model.addAttribute("rotorFixType", wheelService.findRotorFixType());
//        model.addAttribute("bearingType", wheelService.findBearingType());
//        model.addAttribute("backSprocketType", wheelService.findBackSprocketType());
//        model.addAttribute("backSprocketNumber", wheelService.findBackSprocketNumber());
        return "backHub_add_page";
    }

    @RequestMapping("/admin/tire_add_page")
    public String tireAddPage(Model model) {
//        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
//        model.addAttribute("wheelsDiam", forkService.findWheelsDiam());
        return "tire_add_page";
    }

    @RequestMapping("/admin/wheelMaker_add_page")
    public String wheelMakerAddPage() {
        return "wheelMaker_add_page";
    }


    @RequestMapping(value = "/admin/wheel/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteWh(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
//        if (toDelete != null && toDelete.length > 0)
//            wheelService.deleteWheel(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/spoke/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteSpoke(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
//        if (toDelete != null && toDelete.length > 0)
//            wheelService.deleteSpoke(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/rim/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteRim(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
//        if (toDelete != null && toDelete.length > 0)
//            wheelService.deleteRim(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/frontHub/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFrintHub(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
//        if (toDelete != null && toDelete.length > 0)
//            wheelService.deleteFrontHub(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/backHub/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFor(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
//        if (toDelete != null && toDelete.length > 0)
//            wheelService.deleteBackHub(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/tire/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFive(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
//        if (toDelete != null && toDelete.length > 0)
//            wheelService.deleteTire(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add components to database
    @RequestMapping(value="/admin/wheel/add", method = RequestMethod.POST)
    public String wheelAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "wheelsDiam") long wheelsDiamId,
            @RequestParam(value = "bikeType") long bikeTypeId,
            @RequestParam(value = "brakeType") long brakesTypeId,
            @RequestParam(value = "spokeNumber") long spokeNumberId,
            @RequestParam String rimName,
            @RequestParam(value = "rimWide") long rimWideId,
            @RequestParam String rimDescription,
            @RequestParam String hubName,
            @RequestParam String hubDescription,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        //todo migrate to mapper
//        Manufacturer wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        // WheelsDiam wheelsDiam = (wheelsDiamId != DEFAULT_GROUP_ID) ? forkService.findWheelsDiam(wheelsDiamId) : null;
        //  BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? forkService.findBikeType(bikeTypeId) : null;
        //   BrakesType brakeType = (brakesTypeId != DEFAULT_GROUP_ID) ? forkService.findBrakesType(brakesTypeId) : null;
//        SpokeNumber spokeNumber = (spokeNumberId != DEFAULT_GROUP_ID) ? wheelService.findSpokeNumber(spokeNumberId) : null;
//        RimWide rimWide = (rimWideId != DEFAULT_GROUP_ID) ? wheelService.findRimWide(rimWideId) : null;
//        Wheel wheel = new Wheel(wheelMaker, article,url, name, wheelsDiam, bikeType, brakeType, spokeNumber,
//                rimName,rimWide, rimDescription , hubName, hubDescription, description,price,way);
//        wheelService.addWheel(wheel);
        return "redirect:/show_wheels";
    }

    @RequestMapping(value="/admin/spoke/add", method = RequestMethod.POST)
    public String spokeAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam String length,
            @RequestParam String diameter,
            @RequestParam String material,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        //todo migrate to mapper
//        Manufacturer wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
//        Spoke spoke = new Spoke(wheelMaker,article,url, name, length, diameter, material, color ,
//                description, price, way);
//       wheelService.addSpoke(spoke);
        return "redirect:/show_spokes";
    }

    @RequestMapping(value="/admin/rim/add", method = RequestMethod.POST)
    public String rimAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "bikeType") long bikeTypeId,
            @RequestParam(value = "wheelsDiam") long wheelsDiamId,
            @RequestParam(value = "etrtoSize") long etrtoSizeId,
            @RequestParam String material,
            @RequestParam(value = "spokeNumber") long spokeNumberId,
            @RequestParam(value = "innerTubeDiameter") long innerTubeDiameterId,
            @RequestParam(value = "rimWide") long rimWideId,
            @RequestParam(value = "rimHeight") long rimHeightId,
            @RequestParam(value = "brakeType") long brakesTypeId,
            @RequestParam String weight,
            @RequestParam(value = "nipple") long nippleId,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        //todo migrate to mapper
//        Manufacturer wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        // WheelsDiam wheelsDiam = (wheelsDiamId != DEFAULT_GROUP_ID) ? forkService.findWheelsDiam(wheelsDiamId) : null;
        //  BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? forkService.findBikeType(bikeTypeId) : null;
//        EtrtoSize etrtoSize = (etrtoSizeId != DEFAULT_GROUP_ID) ? wheelService.findEtrtoSize(etrtoSizeId) : null;
//        InnerTubeDiameter innerTubeDiameter = (innerTubeDiameterId != DEFAULT_GROUP_ID) ? wheelService.findInnerTubeDiameter(innerTubeDiameterId) : null;
        // BrakesType brakeType = (brakesTypeId != DEFAULT_GROUP_ID) ? forkService.findBrakesType(brakesTypeId) : null;
//        SpokeNumber spokeNumber = (spokeNumberId != DEFAULT_GROUP_ID) ? wheelService.findSpokeNumber(spokeNumberId) : null;
//        RimWide rimWide = (rimWideId != DEFAULT_GROUP_ID) ? wheelService.findRimWide(rimWideId) : null;
//        RimHeight rimHeight = (rimHeightId != DEFAULT_GROUP_ID) ? wheelService.findRimHeight(rimHeightId) : null;
//        Nipple nipple = (nippleId != DEFAULT_GROUP_ID) ? wheelService.findNipple(nippleId) : null;
//        Rim rim = new Rim (wheelMaker,article,url, name, bikeType, wheelsDiam,etrtoSize, material, spokeNumber,
//                innerTubeDiameter,rimWide,rimHeight,brakeType,weight, nipple ,color,description,price,way);
//        wheelService.addRim(rim);
        return "redirect:/show_rims";
    }

    @RequestMapping(value="/admin/frontHub/add", method = RequestMethod.POST)
    public String frontHubAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "hubFixType") long hubFixTypeId,
            @RequestParam(value = "bearingType") long bearingTypeId,
            @RequestParam String material,
            @RequestParam(value = "axisLength") long axisLengthId,
            @RequestParam(value = "axisDiam") long axisDiamId,
            @RequestParam(value = "brakeType") long brakesTypeId,
            @RequestParam(value = "rotorFixType") long rotorFixTypeId,
            @RequestParam(value = "spokeNumber") long spokeNumberId,
            @RequestParam String weight,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
//        Manufacturer wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
//        HubFixType hubFixType = (hubFixTypeId != DEFAULT_GROUP_ID) ? wheelService.findHubFixType(hubFixTypeId) : null;
//        BearingType bearingType = (bearingTypeId != DEFAULT_GROUP_ID) ? wheelService.findBearingType(bearingTypeId) : null;
//        AxisLength axisLength = (axisLengthId != DEFAULT_GROUP_ID) ? wheelService.findAxisLength(axisLengthId) : null;
//        AxisDiam axisDiam = (axisDiamId != DEFAULT_GROUP_ID) ? wheelService.findAxisDiam(axisDiamId) : null;
        // BrakesType brakeType = (brakesTypeId != DEFAULT_GROUP_ID) ? forkService.findBrakesType(brakesTypeId) : null;
//        RotorFixType rotorFixType = (rotorFixTypeId != DEFAULT_GROUP_ID) ? wheelService.findRotorFixType(rotorFixTypeId) : null;
//        SpokeNumber spokeNumber = (spokeNumberId != DEFAULT_GROUP_ID) ? wheelService.findSpokeNumber(spokeNumberId) : null;
//        FrontHub frontHub = new FrontHub (wheelMaker,article,url, name,hubFixType, bearingType, material,axisLength, axisDiam, brakeType,
//                rotorFixType,spokeNumber,weight, color,description,price,way);
//        wheelService.addFrontHub(frontHub);
        return "redirect:/show_frontHubs";
    }

    @RequestMapping(value="/admin/backHub/add", method = RequestMethod.POST)
    public String backHubAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "hubFixType") long hubFixTypeId,
            @RequestParam(value = "bearingType") long bearingTypeId,
            @RequestParam String material,
            @RequestParam(value = "axisLength") long axisLengthId,
            @RequestParam(value = "axisDiam") long axisDiamId,
            @RequestParam(value = "brakeType") long brakesTypeId,
            @RequestParam(value = "rotorFixType") long rotorFixTypeId,
            @RequestParam(value = "spokeNumber") long spokeNumberId,
            @RequestParam(value = "backSprocketType") long backSprocketTypeId,
            @RequestParam(value = "backSprocketNumber") long backSprocketNumberId,
            @RequestParam String weight,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        //todo migrate to mapper
//        Manufacturer wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
//        HubFixType hubFixType = (hubFixTypeId != DEFAULT_GROUP_ID) ? wheelService.findHubFixType(hubFixTypeId) : null;
//        BearingType bearingType = (bearingTypeId != DEFAULT_GROUP_ID) ? wheelService.findBearingType(bearingTypeId) : null;
//        AxisLength axisLength = (axisLengthId != DEFAULT_GROUP_ID) ? wheelService.findAxisLength(axisLengthId) : null;
//        AxisDiam axisDiam = (axisDiamId != DEFAULT_GROUP_ID) ? wheelService.findAxisDiam(axisDiamId) : null;
        //  BrakesType brakeType = (brakesTypeId != DEFAULT_GROUP_ID) ? forkService.findBrakesType(brakesTypeId) : null;
//        RotorFixType rotorFixType = (rotorFixTypeId != DEFAULT_GROUP_ID) ? wheelService.findRotorFixType(rotorFixTypeId) : null;
//        SpokeNumber spokeNumber = (spokeNumberId != DEFAULT_GROUP_ID) ? wheelService.findSpokeNumber(spokeNumberId) : null;
//        BackSprocketType backSprocketType = (backSprocketTypeId != DEFAULT_GROUP_ID) ? wheelService.findBackSprocketType(backSprocketTypeId) : null;
//        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? wheelService.findBackSprocketNumber(backSprocketNumberId) : null;
//        BackHub backHub = new BackHub (wheelMaker,article,url, name,hubFixType, bearingType, material,axisLength, axisDiam, brakeType,
//                rotorFixType,spokeNumber,backSprocketType,backSprocketNumber,weight, color,description,price,way);
//        wheelService.addBackHub(backHub);
        return "redirect:/show_backHubs";
    }

    @RequestMapping(value="/admin/tire/add", method = RequestMethod.POST)
    public String tireAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "wheelsDiam") long wheelsDiamId,
            @RequestParam(value = "tireType") long tireTypeId,
            @RequestParam(value = "cordType") long cordTypeId,
            @RequestParam(value = "tireWide") long tireWideId,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        //todo migrate to mapper
//        Manufacturer wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        //  WheelsDiam wheelsDiam = (wheelsDiamId != DEFAULT_GROUP_ID) ? forkService.findWheelsDiam(wheelsDiamId) : null;
//        Tire tire = new Tire( wheelMaker,article,url, name, wheelsDiam, tireType, cordType, tireWide,
//                color, description,price,way);
//        wheelService.addTire(tire);
        return "redirect:/show_tires";
    }

    //Add Maker to database
    @RequestMapping(value="/admin/wheelMaker/add", method = RequestMethod.POST)
    public String wheelMakerAdd(@RequestParam String name) {
//        wheelService.addWheelMaker(new Manufacturer(name));
        return "redirect:/show_wheels";
    }

    //for admin with all handlebars components
    @RequestMapping("/admin/show_handlebars")
    public String handlebarsAdminVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Handlebar> handlebars = handlebarService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Winding> windings = handlebarService
                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Grips> grips = handlebarService
                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Headset> headsets = handlebarService
                .findAllFor(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        List<Stem> stems = handlebarService
                .findAllFive(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("bikeType", handlebarService.findBikeType());
//        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());
        // model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        model.addAttribute("headsetType", handlebarService.findHeadsetType());
        model.addAttribute("handlebars", handlebars);
        model.addAttribute("windings", windings);
        model.addAttribute("grips", grips);
        model.addAttribute("headsets", headsets);
        model.addAttribute("stems", stems);
       // model.addAttribute("allPages", getPageCount());
        return "handlebarsAdmin";
    }


    //add components from browser

    @RequestMapping("/admin/handlebars_add_page")
    public String handelbarAddPage(Model model) {
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("bikeType", handlebarService.findBikeType());
//        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());
//        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        return "handlebars_add_page";
    }

    @RequestMapping("/admin/winding_add_page")
    public String windingAddPage(Model model) {
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        return "winding_add_page";
    }

    @RequestMapping("/admin/grips_add_page")
    public String gripsAddPage(Model model) {
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        return "grips_add_page";
    }

    @RequestMapping("/admin/headset_add_page")
    public String headsetAddPage(Model model) {
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("headsetType", handlebarService.findHeadsetType());
//        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        return "headset_add_page";
    }

    @RequestMapping("/admin/stem_add_page")
    public String stemAddPage(Model model) {
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
//        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());
//        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        return "stem_add_page";
    }

    @RequestMapping("/admin/handlebarMaker_add_page")
    public String handlebarMakerAddPage() {
        return "handlebarMaker_add_page";
    }


    @RequestMapping(value = "/admin/handlebar/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deletehandlebar(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteHandlebar(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/winding/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deletewinding(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteWinding(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/grips/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deletegrips(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteGrips(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/headset/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteheadset(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteHeadset(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/stem/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deletestem(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteStem(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add components to database

    @RequestMapping(value="/admin/handlebar/add", method = RequestMethod.POST)
    public String handlebarAdd(
            @RequestParam(value = "handlebarMaker") long handlebarMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "bikeType") long bikeTypeId,
            @RequestParam String handlebarWide,
            @RequestParam(value = "handlebarDiameter") long handlebarDiameterId,
            @RequestParam String handlebarHeight,
            @RequestParam String material,
            @RequestParam String weight,
            @RequestParam String color,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        //todo migrate to mapper
        Manufacturer handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? handlebarService.findBikeType(bikeTypeId) : null;
//        HandlebarDiameter handlebarDiameter = (handlebarDiameterId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarDiameter(handlebarDiameterId) : null;
//        Handlebar handlebar = new Handlebar(handlebarMaker,article, url,  name, bikeType, handlebarWide, handlebarDiameter, handlebarHeight,material,weight, color ,
//                 price, description, way);
//        handlebarService.addHandlebar(handlebar);
        return "redirect:/show_handlebars";
    }

    @RequestMapping(value="/admin/winding/add", method = RequestMethod.POST)
    public String windingAdd(
            @RequestParam(value = "handlebarMaker") long handlebarMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam String length,
            @RequestParam String wide,
            @RequestParam String material,
            @RequestParam String color,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        //todo migrate to mapper
        Manufacturer handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
//        Winding winding = new Winding(handlebarMaker,article,url,  name, length, wide, material, color ,
//                price, description, way);
//        handlebarService.addWinding(winding);
        return "redirect:/show_windings";
    }

    @RequestMapping(value="/admin/headset/add", method = RequestMethod.POST)
    public String headsetAdd(
            @RequestParam(value = "handlebarMaker") long handlebarMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "headsetType") long headsetTypeId,
            @RequestParam (value = "tubeDiameter") long tubeDiameterId,
            @RequestParam String material,
            @RequestParam String size,
            @RequestParam String color,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        //todo migrate to mapper
        Manufacturer handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        HeadsetType headsetType = (headsetTypeId != DEFAULT_GROUP_ID) ?  handlebarService.findHeadsetType(headsetTypeId) : null;
        //  TubeDiameter tubeDiameter = (tubeDiameterId != DEFAULT_GROUP_ID) ?  forkService.findTubeDiameter(tubeDiameterId) : null;
//        Headset headset = new Headset(handlebarMaker,article,url,  name, headsetType, tubeDiameter, material,size, color ,
//                price, description, way);
//        handlebarService.addHeadset(headset);
        return "redirect:/show_headsets";
    }

    @RequestMapping(value="/admin/stem/add", method = RequestMethod.POST)
    public String stemAdd(
            @RequestParam(value = "handlebarMaker") long handlebarMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam String angle,
            @RequestParam(value = "handlebarDiameter") long handlebarDiameterId,
            @RequestParam (value = "tubeDiameter") long tubeDiameterId,
            @RequestParam String material,
            @RequestParam String length,
            @RequestParam String color,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        // todo migrate to mapper
        Manufacturer handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
//        HandlebarDiameter handlebarDiameter = (handlebarDiameterId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarDiameter(handlebarDiameterId) : null;
        //  TubeDiameter tubeDiameter = (tubeDiameterId != DEFAULT_GROUP_ID) ?  forkService.findTubeDiameter(tubeDiameterId) : null;
//        Stem stem = new Stem(handlebarMaker, article, url, name, angle, handlebarDiameter, tubeDiameter, material,length, color ,
//                price, description, way);
//        handlebarService.addStem(stem);
        return "redirect:/show_stems";
    }

    @RequestMapping(value="/admin/grips/add", method = RequestMethod.POST)
    public String gripsAdd(
            @RequestParam(value = "handlebarMaker") long handlebarMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam String length,
            @RequestParam String weight,
            @RequestParam String material,
            @RequestParam String color,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        Manufacturer handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        //todo migrate to mapper
        //        Grips grips = new Grips(handlebarMaker,article,url, name, length, weight, material, color ,
//                price, description, way);
//        handlebarService.addGrips(grips);
        return "redirect:/show_grips";
    }

    @RequestMapping(value="/admin/handlebarMaker/add", method = RequestMethod.POST)
    public String handlebarMakerAdd(@RequestParam String name) {
        handlebarService.addHandlebarMaker(new Manufacturer(name));
        return "redirect:/show_handlebars";
    }
}
