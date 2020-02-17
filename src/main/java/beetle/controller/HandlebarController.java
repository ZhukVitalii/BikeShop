package beetle.controller;

import beetle.businessObjects.SearchResultBO;
import beetle.entity.Manufacturer;
import beetle.entity.brake.Brake;
import beetle.exception.CustomWebException;
import beetle.json.SearchResultResponseJSON;
import beetle.json.brakes.BrakeSearchInputJSON;
import beetle.json.handlebar.HandlebarSearchInputJSON;
import beetle.mapper.HandlebarMapper;
import beetle.service.HandlebarService;
import beetle.entity.frame.BikeType;
import beetle.service.ForkService;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.handlebars.*;
import beetle.service.impl.FrameServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
@Controller
public class HandlebarController {
    Logger logger = LoggerFactory.getLogger(BrakeController.class);

    @Autowired
    private HandlebarService handlebarService;
    @Autowired
    private HandlebarMapper mapper;

    //return page with links to pages with components
    @RequestMapping("/show_handlebarsComponents")
    public String brakesComponentsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        return "handlebarsComponents";
    }

    @RequestMapping("/handlebar/search")
    @ResponseBody
    public SearchResultResponseJSON brakesSearch(@RequestBody HandlebarSearchInputJSON input){
        SearchResultResponseJSON response = null;
        try {
            SearchResultBO searchResult = handlebarService.searchByCriteria(input);
            List<Handlebar> handlebars = searchResult.getSearchResult().stream().map(e -> (Handlebar) e).collect(Collectors.toList());
            response = mapper.toSearchResult(handlebars,input,Handlebar.class);
            response.setTotalItems(searchResult.getTotalCount());
        } catch (Exception ex){
            logger.error(ex.getMessage());
            throw new CustomWebException(ex);
        }
        return response;
    }


//    @RequestMapping("/show_stems")
//    public String stemsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
//        if (page < 0) page = 0;
//        List<Stem> stems = handlebarService
//                .findAllFive(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
//        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
//        model.addAttribute("stems", stems);
////        model.addAttribute("allPages", getPageCount());
//        return "stems";
//    }

//    @RequestMapping("/show_windings")
//    public String windingsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
//        if (page < 0) page = 0;
//        List<Winding> windings = handlebarService
//                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
//        model.addAttribute("windings", windings);
////        model.addAttribute("allPages", getPageCount());
//        return "windings";
//    }

//    @RequestMapping("/show_headsets")
//    public String headsetsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
//        if (page < 0) page = 0;
//        List<Headset> headsets = handlebarService
//                .findAllFor(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
//        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
//        model.addAttribute("headsets", headsets);
////        model.addAttribute("allPages", getPageCount());
//        return "headsets";
//    }

//    @RequestMapping("/show_grips")
//    public String gripsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
//        if (page < 0) page = 0;
//        List<Grips> grips = handlebarService
//                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
//        model.addAttribute("grips", grips);
////        model.addAttribute("allPages", getPageCount());
//        return "grips";
//    }



//    // for filter by Maker
//    @RequestMapping("/handlebarMaker/{id}")
//    public String listHandlebarMaker(
//            @PathVariable(value = "id") long handlebarMakerId,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model)
//    {
//        Manufacturer handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
//        if (page < 0) page = 0;
//        List<Handlebar> handlebars = handlebarService
//                .findByHandlebarMakers(handlebarMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
//        model.addAttribute("handlebars", handlebars);
////        model.addAttribute("byHandlebarMakerPages", getPageCount(handlebarMaker));
//        model.addAttribute("groupId", handlebarMakerId);
//
//        return "handlebars";
//    }


    // Select one product by url and open in separate page

//    @RequestMapping("/handlebar/{url}")
//    public String listHandlebarUrl(
//            @PathVariable(value = "url") String url,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model)
//    {
//        if (page < 0) page = 0;
//        List<Handlebar> handlebars = handlebarService
//                .findHandlebarByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("handlebars", handlebars);
//        return "OneHandlebar";
//    }
//
//    @RequestMapping("/stem/{url}")
//    public String listStemUrl(
//            @PathVariable(value = "url") String url,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model)
//    {
//        if (page < 0) page = 0;
//        List<Stem> stems = handlebarService
//                .findStemByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("stems", stems);
//        return "OneStem";
//    }

//    @RequestMapping("/grips/{url}")
//    public String listGripsUrl(
//            @PathVariable(value = "url") String url,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model)
//    {
//        if (page < 0) page = 0;
//        List<Grips> grips = handlebarService
//                .findGripsByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("grips", grips);
//        return "OneGrips";
//    }

//    @RequestMapping("/headset/{url}")
//    public String listHeadsetUrl(
//            @PathVariable(value = "url") String url,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model)
//    {
//        if (page < 0) page = 0;
//        List<Headset> headsets = handlebarService
//                .findHeadsetByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("headsets", headsets);
//        return "OneHeadset";
//    }

//    @RequestMapping("/winding/{url}")
//    public String listWindingUrl(
//            @PathVariable(value = "url") String url,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model)
//    {
//        if (page < 0) page = 0;
//        List<Winding> windings  = handlebarService
//                .findWindingByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//        model.addAttribute("windings", windings);
//        return "OneWinding";
//    }
}
