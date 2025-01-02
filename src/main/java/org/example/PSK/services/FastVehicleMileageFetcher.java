package org.example.PSK.services;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.Random;

@Model
@ApplicationScoped
@Alternative
public class FastVehicleMileageFetcher implements VehicleMileageFetcherInterface, Serializable {
    @Setter
    private Long mileage;
    @Getter @Setter
    private boolean running;

    @PostConstruct
    private void init() {
        running = false;
    }

    @Override
    public Long getMileage() {
        running = true;
        mileage = new Random().nextLong();
        mileage = Math.abs(mileage);
        running = false;
        return mileage;
    }
}
