package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    @ManyToMany(mappedBy = "manufacturers")
    private List<Model> models;

    public void setModels(List<Model> models) {
        this.models = models;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Manufacturer manufacturer = (Manufacturer) o;
        return Objects.equals(id, manufacturer.id) &&
                Objects.equals(company_name, manufacturer.company_name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, company_name);
    }
}
