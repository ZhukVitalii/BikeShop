package beetle.controller;

import beetle.businessObjects.SearchResultBO;
import beetle.entity.frame.*;
import beetle.exception.CustomWebException;
import beetle.json.SearchResultResponseJSON;
import beetle.json.frame.FrameSizeJSON;
import beetle.json.frame.FramesJSON;
import beetle.json.frame.FramesSearchInputJSON;
import beetle.mapper.FrameMapper;
import beetle.service.FrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/frame")
public class FrameController {

    @Autowired
    private FrameService frameService;
    @Autowired
    private FrameMapper frameMapper;


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public SearchResultResponseJSON searchFrames(@RequestBody FramesSearchInputJSON input) {
        SearchResultResponseJSON response = null;
        try {
            SearchResultBO searchResult = frameService.searchByCriteria(input);
            List<Frame> frames = searchResult.getSearchResult().stream().map(e -> (Frame) e).collect(Collectors.toList());
            response = frameMapper.toSearchResult(frames,input);
            response.setTotalItems(searchResult.getTotalCount());
        }
        catch (Exception ex){
            throw new CustomWebException(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/get-frame-sizes", method = RequestMethod.GET)
    @ResponseBody
    public List<FrameSizeJSON> chooseFrameSizes() {
        return frameMapper.toFrameSize(frameService.findFrameSize());
    }

    @RequestMapping("/show-frames")
    @ResponseBody
    public SearchResultResponseJSON framesVeiw(@RequestBody FramesSearchInputJSON input) {
        List<Frame> frames = frameService
                .findAll(new PageRequest(input.getPage(), input.getItemsPerPage(), Sort.Direction.DESC, "id"));
        SearchResultResponseJSON ret = frameMapper.toSearchResult(frames,input);
        ret.setTotalItems(frameService.count());
        return ret;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FramesJSON getFrame(@PathVariable(value = "id") Long id) {
        return frameMapper.toFrame(frameService.findFrame(id));
    }

}
