package ca.rcherara.services.vehicle.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.rcherara.services.vehicle.model.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle getById(long id);
    //List<Vehicle> getByEntcodeContains(String entcode);
    Page<Vehicle> findAll(Pageable pageable);
    List<Vehicle> findAll(Sort sort);
    //Vehicle getByEntcodeAndIdNot(String entcode, Long id);

}