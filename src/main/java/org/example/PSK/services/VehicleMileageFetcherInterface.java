package org.example.PSK.services;

import lombok.Getter;
import lombok.Setter;

public interface VehicleMileageFetcherInterface {

    boolean running = false;
    Long getMileage();
    boolean isRunning();
}
