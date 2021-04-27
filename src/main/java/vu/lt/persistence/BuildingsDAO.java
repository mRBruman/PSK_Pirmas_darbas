package vu.lt.persistence;

import vu.lt.entities.Building;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class BuildingsDAO {

    @Inject
    private EntityManager em;

    public void persist(Building building){
        this.em.persist(building);
    }

    public Building findOne(Integer id){
        return em.find(Building.class, id);
    }

    public Building update(Building building){
        return em.merge(building);
    }
}
