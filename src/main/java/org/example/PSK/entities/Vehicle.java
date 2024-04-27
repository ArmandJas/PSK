package org.example.PSK.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    private String VIN;

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String vin) {
        this.VIN = vin;
    }

    @Basic(optional = false)
    private Long mileage;

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    @Basic(optional = false)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "DRIVER_VEHICLE", joinColumns = @JoinColumn(name = "VEHICLES_VIN"),
            inverseJoinColumns = @JoinColumn(name = "DRIVERS_PID"))
    @Getter @Setter
    private List<Driver> drivers;
}
