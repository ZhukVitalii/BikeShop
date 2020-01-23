package beetle.mapper;

import beetle.entity.Manufacturer;
import beetle.entity.brake.*;
import beetle.enums.brakes.BrakeHandleCompatibilityEnum;
import beetle.enums.brakes.BrakeHandleLocationEnum;
import beetle.json.brakes.*;
import beetle.service.impl.BrakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BrakeMapper {
    @Autowired
    private BrakeServiceImpl brakeServiceImpl;
    public Brake toBrake(BrakeJSON input) {
        Brake ret = new Brake();

        Manufacturer brakeMaker = brakeServiceImpl.findBrakeMaker(input.getManufacturerId());

        ret.setBrakeType(input.getBrakeType());
        ret.setBrakeSubType(input.getBrakeSubType().name());
        ret.setBrakeLiquid(input.getBrakeLiquid());
        ret.setBrakeWeight(input.getBrakeWeight());
        ret.setLengthHydroline(input.getLengthHydroline());
        ret.setLocation(input.getLocation());
        ret.setMaterialHandle(input.getMaterialHandle());
        ret.setRotorDiam(input.getRotorDiam());
        ret.setRotorFixType(input.getRotorFixType());
        ret.setRotorWeight(input.getRotorWeight());
        ret.setArticle(input.getArticle());
        ret.setColor(input.getColor());
        ret.setDescription(input.getDescription());
        ret.setManufacturer(brakeMaker);
        ret.setName(input.getName());
        ret.setPrice(input.getPrice());
        ret.setUrl(input.getUrl());
        ret.setWay(input.getWay());
        return ret;
    }

    public BrakeSearchResultResponseJSON toSearchResult(List<Brake> brakes, BrakeSearchInputJSON input) {
        if (brakes == null)
            return null;
        BrakeSearchResultResponseJSON ret = new BrakeSearchResultResponseJSON();
        ret.setBrakes(toBrakes(brakes));
        if (input != null) {
            ret.setItemsPerPage(input.getItemsPerPage());
            ret.setPage(input.getPage());
        }
        return ret;
    }

    public BrakeHandleSearchResultResponseJSON toSearchResult(List<BrakeHandle> brakeHandles, BrakeHandleSearchInputJSON input) {
        if (brakeHandles == null)
            return null;
        BrakeHandleSearchResultResponseJSON ret = new BrakeHandleSearchResultResponseJSON();
        ret.setBrakeHandles(toBrakeHandles(brakeHandles));
        if (input != null) {
            ret.setItemsPerPage(input.getItemsPerPage());
            ret.setPage(input.getPage());
        }
        return ret;
    }

    private List<BrakeHandleJSON> toBrakeHandles(List<BrakeHandle> brakeHandles) {
        List<BrakeHandleJSON> ret = new ArrayList<>();
        for (BrakeHandle brakeHandle : brakeHandles) {
            ret.add(toBrakeHandle(brakeHandle));
        }
        return  ret;
    }

    private List<BrakeJSON> toBrakes(List<Brake> brakes) {
        List<BrakeJSON> ret = new ArrayList<>();
        for (Brake brake : brakes) {
            ret.add(toBrake(brake));
        }
        return ret;
    }

    public BrakeJSON toBrake(Brake brake) {
        BrakeJSON ret = new BrakeJSON();
        ret.setId(brake.getId());
        ret.setBrakeLiquid(brake.getBrakeLiquid());
        ret.setBrakeSubType(brake.getBrakeSubType());
        ret.setBrakeType(brake.getBrakeType());
        ret.setBrakeWeight(brake.getBrakeWeight());
        ret.setLengthHydroline(brake.getLengthHydroline());
        ret.setLocation(brake.getLocation());
        ret.setMaterialHandle(brake.getMaterialHandle());
        ret.setRotorDiam(brake.getRotorDiam());
        ret.setRotorFixType(brake.getRotorFixType());
        ret.setRotorWeight(brake.getRotorWeight());
        ret.setArticle(brake.getArticle());
        ret.setColor(brake.getColor());
        ret.setDescription(brake.getDescription());
        ret.setManufacturerId(brake.getManufacturer().getId());
        ret.setManufacturerName(brake.getManufacturer().getName());
        ret.setName(brake.getName());
        ret.setPrice(brake.getPrice());
        ret.setWay(brake.getWay());
        return ret;
    }

    public BrakeHandleJSON toBrakeHandle(BrakeHandle brakeHandle){
        BrakeHandleJSON ret = new BrakeHandleJSON();
            ret.setId(brakeHandle.getId());
            ret.setCompatibility(brakeHandle.getCompatibility());
            ret.setHandlebarDiameter(brakeHandle.getHandlebarDiameter().getDiam());
            ret.setLocation(brakeHandle.getLocation());
            ret.setMaterialCorp(brakeHandle.getMaterialCorp());
            ret.setMaterialHandle(brakeHandle.getMaterialHandle());
            ret.setWide(brakeHandle.getWide());
            ret.setArticle(brakeHandle.getArticle());
            ret.setColor(brakeHandle.getColor());
            ret.setDescription(brakeHandle.getDescription());
            ret.setManufacturerId(brakeHandle.getManufacturer().getId());
            ret.setManufacturerName(brakeHandle.getManufacturer().getName());
            ret.setName(brakeHandle.getName());
            ret.setPrice(brakeHandle.getPrice());
            ret.setWay(brakeHandle.getWay());
            ret.setWeight(brakeHandle.getWeight());
        return ret;
    }
}
