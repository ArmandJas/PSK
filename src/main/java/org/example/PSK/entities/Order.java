package org.example.PSK.entities;

import javax.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "FARE")
public class Order {
    @GeneratedValue
    @Id
    private Long orderID;

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long ID) {
        this.orderID = ID;
    }

    @Basic(optional = false)
    private Timestamp orderTimestamp;

    public Timestamp getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(Timestamp basic) {
        this.orderTimestamp = basic;
    }

    @Basic(optional = false)
    private String startLocation;

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    @Basic(optional = false)
    private String endLocation;

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    @ManyToOne
    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
