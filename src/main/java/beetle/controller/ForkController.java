package beetle.controller;

import beetle.businessObjects.SearchResultBO;
import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.Fork;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.frame.BikeType;
import beetle.entity.frame.Frame;
import beetle.exception.CustomWebException;
import beetle.json.fork.ForkJSON;
import beetle.json.fork.ForkSearchInputJSON;
import beetle.json.fork.ForkSearchResultResponseJSON;
import beetle.json.frame.FrameSearchResultResponseJSON;
import beetle.json.frame.FramesJSON;
import beetle.mapper.ForkMapper;
import beetle.service.ForkService;
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
 * Created by VitaliiZhuk on 20.05.2017.
 */
@Controller
@RequestMapping("/fork")
public class ForkController {
    @Autowired
    private ForkService forkService;
    @Autowired
    private ForkMapper forkMapper;

    //show all forks
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public ForkSearchResultResponseJSON searchForks(@RequestBody ForkSearchInputJSON input) {
        ForkSearchResultResponseJSON response = null;

            SearchResultBO searchResult = forkService.searchByCriteria(input);
            List<Fork> forks = searchResult.getSearchResult().stream().map(e -> (Fork) e).collect(Collectors.toList());
            response = forkMapper.toSearchResult(forks,input);
            response.setTotalItems(searchResult.getTotalCount());


        return response;



    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ForkJSON getFrame(@PathVariable(value = "id") Long id) {
        return forkMapper.toFork(forkService.findFork(id));
    }

}

