package ca.rcherara.services.vehicle.service;

import ca.rcherara.services.vehicle.model.Language;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LanguageService {
	Mono<Language> getLanguage(long id);

	Flux<Language> findAll();

	Mono<Language> add(String code, String name, String name_in_native_language, String date_format, String currency);
}