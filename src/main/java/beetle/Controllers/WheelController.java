package beetle.Controllers;

import beetle.Entities.Brakes.BrakeDiscHydraulic;
import beetle.Entities.Brakes.BrakeMaker;
import beetle.Entities.Frames.BikeType;
import beetle.Entities.Forks.BrakesType;
import beetle.Entities.Wheels.*;
import beetle.Services.ForkService;
import beetle.Entities.Forks.WheelsDiam;
import beetle.Services.WheelService;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                .findAllWheels(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Spoke> spokes = wheelService
                .findAllSpokes(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Rim> rims = wheelService
                .findAllRims(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<FrontHub> frontHubs = wheelService
                .findAllFrontHubs(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BackHub> backHubs = wheelService
                .findAllBackHubs(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Tire> tires = wheelService
                .findAllTires(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
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
        model.addAttribute("allPages", getPageCountWheel());
        model.addAttribute("allPages", getPageCountSpoke());
        model.addAttribute("allPages", getPageCountRim());
        model.addAttribute("allPages", getPageCountTire());
        return "wheelsAdmin";
    }

    // return pages with type of wheels components

    @RequestMapping("/show_BackHub")
    public String backHubVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<WheelMaker> wheelMakers = new HashSet<>();
        List<BackHub> backHubs = wheelService
                .findAllBackHubs(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (BackHub backHub : backHubs) {
            wheelMakers.add(backHub.getMaker());
        }
        model.addAttribute("productMakers",wheelMakers);
        model.addAttribute("products", backHubs);
        model.addAttribute("allPages", getPageCountBackHub());
        return "product";
    }

    @RequestMapping("/show_Wheel")
    public String wheelsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<WheelMaker> wheelMakers = new HashSet<>();
        List<Wheel> wheels = wheelService
                .findAllWheels(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Wheel wheel : wheels) {
            wheelMakers.add(wheel.getMaker());
        }
        model.addAttribute("productMakers", wheelMakers);
        model.addAttribute("products", wheels);
        model.addAttribute("allPages", getPageCountWheel());
        return "product";
    }

    @RequestMapping("/show_FrontHub")
    public String frontHubsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<WheelMaker> wheelMakers = new HashSet<>();
        List<FrontHub> frontHubs = wheelService
                .findAllFrontHubs(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (FrontHub frontHub : frontHubs) {
            wheelMakers.add(frontHub.getMaker());
        }
        model.addAttribute("productMakers", wheelMakers);
        model.addAttribute("products", frontHubs);
        model.addAttribute("allPages", getPageCountFrontHub());
        return "product";
    }

    @RequestMapping("/show_Rim")
    public String rimsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<WheelMaker> wheelMakers = new HashSet<>();
        List<Rim> rims = wheelService
                .findAllRims(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Rim rim : rims) {
            wheelMakers.add(rim.getMaker());
        }
        model.addAttribute("productMakers", wheelMakers);
        model.addAttribute("products", rims);
        model.addAttribute("allPages", getPageCountRim());
        return "product";
    }

    @RequestMapping("/show_Spoke")
    public String spokesVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<WheelMaker> wheelMakers = new HashSet<>();
        List<Spoke> spokes = wheelService
                .findAllSpokes(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Spoke spoke : spokes) {
            wheelMakers.add(spoke.getMaker());
        }
        model.addAttribute("productMakers",  wheelMakers);
        model.addAttribute("products", spokes);
        model.addAttribute("allPages", getPageCountSpoke());
        return "product";
    }

    @RequestMapping("/show_Tire")
    public String tiresVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<WheelMaker> wheelMakers = new HashSet<>();

        List<Tire> tires = wheelService
                .findAllTires(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Tire tire : tires) {
            wheelMakers.add(tire.getMaker());
        }
        model.addAttribute("productMakers",  wheelMakers);
        model.addAttribute("products", tires);
        model.addAttribute("allPages", getPageCountTire());
        return "product";
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
    public String listWheelMakerAdmin(
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
        model.addAttribute("byWheelMakerPages", getPageCountWheel(wheelMaker));
        model.addAttribute("groupId", wheelMakerId);
        return "wheelsAdmin";
    }
    @RequestMapping("/WheelMaker/Wheel/{id}")
    public String listWheelMaker(
            @PathVariable(value = "id") long wheelMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        if (page < 0) page = 0;

        Set<WheelMaker> wheelMakers = new HashSet<>();

        List<Wheel> wheelsAll = wheelService.findAllWheels(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));

        for (Wheel wheel : wheelsAll) {
            wheelMakers.add(wheel.getMaker());
        }

        List<Wheel> wheels = wheelService
                .findByWheelMakers(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
            model.addAttribute("productMakers", wheelMakers);

        model.addAttribute("products", wheels);
        model.addAttribute("byGroupPages", getPageCountWheel(wheelMaker));
        model.addAttribute("groupId", wheelMakerId);
        return "product";
    }
    @RequestMapping("/WheelMaker/BackHub/{id}")
    public String listBackHubMaker(
            @PathVariable(value = "id") long wheelMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;

        if (page < 0) page = 0;

        Set<WheelMaker> wheelMakers = new HashSet<>();

        List<BackHub> backHubsAll = wheelService.findAllBackHubs(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));

        for (BackHub backHub : backHubsAll) {
            wheelMakers.add(backHub.getMaker());
        }

        List<BackHub> backHubs = wheelService
                .findByBackHubMaker(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", wheelMakers);
        model.addAttribute("products", backHubs);
        model.addAttribute("byGroupPages", getPageCountBackHub(wheelMaker));
        model.addAttribute("groupId", wheelMakerId);
        return "product";
    }
    @RequestMapping("/WheelMaker/FrontHub/{id}")
    public String listFrontHubMaker(
            @PathVariable(value = "id") long wheelMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        if (page < 0) page = 0;

        Set<WheelMaker> wheelMakers = new HashSet<>();

        List<FrontHub> frontHubsAll = wheelService.findAllFrontHubs(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        for (FrontHub frontHub : frontHubsAll) {
            wheelMakers.add(frontHub.getMaker());
        }
        List<FrontHub> frontHubs = wheelService
                .findByFrontHubMaker(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", wheelMakers);
        model.addAttribute("products", frontHubs);
        model.addAttribute("byGroupPages", getPageCountFrontHub(wheelMaker));
        model.addAttribute("groupId", wheelMakerId);
        return "product";
    }
    @RequestMapping("/WheelMaker/Rim/{id}")
    public String listRimMaker(
            @PathVariable(value = "id") long wheelMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        if (page < 0) page = 0;

        Set<WheelMaker> wheelMakers = new HashSet<>();
        List<Rim> rimsAll = wheelService.findAllRims(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        for (Rim rim : rimsAll) {
            wheelMakers.add(rim.getMaker());
        }
        List<Rim> rims = wheelService
                .findByRimMaker(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", wheelMakers);
        model.addAttribute("products", rims);
        model.addAttribute("byGroupPages", getPageCountRim(wheelMaker));
        model.addAttribute("groupId", wheelMakerId);
        return "product";
    }
    @RequestMapping("/WheelMaker/Spoke/{id}")
    public String listSpokeMaker(
            @PathVariable(value = "id") long wheelMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        if (page < 0) page = 0;
        Set<WheelMaker> wheelMakers = new HashSet<>();
        List<Spoke> spokesAll = wheelService.findAllSpokes(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        for (Spoke spoke : spokesAll) {
            wheelMakers.add(spoke.getMaker());
        }
        List<Spoke> spokes = wheelService
                .findBySpokeMaker(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", wheelMakers);
        model.addAttribute("products", spokes);
        model.addAttribute("byGroupPages", getPageCountSpoke(wheelMaker));
        model.addAttribute("groupId", wheelMakerId);
        return "product";
    }
    @RequestMapping("/WheelMaker/Tire/{id}")
    public String listTireMaker(
            @PathVariable(value = "id") long wheelMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        WheelMaker wheelMaker = (wheelMakerId != DEFAULT_GROUP_ID) ? wheelService.findWheelMaker(wheelMakerId) : null;
        if (page < 0) page = 0;

        Set<WheelMaker> wheelMakers = new HashSet<>();
        List<Tire> tiresAll = wheelService.findAllTires(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        for (Tire tire : tiresAll) {
            wheelMakers.add(tire.getMaker());
        }
        List<Tire> tires = wheelService
                .findByTireMaker(wheelMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", wheelMakers);
        model.addAttribute("products", tires);
        model.addAttribute("byGroupPages", getPageCountTire(wheelMaker));
        model.addAttribute("groupId", wheelMakerId);
        return "product";
    }

    //delete components for admin

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
        return "redirect:/show_Wheel";
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
        return "redirect:/show_Spoke";
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
        return "redirect:/show_Rim";
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
        return "redirect:/show_FrontHub";
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
        return "redirect:/show_BackHub";
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
        return "redirect:/show_Tire";
    }

    //Add Maker to database
    @RequestMapping(value="/admin/wheelMaker/add", method = RequestMethod.POST)
    public String wheelMakerAdd(@RequestParam String name) {
        wheelService.addWheelMaker(new WheelMaker(name));
        return "redirect:/admin/show_wheels";
    }

    // Select one product by url and open in separate page

    @RequestMapping("/Wheel/{url}/{id}")
    public String listWheelUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        Wheel wheel = wheelService.findWheel(id);
        model.addAttribute("product", wheel);
        return "oneProduct";
    }
    @RequestMapping("/Rim/{url}/{id}")
    public String listRimUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        Rim rim = wheelService.findRim(id);
        model.addAttribute("product", rim);
        return "oneProduct";
    }
    @RequestMapping("/BackHub/{url}/{id}")
    public String listBachHubUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        BackHub backHub = wheelService.findBackHub(id);
        model.addAttribute("product", backHub);
        return "oneProduct";
    }

    @RequestMapping("/FrontHub/{url}/{id}")
    public String listFrontHubUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        FrontHub frontHub = wheelService.findFrontHub(id);
        model.addAttribute("product", frontHub);
        return "oneProduct";
    }

    @RequestMapping("/Spoke/{url}/{id}")
    public String listSpokeUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        Spoke spoke = wheelService.findSpoke(id);
        model.addAttribute("product", spoke);
        return "oneProduct";
    }

    @RequestMapping("/Tire/{url}/{id}")
    public String listTireUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        Tire tire = wheelService.findTire(id);
        model.addAttribute("product", tire);
        return "oneProduct";
    }

    private long getPageCountWheel() {
        long totalCount = wheelService.countWheel();
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
    private long getPageCountWheel(WheelMaker wheelMaker) {
        long totalCount = wheelService.countByWheelMakerWheel(wheelMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountSpoke(WheelMaker wheelMaker) {
        long totalCount = wheelService.countByWheelMakerSpoke(wheelMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountRim(WheelMaker wheelMaker) {
        long totalCount = wheelService.countByWheelMakerRim(wheelMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountFrontHub(WheelMaker wheelMaker) {
        long totalCount = wheelService.countByWheelMakerFrontHub(wheelMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBackHub(WheelMaker wheelMaker) {
        long totalCount = wheelService.countByWheelMakerBackHub(wheelMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountTire(WheelMaker wheelMaker) {
        long totalCount = wheelService.countByWheelMakerBackHub(wheelMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

}

