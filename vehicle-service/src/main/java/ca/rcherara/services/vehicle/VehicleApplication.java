package ca.rcherara.services.vehicle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import ca.rcherara.services.vehicle.model.EngineType;
import ca.rcherara.services.vehicle.model.Model;
import ca.rcherara.services.vehicle.model.TyreType;
import ca.rcherara.services.vehicle.model.Vehicle;
import ca.rcherara.services.vehicle.repository.VehicleRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.PropertySource;

@EnableSwagger2
@SpringBootApplication
@PropertySource("classpath:build.yml")
@ComponentScan(basePackages = "ca.rcherara.services.vehicle")
public class VehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(VehicleRepository repository) {
		return (args) -> {
		// save a few vehicles

	 	repository.save(new Vehicle( "Mazda3", "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mazda CX5", "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mazda6", "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mazda CX-3" , "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mazda CX-30",  "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mazda3 Sport", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz GLA", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe C", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe G", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe E",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz GLC",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Coupé GLE", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe A",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe B", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Classe S",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz GLS", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz GLB", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz CLS", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz GLE", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz SLC", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz AMG GT",  "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Coupé GLC",  "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Metris Combi",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Mercedes-Benz Sprinter Équipage",  "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Corolla",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota RAV4",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota C-HR", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Camry",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Prius", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota 86", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Tacoma", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Prius C", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Highlander",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Sienna",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Sequoia",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Camry Hybride",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota 4Runner",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Mirai", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Tundra",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Camry Hybride", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota RAV4 Hybride", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Highlander Hybride", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Corolla Hatchback", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Yaris Berline", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		repository.save(new Vehicle( "Toyota Yaris",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		


	
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