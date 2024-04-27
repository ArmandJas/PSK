package org.example.PSK.controllers;

import lombok.Getter;
import lombok.Setter;
import org.example.PSK.entities.Driver;
import org.example.PSK.entities.Order;
import org.example.PSK.entities.Vehicle;
import org.example.PSK.persistence.DriversDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
@RequestScoped
public class DriverInfoController implements Serializable {
    @Inject
    DriversDAO driversDAO;

    @Setter @Getter
    private Driver selectedDriver;

    private List<Order> driverOrders;

    private List<Vehicle> driverVehicles;

    @Setter @Getter
    private Vehicle vehicleToAdd = new Vehicle();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        long driverPID = Long.parseLong(requestParameters.get("PID"));
        this.selectedDriver = driversDAO.getDriver(driverPID);
    }

    public List<Order> getDriverOrders() {
        driverOrders = driversDAO.getAllOrdersForDriver(selectedDriver.getPID());
        return driverOrders;
    }

    public List<Vehicle> getDriverVehicles() {
        driverVehicles = driversDAO.getAllVehiclesAssignedToDriver(selectedDriver.getPID());
        return driverVehicles;
    }

    @Transactional
    public void addVehicle() {
        List<Driver> tempList = new ArrayList<>();
        tempList.add(selectedDriver);
        vehicleToAdd.setDrivers(tempList);
        driversDAO.addVehicle(vehicleToAdd);
    }
}
