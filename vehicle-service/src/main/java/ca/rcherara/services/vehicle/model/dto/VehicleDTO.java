package ca.rcherara.services.vehicle.model.dto;

import ca.rcherara.services.vehicle.model.EngineType;
import ca.rcherara.services.vehicle.model.Model;
import ca.rcherara.services.vehicle.model.TyreType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VehicleDTO {
	public Long id;
	public String vin;    
	public String name;
	public String plate;  
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

}