package vu.lt.persistence;

import lombok.Getter;
import lombok.Setter;
import vu.lt.mybatis.dao.BuildingMapper;
import vu.lt.mybatis.dao.ManufacturerMapper;
import vu.lt.mybatis.model.Building;
import vu.lt.mybatis.model.Manufacturer;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class BuildingsForManufacturerMyBatis {

    @Inject
    private BuildingMapper buildingMapper;

    @Inject
    private ManufacturerMapper manufacturerMapper;

    @Getter
    private List<Building> allBuildings;

    @Getter @Setter
    private Manufacturer manufacturer;

    @Getter @Setter
    private Building buildingToCreate = new Building();

    @PostConstruct
    public void init(){ this.loadAllBuilding();}

    private void loadAllBuilding() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer manufacturerId = Integer.parseInt(requestParameters.get("manufacturerId"));
        this.manufacturer = manufacturerMapper.selectByPrimaryKey(manufacturerId);
        this.allBuildings = buildingMapper.selectManufacturerBuildings(manufacturerId);
    }

    @Transactional
    public String createManufacturer(){
        buildingMapper.insert(buildingToCreate);
        return "/myBatis/manufacturers?faces-redirect=true";
    }
}
