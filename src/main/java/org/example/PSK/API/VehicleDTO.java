package org.example.PSK.API;

import lombok.Getter;
import lombok.Setter;
import org.example.PSK.entities.Driver;

import java.util.List;

public class VehicleDTO {
    @Setter @Getter
    private String VIN;
    @Setter @Getter
    private Long mileage;
    @Setter @Getter
    private String status;
    @Getter @Setter
    private List<Driver> drivers;
}
