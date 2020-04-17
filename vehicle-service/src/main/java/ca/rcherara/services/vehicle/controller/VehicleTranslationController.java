package ca.rcherara.services.vehicle.controller;


import java.util.Collection;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.rcherara.services.vehicle.model.VehicleTranslation;
import ca.rcherara.services.vehicle.repository.VehicleTranslationRepository;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "transaltion")
public class VehicleTranslationController {
	
		private static final Logger LOGGER = LoggerFactory.getLogger(VehicleTranslationController.class);
		
		@Autowired
		VehicleTranslationRepository vehicleTranslationRepository;

		@GetMapping("/vehicle/translation")
		Collection<VehicleTranslation> vehicles() {
			LOGGER.info("List all vehicles");
			
			return vehicleTranslationRepository.findAll();
		}
/* 

		@PostMapping("/vehicle/translation")
		ResponseEntity<VehicleTranslation> createVehicleTranslation(@Valid @RequestBody VehicleTranslation vehicleTranslation) throws URISyntaxException {
			LOGGER.info("Request to create vehicle translation: {}", vehicleTranslation);
			VehicleTranslation result = vehicleTranslationRepository.save(vehicleTranslation);
			return ResponseEntity.created(new URI("/api/vehicle/" + result.))
					.body(result);
		}


		@GetMapping("/vehicle/{id}")
		ResponseEntity<?> getVehicle(@PathVariable Long id) {
			LOGGER.info("Vehicle find by id={}", id);
			Optional<VehicleTranslation> vehicle = vehicleTranslationRepository.findById(id);
			return vehicle.map(response -> ResponseEntity.ok().body(response))
					.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}


		//@PutMapping("/vehicle/{id}")
		@RequestMapping(value = "/vehicle/{id}",produces = "application/json", method=RequestMethod.PUT)
		ResponseEntity<VehicleTranslation> updateVehicle(@Valid @RequestBody VehicleTranslation vehicle) {
			LOGGER.info("Request to update vehicle: {}", vehicle);
			VehicleTranslation result = vehicleTranslationRepository.save(vehicle); 
			return ResponseEntity.ok().body(result);
		}
	
		@PostMapping
		public ResponseEntity<?> addorUpdateVehicle(@RequestBody VehicleTranslation vehicle) {
			vehicleTranslationRepository.save(vehicle); 
			return new ResponseEntity("Vehicle added succcessfully", HttpStatus.OK);
		}

		

		
		@DeleteMapping("/vehicle/{id}")
		public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
			LOGGER.info("Request to delete vehicle: {}", id);
			vehicleTranslationRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} */
	}
