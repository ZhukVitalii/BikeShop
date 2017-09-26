package beetle.Frames;

import beetle.Forks.BrakesType;
import beetle.Forks.TubeDiameter;
import beetle.Forks.WheelsDiam;
import beetle.Handlebars.HeadsetType;
import beetle.Transmissions.BracketWide;
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

@Controller
public class FrameController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;


    @Autowired
    private FrameService frameService;

    //show all frames
    @RequestMapping("/show_frames")
    public String framesVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Frame> frames = frameService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        model.addAttribute("allPages", getPageCount());
        int a = frameService.getSize();
        System.out.println(a);
        return "frames";
    }

    //Page for admin
    @RequestMapping("/show_framesAdmin")
    public String framesAdminVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Frame> frames = frameService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        model.addAttribute("allPages", getPageCount());
        return "framesAdmin";
    }

    //add components from browser
    @RequestMapping("/frame_add_page")
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

    @RequestMapping("/frameMaker_add_page")
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
        FrameMaker frameMaker = (groupId != DEFAULT_GROUP_ID) ? frameService.findFrameMaker(groupId) : null;
        if (page < 0) page = 0;
        List<Frame> frames = frameService
                .findByFrameMaker(frameMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        model.addAttribute("byGroupPages", getPageCount(frameMaker));
        model.addAttribute("groupId", groupId);

        return "frames";
    }

    //for delete components for admin
    @RequestMapping(value = "/frame/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            frameService.deleteFrame(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add fork to database
    @RequestMapping(value="/frame/add", method = RequestMethod.POST)
    public String frameAdd(
                            @RequestParam(value = "frameMaker") long frameMakerId,
                            @RequestParam Long article,
                            @RequestParam String url,
                            @RequestParam String name,
                            @RequestParam(value = "bikeType") long bikeTypeId,
                            @RequestParam(value = "frameSize") long frameSizeId,
                            @RequestParam(value = "wheelsDiam") long wheelsDiamId,
                            @RequestParam String material,
                            @RequestParam(value = "bracketWide") long bracketWideId,
                            @RequestParam(value = "headsetType") long headsetTypeId,
                            @RequestParam(value = "tubeDiameter") long tubeDiameterId,
                            @RequestParam(value = "underSaddleTube") long underSaddleTubeId,
                            @RequestParam(value = "brakesType") long brakesTypeId,
                            @RequestParam(value = "trunkBinding") long trunkBindingId,
                            @RequestParam String weight,
                            @RequestParam String color,
                            @RequestParam Double price,
                            @RequestParam String description,
                            @RequestParam String way
                              )
    {
        FrameMaker frameMaker = (frameMakerId != DEFAULT_GROUP_ID) ? frameService.findFrameMaker(frameMakerId) : null;
        BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? frameService.findBikeType(bikeTypeId) : null;
        FrameSize frameSize = (frameSizeId != DEFAULT_GROUP_ID) ? frameService.findFrameSize(frameSizeId) : null;
        WheelsDiam wheelsDiam = (wheelsDiamId != DEFAULT_GROUP_ID) ? frameService.findWheelsDiam(wheelsDiamId) : null;
        BracketWide bracketWide = (bracketWideId != DEFAULT_GROUP_ID) ? frameService.findBracketWide(bracketWideId) : null;
        HeadsetType headsetType = (headsetTypeId != DEFAULT_GROUP_ID) ? frameService.findHeadsetType(headsetTypeId) : null;
        TubeDiameter tubeDiameter = (tubeDiameterId != DEFAULT_GROUP_ID) ? frameService.findTubeDiameter(tubeDiameterId) : null;
        UnderSaddleTube underSaddleTube = (underSaddleTubeId != DEFAULT_GROUP_ID) ? frameService.findUnderSaddleTuber(underSaddleTubeId) : null;
        BrakesType brakesType =  (brakesTypeId != DEFAULT_GROUP_ID) ? frameService.findBrakesType(bikeTypeId) : null;
        TrunkBinding trunkBinding = (trunkBindingId != DEFAULT_GROUP_ID) ? frameService.findTrunkBinding(trunkBindingId) : null;
        Frame frame = new Frame(frameMaker,article,url,name,bikeType,frameSize, wheelsDiam, material,bracketWide,headsetType,tubeDiameter,
                underSaddleTube,brakesType,trunkBinding,weight,color,price,description,way);
        frameService.addFrame(frame);
        return "redirect:/show_frames";
    }

    //Add Maker to database
    @RequestMapping(value="/frameMaker/add", method = RequestMethod.POST)
    public String groupAdd(@RequestParam String name) {
        frameService.addFrameMaker(new FrameMaker(name));
        return "redirect:/show_frames";
    }

    // Select one product by url and open in separate page
    @RequestMapping("/frame/{url}")
    public String listFrameUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Frame> frames = frameService
                .findByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frames", frames);
        return "OneFrame";
    }

    private long getPageCount() {
        long totalCount = frameService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCount(FrameMaker frameMaker) {
        long totalCount = frameService.countByFrameMaker(frameMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
}
