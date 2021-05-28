package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Manufacturer;
import vu.lt.persistence.IManufacturersDAO;
import vu.lt.qualifiers.Base;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;


@Model
public class Manufacturers {

    @Inject @Base
    private NameValidator nameValidator;

    @Inject
    private IManufacturersDAO manufacturersDAO;

    @Getter @Setter
    private Manufacturer manufacturerToCreate = new Manufacturer();

    @Getter
    private List<Manufacturer> allManufacturers;

    @PostConstruct
    public void init(){
        loadAllManufacturers();
    }

    @Transactional
    public String createManufacturer(){
        if(nameValidator.isValidName(manufacturerToCreate.getCompany_name())) {
            this.manufacturersDAO.persist(manufacturerToCreate);
            return "index?faces-redirect=true";
        }
        return "index?faces-redirect=true";
    }

    private void loadAllManufacturers(){
        this.allManufacturers = manufacturersDAO.loadAll();
    }

    public List<Manufacturer> loadSome(List<Manufacturer> manufacturers) {
        List <Manufacturer> Temp = manufacturersDAO.loadAll();
        //Temp.stream().filter(a -> manufacturers)
        for( int i = 0; i < manufacturers.size(); i++){
            Temp.remove(manufacturers.get(i));
        }
        return Temp;}
}
