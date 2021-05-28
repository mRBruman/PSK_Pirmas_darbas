package vu.lt.persistence;

import vu.lt.entities.Building;
import vu.lt.entities.Manufacturer;
import vu.lt.interceptors.LoggedInvocation;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Alternative
public class BuildingsDAOForTesting implements IBuildingsDAO {

    private boolean isFilled = false;
    private List<Building> buildings = new ArrayList<>();
    private int buildingId = 5;

    @Inject
    private ManufacturerDAOForTesting manufacturerDAOForTesting;

    public List<Building> loadAll(){
        if(!isFilled){
            fillList();
            isFilled = true;
        }
        return buildings;
    }

    @LoggedInvocation
    public void persist(Building building){
        loadAll();
        List<Manufacturer> manufacturers = manufacturerDAOForTesting.loadAll();
        Integer buildingsManufacturerID = building.getManufacturer().getId();

        for(Manufacturer manufacturer: manufacturers){
            if(buildingsManufacturerID.equals(manufacturer.getId())){
                List<Building> manufacturerBuildings = manufacturer.getBuildings();
                manufacturerBuildings.add(building);
                manufacturer.setBuildings(manufacturerBuildings);
            }
        }
        building.setId(buildingId);
        buildingId++;
        buildings.add(building);
    }

    public Building findOne(Integer id){
        for (Building building: buildings){
            if(id.equals(building.getId())){
                return building;
            }
        }
        return null;
    }

    private void fillList(){
        List<Building> buildingsCreated = createBuildings();
        buildings.addAll(buildingsCreated);
    }

    public Building update(Building buildingUp){
        Building building = findOne(buildingUp.getId());
        building.setBuild_year(buildingUp.getBuild_year());
        return building;
    }

    private List<Building> createBuildings(){
        List<Building> buildingsList = new ArrayList<>();

        Building building = new Building();
        building.setId(1);
        building.setAddress("Yokohama");
        building.setBuild_year(1976);
        building.setPrice(2000000);
        buildingsList.add(building);

        building = new Building();
        building.setId(2);
        building.setAddress("New York");
        building.setBuild_year(2004);
        building.setPrice(1540000);
        buildingsList.add(building);

        building = new Building();
        building.setId(3);
        building.setAddress("Detroit");
        building.setBuild_year(1980);
        building.setPrice(789000);
        buildingsList.add(building);

        building = new Building();
        building.setId(4);
        building.setAddress("Fukushima");
        building.setBuild_year(2011);
        building.setPrice(4500000);
        buildingsList.add(building);

        return buildingsList;
    }
}
