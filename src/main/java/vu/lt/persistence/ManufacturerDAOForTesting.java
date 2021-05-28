package vu.lt.persistence;

import vu.lt.entities.Manufacturer;
import vu.lt.entities.Building;
import vu.lt.qualifiers.Base;
import vu.lt.usecases.NameValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Alternative
public class ManufacturerDAOForTesting implements IManufacturersDAO{

    @Inject @Base
    private NameValidator nameValidator;

    private boolean isFilled = false;
    private List<Manufacturer> manufacturers = new ArrayList<>();

    @Inject
    private IBuildingsDAO buildingsDAOForTesting;

    public List<Manufacturer> loadAll(){
        if(!isFilled){
            fillList();
            isFilled = true;
        }
        return manufacturers;
    }

    public void persist(Manufacturer manufacturer) {
        if(nameValidator.isValidName(manufacturer.getCompany_name()))
            manufacturers.add(manufacturer);
    }

    public Manufacturer findOne(Integer id){
        for(Manufacturer manufacturer: manufacturers){
            if(id.equals(manufacturer.getId())) return manufacturer;
        }
        return null;
    }


    public Manufacturer update(Manufacturer manufacturerUp){
        Manufacturer manufacturer = findOne(manufacturerUp.getId());
        manufacturer.setCompany_name(manufacturerUp.getCompany_name());
        return manufacturer;
    }


    private void fillList(){
        List<Building> buildings = buildingsDAOForTesting.loadAll();

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(1);
        manufacturer.setCompany_name("Toyota");
        List<Building> manufacturerBuildings = manufacturer.getBuildings();
        manufacturerBuildings.add(buildings.get(0));
        buildings.get(0).setManufacturer(manufacturer);
        manufacturerBuildings.add(buildings.get(1));
        buildings.get(1).setManufacturer(manufacturer);
        manufacturer.setBuildings(manufacturerBuildings);
        persist(manufacturer);

        manufacturer = new Manufacturer();
        manufacturer.setId(2);
        manufacturer.setCompany_name("Subaru");
        manufacturerBuildings = manufacturer.getBuildings();
        manufacturerBuildings.add(buildings.get(2));
        buildings.get(2).setManufacturer(manufacturer);
        manufacturer.setBuildings(manufacturerBuildings);
        persist(manufacturer);

        manufacturer = new Manufacturer();
        manufacturer.setId(3);
        manufacturer.setCompany_name("Audi");
        manufacturerBuildings = manufacturer.getBuildings();
        manufacturerBuildings.add(buildings.get(3));
        buildings.get(3).setManufacturer(manufacturer);
        manufacturer.setBuildings(manufacturerBuildings);
        persist(manufacturer);
    }
}
