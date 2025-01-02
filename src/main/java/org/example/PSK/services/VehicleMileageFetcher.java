package org.example.PSK.services;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.Random;

@Model
@ApplicationScoped
@Default
public class VehicleMileageFetcher implements VehicleMileageFetcherInterface, Serializable {
    @Setter
    protected Long mileage;
    @Getter @Setter
    protected boolean running;

    @PostConstruct
    private void init() {
        running = false;
    }

    @Override
    public Long getMileage() {
        try {
            running = true;
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        mileage = new Random().nextLong();
        mileage = Math.abs(mileage);
        running = false;
        return mileage;
    }
}
