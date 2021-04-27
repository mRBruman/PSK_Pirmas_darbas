package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Building;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.BuildingsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateBuildingDetails implements Serializable {

    private Building building;

    @Inject
    private BuildingsDAO buildingsDAO;

    @PostConstruct
    private void init(){
        System.out.println("UpdateBuildingDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer buildingId = Integer.parseInt(requestParameters.get("buildingId"));
        this.building = buildingsDAO.findOne(buildingId);
    }


    @Transactional
    @LoggedInvocation
    public String updateBuildingBuildYear(){
        try{
            buildingsDAO.update(this.building);
        } catch (OptimisticLockException e){
            return "/buildingDetails.xhtml?faces-redirect=true&buildingId=" + this.building.getId();
        }
        return "buildings.xhtml?manufacturerId=" + this.building.getManufacturer().getId() + "&faces-redirect=true";
    }
}
