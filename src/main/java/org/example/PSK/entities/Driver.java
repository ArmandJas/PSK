package org.example.PSK.entities;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Decorated;
import javax.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@ApplicationScoped
public class Driver {
    @Basic(optional = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String basic) {
        this.name = basic;
    }

    @Id
    private Long PID;

    public Long getPID() {
        return PID;
    }

    public void setPID(Long id) {
        this.PID = id;
    }

    @Basic(optional = false)
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        surname = surname;
    }


    @Setter @Getter
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "drivers")
    private List<Vehicle> vehicles;

    @Setter @Getter
    @OneToMany(mappedBy = "driver")
    private List<Order> orders;

}
