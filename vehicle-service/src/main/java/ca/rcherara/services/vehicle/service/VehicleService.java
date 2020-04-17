package ca.rcherara.services.vehicle.service;

import ca.rcherara.services.vehicle.model.Vehicle;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface VehicleService {

    Vehicle saveVehicle(@NotNull @Valid final Vehicle vehicle);

    List<Vehicle> getList();

    Vehicle getVehicle(Long vehicleId);

    void deleteVehicle(final Long vehicleId);

}