package vu.lt.persistence;

import vu.lt.entities.Manufacturer;
import java.util.List;

public interface IManufacturersDAO {
    List<Manufacturer> loadAll();
    void persist(Manufacturer manufacturer);
    Manufacturer findOne(Integer id);
    Manufacturer update(Manufacturer manufacturer);
}
