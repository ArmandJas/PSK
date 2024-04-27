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
public class DriversDAO {
    @Inject
    private EntityManager entityManager;

    public Driver getDriver(long PID) {
        return entityManager.find(Driver.class, PID);
    }

    public List<Driver> getAllDrivers() {
        TypedQuery<Driver> query = entityManager.createQuery("SELECT a FROM Driver a", Driver.class);
        return query.getResultList();
    }

    public List<Order> getAllOrdersForDriver(Long driverPID) {
        TypedQuery<Order> query = entityManager.createQuery(
                "SELECT o FROM Order o WHERE o.driver.PID = :driverPID", Order.class);
        query.setParameter("driverPID", driverPID);
        return query.getResultList();
    }

    public List<Vehicle> getAllVehiclesAssignedToDriver(Long driverPID) {
        TypedQuery<Driver> query = entityManager.createQuery(
                "SELECT d FROM Driver d JOIN FETCH d.vehicles WHERE d.PID = :driverPID", Driver.class);
        query.setParameter("driverPID", driverPID);
        try {
            return query.getSingleResult().getVehicles();
        }
        catch(Exception e) {
            return new ArrayList<>();
        }
    }

    public void addVehicle(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }
}
