package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Building;
import vu.lt.entities.Manufacturer;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.BuildingsDAO;
import vu.lt.persistence.ManufacturersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class BuildingsForManufacturer {

    @Inject
    private BuildingsDAO buildingsDAO;

    @Inject
    private ManufacturersDAO manufacturersDAO;

    @Getter @Setter
    private Manufacturer manufacturer;

    @Getter @Setter
    private Building buildingToCreate = new Building();

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer manufacturerId = Integer.parseInt(requestParameters.get("manufacturerId"));
        this.manufacturer = manufacturersDAO.findOne(manufacturerId);
    }

    @Transactional
    @LoggedInvocation
    public String createBuilding(){
        buildingToCreate.setManufacturer(this.manufacturer);
        buildingsDAO.persist(buildingToCreate);
        return "buildings?faces-redirect=true&manufacturerId=" + this.manufacturer.getId();
    }
}
