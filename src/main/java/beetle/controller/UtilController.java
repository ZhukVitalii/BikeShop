package beetle.controller;

import beetle.json.frame.FramesJSON;
import beetle.json.manufacturer.ManufacturerJSON;
import beetle.service.ManufacturerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UtilController {
    private final ManufacturerService manufacturerService;

    public UtilController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }


    @RequestMapping(value = "manufacturer/{id}", method = RequestMethod.GET)
    public ManufacturerJSON getManufacturer(@PathVariable(value = "id") Long id){
        return manufacturerService.getManufacturer(id);
    }

    @RequestMapping(value = "manufacturer/get-all", method = RequestMethod.GET)
    public List<ManufacturerJSON> getManufacturer(){
        return manufacturerService.getManufacturers();
    }


}
