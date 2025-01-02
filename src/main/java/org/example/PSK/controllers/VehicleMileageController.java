package org.example.PSK.controllers;

import lombok.Getter;
import lombok.Setter;
import org.example.PSK.entities.Vehicle;
import org.example.PSK.persistence.VehiclesDAO;
import org.example.PSK.services.VehicleMileageFetcher;
import org.example.PSK.services.VehicleMileageFetcherInterface;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Model
@SessionScoped
public class VehicleMileageController implements Serializable {


    @Inject
    private VehicleMileageFetcherInterface vehicleMileageFetcher;


    /*
    @Inject
    private VehicleMileageFetcher vehicleMileageFetcher;
    */

    private CompletableFuture<Long> mileageFetchTask = null;

    @Setter
    private Long fetchedMileage = null;

    public void fetchMileage() throws ExecutionException, InterruptedException {
        mileageFetchTask = CompletableFuture.supplyAsync(() -> vehicleMileageFetcher.getMileage());
        //Map<String, String> requestParameters =
        //        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        //return "/vehicles.xhtml?faces-redirect=true&VIN=" + requestParameters.get("VIN");
    }
    public String getFetchedMileage() throws ExecutionException, InterruptedException {
        if (mileageFetchTask == null) {
            return "Mileage not fetched.";
        } else if (vehicleMileageFetcher.isRunning()) {
            return "Working...";
        } else {
            return "" + mileageFetchTask.get();
        }
    }
}
