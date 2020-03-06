package ca.rcherara.services.vehicle.model;





import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@EqualsAndHashCode
//@NoArgsConstructor
//@RequiredArgsConstructor
//@Table(name = "vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public String vin;      // Vehicle Identification Number
	public String name;
	public int year;
    public String position;
    public String location;
    public String tag;
    public Model model;
    public String type;
    public String brand;
    public double mileage;
    public String color;
    public EngineType engine;
    public TyreType tyre;
    public double price;
    public int numOfWindows;
    public boolean AWD;
    public double  cost;
    public boolean electric = false;    
    //private Long dealershipId;
	//private Long transactionId;
	/* @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<Event> events; */
	
	public Vehicle(){};
 
		public Vehicle(String name, int year, Model model, String vin, String position, String location, String tag, String type, String brand, double mileage, String color, EngineType engine, TyreType tyre, double price,int numOfWindows, Boolean AWD, Double cost, Boolean electric  ) {

		this.name = name;
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