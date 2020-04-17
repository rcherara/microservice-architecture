package ca.rcherara.services.vehicle.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageDTO {
	private Long id;
	private String code;
	private String name;
	private String name_in_native_language;
	private String date_format;
	private String currency;

}