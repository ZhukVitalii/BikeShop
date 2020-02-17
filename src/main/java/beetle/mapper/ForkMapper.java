package beetle.mapper;

import beetle.entity.forks.Fork;
import beetle.json.SearchResultResponseJSON;
import beetle.json.fork.ForkJSON;
import beetle.json.fork.ForkSearchInputJSON;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ForkMapper extends BaseMapper{


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
        setBaseParameter(ret, forkEntity);
        return ret;
    }

    public SearchResultResponseJSON toSearchResult(List<Fork> forks, ForkSearchInputJSON input) {
        if (forks == null)
            return null;
        SearchResultResponseJSON ret = new SearchResultResponseJSON();
        ret.setResultResponse(toForks(forks));
        if (input != null) {
            ret.setItemsPerPage(input.getItemsPerPage());
            ret.setPage(input.getPage());
        }
        return ret;
    }
}
