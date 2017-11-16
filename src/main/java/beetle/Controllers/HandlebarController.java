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

import java.util.List;

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
        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());
        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        model.addAttribute("headsetType", handlebarService.findHeadsetType());
        model.addAttribute("handlebars", handlebars);
        model.addAttribute("windings", windings);
        model.addAttribute("grips", grips);
        model.addAttribute("headsets", headsets);
        model.addAttribute("stems", stems);
        model.addAttribute("allPages", getPageCount());
        return "handlebarsAdmin";
    }

    // return pages with type of handlebars components
    @RequestMapping("/show_handlebars")
    public String handlebarsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Handlebar> handlebars = handlebarService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("handlebars", handlebars);
        model.addAttribute("allPages", getPageCount());
        return "handlebars";
    }

    @RequestMapping("/show_stems")
    public String stemsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Stem> stems = handlebarService
                .findAllFive(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("stems", stems);
        model.addAttribute("allPages", getPageCount());
        return "stems";
    }

    @RequestMapping("/show_windings")
    public String windingsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Winding> windings = handlebarService
                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("windings", windings);
        model.addAttribute("allPages", getPageCount());
        return "windings";
    }

    @RequestMapping("/show_headsets")
    public String headsetsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Headset> headsets = handlebarService
                .findAllFor(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("headsets", headsets);
        model.addAttribute("allPages", getPageCount());
        return "headsets";
    }

    @RequestMapping("/show_grips")
    public String gripsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Grips> grips = handlebarService
                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("grips", grips);
        model.addAttribute("allPages", getPageCount());
        return "grips";
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
    public String listHandlebarMaker(
            @PathVariable(value = "id") long handlebarMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        if (page < 0) page = 0;
        List<Handlebar> handlebars = handlebarService
                .findByHandlebarMakers(handlebarMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("handlebars", handlebars);
        model.addAttribute("byHandlebarMakerPages", getPageCount(handlebarMaker));
        model.addAttribute("groupId", handlebarMakerId);

        return "handlebars";
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
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        Winding winding = new Winding(handlebarMaker,article,url,  name, length, wide, material, color ,
                price, description, way);
        handlebarService.addWinding(winding);
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
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        HeadsetType headsetType = (headsetTypeId != DEFAULT_GROUP_ID) ?  handlebarService.findHeadsetType(headsetTypeId) : null;
        TubeDiameter tubeDiameter = (tubeDiameterId != DEFAULT_GROUP_ID) ?  forkService.findTubeDiameter(tubeDiameterId) : null;
        Headset headset = new Headset(handlebarMaker,article,url,  name, headsetType, tubeDiameter, material,size, color ,
                price, description, way);
        handlebarService.addHeadset(headset);
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
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        HandlebarDiameter handlebarDiameter = (handlebarDiameterId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarDiameter(handlebarDiameterId) : null;
        TubeDiameter tubeDiameter = (tubeDiameterId != DEFAULT_GROUP_ID) ?  forkService.findTubeDiameter(tubeDiameterId) : null;
        Stem stem = new Stem(handlebarMaker, article, url, name, angle, handlebarDiameter, tubeDiameter, material,length, color ,
                price, description, way);
        handlebarService.addStem(stem);
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
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        Grips grips = new Grips(handlebarMaker,article,url, name, length, weight, material, color ,
                price, description, way);
        handlebarService.addGrips(grips);
        return "redirect:/show_grips";
    }

    @RequestMapping(value="/admin/handlebarMaker/add", method = RequestMethod.POST)
    public String handlebarMakerAdd(@RequestParam String name) {
        handlebarService.addHandlebarMaker(new HandlebarMaker(name));
        return "redirect:/show_handlebars";
    }

    // Select one product by url and open in separate page

    @RequestMapping("/handlebar/{url}")
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

    @RequestMapping("/stem/{url}")
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

    @RequestMapping("/grips/{url}")
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

    @RequestMapping("/headset/{url}")
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

    @RequestMapping("/winding/{url}")
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

    private long getPageCount() {
        long totalCount = handlebarService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCount(HandlebarMaker handlebarMaker) {
        long totalCount = handlebarService.countByHandlebarMaker(handlebarMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }



}
