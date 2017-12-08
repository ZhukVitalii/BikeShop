package beetle.Controllers;

import beetle.Entities.Frames.BikeType;
import beetle.Entities.Handlebars.*;
import beetle.Services.ForkService;
import beetle.Entities.Forks.TubeDiameter;
import beetle.Services.FrameService;
import beetle.Services.HandlebarService;
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

import javax.persistence.SecondaryTable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
@Controller
public class HandlebarController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;


    @Autowired
    private HandlebarService handlebarService;
    @Autowired
    private ForkService forkService;
    @Autowired
    private FrameService frameService;



    //return page with links to pages with components
    @RequestMapping("/show_handlebarsComponents")
    public String brakesComponentsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        return "handlebarsComponents";
    }

    //for admin with all handlebars components
    @RequestMapping("/admin/show_handlebars")
    public String handlebarsAdminVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Handlebar> handlebars = handlebarService
                .findAllHandlebars(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Winding> windings = handlebarService
                .findAllWindings(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Grips> grips = handlebarService
                .findAllGrips(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Headset> headsets = handlebarService
                .findAllHeadset(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        List<Stem> stems = handlebarService
                .findAllStems(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("bikeType", handlebarService.findBikeType());
        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());
        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        model.addAttribute("headsetType", handlebarService.findHeadsetType());
        model.addAttribute("handlebars", handlebars);
        model.addAttribute("windings", windings);
        model.addAttribute("grips", grips);
        model.addAttribute("headsets", headsets);
        model.addAttribute("stems", stems);
        return "handlebarsAdmin";
    }

    // return pages with type of handlebars components
    @RequestMapping("/show_Handlebar")
    public String handlebarsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Handlebar> handlebars = handlebarService
                .findAllHandlebars(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<HandlebarMaker> handlebarMakers = new HashSet<>();
        for (Handlebar handlebar : handlebars) {
            handlebarMakers.add(handlebar.getMaker());
        }
        model.addAttribute("productMakers", handlebarMakers);
        model.addAttribute("products", handlebars);
        model.addAttribute("allPages", getPageCountHandlebar());
        return "product";
    }

    @RequestMapping("/show_Stem")
    public String stemsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Stem> stemsAll = handlebarService
                .findAllStems(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        Set<HandlebarMaker> handlebarMakers = new HashSet<>();
        for (Stem stem : stemsAll) {
            handlebarMakers.add(stem.getMaker());
        }
        model.addAttribute("productMakers", handlebarMakers);
        model.addAttribute("products", stemsAll);
        model.addAttribute("allPages", getPageCountStem());
        return "product";
    }

    @RequestMapping("/show_Winding")
    public String windingsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Winding> windings = handlebarService
                .findAllWindings(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<HandlebarMaker> handlebarMakers = new HashSet<>();
        for (Winding winding : windings) {
            handlebarMakers.add(winding.getMaker());
        }
        model.addAttribute("productMakers",handlebarMakers);
        model.addAttribute("products", windings);
        model.addAttribute("allPages", getPageCountWinding());
        return "product";
    }

    @RequestMapping("/show_Headset")
    public String headsetsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Headset> headsets = handlebarService
                .findAllHeadset(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        Set<HandlebarMaker> handlebarMakers = new HashSet<>();
        for (Headset headset : headsets) {
            handlebarMakers.add(headset.getMaker());
        }
        model.addAttribute("productMakers",handlebarMakers);
        model.addAttribute("products", headsets);
        model.addAttribute("allPages", getPageCountHeadset());
        return "product";
    }

    @RequestMapping("/show_Grips")
    public String gripsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Grips> grips = handlebarService
                .findAllGrips(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<HandlebarMaker> handlebarMakers = new HashSet<>();
        for (Grips gripss : grips) {
            handlebarMakers.add(gripss.getMaker());
        }
        model.addAttribute("productMakers",handlebarMakers);
        model.addAttribute("products", grips);
        model.addAttribute("allPages", getPageCountGrips());
        return "product";
    }

    //add components from browser

    @RequestMapping("/admin/handlebars_add_page")
    public String contactAddPage(Model model) {
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("bikeType", handlebarService.findBikeType());
        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());
        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
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
        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        return "headset_add_page";
    }

    @RequestMapping("/admin/stem_add_page")
    public String stemAddPage(Model model) {
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());
        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        return "stem_add_page";
    }

    @RequestMapping("/admin/handlebarMaker_add_page")
    public String handlebarMakerAddPage() {
        return "handlebarMaker_add_page";
    }

    // for filter by Maker
    @RequestMapping("/handlebarMaker/{id}")
    public String listHandlebarMakerAdmin(
            @PathVariable(value = "id") long handlebarMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        if (page < 0) page = 0;
        List<Handlebar> handlebars = handlebarService
                .findByHandlebarMakerHandlebar(handlebarMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("handlebars", handlebars);
        model.addAttribute("groupId", handlebarMakerId);
        return "handlebars";
    }
    @RequestMapping("/HandlebarMaker/Handlebar/{id}")
    public String listHandlebarMakerHandlebar(
            @PathVariable(value = "id") long handlebarMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        if (page < 0) page = 0;
        List<Handlebar> handlebarsAll = handlebarService.findAllHandlebars(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        Set<HandlebarMaker> handlebarMakers = new HashSet<>();
        for (Handlebar handlebar : handlebarsAll) {
            handlebarMakers.add(handlebar.getMaker());
        }
        List<Handlebar> handlebars = handlebarService
                .findByHandlebarMakerHandlebar(handlebarMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", handlebarMakers);
        model.addAttribute("products", handlebars);
        model.addAttribute("byGroupPages", getPageCountHandlebar(handlebarMaker));
        model.addAttribute("groupId", handlebarMakerId);
        return "product";
    }
    @RequestMapping("/HandlebarMaker/Grips/{id}")
    public String listHandlebarMakerGrips(
            @PathVariable(value = "id") long handlebarMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        if (page < 0) page = 0;
        List<Grips> gripsAll = handlebarService.findAllGrips(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        Set<HandlebarMaker> handlebarMakers = new HashSet<>();
        for (Grips grips : gripsAll) {
            handlebarMakers.add(grips.getMaker());
        }
        List<Grips> grips = handlebarService
                .findByHandlebarMakerGrips(handlebarMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", handlebarMakers);
        model.addAttribute("products", grips);
        model.addAttribute("byGroupPages", getPageCountGrips(handlebarMaker));
        model.addAttribute("groupId", handlebarMakerId);
        return "product";
    }
    @RequestMapping("/HandlebarMaker/Headset/{id}")
    public String listHandlebarMakerHedset(
            @PathVariable(value = "id") long handlebarMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        if (page < 0) page = 0;
        List<Headset> headsetsAll = handlebarService.findAllHeadset(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        Set<HandlebarMaker> handlebarMakers = new HashSet<>();
        for (Headset headset : headsetsAll) {
            handlebarMakers.add(headset.getMaker());
        }
        List<Headset> headsets = handlebarService
                .findByHandlebarMakerHeadset(handlebarMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", handlebarMakers);
        model.addAttribute("products", headsets);
        model.addAttribute("byGroupPages", getPageCountHeadset(handlebarMaker));
        model.addAttribute("groupId", handlebarMakerId);
        return "product";
    }
    @RequestMapping("/HandlebarMaker/Stem/{id}")
    public String listHandlebarMakerStem (
            @PathVariable(value = "id") long handlebarMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        if (page < 0) page = 0;
        List<Stem> stemsAll = handlebarService
                .findAllStems(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        List<Stem> stems = handlebarService
                .findByHandlebarMakerStem(handlebarMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<HandlebarMaker> handlebarMakers = new HashSet<>();
        for (Stem stem : stemsAll) {
            handlebarMakers.add(stem.getMaker());
        }
            model.addAttribute("productMakers",handlebarMakers);
            model.addAttribute("products", stems);
            model.addAttribute("byGroupPages", getPageCountStem(handlebarMaker));
            model.addAttribute("groupId", handlebarMakerId);
            return "product";
    }
    @RequestMapping("/HandlebarMaker/Winding/{id}")
    public String listHandlebarMakerWinding(
            @PathVariable(value = "id") long handlebarMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        if (page < 0) page = 0;
        List<Winding> windingsAll = handlebarService.findAllWindings(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        Set<HandlebarMaker> handlebarMakers = new HashSet<>();
        for (Winding winding : windingsAll) {
            handlebarMakers.add(winding.getMaker());
        }
        List<Winding> windings = handlebarService
                .findByHandlebarMakerWinding(handlebarMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", handlebarMakers);
        model.addAttribute("products", windings);
        model.addAttribute("byGroupPages", getPageCountWinding(handlebarMaker));
        model.addAttribute("groupId", handlebarMakerId);
        return "product";
    }

    //for delete components for admin
    @RequestMapping(value = "/admin/handlebar/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteHandlebar(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/winding/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteOne(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteWinding(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/grips/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteTwo(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteGrips(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/headset/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteThree(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteHeadset(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/stem/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFor(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
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
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? handlebarService.findBikeType(bikeTypeId) : null;
        HandlebarDiameter handlebarDiameter = (handlebarDiameterId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarDiameter(handlebarDiameterId) : null;
        Handlebar handlebar = new Handlebar(handlebarMaker,article, url,  name, bikeType, handlebarWide, handlebarDiameter, handlebarHeight,material,weight, color ,
                 price, description, way);
        handlebarService.addHandlebar(handlebar);
        return "redirect:/show_Handlebar";
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
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        Winding winding = new Winding(handlebarMaker,article,url,  name, length, wide, material, color ,
                price, description, way);
        handlebarService.addWinding(winding);
        return "redirect:/show_Winding";
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
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        HeadsetType headsetType = (headsetTypeId != DEFAULT_GROUP_ID) ?  handlebarService.findHeadsetType(headsetTypeId) : null;
        TubeDiameter tubeDiameter = (tubeDiameterId != DEFAULT_GROUP_ID) ?  forkService.findTubeDiameter(tubeDiameterId) : null;
        Headset headset = new Headset(handlebarMaker,article,url,  name, headsetType, tubeDiameter, material,size, color ,
                price, description, way);
        handlebarService.addHeadset(headset);
        return "redirect:/show_Headset";
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
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        HandlebarDiameter handlebarDiameter = (handlebarDiameterId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarDiameter(handlebarDiameterId) : null;
        TubeDiameter tubeDiameter = (tubeDiameterId != DEFAULT_GROUP_ID) ?  forkService.findTubeDiameter(tubeDiameterId) : null;
        Stem stem = new Stem(handlebarMaker, article, url, name, angle, handlebarDiameter, tubeDiameter, material,length, color ,
                price, description, way);
        handlebarService.addStem(stem);
        return "redirect:/show_Stem";
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
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        Grips grips = new Grips(handlebarMaker,article,url, name, length, weight, material, color ,
                price, description, way);
        handlebarService.addGrips(grips);
        return "redirect:/show_Grips";
    }

    @RequestMapping(value="/admin/handlebarMaker/add", method = RequestMethod.POST)
    public String handlebarMakerAdd(@RequestParam String name) {
        handlebarService.addHandlebarMaker(new HandlebarMaker(name));
        return "redirect:/show_handlebars";
    }

    // Select one product by url and open in separate page

    @RequestMapping("/Handlebar/{url}")
    public String listHandlebarUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Handlebar> handlebars = handlebarService
                .findHandlebarByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("handlebars", handlebars);
        return "OneHandlebar";
    }

    @RequestMapping("/Stem/{url}")
    public String listStemUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Stem> stems = handlebarService
                .findStemByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("stems", stems);
        return "OneStem";
    }

    @RequestMapping("/Grips/{url}")
    public String listGripsUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Grips> grips = handlebarService
                .findGripsByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("grips", grips);
        return "OneGrips";
    }

    @RequestMapping("/Headset/{url}")
    public String listHeadsetUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Headset> headsets = handlebarService
                .findHeadsetByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("headsets", headsets);
        return "OneHeadset";
    }

    @RequestMapping("/Winding/{url}")
    public String listWindingUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Winding> windings  = handlebarService
                .findWindingByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("windings", windings);
        return "OneWinding";
    }

    private long getPageCountHandlebar() {
        long totalCount = handlebarService.countHadlebar();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountHandlebar(HandlebarMaker handlebarMaker) {
        long totalCount = handlebarService.countByHandlebarMakerHandlebar(handlebarMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getPageCountGrips() {
        long totalCount = handlebarService.countGrips();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountGrips(HandlebarMaker handlebarMaker) {
        long totalCount = handlebarService.countByHandlebarMakerGrips(handlebarMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountHeadset() {
        long totalCount = handlebarService.countHeadset();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountHeadset(HandlebarMaker handlebarMaker) {
        long totalCount = handlebarService.countByHandlebarMakerHeadset(handlebarMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountStem() {
        long totalCount = handlebarService.countStem();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountStem(HandlebarMaker handlebarMaker) {
        long totalCount = handlebarService.countByHandlebarMakerStem(handlebarMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountWinding() {
        long totalCount = handlebarService.countWinding();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountWinding(HandlebarMaker handlebarMaker) {
        long totalCount = handlebarService.countByHandlebarMakerWinding(handlebarMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
}
