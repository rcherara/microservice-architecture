package ca.rcherara.services.vehicle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.rcherara.services.vehicle.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findById(Long id);
    Vehicle findByName(String name);
 /*    Collection<Vehicle> findByDealership(Long dealershipId);
    Collection<Vehicle> findByTransaction(Long transactionId); */

}