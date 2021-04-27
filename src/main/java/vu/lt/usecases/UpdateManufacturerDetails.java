package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Manufacturer;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.ManufacturersDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
    private ManufacturersDAO manufacturersDAO;

    @PostConstruct
    private void init(){
        System.out.println("UpdateManufacturerDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer manufacturerId = Integer.parseInt(requestParameters.get("manufacturerId"));
        this.manufacturer = manufacturersDAO.findOne(manufacturerId);
    }

    @Transactional
    @LoggedInvocation
    public String updateManufacturer(){
        manufacturersDAO.update(this.manufacturer);
        return "index?faces-redirect=true";
    }
}
