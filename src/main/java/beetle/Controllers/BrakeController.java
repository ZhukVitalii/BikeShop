package beetle.Controllers;

import beetle.Entities.Brakes.*;
import beetle.Entities.Handlebars.HandlebarDiameter;
import beetle.Entities.Handlebars.HandlebarMaker;
import beetle.Entities.Handlebars.Headset;
import beetle.Services.HandlebarService;
import beetle.Services.BrakeService;
import beetle.Entities.Wheels.RotorFixType;
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
 * Created by VitaliiZhuk on 26.06.2017.
 */
@Controller
public class BrakeController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;

    @Autowired
    private BrakeService brakeService;
    @Autowired
    private WheelService wheelService;
    @Autowired
    private HandlebarService handlebarService;

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

        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeService
                .findAllBrakeDiscHydraulic(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeService
                .findAllBrakeDiscMechanik(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeVBrake> brakeVBrakes = brakeService
                .findAllBraleVBrake(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeHandle> brakeHandles = brakeService
                .findAllBrakeHandle(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeMakers", brakeService.findBrakeMakers());
        model.addAttribute("locations", brakeService.findLocation());
        model.addAttribute("brakeLiquids", brakeService.findBrakeLiquid());
        model.addAttribute("lengthHydrolines", brakeService.findLengthHydroline());
        model.addAttribute("rotorDiams", brakeService.findRotorDiam());
        model.addAttribute("rotorFixTypes", wheelService.findRotorFixType());
        model.addAttribute("brakeHandleLocations", brakeService.findBrakeHandleLocation());
        model.addAttribute("brakeHandleCompatibilitys", brakeService.findBrakeHandleCompatibility());
        model.addAttribute("handlebarDiameters", handlebarService.findHandlebarDiameter());
        model.addAttribute("brakeHandleWides", brakeService.findBrakeHandleWide());
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
    @RequestMapping("/show_BrakeDiscHydraulic")

    public String brakesHydroVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeService
                .findAllBrakeDiscHydraulic(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<BrakeMaker>brakeMakers = new HashSet<>();
        for (BrakeDiscHydraulic brakeDiscHydraulic : brakeDiscHydraulics) {
            brakeMakers.add(brakeDiscHydraulic.getMaker());
        }
        model.addAttribute("productMakers",brakeMakers);
        model.addAttribute("products", brakeDiscHydraulics);
        model.addAttribute("allPages", getPageCountBrakeDiscHydr());
        return "product";
    }

    @RequestMapping("/show_BrakeDiscMechanik")
    public String brakesMechVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeService
                .findAllBrakeDiscMechanik(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<BrakeMaker>brakeMakers = new HashSet<>();
        for (BrakeDiscMechanik brakeDiscMechanik : brakeDiscMechaniks) {
            brakeMakers.add(brakeDiscMechanik.getMaker());
        }
        model.addAttribute("productMakers",brakeMakers);
        model.addAttribute("products", brakeDiscMechaniks);
        model.addAttribute("allPages", getPageCountBrakeDiscMech());
        return "product";
    }

    @RequestMapping("/show_BrakeVBrake")
    public String brakesVBrakeVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BrakeVBrake> brakeVBrakes = brakeService
                .findAllBraleVBrake(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<BrakeMaker>brakeMakers = new HashSet<>();
        for (BrakeVBrake brakeVBrake : brakeVBrakes) {
            brakeMakers.add(brakeVBrake.getMaker());
        }

        model.addAttribute("productMakers", brakeMakers);
        model.addAttribute("products", brakeVBrakes);
        model.addAttribute("allPages", getPageCountVBrake());
        return "product";
    }

    @RequestMapping("/show_BrakeHandle")
    public String brakesHandleVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BrakeHandle> brakeHandles = brakeService
                .findAllBrakeHandle(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<BrakeMaker>brakeMakers = new HashSet<>();
        for (BrakeHandle brakeHandle : brakeHandles) {
            brakeMakers.add(brakeHandle.getMaker());
        }
        model.addAttribute("productMakers",brakeMakers);
        model.addAttribute("products", brakeHandles);
        model.addAttribute("allPages", getPageCountBrakeHandle());
        return "product";
    }

    //add components from browser
    @RequestMapping("/admin/brakeDiscHydr_add_page")
    public String brakeDiscHydrAddPage(Model model) {
        model.addAttribute("brakeMakers", brakeService.findBrakeMakers());
        model.addAttribute("locations", brakeService.findLocation());
        model.addAttribute("brakeLiquids", brakeService.findBrakeLiquid());
        model.addAttribute("lengthHydrolines", brakeService.findLengthHydroline());
        model.addAttribute("rotorDiams", brakeService.findRotorDiam());
        model.addAttribute("rotorFixTypes", wheelService.findRotorFixType());
        return "brakeDiscHydr_add_page";
    }

    @RequestMapping("/admin/brakeDiscMech_add_page")
    public String brakeDiscMechAddPage(Model model) {
        model.addAttribute("brakeMakers", brakeService.findBrakeMakers());
        model.addAttribute("locations", brakeService.findLocation());
        model.addAttribute("rotorDiams", brakeService.findRotorDiam());
        model.addAttribute("rotorFixTypes", wheelService.findRotorFixType());
        return "brakeDiscMech_add_page";
    }

    @RequestMapping("/admin/brakeVBrake_add_page")
    public String brakeVBrakeAddPage(Model model) {
        model.addAttribute("brakeMakers", brakeService.findBrakeMakers());
        model.addAttribute("locations", brakeService.findLocation());
        return "brakeVBrake_add_page";
    }

    @RequestMapping("/admin/brakeHandle_add_page")
    public String brakeHandleAddPage(Model model) {
        model.addAttribute("brakeMakers", brakeService.findBrakeMakers());
        model.addAttribute("brakeHandleLocations", brakeService.findBrakeHandleLocation());
        model.addAttribute("brakeHandleCompatibilitys", brakeService.findBrakeHandleCompatibility());
        model.addAttribute("handlebarDiameters", handlebarService.findHandlebarDiameter());
        model.addAttribute("brakeHandleWides", brakeService.findBrakeHandleWide());

        return "brakeHandle_add_page";
    }

    @RequestMapping("/admin/brakeMaker_add_page")
    public String brakeMakerAddPage() {
        return "brakeMaker_add_page";
    }

    // for filter by Maker
    @RequestMapping("/brakeMakerAdmin/{id}")
    public String listBrakeMakerAdmin(
            @PathVariable(value = "id") long brakeMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        BrakeMaker brakeMaker = (brakeMakerId != DEFAULT_GROUP_ID) ? brakeService.findBrakeMaker(brakeMakerId) : null;
        if (page < 0) page = 0;
        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeService
                .findByBrakeDiscHydraulicMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeService
                .findByBrakeDiscMechanikMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeVBrake> brakeVBrakes = brakeService
                .findByBrakeVBrakeMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BrakeHandle> brakeHandles = brakeService
                .findByBrakeHandleMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brakeMakers", brakeService.findBrakeMakers());
        model.addAttribute("brakeDiscHydraulics", brakeDiscHydraulics);
        model.addAttribute("brakeDiscMechaniks", brakeDiscMechaniks);
        model.addAttribute("brakeVBrakes", brakeVBrakes);
        model.addAttribute("brakeHandles", brakeHandles);
        model.addAttribute("byBrakeMakerDiscHydrPages", getPageCountBrakeDiscHydr(brakeMaker));
        model.addAttribute("byBrakeMakerDiscMechPages", getPageCountBrakeDiscMech(brakeMaker));
        model.addAttribute("byBrakeMakerVbrake", getPageCountBrakeVBrake(brakeMaker));
        model.addAttribute("byBrakeMakerHandle", getPageCountBrakeHandle(brakeMaker));
        model.addAttribute("groupId", brakeMakerId);
        return "brakes";
    }
    @RequestMapping("/BrakeMaker/BrakeDiscHydraulic/{id}")
    public String listBrakeDiscHydraulicMaker(
            @PathVariable(value = "id") long groupId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        BrakeMaker brakeMaker = (groupId != DEFAULT_GROUP_ID) ? brakeService.findBrakeMaker(groupId) : null;
        if (page < 0) page = 0;

        List<BrakeDiscHydraulic> brakeDiscHydraulicsAll = brakeService.findAllBrakeDiscHydraulic(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));

        Set<BrakeMaker> brakeMakers = new HashSet<>();

        for (BrakeDiscHydraulic brakeDiscHydraulic : brakeDiscHydraulicsAll) {
            brakeMakers.add(brakeDiscHydraulic.getMaker());
        }

        List<BrakeDiscHydraulic> brakeDiscHydraulics = brakeService
                .findByBrakeDiscHydraulicMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers",brakeMakers);
        model.addAttribute("products", brakeDiscHydraulics);
        model.addAttribute("byGroupPages", getPageCountBrakeDiscHydr(brakeMaker));
        model.addAttribute("groupId", groupId);
        return "product";
    }
    @RequestMapping("/BrakeMaker/BrakeDiscMechanik/{id}")
    public String listBrakeDiscMechanikMaker(
            @PathVariable(value = "id") long groupId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        BrakeMaker brakeMaker = (groupId != DEFAULT_GROUP_ID) ? brakeService.findBrakeMaker(groupId) : null;
        if (page < 0) page = 0;
        List<BrakeDiscMechanik> brakeDiscMechaniksAll = brakeService.findAllBrakeDiscMechanik(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        Set<BrakeMaker>brakeMakers = new HashSet<>();
        for (BrakeDiscMechanik brakeDiscMechanik : brakeDiscMechaniksAll) {
            brakeMakers.add(brakeDiscMechanik.getMaker());
        }
        List<BrakeDiscMechanik> brakeDiscMechaniks = brakeService
                .findByBrakeDiscMechanikMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", brakeMakers);
        model.addAttribute("products", brakeDiscMechaniks);
        model.addAttribute("byGroupPages", getPageCountBrakeDiscMech(brakeMaker));
        model.addAttribute("groupId", groupId);
        return "product";
    }
    @RequestMapping("/BrakeMaker/BrakeVBrake/{id}")
    public String listBrakeVBrakeMaker(
            @PathVariable(value = "id") long groupId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        BrakeMaker brakeMaker = (groupId != DEFAULT_GROUP_ID) ? brakeService.findBrakeMaker(groupId) : null;
        if (page < 0) page = 0;
        List<BrakeVBrake> brakeVBrakesAll = brakeService.findAllBraleVBrake(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        Set<BrakeMaker>brakeMakers = new HashSet<>();
        for (BrakeVBrake brakeVBrake : brakeVBrakesAll) {
            brakeMakers.add(brakeVBrake.getMaker());
        }
        List<BrakeVBrake> brakeVBrakes = brakeService
                .findByBrakeVBrakeMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", brakeMakers);
        model.addAttribute("products", brakeVBrakes);
        model.addAttribute("byGroupPages", getPageCountBrakeVBrake(brakeMaker));
        model.addAttribute("groupId", groupId);
        return "product";
    }
    @RequestMapping("/BrakeMaker/BrakeHandle/{id}")
    public String listBrakeHandleMaker(
            @PathVariable(value = "id") long groupId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        BrakeMaker brakeMaker = (groupId != DEFAULT_GROUP_ID) ? brakeService.findBrakeMaker(groupId) : null;
        if (page < 0) page = 0;
        List<BrakeHandle> brakeHandlesAll = brakeService.findAllBrakeHandle( new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        Set<BrakeMaker>brakeMakers = new HashSet<>();
        for (BrakeHandle brakeHandle : brakeHandlesAll) {
            brakeMakers.add(brakeHandle.getMaker());
        }
        List<BrakeHandle> brakeHandles = brakeService
                .findByBrakeHandleMakers(brakeMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", brakeMakers);
        model.addAttribute("products", brakeHandles);
        model.addAttribute("byGroupPages", getPageCountBrakeHandle(brakeMaker));
        model.addAttribute("groupId", groupId);
        return "product";
    }


    //for delete components for admin
    @RequestMapping(value = "/admin/brakeDiscHydr/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            brakeService.deleteBrakeDiscHydraulic(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/brakeDiscMech/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteOne(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            brakeService.deleteBrakeDiscMechanik(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/brakeVBrake/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteTwo(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            brakeService.deleteBrakeVBrake(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/brakeHandle/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteThree(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            brakeService.deleteBrakeHandle(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add components to database
    @RequestMapping(value="/admin/brakeDiscHydr/add", method = RequestMethod.POST)
    public String brakeDiscHydrAdd(
            @RequestParam(value = "brakeMaker") long brakeMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "location") long locationId,
            @RequestParam(value = "brakeLiquid") long brakeLiquidId,
            @RequestParam String materialHandle,
            @RequestParam(value = "lengthHydroline") long lengthHydrolineId,
            @RequestParam(value = "rotorDiam") long rotorDiamId,
            @RequestParam String rotorWeight,
            @RequestParam String material,
            @RequestParam String brakeWeight,
            @RequestParam(value = "rotorFixType") long rotorFixTypeId,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        BrakeMaker brakeMaker = (brakeMakerId != DEFAULT_GROUP_ID) ? brakeService.findBrakeMaker(brakeMakerId) : null;
        Location location = (locationId != DEFAULT_GROUP_ID) ? brakeService.findLication(locationId) : null;
        BrakeLiquid brakeLiquid = (brakeLiquidId != DEFAULT_GROUP_ID) ? brakeService.findBrakeLiquid(brakeLiquidId) : null;
        LengthHydroline lengthHydroline = (lengthHydrolineId != DEFAULT_GROUP_ID) ? brakeService.findLengthHydroline(lengthHydrolineId) : null;
        RotorDiam rotorDiam = (rotorDiamId != DEFAULT_GROUP_ID) ? brakeService.findRotorDiam(rotorDiamId) : null;
        RotorFixType rotorFixType = (rotorFixTypeId != DEFAULT_GROUP_ID) ? wheelService.findRotorFixType(rotorFixTypeId) : null;
        BrakeDiscHydraulic brakeDiscHydraulic = new BrakeDiscHydraulic(brakeMaker,article,url, name,location,brakeLiquid,materialHandle,lengthHydroline,
                rotorDiam,rotorWeight,material,brakeWeight,rotorFixType,color,description,price,way);

        brakeService.addBrakeDiscHydraulic(brakeDiscHydraulic);
        return "redirect:/show_BrakeDiscHydraulic";
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
        BrakeMaker brakeMaker = (brakeMakerId != DEFAULT_GROUP_ID) ? brakeService.findBrakeMaker(brakeMakerId) : null;
        Location location = (locationId != DEFAULT_GROUP_ID) ? brakeService.findLication(locationId) : null;
        RotorDiam rotorDiam = (rotorDiamId != DEFAULT_GROUP_ID) ? brakeService.findRotorDiam(rotorDiamId) : null;
        RotorFixType rotorFixType = (rotorFixTypeId != DEFAULT_GROUP_ID) ? wheelService.findRotorFixType(rotorFixTypeId) : null;
        BrakeDiscMechanik brakeDiscMechanik = new BrakeDiscMechanik(brakeMaker,article,url,name,location,rotorDiam,rotorWeight,materialBrake,brakeWeight,
                rotorFixType,color,description,price,way);
        brakeService.addBrakeDiscMechanik(brakeDiscMechanik);
        return "redirect:/show_BrakeDiscMechanik";
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
        BrakeMaker brakeMaker = (brakeMakerId != DEFAULT_GROUP_ID) ? brakeService.findBrakeMaker(brakeMakerId) : null;
        Location location = (locationId != DEFAULT_GROUP_ID) ? brakeService.findLication(locationId) : null;
        BrakeVBrake brakeVBrake = new BrakeVBrake(brakeMaker,article,url, name,location,material,color,description,price,way);
        brakeService.addBrakeVBrake(brakeVBrake);
        return "redirect:/show_BrakeVBrake";
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
        BrakeMaker brakeMaker = (brakeMakerId != DEFAULT_GROUP_ID) ? brakeService.findBrakeMaker(brakeMakerId) : null;
        BrakeHandleLocation brakeHandleLocation = (brakeHandleLocationId != DEFAULT_GROUP_ID) ? brakeService.findBrakeHandleLocation(brakeHandleLocationId) : null;
        BrakeHandleCompatibility brakeHandleCompatibility = (brakeHandleCompatibilityId != DEFAULT_GROUP_ID) ? brakeService.findBrakeHandleCompatibility(brakeHandleCompatibilityId) : null;
        HandlebarDiameter handlebarDiameter = (handlebarDiameterId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarDiameter(handlebarDiameterId) : null;
        BrakeHandleWide brakeHandleWide = (brakeHandleWideId != DEFAULT_GROUP_ID) ? brakeService.findBrakeHandleWide(brakeHandleWideId) : null;
        BrakeHandle brakeHandle = new BrakeHandle(brakeMaker,article,url,name,brakeHandleLocation,brakeHandleCompatibility,materialHandle,materialCorp,
                handlebarDiameter,brakeHandleWide,weight,color,description,price,way);
        brakeService.addBrakeHandle(brakeHandle);
        return "redirect:/show_BrakeHandle";
    }

    //Add Maker to database
    @RequestMapping(value="/admin/brakeMaker/add", method = RequestMethod.POST)
    public String brakeMakerAdd(@RequestParam String name) {
        brakeService.addBrakeMaker(new BrakeMaker(name));
        return "redirect:/show_brakes";
    }

    // Select one product by url and open in separate page
    @RequestMapping("/BrakeDiscHydraulic/{url}/{id}")
    public String listBrakeDiscHydraulicUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        BrakeDiscHydraulic brakeDiscHydraulic = brakeService.findBrakeDiscHydraulic(id);
        model.addAttribute("product", brakeDiscHydraulic);
        return "oneProduct";
    }

    @RequestMapping("/BrakeDiscMechanik/{url}/{id}")
    public String listBrakeDiscMechanikUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        BrakeDiscMechanik brakeDiscMechanik = brakeService.findBrakeDiscMechanik(id);
        model.addAttribute("product", brakeDiscMechanik);
        return "oneProduct";
    }

    @RequestMapping("/BrakeVBrake/{url}/{id}")
    public String listBrakeVBrakeUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        BrakeVBrake brakeVBrake = brakeService.findBrakeVBrake(id);
        model.addAttribute("product", brakeVBrake);
        return "oneProduct";
    }

    @RequestMapping("/BrakeHandle/{url}/{id}")
    public String listBrakeHandleUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        BrakeHandle brakeHandle = brakeService.findBrakeHandle(id);

        model.addAttribute("product", brakeHandle);
        return "oneProduct";
    }

    private long getPageCountBrakeDiscHydr() {
        long totalCount = brakeService.countBrakeDiscHydr();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBrakeDiscMech() {
        long totalCount = brakeService.countBrakeDiscMech();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountVBrake() {
        long totalCount = brakeService.countVBrake();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBrakeHandle() {
        long totalCount = brakeService.countBrakeHandle();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBrakeDiscHydr(BrakeMaker brakeMaker) {
        long totalCount = brakeService.countByBrakeMakerDiscHydr(brakeMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBrakeDiscMech(BrakeMaker brakeMaker) {
        long totalCount = brakeService.countByBrakeMakerDiscMech(brakeMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBrakeVBrake(BrakeMaker brakeMaker) {
        long totalCount = brakeService.countByBrakeMakerVBrake(brakeMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBrakeHandle(BrakeMaker brakeMaker) {
        long totalCount = brakeService.countByBrakeMakerHandle(brakeMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

}



