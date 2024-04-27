package org.example.PSK.controllers;

import lombok.Getter;
import lombok.Setter;
import org.example.PSK.mybatis.dao.DriverMapper;
import org.example.PSK.mybatis.dao.DriverVehicleMapper;
import org.example.PSK.mybatis.dao.VehicleMapper;
import org.example.PSK.mybatis.model.Driver;
import org.example.PSK.mybatis.model.DriverVehicle;
import org.example.PSK.mybatis.model.Fare;
import org.example.PSK.mybatis.model.Vehicle;

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
public class DriverInfoControllerMyBatis implements Serializable {
    @Inject
    DriverMapper driverMapper;

    @Inject
    VehicleMapper vehicleMapper;

    @Inject
    DriverVehicleMapper driverVehicleMapper;

    @Setter @Getter
    private Driver selectedDriver;

    private List<Fare> driverFares;

    private List<Vehicle> driverVehicles;

    @Setter @Getter
    private Vehicle vehicleToAdd = new Vehicle();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        long driverPID = Long.parseLong(requestParameters.get("PID"));
        this.selectedDriver = driverMapper.selectByPrimaryKey(driverPID);
    }

    public List<Fare> getDriverFares() {
        driverFares = driverMapper.selectAllOrdersForDriver(selectedDriver.getPid());
        return driverFares;
    }

    public List<Vehicle> getDriverVehicles() {
        driverVehicles = driverMapper.selectVehiclesAssignedToDriver(selectedDriver.getPid());
        return driverVehicles;
    }

    @Transactional
    public void addVehicle() {
        List<Driver> tempList = new ArrayList<>();
        DriverVehicle driverVehicleToInsert = new DriverVehicle();

        driverVehicleToInsert.setDriversPid(selectedDriver.getPid());
        driverVehicleToInsert.setVehiclesVin(vehicleToAdd.getVin());

        tempList.add(selectedDriver);
        vehicleToAdd.setDrivers(tempList);

        vehicleMapper.insert(vehicleToAdd);
        driverVehicleMapper.insert(driverVehicleToInsert);
    }
}
