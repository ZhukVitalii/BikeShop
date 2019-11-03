package beetle.controller;

import beetle.entity.Manufacturer;
import beetle.entity.handlebars.HandlebarDiameter;
import beetle.json.BrakeDiscHydraulicInputJSON;
import beetle.mapper.BrakeMapper;
import beetle.service.HandlebarService;
import beetle.entity.wheels.RotorFixType;
import beetle.service.WheelService;
import beetle.entity.brake.*;
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

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
@Controller
public class BrakeController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;

    @Autowired
    private BrakeServiceImpl brakeServiceImpl;
    @Autowired
    private WheelService wheelService;
    @Autowired
    private HandlebarService handlebarService;
    @Autowired
    private BrakeMapper mapper;

    //return page with links to pages with components
    @RequestMapping("/show_brakesComponents")
    public String brakesComponentsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        return "brakesComponents";
    }

    //for admin with all brakes components
    @RequestMapping("/admin/show_brakes")
    public String brakesVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeServiceImpl
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeServiceImpl
                .findAllOne(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeVBrake> brakeVBrakes = brakeServiceImpl
                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeHandle> brakeHandles = brakeServiceImpl
                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
        model.addAttribute("locations", brakeServiceImpl.findLocation());
        model.addAttribute("brakeLiquids", brakeServiceImpl.findBrakeLiquid());
        model.addAttribute("lengthHydrolines", brakeServiceImpl.findLengthHydroline());
        model.addAttribute("rotorDiams", brakeServiceImpl.findRotorDiam());
        model.addAttribute("rotorFixTypes", wheelService.findRotorFixType());
        model.addAttribute("brakeHandleLocations", brakeServiceImpl.findBrakeHandleLocation());
        model.addAttribute("brakeHandleCompatibilitys", brakeServiceImpl.findBrakeHandleCompatibility());
        model.addAttribute("handlebarDiameters", handlebarService.findHandlebarDiameter());
        model.addAttribute("brakeHandleWides", brakeServiceImpl.findBrakeHandleWide());
        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);
        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
        model.addAttribute("brakeVBrakes", brakeVBrakes);
        model.addAttribute("brakeHandles", brakeHandles);
        model.addAttribute("allPages", getPageCountBrakeDiscHydr());
        model.addAttribute("allPages", getPageCountBrakeDiscMech());
        model.addAttribute("allPages", getPageCountVBrake());
        model.addAttribute("allPages", getPageCountBrakeHandle());
        return "brakesAdmin";
    }

    // return pages with type of brakes components
    @RequestMapping("/show_brakesHydro")

    public String brakesHydroVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeServiceImpl
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);
        model.addAttribute("allPages", getPageCountBrakeDiscHydr());
        return "brakesHydro";
    }

    @RequestMapping("/show_brakesMech")
    public String brakesMechVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeServiceImpl
                .findAllOne(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
        model.addAttribute("allPages", getPageCountBrakeDiscMech());
        return "brakesMech";
    }

    @RequestMapping("/show_brakesVBrake")
    public String brakesVBrakeVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BrakeVBrake> brakeVBrakes = brakeServiceImpl
                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
        model.addAttribute("brakeVBrakes", brakeVBrakes);
        model.addAttribute("allPages", getPageCountVBrake());
        return "brakesVBrake";
    }

    @RequestMapping("/show_brakesHandle")
    public String brakesHandleVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BrakeHandle> brakeHandles = brakeServiceImpl
                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
        model.addAttribute("brakeHandles", brakeHandles);
        model.addAttribute("allPages", getPageCountBrakeHandle());
        return "brakesHandle";
    }

    //add components from browser
    @RequestMapping("/admin/brakeDiscHydr_add_page")
    public String brakeDiscHydrAddPage(Model model) {
        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
        model.addAttribute("locations", brakeServiceImpl.findLocation());
        model.addAttribute("brakeLiquids", brakeServiceImpl.findBrakeLiquid());
        model.addAttribute("lengthHydrolines", brakeServiceImpl.findLengthHydroline());
        model.addAttribute("rotorDiams", brakeServiceImpl.findRotorDiam());
        model.addAttribute("rotorFixTypes", wheelService.findRotorFixType());
        return "brakeDiscHydr_add_page";
    }

    @RequestMapping("/admin/brakeDiscMech_add_page")
    public String brakeDiscMechAddPage(Model model) {
        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
        model.addAttribute("locations", brakeServiceImpl.findLocation());
        model.addAttribute("rotorDiams", brakeServiceImpl.findRotorDiam());
        model.addAttribute("rotorFixTypes", wheelService.findRotorFixType());
        return "brakeDiscMech_add_page";
    }

    @RequestMapping("/admin/brakeVBrake_add_page")
    public String brakeVBrakeAddPage(Model model) {
        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
        model.addAttribute("locations", brakeServiceImpl.findLocation());
        return "brakeVBrake_add_page";
    }

    @RequestMapping("/admin/brakeHandle_add_page")
    public String brakeHandleAddPage(Model model) {
        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
        model.addAttribute("brakeHandleLocations", brakeServiceImpl.findBrakeHandleLocation());
        model.addAttribute("brakeHandleCompatibilitys", brakeServiceImpl.findBrakeHandleCompatibility());
        model.addAttribute("handlebarDiameters", handlebarService.findHandlebarDiameter());
        model.addAttribute("brakeHandleWides", brakeServiceImpl.findBrakeHandleWide());

        return "brakeHandle_add_page";
    }

    @RequestMapping("/admin/brakeMaker_add_page")
    public String brakeMakerAddPage() {
        return "brakeMaker_add_page";
    }

    // for filter by Maker
    @RequestMapping("/brakeMaker/{id}")
    public String listBrakeMaker(
            @PathVariable(value = "id") long brakeMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        Manufacturer brakeMaker = (brakeMakerId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findBrakeMaker(brakeMakerId) : null;
        if (page < 0) page = 0;
        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeServiceImpl
                .findByBrakeDiscHydraulicMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeServiceImpl
                .findByBrakeDiscMechanikMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeVBrake> brakeVBrakes = brakeServiceImpl
                .findByBrakeVBrakeMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeHandle> brakeHandles = brakeServiceImpl
                .findByBrakeHandleMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeMakers", brakeServiceImpl.findBrakeMakers());
        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);
        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
        model.addAttribute("brakeVBrakes", brakeVBrakes);
        model.addAttribute("brakeHandles", brakeHandles);
//        model.addAttribute("byBrakeMakerDiscHydrPages", getPageCountBrakeDiscHydr(brakeMaker));
//        model.addAttribute("byBrakeMakerDiscMechPages", getPageCountBrakeDiscMech(brakeMaker));
//        model.addAttribute("byBrakeMakerVbrake", getPageCountBrakeVBrake(brakeMaker));
//        model.addAttribute("byBrakeMakerHandle", getPageCountBrakeHandle(brakeMaker));
        model.addAttribute("groupId", brakeMakerId);
        return "brakes";
    }

    //for delete components for admin
    @RequestMapping(value = "/admin/brakeDiscHydr/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            brakeServiceImpl.deleteBrakeDiscHydraulic(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/brakeDiscMech/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteOne(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            brakeServiceImpl.deleteBrakeDiscMechanik(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/brakeVBrake/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteTwo(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            brakeServiceImpl.deleteBrakeVBrake(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/brakeHandle/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteThree(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            brakeServiceImpl.deleteBrakeHandle(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add components to database
    @RequestMapping(value="/admin/brakeDiscHydr/add", method = RequestMethod.POST)
    @ResponseBody
    public String brakeDiscHydrAdd(@RequestBody BrakeDiscHydraulicInputJSON input ){
        BrakeDiscHydraulic brakeDiscHydraulic = mapper.toBrakeDiscHydraulic(input);
        brakeServiceImpl.addBrakeDiscHydraulic(brakeDiscHydraulic);
        return "redirect:/show_brakesHydro";
    }

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
        Manufacturer brakeMaker = (brakeMakerId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findBrakeMaker(brakeMakerId) : null;
        BrakeHandleLocation brakeHandleLocation = (brakeHandleLocationId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findBrakeHandleLocation(brakeHandleLocationId) : null;
        BrakeHandleCompatibility brakeHandleCompatibility = (brakeHandleCompatibilityId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findBrakeHandleCompatibility(brakeHandleCompatibilityId) : null;
        HandlebarDiameter handlebarDiameter = (handlebarDiameterId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarDiameter(handlebarDiameterId) : null;
        BrakeHandleWide brakeHandleWide = (brakeHandleWideId != DEFAULT_GROUP_ID) ? brakeServiceImpl.findBrakeHandleWide(brakeHandleWideId) : null;
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

    // Select one product by url and open in separate page
    @RequestMapping("/brakeDiscHydraulic/{url}")
    public String listBrakeDiscHydraulicUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeServiceImpl
                .findBrakeDiscHydraulicByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);
        return "OneBrakeDiscHydraulic";
    }

    @RequestMapping("/brakeDiscMechanik/{url}")
    public String listBrakeDiscMechanikUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeServiceImpl
                .findBrakeDiscMechanikByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
        return "OneBrakeDiscMechanik";
    }

    @RequestMapping("/brakeVBrake/{url}")
    public String listBrakeVBrakeUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<BrakeVBrake> brakeVBrakes = brakeServiceImpl
                .findBrakeVBrakeByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeVBrakes", brakeVBrakes);
        return "OneBrakeVBrake";
    }

    @RequestMapping("/brakeHandle/{url}")
    public String listBrakeHandleUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<BrakeHandle> brakeHandles = brakeServiceImpl
                .findBrakeHandleByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeHandles", brakeHandles);
        return "OneBrakeHandle";
    }


    private long getPageCountBrakeDiscHydr() {
        long totalCount = brakeServiceImpl.countBrakeDiscHydr();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBrakeDiscMech() {
        long totalCount = brakeServiceImpl.countBrakeDiscMech();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountVBrake() {
        long totalCount = brakeServiceImpl.countVBrake();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBrakeHandle() {
        long totalCount = brakeServiceImpl.countBrakeHandle();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
//    private long getPageCountBrakeDiscHydr(BrakeMaker brakeMaker) {
//        long totalCount = brakeServiceImpl.countByBrakeMakerDiscHydr(brakeMaker);
//        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
//    }
//    private long getPageCountBrakeDiscMech(BrakeMaker brakeMaker) {
//        long totalCount = brakeServiceImpl.countByBrakeMakerDiscMech(brakeMaker);
//        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
//    }
//    private long getPageCountBrakeVBrake(BrakeMaker brakeMaker) {
//        long totalCount = brakeServiceImpl.countByBrakeMakerVBrake(brakeMaker);
//        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
//    }
//    private long getPageCountBrakeHandle(BrakeMaker brakeMaker) {
//        long totalCount = brakeServiceImpl.countByBrakeMakerHandle(brakeMaker);
//        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
//    }

}



