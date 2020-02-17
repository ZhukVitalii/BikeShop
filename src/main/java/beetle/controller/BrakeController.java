package beetle.controller;

import beetle.businessObjects.SearchResultBO;
import beetle.exception.CustomWebException;
import beetle.json.SearchResultResponseJSON;
import beetle.json.brakes.*;
import beetle.mapper.BrakeMapper;
import beetle.service.BrakeService;
import beetle.service.HandlebarService;
import beetle.service.WheelService;
import beetle.entity.brake.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
@Controller
@RequestMapping("/brake")
public class BrakeController {
    Logger logger = LoggerFactory.getLogger(BrakeController.class);
    @Autowired
    private BrakeService brakeService;
    @Autowired
    private BrakeMapper brakeMapper;

    //return page with links to pages with components
    @RequestMapping("/show_brakesComponents")
    public String brakesComponentsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        return "brakesComponents";
    }


    @RequestMapping("/search")
    @ResponseBody
    public SearchResultResponseJSON brakesSearch(@RequestBody BrakeSearchInputJSON input){
        SearchResultResponseJSON response = null;
        try {
        SearchResultBO searchResult = brakeService.searchByCriteria(input);
            List<Brake> brakes = searchResult.getSearchResult().stream().map(e -> (Brake) e).collect(Collectors.toList());
            response = brakeMapper.toSearchResult(brakes,input, Brake.class);
            response.setTotalItems(searchResult.getTotalCount());
        } catch (Exception ex){
            logger.error(ex.getMessage());
            throw new CustomWebException(ex);
       }
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BrakeJSON getBrake(@PathVariable(value = "id") Long id) {
        return brakeMapper.toBrake(brakeService.getBrake(id));
    }
    @RequestMapping(value = "/brakes-handle/search", method = RequestMethod.POST)
    @ResponseBody
    public SearchResultResponseJSON searchBrakesHandles(@RequestBody BrakeHandleSearchInputJSON input) {
        SearchResultResponseJSON response = null;
       try {
            SearchResultBO searchResult = brakeService.searchByCriteria(input);
            List<BrakeHandle> brakes = searchResult.getSearchResult().stream().map(e -> (BrakeHandle) e).collect(Collectors.toList());
            response = brakeMapper.toSearchResult(brakes,input, BrakeHandle.class);
            response.setTotalItems(searchResult.getTotalCount());
       } catch (Exception ex){
            logger.error(ex.getMessage());
            throw new CustomWebException(ex);
       }
        return response;
    }

    @RequestMapping(value = "/brakes-handle/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BrakeHandleJSON getBrakeHandle(@PathVariable(value = "id") Long id) {
        return brakeMapper.toBrakeHandle(brakeService.getBrakeHandle(id));
    }

}



