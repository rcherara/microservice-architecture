package ca.rcherara.services.vehicle.exception;

public class VehicleNotFoundException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	public VehicleNotFoundException(String vehicletId) {
		super("Vehicle not found with id " + vehicletId);
	}

}



