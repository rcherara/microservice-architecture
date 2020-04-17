package ca.rcherara.services.vehicle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@EqualsAndHashCode
@Table(name = "vehicle_translation")
public class VehicleTranslation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private long vehicleId;
	private String languageId;
	private String name_translation;
    private String location_translation;
    private String type_translation;
    private String brand_translation;
    private String color_translation;
	@JsonIgnore
    private final LocalDateTime createdAt = LocalDateTime.now();
    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();
	public VehicleTranslation(){};
	public VehicleTranslation(long vehicleId,String languageId,String name_translation,String location_translation, String type_translation, String brand_translation, String color_translation ) {
		this.vehicleId = vehicleId;
		this.languageId = languageId;
		this.name_translation = name_translation;
		this.location_translation = location_translation;
		this.type_translation = type_translation;
		this.brand_translation = brand_translation;
		this.color_translation = color_translation;
	}
}