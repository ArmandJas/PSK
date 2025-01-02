package org.example.PSK.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.example.PSK.entities.Driver;
import org.example.PSK.entities.Order;
import org.example.PSK.entities.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VehiclesDAO {
    @Inject
    private EntityManager entityManager;

    public Vehicle update(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }
    public void create(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

    public Vehicle getVehicle(String vehicleVIN) { return entityManager.find(Vehicle.class, vehicleVIN); }
}
