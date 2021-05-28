package vu.lt.persistence;

import vu.lt.entities.Building;

import java.util.List;

public interface IBuildingsDAO {
    List<Building> loadAll();
    void persist(Building building);
    Building findOne(Integer id);
    Building update(Building building);
}
