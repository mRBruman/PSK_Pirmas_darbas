package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Building.findAll", query = "select b from Building as b")
})
@Table(name = "BUILDING")
@Getter @Setter
public class Building implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "BUILD_YEAR")
    private Integer build_year;

    @Column(name = "PRICE")
    private Integer price;

    @ManyToOne
    @JoinColumn(name="MANUFACTURER_ID")
    private Manufacturer manufacturer;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    public Building() {
    }

}
