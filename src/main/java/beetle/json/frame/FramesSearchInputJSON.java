package beetle.json.frame;

import beetle.enums.BikeTypeEnum;
import beetle.json.PaggingJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FramesSearchInputJSON extends PaggingJSON {
    private Long bikeTypeId;
    private BikeTypeEnum bikeType;
    private Long frameSizeId;
    private String frameSize;
    private Long manufacturerId;
    private Long wheelsDiamId;
    private Long bracketWideId;
    private Long headsetTypeId;
    private Long tubeDiameterId;
    private Long underSaddleTubeId;
    private Long brakesTypeId;

}
