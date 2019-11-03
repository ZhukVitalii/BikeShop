package beetle.mapper;

import beetle.entity.Manufacturer;
import beetle.entity.brake.*;
import beetle.entity.wheels.RotorFixType;
import beetle.json.BrakeDiscHydraulicInputJSON;
import beetle.service.HandlebarService;
import beetle.service.WheelService;
import beetle.service.impl.BrakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrakeMapper {
    @Autowired
    private BrakeServiceImpl brakeServiceImpl;
    @Autowired
    private WheelService wheelService;
    @Autowired
    private HandlebarService handlebarService;
    public BrakeDiscHydraulic toBrakeDiscHydraulic(BrakeDiscHydraulicInputJSON input) {
        BrakeDiscHydraulic ret = new BrakeDiscHydraulic();

        Manufacturer brakeMaker = brakeServiceImpl.findBrakeMaker(input.getManufacturer());
        Location location = brakeServiceImpl.findLication(input.getLocationId());
        BrakeLiquid brakeLiquid = brakeServiceImpl.findBrakeLiquid(input.getBrakeLiquidId()) ;
        LengthHydroline lengthHydroline = brakeServiceImpl.findLengthHydroline(input.getLengthHydrolineId());
        RotorDiam rotorDiam = brakeServiceImpl.findRotorDiam(input.getRotorDiamId());
        RotorFixType rotorFixType = wheelService.findRotorFixType(input.getRotorFixTypeId());

        ret.setBrakeLiquid(brakeLiquid);
        ret.setBrakeWeight(input.getBrakeWeight());
        ret.setLengthHydroline(lengthHydroline);
        ret.setLocation(location);
        ret.setMaterialHandle(input.getMaterialHandle());
        ret.setRotorDiam(rotorDiam);
        ret.setRotorFixType(rotorFixType);
        ret.setRotorWeight(input.getRotorWeight());
        ret.setArticle(input.getArticle());
        ret.setColor(input.getColor());
        ret.setDescription(input.getDescription());
        ret.setManufacturer(brakeMaker);
        ret.setName(input.getName());
        ret.setPrice(input.getPrice());
        ret.setUrl(input.getUrl());
        ret.setWay(input.getWay());
        ret.setWeight(input.getWeight());
        return ret;
    }
}
