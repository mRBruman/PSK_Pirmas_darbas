package vu.lt.rest;


import lombok.Getter;
import lombok.Setter;
import vu.lt.persistence.BuildingsDAO;
import vu.lt.entities.Building;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/buildings")
public class BuildingsController {

    @Inject
    @Setter
    @Getter
    private BuildingsDAO buildingsDAO;


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {

        Building building = buildingsDAO.findOne(id);

        if (building == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        BuildingDto buildingDto = new BuildingDto();
        buildingDto.setAddress(building.getAddress());
        buildingDto.setBuild_year(building.getBuild_year());
        buildingDto.setManufacturerCompanyName(building.getManufacturer().getCompany_name());
        buildingDto.setPrice(building.getPrice());
        return Response.ok(buildingDto).build();
    }


    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer albumId,
            BuildingDto buildingData){
        try{
            Building existingBuilding = buildingsDAO.findOne(albumId);
            if (existingBuilding == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingBuilding.setAddress(buildingData.getAddress());
            existingBuilding.setBuild_year(buildingData.getBuild_year());
            existingBuilding.setPrice(buildingData.getPrice());
            buildingsDAO.update(existingBuilding);
            return Response.ok().build();
        } catch (OptimisticLockException ole){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
