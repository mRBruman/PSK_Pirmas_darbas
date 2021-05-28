package vu.lt.persistence;

import vu.lt.entities.Building;
import vu.lt.interceptors.LoggedInvocation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BuildingsDAO implements IBuildingsDAO{

    @Inject
    private EntityManager em;

    public List<Building> loadAll() { return em.createNamedQuery("Building.findAll", Building.class).getResultList();}

    @LoggedInvocation
    public void persist(Building building){
        this.em.persist(building);
    }

    public Building findOne(Integer id){
        return em.find(Building.class, id);
    }

    @LoggedInvocation
    public Building update(Building building){
        return em.merge(building);
    }
}
