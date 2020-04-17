package ca.rcherara.services.vehicle.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@EqualsAndHashCode
@Table(name = "language")
@Data
@Entity
// @AllArgsConstructor
//public class Language extends BaseEntity {
	public class Language{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Language UUID in  the database")
    @JsonProperty("id")
	private Long id;

	@Basic
	@Column(name = "language_code")
	@NotBlank @Size(min = 2, max = 5) 
	private String code;


	@Basic
	@Column(name = "language_name")
	@NotBlank @Size(min = 0, max = 50) 
	private String name;

	@Basic
	@Column(name = "language_name_in_native_language")
	private String name_in_native_language;
	
	@Basic
	@Column(name = "language_date_format")
	private String date_format;
	
	@Basic
	@Column(name = "language_currency")
	private String currency;

	public Language(){};
 
	public Language(String language_code, String name,  String name_in_native_language,String date_format, String currency ) {
		
		this.name = name;
		this.code = language_code;
		this.name_in_native_language = name_in_native_language;
		this.date_format = date_format;
		this.currency = currency;
		//this.updatedBy ="Vehicle Service ";
		//this.createdBy= "Vehicle Service ";
	}

/* 	@Override
	public boolean equals(Object o) {
	  if (this == o) return true;
	  if (o == null || getClass() != o.getClass())
		return false;
		Language language = (Language) o;
	  return Objects.equals(id, language.id) &&
		  Objects.equals(language_code ,language.language_code)  &&
		  Objects.equals(name, language.name);
	}
  
	@Override
	public int hashCode() {
	  return Objects.hash(id, language_code,name);
	} */
}

