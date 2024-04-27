package org.example.PSK.controllers;

import org.example.PSK.mybatis.dao.DriverMapper;
import org.example.PSK.mybatis.model.Driver;
import org.example.PSK.persistence.DriversDAO;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
@RequestScoped
public class DriverControllerMyBatis {
    @Inject
    DriverMapper driverMapper;

    private List<Driver> allDrivers;

    public List<Driver> getAllDrivers() {
        allDrivers = driverMapper.selectAll();
        return allDrivers;
    }
}
