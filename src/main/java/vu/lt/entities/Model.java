package vu.lt.entities;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Model.findAll", query = "select m from Model as m")
})
@Table(name = "MODEL")
@Getter @Setter
public class Model {

    public Model(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MODEL")
    private String brand;

    @Column(name = "TYPE")
    private String model;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Manufacturer> manufacturers;

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }
}
