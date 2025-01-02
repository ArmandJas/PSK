package org.example.PSK.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Specializes;
import java.util.Random;

@Model
@ApplicationScoped
@Specializes
public class ImperialVehicleMileageFetcher extends VehicleMileageFetcher{
    @Override
    public Long getMileage() {
        try {
            running = true;
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        mileage = new Random().nextLong();
        mileage = Math.abs(mileage);
        mileage = (long) (mileage / (Math.pow(10, 15)));
        mileage = (long) (mileage / 1.609);
        running = false;
        return mileage;
    }
}
