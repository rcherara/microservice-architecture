package ca.rcherara.services.vehicle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ca.rcherara.services.vehicle.model.EngineType;
import ca.rcherara.services.vehicle.model.Model;
import ca.rcherara.services.vehicle.model.TyreType;
import ca.rcherara.services.vehicle.model.Vehicle;
import ca.rcherara.services.vehicle.repository.VehicleRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class VehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(VehicleRepository repository) {
		return (args) -> {
		// save a few vehicles

	 	repository.save(new Vehicle( "Mazda3", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mazda CX5", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mazda6", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mazda CX-3", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mazda CX-30", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mazda3 Sport", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz GLA", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe C", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe G", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe E", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz GLC", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Coupé GLE", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe A", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe B", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe S", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz GLS", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz GLB", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz CLS", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz GLE", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz SLC", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz AMG GT", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Coupé GLC", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Metris Combi", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Sprinter Équipage", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Corolla", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota RAV4", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota C-HR", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Camry", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Prius", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota 86", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Tacoma", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Prius C", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Highlander", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Sienna", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Sequoia", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Camry Hybride", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota 4Runner", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Mirai", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Tundra", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Camry Hybride", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota RAV4 Hybride", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Highlander Hybride", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Corolla Hatchback", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Yaris Berline", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Yaris", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		


	
		 /*	repository.save(new Vehicle("Toyota Yaris",2019, Model.SEDAN));
		repository.save(new Vehicle("Honda", 2020,  Model.SUV));
		repository.save(new Vehicle("Ford", 2018,  Model.SUV));
		repository.save(new Vehicle("Nissan", 2017,  Model.SUV));
		repository.save(new Vehicle("Volgswagan", 2019,  Model.SUV));
		repository.save(new Vehicle("Hunday", 2020,  Model.SUV));
		repository.save(new Vehicle("Jeep", 2019,  Model.SUV));
		repository.save(new Vehicle("Kia", 2016,  Model.SUV));  */
		// fetch all vehicles
		repository.findAll().forEach(System.out::println);
		};
	}

}