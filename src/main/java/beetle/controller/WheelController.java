package beetle.controller;

import beetle.businessObjects.SearchResultBO;
import beetle.entity.wheels.*;
import beetle.exception.CustomWebException;
import beetle.json.SearchResultResponseJSON;
import beetle.json.wheel.*;
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


    @Autowired
    private WheelService wheelService;
    @Autowired
    private WheelMapper wheelMapper;

    @RequestMapping(value = "wheel/search", method = RequestMethod.POST)
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
            throw new CustomWebException(ex);
        }
        return response;
    }

    @RequestMapping(value = "hub/search", method = RequestMethod.POST)
    @ResponseBody
    public SearchResultResponseJSON searchHubs(@RequestBody HubSearchInputJSON input) {
        SearchResultResponseJSON response = null;
        try {
            SearchResultBO searchResult = wheelService.searchByCriteria(input);
            List<Hub> hubs = searchResult.getSearchResult().stream().map(e -> (Hub) e).collect(Collectors.toList());
            response = wheelMapper.toSearchResult(hubs,input,Hub.class);
            response.setTotalItems(searchResult.getTotalCount());
        }
        catch (Exception ex){
            throw new CustomWebException(ex);
        }
        return response;
    }

    @RequestMapping(value = "spoke/search", method = RequestMethod.POST)
    @ResponseBody
    public SearchResultResponseJSON searchSpokes(@RequestBody SpokeSearchInputJSON input) {
        SearchResultResponseJSON response = null;
        try {
            SearchResultBO searchResult = wheelService.searchByCriteria(input);
            List<Spoke> spokes = searchResult.getSearchResult().stream().map(e -> (Spoke) e).collect(Collectors.toList());
            response = wheelMapper.toSearchResult(spokes,input,Spoke.class);
            response.setTotalItems(searchResult.getTotalCount());
        }
        catch (Exception ex){
            throw new CustomWebException(ex);
        }
        return response;
    }

    @RequestMapping(value = "tire/search", method = RequestMethod.POST)
    @ResponseBody
    public SearchResultResponseJSON searchTires(@RequestBody TireSearchInputJSON input) {
        SearchResultResponseJSON response = null;
        try {
            SearchResultBO searchResult = wheelService.searchByCriteria(input);
            List<Tire> tires = searchResult.getSearchResult().stream().map(e -> (Tire) e).collect(Collectors.toList());
            response = wheelMapper.toSearchResult(tires,input,Tire.class);
            response.setTotalItems(searchResult.getTotalCount());
        }
        catch (Exception ex){
            throw new CustomWebException(ex);
        }
        return response;
    }

    @RequestMapping(value = "rim/search", method = RequestMethod.POST)
    @ResponseBody
    public SearchResultResponseJSON searchRims(@RequestBody RimSearchInputJSON input) {
        SearchResultResponseJSON response = null;
        try {
            SearchResultBO searchResult = wheelService.searchByCriteria(input);
            List<Rim> rims = searchResult.getSearchResult().stream().map(e -> (Rim) e).collect(Collectors.toList());
            response = wheelMapper.toSearchResult(rims,input,Rim.class);
            response.setTotalItems(searchResult.getTotalCount());
        }
        catch (Exception ex){
            throw new CustomWebException(ex);
        }
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
    @RequestMapping(value = "tire/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TireJSON getTire(@PathVariable(value = "id") Long id) {
        return wheelMapper.toTire(wheelService.getTire(id));
    }
    @RequestMapping(value = "spoke/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SpokeJSON getSpokes(@PathVariable(value = "id") Long id) {
        return wheelMapper.toSpoke(wheelService.getSpoke(id));
    }

    @RequestMapping(value = "rim/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RimJSON getRims(@PathVariable(value = "id") Long id) {
        return wheelMapper.toRim(wheelService.getRim(id));
    }

}

