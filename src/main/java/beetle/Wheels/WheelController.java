package beetle.Wheels;

import beetle.Bakes.BikeType;
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
import beetle.Forks.BrakesType;
import beetle.Forks.ForkService;
import beetle.Forks.WheelsDiam;

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




    @RequestMapping("/show_wheels")
    public String wheelsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
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

        return "wheels";
    }

    @RequestMapping("/wheel_add_page")
    public String wheelAddPage(Model model) {

        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("spokeNumber", wheelService.findSpokeNumber());
        model.addAttribute("rimWide", wheelService.findRimWide());

        model.addAttribute("wheelsDiam", forkService.findWheelsDiam());
        model.addAttribute("brakesType", forkService.findBrakesType());
        model.addAttribute("bikeType", forkService.findBikeType());


        return "wheel_add_page";
    }

    @RequestMapping("/spoke_add_page")
    public String spokeAddPage(Model model) {
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());

        return "spoke_add_page";
    }
    @RequestMapping("/rim_add_page")
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

    @RequestMapping("/frontHub_add_page")
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
    @RequestMapping("/backHub_add_page")
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
    @RequestMapping("/tire_add_page")
    public String tireAddPage(Model model) {
        model.addAttribute("wheelMakers", wheelService.findWheelMakers());
        model.addAttribute("tireType", wheelService.findTireType());
        model.addAttribute("cordType", wheelService.findCordType());
        model.addAttribute("tireWide", wheelService.findTireWide());
        model.addAttribute("wheelsDiam", forkService.findWheelsDiam());

        return "tire_add_page";
    }



    @RequestMapping("/wheelMaker_add_page")
    public String wheelMakerAddPage() {
        return "wheelMaker_add_page";
    }



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


        model.addAttribute("wheelMakers", wheelService.findWheelMakers());

        model.addAttribute("wheels", wheels);

        model.addAttribute("byWheelMakerPages", getPageCount(wheelMaker));

        model.addAttribute("groupId", wheelMakerId);

        return "wheels";
    }


    @RequestMapping(value = "/wheel/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteWheel(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/spoke/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteOne(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteSpoke(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/rim/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteTwo(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteRim(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/fromtHub/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteThree(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteFrontHub(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/backHub/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFor(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteBackHub(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/tire/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFive(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            wheelService.deleteTire(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }




    @RequestMapping(value="/wheel/add", method = RequestMethod.POST)
    public String wheelAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
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
        Wheel wheel = new Wheel(wheelMaker,  name, wheelsDiam, bikeType, brakesType, spokeNumber,
                rimName,rimWide, rimDescription , hubName, hubDescription, description,price,way);


        wheelService.addWheel(wheel);
        return "redirect:/show_wheels";
    }


    @RequestMapping(value="/spoke/add", method = RequestMethod.POST)
    public String spokeAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
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

        Spoke spoke = new Spoke(wheelMaker,  name, length, diameter, material, color ,
                description, price, way);


       wheelService.addSpoke(spoke);

        return "redirect:/show_wheels";
    }

    @RequestMapping(value="/rim/add", method = RequestMethod.POST)
    public String rimAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
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
        Rim rim = new Rim (wheelMaker,  name, bikeType, wheelsDiam,etrtoSize, material, spokeNumber,
                innerTubeDiameter,rimWide,rimHeight,brakesType,weight, nipple ,color,description,price,way);


        wheelService.addRim(rim);
        return "redirect:/show_wheels";
    }

    @RequestMapping(value="/frontHub/add", method = RequestMethod.POST)
    public String frontHubAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
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
        FrontHub frontHub = new FrontHub (wheelMaker,  name,hubFixType, bearingType, material,axisLength, axisDiam, brakesType,
                rotorFixType,spokeNumber,weight, color,description,price,way);


        wheelService.addFrontHub(frontHub);
        return "redirect:/show_wheels";
    }

    @RequestMapping(value="/backHub/add", method = RequestMethod.POST)
    public String backHubAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
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
        BackHub backHub = new BackHub (wheelMaker,  name,hubFixType, bearingType, material,axisLength, axisDiam, brakesType,
                rotorFixType,spokeNumber,backSprocketType,backSprocketNumber,weight, color,description,price,way);


        wheelService.addBackHub(backHub);
        return "redirect:/show_wheels";
    }

    @RequestMapping(value="/tire/add", method = RequestMethod.POST)
    public String tireAdd(
            @RequestParam(value = "wheelMaker") long wheelMakerId,
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

        Tire tire = new Tire( wheelMaker,  name, wheelsDiam, tireType, cordType, tireWide,
                color, description,price,way);


        wheelService.addTire(tire);
        return "redirect:/show_wheels";
    }







    @RequestMapping(value="/wheelMaker/add", method = RequestMethod.POST)
    public String wheelMakerAdd(@RequestParam String name) {
        wheelService.addWheelMaker(new WheelMaker(name));
        return "redirect:/show_wheels";
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
    private long getPageCount(SpokeNumber spokeNumber) {
        long totalCount = wheelService.countBySpokeNumber(spokeNumber);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCount(RimWide rimWide) {
        long totalCount = wheelService.countByRimWide(rimWide);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }


}

