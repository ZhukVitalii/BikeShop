package beetle.Wheels;

import beetle.Frames.BikeType;
import beetle.Forks.BrakesType;
import beetle.Forks.ForkService;
import beetle.Forks.WheelsDiam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by VitaliiZhuk on 12.06.2017.
 */
@Controller
public class WheelController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;


    @Autowired
    private WheelService wheelService;
    @Autowired
    private ForkService forkService;

    //return page with links to pages with components
    @RequestMapping("/show_wheelsComponent")
    public String wheelsComponentsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        return "wheelsComponent";
    }

    //for admin with all brakes components
    @RequestMapping("/admin/show_wheels")
    public String wheelsAdminVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Wheel> wheels = wheelService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Spoke> spokes = wheelService
                .findAllOne(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Rim> rims = wheelService
                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<FrontHub> frontHubs = wheelService
                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BackHub> backHubs = wheelService
                .findAllFor(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Tire> tires = wheelService
                .findAllFive(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("spokeNumber", wheelService.findSpokeNumber());
        model.addAttribute("rimWide", wheelService.findRimWide());
        model.addAttribute("wheelsDiam", forkService.findWheelsDiam());
        model.addAttribute("brakesType", forkService.findBrakesType());
        model.addAttribute("bikeType", forkService.findBikeType());
        model.addAttribute("etrtoSize", wheelService.findEtrtoSize());
        model.addAttribute("innerTubeDiameter", wheelService.findInnerTubeDiameter());
        model.addAttribute("rimHeight", wheelService.findRimHeight());
        model.addAttribute("nipple", wheelService.findNipple());
        model.addAttribute("axisDiam", wheelService.findAxisDiam());
        model.addAttribute("axisLength", wheelService.findAxisLength());
        model.addAttribute("backSprocketType", wheelService.findBackSprocketType());
        model.addAttribute("backSprocketNumber", wheelService.findBackSprocketNumber());
        model.addAttribute("hubFixType", wheelService.findHubFixType());
        model.addAttribute("rotorFixType", wheelService.findRotorFixType());
        model.addAttribute("bearingType", wheelService.findBearingType());
        model.addAttribute("tireType", wheelService.findTireType());
        model.addAttribute("cordType", wheelService.findCordType());
        model.addAttribute("tireWide", wheelService.findTireWide());
        model.addAttribute("wheels", wheels);
        model.addAttribute("spokes", spokes);
        model.addAttribute("rims", rims);
        model.addAttribute("frontHubs", frontHubs);
        model.addAttribute("backHubs", backHubs);
        model.addAttribute("tires", tires);
        model.addAttribute("allPages", getPageCount());
        model.addAttribute("allPages", getPageCountSpoke());
        model.addAttribute("allPages", getPageCountRim());
        model.addAttribute("allPages", getPageCountTire());
        return "wheelsAdmin";
    }

    // return pages with type of wheels components

    @RequestMapping("/show_backHubs")
    public String backHubVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BackHub> backHubs = wheelService
                .findAllFor(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("backHubs", backHubs);
        model.addAttribute("allPages", getPageCountBackHub());
        return "backHubs";
    }

    @RequestMapping("/show_wheels")
    public String wheelsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Wheel> wheels = wheelService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("wheels", wheels);
        model.addAttribute("allPages", getPageCount());
        return "wheels";
    }

    @RequestMapping("/show_frontHubs")
    public String frontHubsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<FrontHub> frontHubs = wheelService
                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("frontHubs", frontHubs);
        model.addAttribute("allPages", getPageCountFrontHub());
        return "frontHubs";
    }

    @RequestMapping("/show_rims")
    public String rimsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Rim> rims = wheelService
                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("rims", rims);
        model.addAttribute("allPages", getPageCountRim());
        return "rims";
    }

    @RequestMapping("/show_spokes")
    public String spokesVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Spoke> spokes = wheelService
                .findAllOne(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("spokes", spokes);
        model.addAttribute("allPages", getPageCountSpoke());
        return "spokes";
    }

    @RequestMapping("/show_tires")
    public String tiresVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Tire> tires = wheelService
                .findAllFive(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("tires", tires);
        model.addAttribute("allPages", getPageCountTire());
        return "tires";
    }

    //add components from browser

    @RequestMapping("/admin/wheel_add_page")
    public String wheelAddPage(Model model) {
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("spokeNumber", wheelService.findSpokeNumber());
        model.addAttribute("rimWide", wheelService.findRimWide());
        model.addAttribute("wheelsDiam", forkService.findWheelsDiam());
        model.addAttribute("brakesType", forkService.findBrakesType());
        model.addAttribute("bikeType", forkService.findBikeType());
        return "wheel_add_page";
    }

    @RequestMapping("/admin/spoke_add_page")
    public String spokeAddPage(Model model) {
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        return "spoke_add_page";
    }

    @RequestMapping("/admin/rim_add_page")
    public String rimAddPage(Model model) {
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("bikeType", forkService.findBikeType());
        model.addAttribute("wheelsDiam", forkService.findWheelsDiam());
        model.addAttribute("etrtoSize", wheelService.findEtrtoSize());
        model.addAttribute("spokeNumber", wheelService.findSpokeNumber());
        model.addAttribute("innerTubeDiameter", wheelService.findInnerTubeDiameter());
        model.addAttribute("rimWide", wheelService.findRimWide());
        model.addAttribute("rimHeight", wheelService.findRimHeight());
        model.addAttribute("brakesType", forkService.findBrakesType());
        model.addAttribute("nipple", wheelService.findNipple());
        return "rim_add_page";
    }

    @RequestMapping("/admin/frontHub_add_page")
    public String frontHubAddPage(Model model) {
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("spokeNumber", wheelService.findSpokeNumber());
        model.addAttribute("brakesType", forkService.findBrakesType());
        model.addAttribute("axisDiam", wheelService.findAxisDiam());
        model.addAttribute("axisLength", wheelService.findAxisLength());
        model.addAttribute("hubFixType", wheelService.findHubFixType());
        model.addAttribute("rotorFixType", wheelService.findRotorFixType());
        model.addAttribute("bearingType", wheelService.findBearingType());
        return "frontHub_add_page";
    }

    @RequestMapping("/admin/backHub_add_page")
    public String backHubAddPage(Model model) {
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("spokeNumber", wheelService.findSpokeNumber());
        model.addAttribute("brakesType", forkService.findBrakesType());
        model.addAttribute("axisDiam", wheelService.findAxisDiam());
        model.addAttribute("axisLength", wheelService.findAxisLength());
        model.addAttribute("hubFixType", wheelService.findHubFixType());
        model.addAttribute("rotorFixType", wheelService.findRotorFixType());
        model.addAttribute("bearingType", wheelService.findBearingType());
        model.addAttribute("backSprocketType", wheelService.findBackSprocketType());
        model.addAttribute("backSprocketNumber", wheelService.findBackSprocketNumber());
        return "backHub_add_page";
    }

    @RequestMapping("/admin/tire_add_page")
    public String tireAddPage(Model model) {
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("tireType", wheelService.findTireType());
        model.addAttribute("cordType", wheelService.findCordType());
        model.addAttribute("tireWide", wheelService.findTireWide());
        model.addAttribute("wheelsDiam", forkService.findWheelsDiam());
        return "tire_add_page";
    }

    @RequestMapping("/admin/wheelMaker_add_page")
    public String wheelMakerAddPage() {
        return "wheelMaker_add_page";
    }

    // for filter by Maker

    @RequestMapping("/wheelMaker/{id}")
    public String listWheelMaker(
            @PathVariable(value = "id") long wheelMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        if (page < 0) page = 0;
        List<Wheel> wheels = wheelService
                .findByWheelMakers(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BackHub> backHubs = wheelService
                .findByBackHubMaker(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<FrontHub> frontHubs = wheelService
                .findByFrontHubMaker(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Rim> rims = wheelService
                .findByRimMaker(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Spoke> spokes = wheelService
                .findBySpokeMaker(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Tire> tires = wheelService
                .findByTireMaker(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("wheels", wheels);
        model.addAttribute("backHubs", backHubs);
        model.addAttribute("frontHubs", frontHubs);
        model.addAttribute("rims", rims);
        model.addAttribute("spokes", spokes);
        model.addAttribute("tires", tires);
        model.addAttribute("byWheelMakerPages", getPageCount(wheelMaker));
        model.addAttribute("groupId", wheelMakerId);
        return "wheelsAdmin";
    }

    //for delete components for admin

    @RequestMapping(value = "/admin/wheel/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteWheel(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/spoke/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteOne(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteSpoke(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/rim/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteTwo(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteRim(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/frontHub/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteThree(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteFrontHub(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/backHub/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFor(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteBackHub(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/tire/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFive(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteTire(toDelete);
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
            @RequestParam(value = "brakesType") long brakesTypeId,
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
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        WheelsDiam wheelsDiam = (wheelsDiamId != DEFAULT_GROUP_ID) ? forkService.findWheelsDiam(wheelsDiamId) : null;
        BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? forkService.findBikeType(bikeTypeId) : null;
        BrakesType brakesType = (brakesTypeId != DEFAULT_GROUP_ID) ? forkService.findBrakesType(brakesTypeId) : null;
        SpokeNumber spokeNumber = (spokeNumberId != DEFAULT_GROUP_ID) ? wheelService.findSpokeNumber(spokeNumberId) : null;
        RimWide rimWide = (rimWideId != DEFAULT_GROUP_ID) ? wheelService.findRimWide(rimWideId) : null;
        Wheel wheel = new Wheel(wheelMaker, article,url, name, wheelsDiam, bikeType, brakesType, spokeNumber,
                rimName,rimWide, rimDescription , hubName, hubDescription, description,price,way);
        wheelService.addWheel(wheel);
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
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        Spoke spoke = new Spoke(wheelMaker,article,url, name, length, diameter, material, color ,
                description, price, way);
       wheelService.addSpoke(spoke);
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
            @RequestParam(value = "brakesType") long brakesTypeId,
            @RequestParam String weight,
            @RequestParam(value = "nipple") long nippleId,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        WheelsDiam wheelsDiam = (wheelsDiamId != DEFAULT_GROUP_ID) ? forkService.findWheelsDiam(wheelsDiamId) : null;
        BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? forkService.findBikeType(bikeTypeId) : null;
        EtrtoSize etrtoSize = (etrtoSizeId != DEFAULT_GROUP_ID) ? wheelService.findEtrtoSize(etrtoSizeId) : null;
        InnerTubeDiameter innerTubeDiameter = (innerTubeDiameterId != DEFAULT_GROUP_ID) ? wheelService.findInnerTubeDiameter(innerTubeDiameterId) : null;
        BrakesType brakesType = (brakesTypeId != DEFAULT_GROUP_ID) ? forkService.findBrakesType(brakesTypeId) : null;
        SpokeNumber spokeNumber = (spokeNumberId != DEFAULT_GROUP_ID) ? wheelService.findSpokeNumber(spokeNumberId) : null;
        RimWide rimWide = (rimWideId != DEFAULT_GROUP_ID) ? wheelService.findRimWide(rimWideId) : null;
        RimHeight rimHeight = (rimHeightId != DEFAULT_GROUP_ID) ? wheelService.findRimHeight(rimHeightId) : null;
        Nipple nipple = (nippleId != DEFAULT_GROUP_ID) ? wheelService.findNipple(nippleId) : null;
        Rim rim = new Rim (wheelMaker,article,url, name, bikeType, wheelsDiam,etrtoSize, material, spokeNumber,
                innerTubeDiameter,rimWide,rimHeight,brakesType,weight, nipple ,color,description,price,way);
        wheelService.addRim(rim);
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
            @RequestParam(value = "brakesType") long brakesTypeId,
            @RequestParam(value = "rotorFixType") long rotorFixTypeId,
            @RequestParam(value = "spokeNumber") long spokeNumberId,
            @RequestParam String weight,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        HubFixType hubFixType = (hubFixTypeId != DEFAULT_GROUP_ID) ? wheelService.findHubFixType(hubFixTypeId) : null;
        BearingType bearingType = (bearingTypeId != DEFAULT_GROUP_ID) ? wheelService.findBearingType(bearingTypeId) : null;
        AxisLength axisLength = (axisLengthId != DEFAULT_GROUP_ID) ? wheelService.findAxisLength(axisLengthId) : null;
        AxisDiam axisDiam = (axisDiamId != DEFAULT_GROUP_ID) ? wheelService.findAxisDiam(axisDiamId) : null;
        BrakesType brakesType = (brakesTypeId != DEFAULT_GROUP_ID) ? forkService.findBrakesType(brakesTypeId) : null;
        RotorFixType rotorFixType = (rotorFixTypeId != DEFAULT_GROUP_ID) ? wheelService.findRotorFixType(rotorFixTypeId) : null;
        SpokeNumber spokeNumber = (spokeNumberId != DEFAULT_GROUP_ID) ? wheelService.findSpokeNumber(spokeNumberId) : null;
        FrontHub frontHub = new FrontHub (wheelMaker,article,url, name,hubFixType, bearingType, material,axisLength, axisDiam, brakesType,
                rotorFixType,spokeNumber,weight, color,description,price,way);
        wheelService.addFrontHub(frontHub);
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
            @RequestParam(value = "brakesType") long brakesTypeId,
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
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        HubFixType hubFixType = (hubFixTypeId != DEFAULT_GROUP_ID) ? wheelService.findHubFixType(hubFixTypeId) : null;
        BearingType bearingType = (bearingTypeId != DEFAULT_GROUP_ID) ? wheelService.findBearingType(bearingTypeId) : null;
        AxisLength axisLength = (axisLengthId != DEFAULT_GROUP_ID) ? wheelService.findAxisLength(axisLengthId) : null;
        AxisDiam axisDiam = (axisDiamId != DEFAULT_GROUP_ID) ? wheelService.findAxisDiam(axisDiamId) : null;
        BrakesType brakesType = (brakesTypeId != DEFAULT_GROUP_ID) ? forkService.findBrakesType(brakesTypeId) : null;
        RotorFixType rotorFixType = (rotorFixTypeId != DEFAULT_GROUP_ID) ? wheelService.findRotorFixType(rotorFixTypeId) : null;
        SpokeNumber spokeNumber = (spokeNumberId != DEFAULT_GROUP_ID) ? wheelService.findSpokeNumber(spokeNumberId) : null;
        BackSprocketType backSprocketType = (backSprocketTypeId != DEFAULT_GROUP_ID) ? wheelService.findBackSprocketType(backSprocketTypeId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? wheelService.findBackSprocketNumber(backSprocketNumberId) : null;
        BackHub backHub = new BackHub (wheelMaker,article,url, name,hubFixType, bearingType, material,axisLength, axisDiam, brakesType,
                rotorFixType,spokeNumber,backSprocketType,backSprocketNumber,weight, color,description,price,way);
        wheelService.addBackHub(backHub);
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
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        WheelsDiam wheelsDiam = (wheelsDiamId != DEFAULT_GROUP_ID) ? forkService.findWheelsDiam(wheelsDiamId) : null;
        TireType tireType = (tireTypeId != DEFAULT_GROUP_ID) ? wheelService.findTireType(tireTypeId) : null;
        CordType cordType = (cordTypeId != DEFAULT_GROUP_ID) ? wheelService.findCordType(cordTypeId) : null;
        TireWide tireWide = (tireWideId != DEFAULT_GROUP_ID) ? wheelService.findTireWide(tireWideId) : null;
        Tire tire = new Tire( wheelMaker,article,url, name, wheelsDiam, tireType, cordType, tireWide,
                color, description,price,way);
        wheelService.addTire(tire);
        return "redirect:/show_tires";
    }

    //Add Maker to database
    @RequestMapping(value="/admin/wheelMaker/add", method = RequestMethod.POST)
    public String wheelMakerAdd(@RequestParam String name) {
        wheelService.addWheelMaker(new WheelMaker(name));
        return "redirect:/show_wheels";
    }

    // Select one product by url and open in separate page

    @RequestMapping("/wheel/{url}")
    public String listWheelUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Wheel> wheels = wheelService
                .findWheelByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("wheels", wheels);
        return "OneWheel";
    }

    @RequestMapping("/backHub/{url}")
    public String listBachHubUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<BackHub> backHubs = wheelService
                .findBackHubByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("backHubs", backHubs);
        return "OneBackHub";
    }

    @RequestMapping("/frontHub/{url}")
    public String listFrontHubUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<FrontHub> frontHubs = wheelService
                .findFrontHubByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frontHubs", frontHubs);
        return "OneFrontHub";
    }

    @RequestMapping("/rim/{url}")
    public String listRimUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Rim> rims = wheelService
                .findRimByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("rims", rims);
        return "OneRim";
    }

    @RequestMapping("/spoke/{url}")
    public String listSpokeUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Spoke> spokes = wheelService
                .findSpokeByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("spokes", spokes);
        return "OneSpoke";
    }

    @RequestMapping("/tire/{url}")
    public String listTireUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Tire> tires = wheelService
                .findTireByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("tires", tires);
        return "OneTire";
    }



    private long getPageCount() {
        long totalCount = wheelService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountSpoke() {
        long totalCount = wheelService.countSpoke();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountRim() {
        long totalCount = wheelService.countRim();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountFrontHub() {
        long totalCount = wheelService.countFrontHub();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBackHub() {
        long totalCount = wheelService.countBackHub();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountTire() {
        long totalCount = wheelService.countTire();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCount(WheelMaker wheelMaker) {
        long totalCount = wheelService.countByWheelMaker(wheelMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

}

