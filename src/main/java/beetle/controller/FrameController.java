package beetle.controller;

import beetle.entity.Manufacturer;
import beetle.entity.frame.*;
import beetle.exception.CustomWebException;
import beetle.json.*;
import beetle.mapper.FrameMapper;
import beetle.service.FrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FrameController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;


    @Autowired
    private FrameService frameService;
    @Autowired
    private FrameMapper frameMapper;


    // for filter by Maker
    @RequestMapping(value = "/frame-maker", method = RequestMethod.POST)
    @ResponseBody
    public FrameSearchResultResponseJSON listByFrameMaker(@RequestBody FramesSearchInputJSON input) {
        FrameSearchResultResponseJSON response = null;
        try {
            response = frameMapper.toSearchResult(frameService.searchByCriteria(input),input);
        }
        catch (Exception ex){
            throw new CustomWebException(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/get-frames", method = RequestMethod.POST)
    @ResponseBody
    public FrameSearchResultResponseJSON getFrames( @RequestBody FramesSearchInputJSON input) {

        return frameMapper.toSearchResult(frameService.findByBikeType(frameService.findBikeType(input.getBikeTypeId()),
                new PageRequest(input.getPage() < 0 ? 0 : input.getPage(),
                        input.getItemsPerPage(),
                        Sort.Direction.DESC, "id")), input);
    }

    @RequestMapping(value = "/get-frame-sizes", method = RequestMethod.GET)
    @ResponseBody
    public List<FrameSizeJSON> chooseFrameSizes() {
        return frameMapper.toFrameSize(frameService.findFrameSize());
    }

    @RequestMapping(value = "/frames-by-size", method = RequestMethod.POST)
    @ResponseBody
    public FrameSearchResultResponseJSON getFramesBySize(@RequestBody FramesSearchInputJSON input) {
        return frameMapper.toSearchResult(frameService.findByTypeAndSize(frameService.findBikeType(input.getBikeTypeId()),
                frameService.findFrameSize(input.getFrameSizeId()),
                new PageRequest(input.getPage() < 0 ? 0 : input.getPage(),
                        input.getItemsPerPage(),
                        Sort.Direction.DESC, "id")), input);
    }

    @RequestMapping("/show_frames")
    @ResponseBody
    public FrameSearchResultResponseJSON framesVeiw(@RequestBody FramesSearchInputJSON input) {
        List<Frame> frames = frameService
                .findAll(new PageRequest(input.getPage(), input.getItemsPerPage(), Sort.Direction.DESC, "id"));
        FrameSearchResultResponseJSON ret = frameMapper.toSearchResult(frames,input);
        return ret;
    }

    //Page for admin
    @RequestMapping("/admin/show_framesAdmin")
    public String framesAdminVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Frame> frames = frameService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        model.addAttribute("allPages", getPageCount());
        return "framesAdmin";
    }

    //add components from browser
    @RequestMapping("/admin/frame_add_page")
    public String frameAddPage(Model model) {
        model.addAttribute("frameMakers", frameService.findFrameMakers());
        model.addAttribute("frameSizes", frameService.findFrameSize());
        model.addAttribute("wheelsDiams", frameService.findWheelsDiam());
        model.addAttribute("trunkBindings", frameService.findTrunkBinding());
        model.addAttribute("bikeTypes", frameService.findBikeType());
        model.addAttribute("bracketWides", frameService.findBracketWide());
        model.addAttribute("headsetTypes", frameService.findHeadsetType());
        model.addAttribute("tubeDiameters", frameService.findTubeDiameter());
        model.addAttribute("underSaddleTubes", frameService.findUnderSaddleTube());
        model.addAttribute("brakesTypes", frameService.findBrakesType());
        return "frame_add_page";
    }

    @RequestMapping("/admin/frameMaker_add_page")
    public String frameMakerAddPage() {
        return "frameMaker_add_page";
    }

    //for delete components for admin
    @RequestMapping(value = "/admin/frame/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            frameService.deleteFrame(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add fork to database
    @RequestMapping(value="/admin/frame/add", method = RequestMethod.POST)
    public String frameAdd( @RequestBody FrameInputJSON input)
    {
        Frame frame = frameMapper.toFrame(input);
        frameService.addFrame(frame);
        return "redirect:/show_frames";
    }

    //Add Maker to database
    @RequestMapping(value="/admin/frameMaker/add", method = RequestMethod.POST)
    public String groupAdd(@RequestParam String name) {
        frameService.addFrameMaker(new Manufacturer(name));
        return "redirect:/show_frames";
    }

    @RequestMapping(value = "/frame/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FramesJSON listFrameUrl(
            @PathVariable(value = "id") Long id) {
        return frameMapper.toFrame(frameService.findFrame(id));
    }

    private long getPageCount() {
        long totalCount = frameService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCount(Manufacturer frameMaker) {
        long totalCount = frameService.countByFrameMaker(frameMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
}
