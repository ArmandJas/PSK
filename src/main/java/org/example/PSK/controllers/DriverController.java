package org.example.PSK.controllers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.example.PSK.entities.Driver;
import org.example.PSK.persistence.DriversDAO;

import java.util.List;

@Model
@RequestScoped
public class DriverController {
    @Inject
    DriversDAO driversDAO;

    private List<Driver> allDrivers;

    public List<Driver> getAllDrivers() {
        allDrivers = driversDAO.getAllDrivers();
        return allDrivers;
    }
}
