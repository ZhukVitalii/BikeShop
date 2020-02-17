package beetle.mapper;

import beetle.entity.brake.Brake;
import beetle.entity.handlebars.*;
import beetle.json.BaseJSON;
import beetle.json.SearchResultResponseJSON;
import beetle.json.brakes.BrakeJSON;
import beetle.json.handlebar.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HandlebarMapper extends BaseMapper {

    public static HandlebarJSON toHandlebar(Handlebar handlebar) {
        HandlebarJSON ret = new HandlebarJSON();
        ret.setId(handlebar.getId());
        ret.setBikeType(handlebar.getBikeType().getType());
        ret.setBikeTypeId(handlebar.getBikeType().getId());
        ret.setHandlebarDiameter(handlebar.getHandlebarDiameter());
        ret.setHandlebarHeight(handlebar.getHandlebarHeight());
        ret.setHandlebarWide(handlebar.getHandlebarWide());
        setBaseParameter(ret, handlebar);
        return ret;
    }

    public static StemJSON toStem(Stem stem) {
        StemJSON ret = new StemJSON();
        ret.setAngle(stem.getAngle());
        ret.setHandlebarDiameter(stem.getHandlebarDiameter());
        ret.setId(stem.getId());
        ret.setLength(stem.getLength());
        ret.setTubeDiameter(stem.getTubeDiameter().getDiam());
        ret.setTubeDiameterId(stem.getTubeDiameter().getId());
        setBaseParameter(ret,stem);
        return ret;
    }

    public static WindingJSON toWinding(Winding winding){
        WindingJSON ret = new WindingJSON();
        ret.setId(winding.getId());
        ret.setLength(winding.getLength());
        ret.setWide(winding.getWide());
        setBaseParameter(ret, winding);
        return ret;
    }

    public static GripsJSON toGrips(Grips grips){
        GripsJSON ret = new GripsJSON();
        ret.setId(grips.getId());
        ret.setLength(grips.getLength());
        setBaseParameter(ret,grips);
        return ret;
    }
    public static HeadsetJSON toHeadset(Headset headset){
        HeadsetJSON ret = new HeadsetJSON();
        ret.setId(headset.getId());
        ret.setHeadsetType(headset.getHeadsetType().getType());
        ret.setHeadsetTypeId(headset.getHeadsetType().getId());
        ret.setSize(headset.getSize());
        ret.setTubeDiameter(headset.getTubeDiameter().getDiam());
        ret.setTubeDiameterId(headset.getTubeDiameter().getId());
        setBaseParameter(ret, headset);
        return ret;
    }
}
