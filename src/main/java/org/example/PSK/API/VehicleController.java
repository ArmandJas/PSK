package org.example.PSK.API;


import org.example.PSK.entities.Driver;
import org.example.PSK.entities.Vehicle;
import org.example.PSK.persistence.DriversDAO;
import org.example.PSK.persistence.VehiclesDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/vehicles")
public class VehicleController {

    @Inject
    private VehiclesDAO vehiclesDAO;

    @Path("/{VIN}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByVIN(@PathParam("VIN") final String VIN) {
        Vehicle vehicle = vehiclesDAO.getVehicle(VIN);
        if (vehicle == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVIN(vehicle.getVIN());
        vehicleDTO.setStatus(vehicle.getStatus());
        vehicleDTO.setMileage(vehicle.getMileage());

        return Response.ok(vehicleDTO).build();
    }
    @Path("/{VIN}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("VIN") final String VIN,
            VehicleDTO vehicleDTO) {
        try {
            Vehicle existingVehicle = vehiclesDAO.getVehicle(VIN);
            if (existingVehicle == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingVehicle.setVIN(vehicleDTO.getVIN());
            existingVehicle.setStatus(vehicleDTO.getStatus());
            existingVehicle.setMileage(vehicleDTO.getMileage());
            vehiclesDAO.update(existingVehicle);
            return Response.ok().build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/{VIN}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(
            @PathParam("VIN") final String VIN,
            VehicleDTO vehicleDTO) {
        try {
            Vehicle existingVehicle = vehiclesDAO.getVehicle(VIN);
            if (existingVehicle != null) {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
            Vehicle newVehicle = new Vehicle();
            newVehicle.setVIN(vehicleDTO.getVIN());
            newVehicle.setStatus(vehicleDTO.getStatus());
            newVehicle.setMileage(vehicleDTO.getMileage());
            vehiclesDAO.create(newVehicle);
            return Response.ok().build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
