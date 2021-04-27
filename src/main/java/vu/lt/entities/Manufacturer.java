package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Manufacturer.findAll", query = "select m from Manufacturer as m")
})
@Table(name = "MANUFACTURER")
@Getter @Setter
public class Manufacturer {

    public Manufacturer(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String company_name;

    @OneToMany(mappedBy = "manufacturer")
    private List<Building> buildings = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "MANUFACTURER_MODELS",
            joinColumns = @JoinColumn(name = "manufacturer_id"),
            inverseJoinColumns = @JoinColumn(name = "model_id"))
    List<Model> models;
}
