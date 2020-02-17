package beetle.json.handlebar;

import beetle.entity.forks.TubeDiameter;
import beetle.entity.handlebars.HeadsetType;
import beetle.json.BaseJSON;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class HeadsetJSON extends BaseJSON {
    private long id;
    private String headsetType;
    private Long headsetTypeId;
    private String tubeDiameter;
    private Long tubeDiameterId;
    private String size;
}
