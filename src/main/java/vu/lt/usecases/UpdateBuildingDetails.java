package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Building;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.BuildingsDAO;
import vu.lt.persistence.IBuildingsDAO;

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
    private IBuildingsDAO buildingsDAO;

    @PostConstruct
    private void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer buildingId = Integer.parseInt(requestParameters.get("buildingId"));
        this.building = buildingsDAO.findOne(buildingId);
    }


    @Transactional
    public String updateBuildingBuildYear(){
        try{
            buildingsDAO.update(this.building);
        } catch (OptimisticLockException e){
            return "/buildingDetails.xhtml?faces-redirect=true&buildingId=" + this.building.getId() + "&error=optimistic-lock-exception";
        }
        return "buildings.xhtml?manufacturerId=" + this.building.getManufacturer().getId() + "&faces-redirect=true";
    }
}
