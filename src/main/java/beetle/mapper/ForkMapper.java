package beetle.mapper;

import beetle.entity.forks.Fork;
import beetle.json.fork.ForkJSON;
import beetle.json.fork.ForkSearchInputJSON;
import beetle.json.fork.ForkSearchResultResponseJSON;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ForkMapper {


    public List<ForkJSON> toForks(List<Fork> dest){
        List<ForkJSON> ret = new ArrayList<>();
        for (Fork forkEntity : dest) {
            ret.add(toFork(forkEntity));
        }
        return ret;
    }

    public ForkJSON toFork(Fork forkEntity) {
        ForkJSON ret = new ForkJSON();
        ret.setBikeType(forkEntity.getBikeType().getType());
        ret.setBrakeType(forkEntity.getBrakeType());
        ret.setId(forkEntity.getId());
        ret.setStTubeLength(forkEntity.getStTubeLength());
        ret.setTubeDiameter(forkEntity.getTubeDiameter().getDiam());
        ret.setWheelsDiam(forkEntity.getWheelsDiam().getDiam());
        ret.setArticle(forkEntity.getArticle());
        ret.setColor(forkEntity.getColor());
        ret.setDescription(forkEntity.getDescription());
        ret.setManufacturerId(forkEntity.getManufacturer().getId());
        ret.setManufacturerName(forkEntity.getManufacturer().getName());
        ret.setMaterial(forkEntity.getMaterial());
        ret.setName(forkEntity.getName());
        ret.setPrice(forkEntity.getPrice());
        ret.setUrl(forkEntity.getUrl());
        ret.setWay(forkEntity.getWay());
        ret.setWeight(forkEntity.getWeight());
        return ret;
    }

    public ForkSearchResultResponseJSON toSearchResult(List<Fork> forks, ForkSearchInputJSON input) {
        if (forks == null)
            return null;
        ForkSearchResultResponseJSON ret = new ForkSearchResultResponseJSON();
        ret.setForks(toForks(forks));
        if (input != null) {
            ret.setItemsPerPage(input.getItemsPerPage());
            ret.setPage(input.getPage());
        }
        return ret;
    }
}
