package ca.rcherara.services.vehicle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "vehicle")
@EntityListeners(AuditingEntityListener.class)
public class Vehicle  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@NotNull(message = "Please, inform a vin (Vehicle Identification Number) for your vehicle.")
	@Size(min = 1, max = 15, message = "Name must have between {min} and {max} characters.")
	@Column(name = "vehicle_vin")
	private String vin;    

	
	@Column(name = "vehicle_name")
	@Size(max = 65)
	private String name;

	@NotNull(message = "Please, inform a vehicle registration plate for your vehicle.")
	@Column(name = "vehicle_plate")
	private String plate;  

	@Column(name = "vehicle_year")
	private int year;

	@Column(name = "vehicle_position")
	private String position;
	
	@Column(name = "vehicle_location")
	private String location;
	
	@Column(name = "vehicle_tag")
	private String tag;
	
	@Column(name = "vehicle_model")
	private Model model;
	
	@Column(name = "vehicle_type")
	private String type;
	
	@Column(name = "vehicle_brand")
	private String brand;
	
	@Column(name = "vehicle_mileage")
	private double mileage;
	
	@Column(name = "vehicle_color")
	private String color;
	
	@Column(name = "vehicle_engine")
	private EngineType engine;
	
	@Column(name = "vehicle_tyre")
	private TyreType tyre;

	@Min(message = "Price cannot be negative", value = 0)
	@Column(name = "vehicle_price")
	private double price;
	
	@Min(message = "Number of windows of the vehicle cannot be negative", value = 2)
	@Column(name = "vehicle_windows")
	private int numOfWindows;
	
	@Column(name = "vehicle_awd")
	private boolean AWD;
	
	@Column(name = "vehicle_cost")
	private double  cost;

	@Column(name = "vehicle_electric")
	private boolean electric = false;    

	@JsonIgnore
	@CreatedDate
    private final LocalDateTime createdAt = LocalDateTime.now();

	@JsonIgnore
	@LastModifiedDate
	private final LocalDateTime editedAt = LocalDateTime.now();
	
	
	public Vehicle(){};
 
		public Vehicle(String name,String plate, int year, Model model, String vin, String position, String location, String tag, String type, String brand, double mileage, String color, EngineType engine, TyreType tyre, double price,int numOfWindows, Boolean AWD, Double cost, Boolean electric  ) {

		this.name = name;
		this.plate = plate;
		this.year = year;
		this.model = model;
		this.vin= vin;
		this.position= position;
		this.location= location;
		this.tag=tag;
		this.type= type;
		this.brand=brand;
		this.mileage= mileage;
		this.color= color;
		this.engine= engine;
		this.tyre= tyre;
		this.price= price;
		this.numOfWindows= numOfWindows;
		this.AWD=AWD;
		this.cost=cost;
		this.electric = electric;  
		 
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", type=" + type
				+ ", name=" + name + ", tag=" + tag + ", location=" + location+ ", mileage=" + mileage + ", position=" + position + ", year=" + year + "]";
	}

}