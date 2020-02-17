package beetle.mapper;

import beetle.entity.BaseEntity;
import beetle.entity.brake.Brake;
import beetle.entity.brake.BrakeHandle;
import beetle.entity.handlebars.*;
import beetle.entity.wheels.*;
import beetle.exception.CustomWebException;
import beetle.json.BaseJSON;
import beetle.json.PaggingJSON;
import beetle.json.SearchResultResponseJSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static beetle.mapper.BrakeMapper.toBrake;
import static beetle.mapper.BrakeMapper.toBrakeHandle;
import static beetle.mapper.HandlebarMapper.*;
import static beetle.mapper.WheelMapper.*;

public class BaseMapper {

    public SearchResultResponseJSON toSearchResult(List<? extends BaseEntity> entities, PaggingJSON input, Class<?> inputClass) {
        if (entities == null)
            return null;
        SearchResultResponseJSON ret = new SearchResultResponseJSON();
        ret.setResultResponse(toList(entities, inputClass));
        if (input != null) {
            ret.setItemsPerPage(input.getItemsPerPage());
            ret.setPage(input.getPage());
        }
        return ret;
    }




    public static void setBaseParameter(BaseJSON baseJSON, BaseEntity baseEntity){
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

    public List<? extends BaseJSON> toList(List<? extends BaseEntity> results, Class<?> inputClass) {
        List<? extends BaseJSON> ret = new ArrayList<>();
        if (inputClass.equals(Wheel.class)) {
            List<Wheel> wheels = results.stream().map(e -> (Wheel) e).collect(Collectors.toList());
            ret = wheels.stream().map(e ->  toWheel(e)).collect(Collectors.toList());
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
        else if(inputClass.equals(Brake.class)){
            List<Brake> brakes = results.stream().map(e -> (Brake) e).collect(Collectors.toList());
            ret = brakes.stream().map( e -> toBrake(e)).collect(Collectors.toList());
        }
        else if(inputClass.equals(BrakeHandle.class)){
            List<BrakeHandle> brakeHandles = results.stream().map(e -> (BrakeHandle) e).collect(Collectors.toList());
            ret = brakeHandles.stream().map( e -> toBrakeHandle(e)).collect(Collectors.toList());
        }
        else if(inputClass.equals(Handlebar.class)){
            List<Handlebar> handlebars  = results.stream().map(e -> (Handlebar) e).collect(Collectors.toList());
            ret = handlebars.stream().map( e -> toHandlebar(e)).collect(Collectors.toList());
        }
        else if(inputClass.equals(Stem.class)){
            List<Stem> stems  = results.stream().map(e -> (Stem) e).collect(Collectors.toList());
            ret = stems.stream().map( e -> toStem(e)).collect(Collectors.toList());
        }
        else if(inputClass.equals(Winding.class)){
            List<Winding> windings  = results.stream().map(e -> (Winding) e).collect(Collectors.toList());
            ret = windings.stream().map( e -> toWinding(e)).collect(Collectors.toList());
        }
        else if(inputClass.equals(Headset.class)){
            List<Headset> headsets  = results.stream().map(e -> (Headset) e).collect(Collectors.toList());
            ret = headsets.stream().map( e -> toHeadset(e)).collect(Collectors.toList());
        }
        else if(inputClass.equals(Grips.class)){
            List<Grips> grips  = results.stream().map(e -> (Grips) e).collect(Collectors.toList());
            ret = grips.stream().map( e -> toGrips(e)).collect(Collectors.toList());
        }
        return ret;
    }
}
