package ca.rcherara.services.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ca.rcherara.services.vehicle.model.VehicleTranslation;

public interface VehicleTranslationRepository extends JpaRepository<VehicleTranslation, Long> {

}