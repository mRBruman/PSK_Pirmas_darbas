package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Manufacturer;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.ManufacturersDAO;
import vu.lt.persistence.IManufacturersDAO;

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
@Getter
@Setter
public class UpdateManufacturerDetails implements Serializable {
    private Manufacturer manufacturer;

    @Inject
    private IManufacturersDAO manufacturersDAO;

    @PostConstruct
    private void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer manufacturerId = Integer.parseInt(requestParameters.get("manufacturerId"));
        this.manufacturer = manufacturersDAO.findOne(manufacturerId);
    }

    @Transactional
    public String updateManufacturer(){
        try {
            manufacturersDAO.update(this.manufacturer);
        } catch(OptimisticLockException e){
            return "/buildings.xhtml?faces-redirect=true&manufacturerId=" + this.manufacturer.getId() + "&error=optimistic-lock-exception";
        }
        return "index.xhtml?faces-redirect=true";
    }
}
