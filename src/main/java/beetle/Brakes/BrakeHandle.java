package beetle.Brakes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import beetle.Handlebars.HandlebarDiameter;

import javax.persistence.*;

/**
 * Created by VitaliiZhuk on 29.06.2017.
 */
@Entity
@Table(name="BrakeHandles")
@NoArgsConstructor
@Getter
@Setter
public class BrakeHandle {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="maker_id")
    private BrakeMaker brakeMaker;
    private Long article;
    private String url;
    private String name;
    @ManyToOne
    @JoinColumn(name="loc_id")
    private BrakeHandleLocation brakeHandleLocation;
    @ManyToOne
    @JoinColumn(name="comp_id")
    private BrakeHandleCompatibility brakeHandleCompatibility;
    private String materialHandle;
    private String materialCorp;
    @ManyToOne
    @JoinColumn(name="diam_id")
    private HandlebarDiameter handlebarDiameter;
    @ManyToOne
    @JoinColumn(name="wide_id")
    private  BrakeHandleWide brakeHandleWide;
    private String weight;
    private String color;
    @Column(name = "description", length = 10000)
    private String description;
    private Double price;
    private String way;

    public BrakeHandle(BrakeMaker brakeMaker, Long article,String url,String name,BrakeHandleLocation brakeHandleLocation, BrakeHandleCompatibility brakeHandleCompatibility,
                       String materialHandle,String materialCorp,HandlebarDiameter handlebarDiameter,BrakeHandleWide brakeHandleWide,
                       String weight, String color, String description, Double price,  String way) {
        this.brakeMaker = brakeMaker;
        this.article = article;
        this.url = url;
        this.name = name;
        this.brakeHandleLocation = brakeHandleLocation;
        this.brakeHandleCompatibility = brakeHandleCompatibility;
        this.materialHandle = materialHandle;
        this.materialCorp = materialCorp;
        this.handlebarDiameter = handlebarDiameter;
        this.brakeHandleWide = brakeHandleWide;
        this.weight = weight;
        this.color = color;
        this.description = description;
        this.price = price;
        this.way = way;
    }
    public Double getPrice(){
        return price;
    }

}