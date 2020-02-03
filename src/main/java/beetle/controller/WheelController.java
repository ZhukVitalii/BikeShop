package beetle.controller;

import beetle.businessObjects.SearchResultBO;
import beetle.entity.wheels.*;
import beetle.exception.CustomWebException;
import beetle.json.SearchResultResponseJSON;
import beetle.json.wheel.HubJSON;
import beetle.json.wheel.HubSearchInputJSON;
import beetle.json.wheel.WheelJSON;
import beetle.json.wheel.WheelSearchInputJSON;
import beetle.mapper.WheelMapper;
import beetle.service.WheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    private WheelMapper wheelMapper;

    //return page with links to pages with components
    @RequestMapping("/show_wheelsComponent")
    public String wheelsComponentsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        return "wheelsComponent";
    }


    @RequestMapping("wheel/search")
    @ResponseBody
    public SearchResultResponseJSON searchWheels(@RequestBody WheelSearchInputJSON input) {
        SearchResultResponseJSON response = null;
        try {
            SearchResultBO searchResult = wheelService.searchByCriteria(input);
            List<Wheel> wheels = searchResult.getSearchResult().stream().map(e -> (Wheel) e).collect(Collectors.toList());
            response = wheelMapper.toSearchResult(wheels,input,Wheel.class);
            response.setTotalItems(searchResult.getTotalCount());
        }
        catch (Exception ex){
            throw new CustomWebException(ex.getMessage());
        }
        return response;
    }

    @RequestMapping("hub/search")
    @ResponseBody
    public SearchResultResponseJSON searchHubs(@RequestBody HubSearchInputJSON input) {
        SearchResultResponseJSON response = null;
       // try {
            SearchResultBO searchResult = wheelService.searchByCriteria(input);
            List<Hub> hubs = searchResult.getSearchResult().stream().map(e -> (Hub) e).collect(Collectors.toList());
            response = wheelMapper.toSearchResult(hubs,input,Hub.class);
            response.setTotalItems(searchResult.getTotalCount());
       // }
       // catch (Exception ex){
       //     throw new CustomWebException(ex.getMessage());
       // }
        return response;
    }




    @RequestMapping(value = "wheel/{id}", method = RequestMethod.GET)
    @ResponseBody
    public WheelJSON getWheel(@PathVariable(value = "id") Long id) {
        return wheelMapper.toWheel(wheelService.getWheel(id));
    }

    @RequestMapping(value = "hub/{id}", method = RequestMethod.GET)
    @ResponseBody
    public HubJSON getHub(@PathVariable(value = "id") Long id) {
        return wheelMapper.toHub(wheelService.getHub(id));
    }


}

