package vu.lt.persistence;


import vu.lt.entities.Building;
import vu.lt.entities.Manufacturer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ManufacturersDAO {

    @Inject
    private EntityManager em;

    public List<Manufacturer> loadAll() { return em.createNamedQuery("Manufacturer.findAll", Manufacturer.class).getResultList();}

    public void persist(Manufacturer manufacturer){ this.em.persist(manufacturer);}

    public Manufacturer findOne(Integer id){ return em.find(Manufacturer.class, id);}

    public Manufacturer update(Manufacturer manufacturer){
        return em.merge(manufacturer);
    }
}
