package beetle.controller;

import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.handlebars.HeadsetType;
import beetle.entity.transmission.BracketWide;
import beetle.entity.frame.*;
import beetle.json.*;
import beetle.mapper.FrameMapper;
import beetle.service.impl.FrameServiceImpl;
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
    private FrameServiceImpl frameServiceImpl;
    @Autowired
    private FrameMapper mapper;

    @RequestMapping("/show_frames")
    @ResponseBody
    public FrameSearchResultResponseJSON framesVeiw(@RequestBody FramesSearchInputJSON input) {
        List<Frame> frames = frameServiceImpl
                .findAll(new PageRequest(input.getPage(), input.getItemsPerPage(), Sort.Direction.DESC, "id"));
        FrameSearchResultResponseJSON ret = mapper.toSearchResult(frames,input);
        return ret;
    }

    //Page for admin
    @RequestMapping("/admin/show_framesAdmin")
    public String framesAdminVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Frame> frames = frameServiceImpl
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        model.addAttribute("allPages", getPageCount());
        return "framesAdmin";
    }

    //add components from browser
    @RequestMapping("/admin/frame_add_page")
    public String frameAddPage(Model model) {
        model.addAttribute("frameMakers", frameServiceImpl.findFrameMakers());
        model.addAttribute("frameSizes", frameServiceImpl.findFrameSize());
        model.addAttribute("wheelsDiams", frameServiceImpl.findWheelsDiam());
        model.addAttribute("trunkBindings", frameServiceImpl.findTrunkBinding());
        model.addAttribute("bikeTypes", frameServiceImpl.findBikeType());
        model.addAttribute("bracketWides", frameServiceImpl.findBracketWide());
        model.addAttribute("headsetTypes", frameServiceImpl.findHeadsetType());
        model.addAttribute("tubeDiameters", frameServiceImpl.findTubeDiameter());
        model.addAttribute("underSaddleTubes", frameServiceImpl.findUnderSaddleTube());
        model.addAttribute("brakesTypes", frameServiceImpl.findBrakesType());
        return "frame_add_page";
    }

    @RequestMapping("/admin/frameMaker_add_page")
    public String frameMakerAddPage() {
        return "frameMaker_add_page";
    }

    // for filter by Maker
    @RequestMapping("/frameMaker/{id}")
    public String listFrameMaker(
            @PathVariable(value = "id") long groupId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        Manufacturer frameMaker = (groupId != DEFAULT_GROUP_ID) ? frameServiceImpl.findFrameMaker(groupId) : null;
        if (page < 0) page = 0;
        List<Frame> frames = frameServiceImpl
                .findByFrameMaker(frameMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        model.addAttribute("byGroupPages", getPageCount(frameMaker));
        model.addAttribute("groupId", groupId);

        return "frames";
    }

    //for delete components for admin
    @RequestMapping(value = "/admin/frame/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            frameServiceImpl.deleteFrame(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add fork to database
    @RequestMapping(value="/admin/frame/add", method = RequestMethod.POST)
    public String frameAdd( @RequestBody FrameInputJSON input)
    {
        Frame frame = mapper.toFrame(input);
        frameServiceImpl.addFrame(frame);
        return "redirect:/show_frames";
    }

    //Add Maker to database
    @RequestMapping(value="/admin/frameMaker/add", method = RequestMethod.POST)
    public String groupAdd(@RequestParam String name) {
        frameServiceImpl.addFrameMaker(new Manufacturer(name));
        return "redirect:/show_frames";
    }

    @RequestMapping(value = "/frame/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FramesJSON listFrameUrl(
            @PathVariable(value = "id") Long id) {
        return mapper.toFrame(frameServiceImpl.findFrame(id));
    }

    private long getPageCount() {
        long totalCount = frameServiceImpl.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCount(Manufacturer frameMaker) {
        long totalCount = frameServiceImpl.countByFrameMaker(frameMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
}
