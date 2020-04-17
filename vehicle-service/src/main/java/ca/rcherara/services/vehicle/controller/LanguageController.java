package ca.rcherara.services.vehicle.controller;

import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.rcherara.services.vehicle.model.Language;
import ca.rcherara.services.vehicle.model.dto.LanguageDTO;
import ca.rcherara.services.vehicle.repository.LanguageRepository;
import ca.rcherara.services.vehicle.service.LanguageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "language")
public class LanguageController {
	
		private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);
		
		@Autowired
		LanguageRepository languageRepository;

		@Autowired
	    private LanguageService languageService;

		@Autowired
	    private LanguageMapper languageMapper;

		@Operation(description = "See the language list", responses = {
        @ApiResponse(content = @Content(array = @ArraySchema(schema = @Schema(implementation = Language.class))), responseCode = "200") })
		@ApiResponses(value = {
				@ApiResponse(responseCode  = "200", description = "Success"),
				@ApiResponse(responseCode  = "401", description = "Not authenticated "),
				@ApiResponse(responseCode  = "403", description = "Access is prohibited"),
				@ApiResponse(responseCode  = "404", description = "Not found")
		})
		@GetMapping("/languages")
		Collection<Language> languages() {
			LOGGER.info("List all languages");			
			return languageRepository.findAll();
		}


		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "get All Languages") })
		@GetMapping("/flux/languagesDTO")
		public Flux<LanguageDTO> listDTO() {
			Flux<Language> language = languageService.findAll();
			return languageMapper.toDTO(language);
		}

		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "get All Languages") })
		@GetMapping("/flux/languages")
		public Flux<Language> list() {
			Flux<Language> languages = languageService.findAll();
			return languages;
		}

		 
		@ApiResponses(value = {
			@ApiResponse(responseCode  = "200", description = "Success - Return count of Languages"),
			@ApiResponse(responseCode  = "401", description = "Not authenticated "),
			@ApiResponse(responseCode  = "403", description = "Access is prohibited"),
			@ApiResponse(responseCode  = "404", description = "Not found")
		})
		@GetMapping("/languages/count")
		ResponseEntity<String> countLanguages() {		
			String result = Long.toString(languageRepository.count());
			LOGGER.info("Count languages " + result);
			return ResponseEntity.ok().body(result);		
		}
	/*	@PostMapping("/language")
		ResponseEntity<Language> createLanguage(@Valid @RequestBody Language language) throws URISyntaxException {
			LOGGER.info("Request to create language: {}", language);
			Language result = languageRepository.save(language);
			return ResponseEntity.created(new URI("/api/language/" + result.getId id))
					.body(result);
		}

		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "get Language By Id"),
			@ApiResponse(responseCode = "404", description = "Language not found") })
		@GetMapping("/language/{language_code}")
		ResponseEntity<?> getLanguage(@PathVariable String language_code) {
			LOGGER.info("Language find by language_code={}", language_code);
			Optional<Language> language = LanguageRepository.findByCode(language_code);
			return language.map(response -> ResponseEntity.ok().body(response))
					.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}
		@RequestMapping(value = "/language/{language_code}",produces = "application/json", method=RequestMethod.PUT)
		ResponseEntity<Language> updateLanguage(@Valid @RequestBody Language language) {
			LOGGER.info("Request to update language: {}", language);
			Language result = languageRepository.save(language); 
			return ResponseEntity.ok().body(result);
		}
	 	@PostMapping("/language")
		public ResponseEntity<?> addorUpdateLanguage(@RequestBody Language language) {
			languageRepository.save(language); 
			return new ResponseEntity("Language added succcessfully", HttpStatus.OK);
		}
		@DeleteMapping("/language/{language_code}")
		public ResponseEntity<?> deleteGroup(@PathVariable String language_code) {
			LOGGER.info("Request to delete language: {}", language_code);
			languageRepository.deleteById(language_code); 
			return ResponseEntity.ok().build();
		} */
	}
