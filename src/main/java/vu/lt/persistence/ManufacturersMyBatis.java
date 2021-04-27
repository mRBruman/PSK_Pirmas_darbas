package vu.lt.persistence;

import lombok.Getter;
import lombok.Setter;
import vu.lt.mybatis.dao.ManufacturerMapper;
import vu.lt.mybatis.model.Manufacturer;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ManufacturersMyBatis {

    @Inject
    private ManufacturerMapper manufacturerMapper;

    @Getter
    private List<Manufacturer> allManufacturers;

    @Getter @Setter
    private Manufacturer manufacturerToCreate = new Manufacturer();

    @PostConstruct
    public void init(){ this.loadAllMusicians();}

    private void loadAllMusicians() { this.allManufacturers = manufacturerMapper.selectAll();}

    @Transactional
    public String createManufacturer(){
        manufacturerMapper.insert(manufacturerToCreate);
        return "/myBatis/manufacturers?faces-redirect=true";
    }
}
