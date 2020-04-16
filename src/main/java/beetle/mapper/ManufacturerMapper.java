package beetle.mapper;

import beetle.entity.Manufacturer;
import beetle.json.manufacturer.ManufacturerJSON;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ManufacturerMapper {
    public ManufacturerJSON toJSON(Manufacturer manufacturer){
        ManufacturerJSON ret = new ManufacturerJSON();
        ret.setId(manufacturer.getId());
        ret.setName(manufacturer.getName());
        return ret;
    }

    public List<ManufacturerJSON> toJSONs(List<Manufacturer> manufacturers){
        return manufacturers.stream().map( e -> toJSON(e)).collect(Collectors.toList());
    }
}
