package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import org.mybatis.cdi.Transactional;
import vu.lt.entities.Manufacturer;
import vu.lt.entities.Model;
import vu.lt.persistence.ManufacturersDAO;
import vu.lt.persistence.ModelsDAO;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
@Stateful
public class ModelDetails implements Serializable {

    private Model model;

    @Inject
    private ModelsDAO modelsDAO;

    @Inject
    private ManufacturersDAO manufacturersDAO;

    @Getter @Setter
    private Integer manufacturerToAssignId = 0;

    @PostConstruct
    private void init(){
        System.out.println("UpdateModelDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer modelId = Integer.parseInt(requestParameters.get("modelId"));
        this.model = modelsDAO.findOne(modelId);
    }
    @Transactional
    public String assignToNewManufacturer(){
        List<Manufacturer> manufacturers = model.getManufacturers();
        Manufacturer manufacturerToAssign = manufacturersDAO.findOne(manufacturerToAssignId);
        if(!manufacturers.contains(manufacturerToAssign)) {
            manufacturers.add(manufacturerToAssign);
            model.setManufacturers(manufacturers);
            modelsDAO.update(model);
        }
        return "models?faces-redirect=true&modelId="+ model.getId();
    }
}
