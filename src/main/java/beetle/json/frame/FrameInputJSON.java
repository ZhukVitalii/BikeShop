package beetle.json.frame;

import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrameInputJSON extends BaseJSON {
    private Long bikeTypeId;
    private Long frameSizeId;
    private Long wheelsDiamId;
    private Double bracketWide;
    private Long headsetTypeId;
    private Long tubeDiameterId;
    private Long underSaddleTubeId;
    private Long brakesTypeId;
    private Long trunkBindingId;
}
