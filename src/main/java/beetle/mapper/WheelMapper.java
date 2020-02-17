package beetle.mapper;

import beetle.entity.BaseEntity;
import beetle.entity.wheels.*;
import beetle.json.BaseJSON;
import beetle.json.PaggingJSON;
import beetle.json.SearchResultResponseJSON;
import beetle.json.wheel.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WheelMapper extends BaseMapper {


    public static WheelJSON toWheel(Wheel wheel) {
        WheelJSON ret = new WheelJSON();
        ret.setId(wheel.getId());
        ret.setBikeType(wheel.getBikeType().getType());
        ret.setBrakeType(wheel.getBrakeType());
        ret.setHubDescription(wheel.getHubDescription());
        ret.setHubName(wheel.getHubName());
        ret.setLocation(wheel.getLocation());
        ret.setRimDescription(wheel.getRimDescription());
        ret.setRimName(wheel.getRimName());
        ret.setRimWide(wheel.getRimWide());
        ret.setSpokeNumber(wheel.getSpokeNumber());
        ret.setWheelsDiam(wheel.getWheelsDiam());

        setBaseParameter(ret,wheel);
        return ret;
    }

    public static TireJSON toTire(Tire tire){
        TireJSON ret = new TireJSON();
        ret.setCordType(tire.getCordType());
        ret.setId(tire.getId());
        ret.setTireType(tire.getTireType());
        ret.setTireWide(tire.getTireWide());
        if(tire.getWheelsDiam() != null) {
            ret.setWheelsDiam(tire.getWheelsDiam().getDiam());
            ret.setWheelsDiamId(tire.getWheelsDiam().getId());
        }
        setBaseParameter(ret,tire);
        return ret;
    }

    public static SpokeJSON toSpoke(Spoke spoke){
        SpokeJSON ret = new SpokeJSON();
        ret.setDiameter(spoke.getDiameter());
        ret.setLength(spoke.getLength());
        setBaseParameter(ret, spoke);
        return ret;
    }

    public static RimJSON toRim(Rim rim){
        RimJSON ret = new RimJSON();
        if(rim.getBikeType() != null) {
            ret.setBikeType(rim.getBikeType().getType());
            ret.setBikeTypeId(rim.getBikeType().getId());
        }

        ret.setBrakeType(rim.getBrakeType());
        ret.setEtrtoSize(rim.getEtrtoSize());
        ret.setId(rim.getId());
        ret.setInnerTubeDiameter(rim.getInnerTubeDiameter());
        ret.setRimHeight(rim.getRimHeight());
        ret.setRimWide(rim.getRimWide());
        ret.setSpokeNumber(rim.getSpokeNumber());
        if(rim.getWheelsDiam() != null) {
            ret.setWheelsDiam(rim.getWheelsDiam().getDiam());
            ret.setWheelsDiamId(rim.getWheelsDiam().getId());
        }
        setBaseParameter(ret,rim);
        return ret;
        }


    public static HubJSON toHub(Hub hub) {
        HubJSON ret = new HubJSON();

        ret.setAxisDiam(hub.getAxisDiam());
        ret.setAxisLength(hub.getAxisLength());
        ret.setBackSprocketNumber(hub.getBackSprocketNumber());
        ret.setBearingType(hub.getBearingType());
        ret.setBrakeType(hub.getBrakeType());
        ret.setCogsetType(hub.getCogsetType());
        ret.setHubBindingType(hub.getHubBindingType());
        ret.setId(hub.getId());
        ret.setLocation(hub.getLocation());
        if(hub.getRotorFixType() != null) {
            ret.setRotorFixType(hub.getRotorFixType().getType());
            ret.setRotorFixTypeId(hub.getRotorFixType().getId());
        }
        setBaseParameter(ret,hub);

        return ret;
    }

}
