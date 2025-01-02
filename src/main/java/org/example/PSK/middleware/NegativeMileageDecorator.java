package org.example.PSK.middleware;

import org.example.PSK.services.VehicleMileageFetcherInterface;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public abstract class NegativeMileageDecorator implements VehicleMileageFetcherInterface {

    @Inject
    @Delegate
    private VehicleMileageFetcherInterface vehicleMileageFetcher;

    @Override
    public Long getMileage() {
        return vehicleMileageFetcher.getMileage() * (-1);
    }

    public abstract boolean isRunning();
}
