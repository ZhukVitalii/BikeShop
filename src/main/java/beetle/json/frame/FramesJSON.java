package beetle.json.frame;


import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FramesJSON extends BaseJSON {
    private Long frameId;
    private String bikeType;
    private String wheelsDiameter;
    private String material;
    private String headsetType;
    private String tubeDiameter;
    private String underSaddleTubeDiameter;
    private String brakesType;
    private String trunkBinding;
    private Double bracketWide;
}
