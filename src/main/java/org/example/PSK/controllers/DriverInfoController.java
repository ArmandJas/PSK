package org.example.PSK.controllers;

import lombok.Getter;
import lombok.Setter;
import org.example.PSK.entities.Driver;
import org.example.PSK.entities.Order;
import org.example.PSK.entities.Vehicle;
import org.example.PSK.middleware.LoggedMethod;
import org.example.PSK.persistence.DriversDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Model
@ViewScoped
public class DriverInfoController implements Serializable {
    @Inject
    DriversDAO driversDAO;

    @Setter @Getter
    private Driver selectedDriver;

    private List<Order> driverOrders;

    private List<Vehicle> driverVehicles;

    @Setter @Getter
    private Vehicle vehicleToAdd = new Vehicle();

    @Setter @Getter
    private String errorDisplay;

    @Setter @Getter
    private boolean isError;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        long driverPID = Long.parseLong(requestParameters.get("PID"));
        this.selectedDriver = driversDAO.getDriver(driverPID);
        errorDisplay = requestParameters.get("ERROR");
        if(Objects.equals(errorDisplay, null))
            errorDisplay = "none";
        isError = false;
    }

    public List<Order> getDriverOrders() {
        driverOrders = driversDAO.getAllOrdersForDriver(selectedDriver.getPID());
        return driverOrders;
    }
    @LoggedMethod
    public List<Vehicle> getDriverVehicles() {
        driverVehicles = driversDAO.getAllVehiclesAssignedToDriver(selectedDriver.getPID());
        return driverVehicles;
    }

    @Transactional
    public void addVehicle() {
        setErrorDisplay("none");
        List<Driver> tempList = new ArrayList<>();
        tempList.add(selectedDriver);
        vehicleToAdd.setDrivers(tempList);
        try {
            driversDAO.addVehicle(vehicleToAdd);
        }
        catch(Exception e) {
            setErrorDisplay("block");
            setError(true);
        }
    }
}
