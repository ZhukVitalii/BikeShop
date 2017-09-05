package beetle.Bakes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by VitaliiZhuk on 30.07.2017.
 */
@Entity
@Table(name="Carts")
@NoArgsConstructor
@Getter
@Setter

public class Cart {


    @Id
    @GeneratedValue
    private long id;

    private Long article;

/*
    @ManyToOne
    @JoinColumn(name = "fork")
    private Fork fork;
*/

    public Cart(Long article) {
        this.article = article;
       // this.fork = fork;

    }
}

