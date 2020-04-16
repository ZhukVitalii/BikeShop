package beetle.json.frame;


import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class FramesJSON extends BaseJSON {
    private Long frameId;
    private String bikeType;
    private String wheelsDiameter;
    private Long wheelsDiameterId;
    private String material;
    private String headsetType;
    private String tubeDiameter;
    private String underSaddleTubeDiameter;
    private String brakesType;
    private String trunkBinding;
    private Double bracketWide;
    private String frameSize;
    private Long frameSizeId;
    private Set<FrameSizeJSON> frameSizeTypes;
}
