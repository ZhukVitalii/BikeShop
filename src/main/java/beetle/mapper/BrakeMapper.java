package beetle.mapper;

import beetle.entity.Manufacturer;
import beetle.entity.brake.*;
import beetle.json.SearchResultResponseJSON;
import beetle.json.brakes.*;
import beetle.service.impl.BrakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BrakeMapper extends BaseMapper {
    @Autowired
    private BrakeServiceImpl brakeServiceImpl;
    public Brake toBrake(BrakeJSON input) {
        Brake ret = new Brake();

        Manufacturer brakeMaker = brakeServiceImpl.findBrakeMaker(input.getManufacturerId());

        ret.setBrakeType(input.getBrakeType());
        ret.setBrakeSubType(input.getBrakeSubType());
        ret.setBrakeLiquid(input.getBrakeLiquid());
        ret.setWeight(input.getBrakeWeight());
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

    public static BrakeJSON toBrake(Brake brake) {
        BrakeJSON ret = new BrakeJSON();
        ret.setId(brake.getId());
        ret.setBrakeLiquid(brake.getBrakeLiquid());
        ret.setBrakeSubType(brake.getBrakeSubType());
        ret.setBrakeType(brake.getBrakeType());
        ret.setBrakeWeight(brake.getWeight());
        ret.setLengthHydroline(brake.getLengthHydroline());
        ret.setLocation(brake.getLocation());
        ret.setMaterialHandle(brake.getMaterialHandle());
        ret.setRotorDiam(brake.getRotorDiam());
        ret.setRotorFixType(brake.getRotorFixType());
        ret.setRotorWeight(brake.getRotorWeight());
        setBaseParameter(ret, brake);
        return ret;
    }

    public static BrakeHandleJSON toBrakeHandle(BrakeHandle brakeHandle){
        BrakeHandleJSON ret = new BrakeHandleJSON();
            ret.setId(brakeHandle.getId());
            ret.setCompatibility(brakeHandle.getCompatibility());
            ret.setHandlebarDiameter(brakeHandle.getHandlebarDiameter());
            ret.setLocation(brakeHandle.getLocation());
            ret.setMaterialCorp(brakeHandle.getMaterialCorp());
            ret.setMaterialHandle(brakeHandle.getMaterial());

            setBaseParameter(ret, brakeHandle);
        return ret;
    }
}
