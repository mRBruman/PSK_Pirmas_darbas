package vu.lt.rest;


import vu.lt.entities.Manufacturer;
import vu.lt.persistence.ManufacturersDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/manufacturers")
public class ManufacturersController {

    @Inject
    private ManufacturersDAO manufacturersDAO;

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postManufacturer(ManufacturerDto manufacturerDto){
        Manufacturer manufacturer = new Manufacturer();
        System.out.println(manufacturerDto.getCompanyName());
        manufacturer.setCompany_name(manufacturerDto.getCompanyName());
        this.manufacturersDAO.persist(manufacturer);
        return Response.ok().build();
    }
}
