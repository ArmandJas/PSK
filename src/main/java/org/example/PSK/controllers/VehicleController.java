package org.example.PSK.controllers;

import org.example.PSK.services.VehicleMileageFetcher;
import org.example.PSK.persistence.VehiclesDAO;
import lombok.Getter;
import lombok.Setter;
import org.example.PSK.entities.Vehicle;
import org.example.PSK.services.VehicleMileageFetcherInterface;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Model
@ViewScoped
public class VehicleController implements Serializable {

    @Getter @Setter
    private Vehicle vehicle;
    @Inject
    private VehiclesDAO vehiclesDAO;
    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String vehicleVIN = requestParameters.get("VIN");
        this.vehicle = vehiclesDAO.getVehicle(vehicleVIN);
    }

    @Transactional
    public String updateVehicle() {
        String returnString = "/vehicles.xhtml?faces-redirect=true&VIN=" + this.vehicle.getVIN();
        try {
            vehiclesDAO.update(this.vehicle);
        } catch (OptimisticLockException e) {
            return returnString + "&error=optimistic-lock-exception";
        }
        return returnString;
    }
}
