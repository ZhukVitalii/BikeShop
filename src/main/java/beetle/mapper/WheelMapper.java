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
public class WheelMapper {

    public SearchResultResponseJSON toSearchResult(List<? extends BaseEntity> entities, PaggingJSON input, Class<?> inputClass) {
        if (entities == null)
            return null;
        SearchResultResponseJSON ret = new SearchResultResponseJSON();
        ret.setResult(toList(entities, inputClass));
        if (input != null) {
            ret.setItemsPerPage(input.getItemsPerPage());
            ret.setPage(input.getPage());
        }
        return ret;
    }

    private List<? extends BaseJSON> toList(List<? extends BaseEntity> results, Class<?> inputClass) {
        List<? extends BaseJSON> ret = new ArrayList<>();
        if (inputClass.equals(Wheel.class)) {
            List<Wheel> wheels = results.stream().map(e -> (Wheel) e).collect(Collectors.toList());
            ret = wheels.stream().map(e -> toWheel(e)).collect(Collectors.toList());
        }
        else if(inputClass.equals(Hub.class)){
            List<Hub> hubs = results.stream().map(e -> (Hub) e).collect(Collectors.toList());
            ret = hubs.stream().map(e -> toHub(e)).collect(Collectors.toList());
        }
        else if(inputClass.equals(Tire.class)){
            List<Tire> tires = results.stream().map(e -> (Tire) e).collect(Collectors.toList());
            ret = tires.stream().map(e -> toTire(e)).collect(Collectors.toList());
        }
        else if(inputClass.equals(Rim.class)){
            List<Rim> rims = results.stream().map(e -> (Rim) e).collect(Collectors.toList());
            ret = rims.stream().map(e -> toRim(e)).collect(Collectors.toList());
        }
        else if(inputClass.equals(Spoke.class)){
            List<Spoke> spokes = results.stream().map(e -> (Spoke) e).collect(Collectors.toList());
            ret = spokes.stream().map(e -> toSpoke(e)).collect(Collectors.toList());
        }
        return ret;
    }

    public WheelJSON toWheel(Wheel wheel) {
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

    public TireJSON toTire(Tire tire){
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

    public SpokeJSON toSpoke(Spoke spoke){
        SpokeJSON ret = new SpokeJSON();
        ret.setDiameter(spoke.getDiameter());
        ret.setLength(spoke.getLength());
        setBaseParameter(ret, spoke);
        return ret;
    }

    public RimJSON toRim(Rim rim){
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


    public HubJSON toHub(Hub hub) {
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

    private void setBaseParameter(BaseJSON baseJSON, BaseEntity baseEntity){
        baseJSON.setArticle(baseEntity.getArticle());
        baseJSON.setColor(baseEntity.getColor());
        baseJSON.setDescription(baseEntity.getDescription());
        if(baseEntity.getManufacturer() != null) {
            baseJSON.setManufacturerId(baseEntity.getManufacturer().getId());
            baseJSON.setManufacturerName(baseEntity.getManufacturer().getName());
        }
        baseJSON.setMaterial(baseEntity.getMaterial());
        baseJSON.setName(baseEntity.getName());
        baseJSON.setPrice(baseEntity.getPrice());
        baseJSON.setUrl(baseEntity.getUrl());
        baseJSON.setWay(baseEntity.getWay());
        baseJSON.setWeight(baseEntity.getWeight());
    }

}
