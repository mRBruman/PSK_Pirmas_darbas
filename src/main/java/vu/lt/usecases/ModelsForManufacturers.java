package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Manufacturer;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.ManufacturersDAO;
import vu.lt.persistence.ModelsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;

@Model
public class ModelsForManufacturers {

    @Inject
    private ModelsDAO modelsDAO;

    @Inject
    private ManufacturersDAO manufacturersDAO;

    @Getter @Setter
    private Manufacturer manufacturer;

    @Getter @Setter
    private vu.lt.entities.Model modelToCreate = new vu.lt.entities.Model();

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer manufacturerId = Integer.parseInt(requestParameters.get("manufacturerId"));
        this.manufacturer = manufacturersDAO.findOne(manufacturerId);
    }

    @Transactional
    @LoggedInvocation
    public String createModel(){
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturers.add(this.manufacturer);
        modelToCreate.setManufacturers(manufacturers);
        modelsDAO.persist(this.modelToCreate);
        return "buildings?faces-redirect=true&manufacturerId=" + this.manufacturer.getId();
    }
}
