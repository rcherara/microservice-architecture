package ca.rcherara.services.vehicle.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.rcherara.services.vehicle.exception.VehicleNotFoundException;
import ca.rcherara.services.vehicle.model.Vehicle;
import ca.rcherara.services.vehicle.repository.VehicleRepository;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "vehicule")
public class VehiculeController {
	
		private static final Logger LOGGER = LoggerFactory.getLogger(VehiculeController.class);
		
		@Autowired
		VehicleRepository vehiculeRepository;

		@GetMapping("/vehicles")
		Collection<Vehicle> vehicles() {
			LOGGER.info("List all vehicles");
			
			return vehiculeRepository.findAll();
		}

		@GetMapping("/vehicles/count")
		//@RequestMapping(value = "/vehicles/count",produces = "application/json", method=RequestMethod.GET)
		ResponseEntity<String> countVehicles() {		
			String result = Long.toString(vehiculeRepository.count());
			//LOGGER.info("Count  vehicles " + result);
			return ResponseEntity.ok().body(result);		
		}

		@GetMapping("/vehiclesWithDelay")
		Collection<Vehicle> vehiclesWithDelay() {
			LOGGER.info("List all vehicles with delay");
			try {
				Thread.sleep(5000);
			} catch(InterruptedException e) {
				System.out.println("Damn! the error occured");
			}
			return vehiculeRepository.findAll();
		}


		@PostMapping("/vehicle")
		ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle vehicle) throws URISyntaxException {
			LOGGER.info("Request to create vehicle: {}", vehicle);
			Vehicle result = vehiculeRepository.save(vehicle);
			return ResponseEntity.created(new URI("/api/vehicle/" + result.getId()))
					.body(result);
		}


		@GetMapping("/vehicle/{id}")
		ResponseEntity<?> getVehicle(@PathVariable Long id) {
			LOGGER.info("Vehicle find by id={}", id);
			Optional<Vehicle> vehicle = vehiculeRepository.findById(id);
			if (vehicle==null) {
				throw new VehicleNotFoundException("Intended User Id not found :"+id);
			}
			return vehicle.map(response -> ResponseEntity.ok().body(response))
					.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}


		@RequestMapping(value = "/vehicle/{id}",produces = "application/json", method=RequestMethod.PUT)
		ResponseEntity<Vehicle> updateVehicle(@Valid @RequestBody Vehicle vehicle) {
			LOGGER.info("Request to update vehicle: {}", vehicle);
			Vehicle result = vehiculeRepository.save(vehicle); 
			return ResponseEntity.ok().body(result);
		}
	
/* 		@PostMapping("/vehicle")
		public ResponseEntity<?> addorUpdateVehicle(@RequestBody Vehicle vehicle) {
			vehiculeRepository.save(vehicle); 
			return new ResponseEntity("Vehicle added succcessfully", HttpStatus.OK);
		} */

		

		
		@DeleteMapping("/vehicle/{id}")
		public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
			LOGGER.info("Request to delete vehicle: {}", id);
			vehiculeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
	}
