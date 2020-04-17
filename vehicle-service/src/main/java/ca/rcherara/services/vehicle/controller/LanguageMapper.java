package ca.rcherara.services.vehicle.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import ca.rcherara.services.vehicle.model.Language;
import ca.rcherara.services.vehicle.model.dto.LanguageDTO;

@Component
public class LanguageMapper {

	Flux<LanguageDTO> toDTO(Flux<Language> language) {
		return language.map(this::toDTO);
	}

	Flux<Language> toEntity(Flux<LanguageDTO> languageDTO) {
		return languageDTO.map(this::toEntity);
	}

	Mono<LanguageDTO> toDTO(Mono<Language> language) {
		return language.map(this::toDTO);
	}

	Mono<Language> toEntity(Mono<LanguageDTO> languageDTO) {
		return languageDTO.map(this::toEntity);
	}

	LanguageDTO toDTO(Language language) {
		LanguageDTO teLanguageDTO = new LanguageDTO();
		BeanUtils.copyProperties(teLanguageDTO, language);
		return teLanguageDTO;
	}

	Language toEntity(LanguageDTO languageDTO) {
		Language teLanguage = new Language();
		BeanUtils.copyProperties(new Language(), languageDTO);
		return teLanguage;
	}

}