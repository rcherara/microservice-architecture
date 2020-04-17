package ca.rcherara.services.vehicle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import ca.rcherara.services.vehicle.model.EngineType;
import ca.rcherara.services.vehicle.model.Language;
import ca.rcherara.services.vehicle.model.Model;
import ca.rcherara.services.vehicle.model.TyreType;
import ca.rcherara.services.vehicle.model.Vehicle;
import ca.rcherara.services.vehicle.model.VehicleTranslation;
import ca.rcherara.services.vehicle.repository.LanguageRepository;
import ca.rcherara.services.vehicle.repository.VehicleRepository;
import ca.rcherara.services.vehicle.repository.VehicleTranslationRepository;
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
	public CommandLineRunner demo(VehicleRepository vehicleRepository, VehicleTranslationRepository vehicleTranslationRepository, LanguageRepository languageRepository) {
		return (args) -> {
		// save a few vehicles
		//                         Vehicle(String name,String plate, int year, Model model, String vin, String position, String location, String tag, String type, String brand, double mileage, String color, EngineType engine, TyreType tyre, double price,int numOfWindows, Boolean AWD, Double cost, Boolean electric  ) {

		vehicleRepository.save(new Vehicle( "Mazda3", "SDE34422", 2017, Model.SPORTS,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Mazda Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 23333.00, false) );
		vehicleRepository.save(new Vehicle( "Mazda CX5", "SDE34422", 2020, Model.SUV,"SAD23SD4DSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Mazda Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 40000.00,6, true, 3500.00, false) );
		vehicleRepository.save(new Vehicle( "Mazda6", "SDE34422", 2020, Model.SPORTS,"SAD233DSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Mazda Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 32000.00,6, true, 256300.00, false) );
		vehicleRepository.save(new Vehicle( "Mazda CX-3" , "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Mazda Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 23333.00, false) );
		vehicleRepository.save(new Vehicle( "Mazda CX-30",  "SDE34422",  2018, Model.SPORTS,"SAD23SSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Mazda Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mazda3 Sport", "SDE34422",  2019, Model.SPORTS,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Mazda Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz GLA", "SDE34422",  2019, Model.SUV,"SAD13SDSHDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Mazda Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz Classe C", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz Classe G", "SDE34422",  2017, Model.SUV,"SAD27SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz Classe E",  "SDE34422", 2012, Model.SUV,"SAD23SD7SDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz GLC",  "SDE34422", 2019, Model.SUV,"SAS23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz Coupé GLE", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz Classe A",  "SDE34422", 2016, Model.SUV,"SAS23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz Classe B", "SDE34422",  2013, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz Classe S",  "SDE34422", 2011, Model.SUV,"SAG23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz GLS", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz GLB", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 2383.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz CLS", "SDE34422",  2018, Model.SUV,"SAD23SD11DSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz GLE", "SDE34422",  2015, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz SLC", "SDE34422",  2014, Model.SUV,"SAD23SD22DSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz AMG GT",  "SDE34422",  2019, Model.SUV,"SAD27SD66DSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz Coupé GLC",  "SDE34422",  2019, Model.SUV,"SAD238DSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz Metris Combi",  "SDE34422", 2019, Model.SUV,"SAD23S77DSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Mercedes-Benz Sprinter Équipage",  "SDE34422",  2019, Model.SUV,"SAD23SD11DSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Corolla",  "SDE34422", 2019, Model.SUV,"SAD13SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Daimler AG",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota RAV4",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "sfasfa",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota C-HR", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Camry",  "SDE34422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Prius", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota 86", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Tacoma", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Prius C", "SDE34422",  2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Highlander",  "SDE33322", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Sienna",  "SDE31122", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Sequoia",  "SDE00422", 2019, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Camry Hybride",  "SDE35522", 2015, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota 4Runner",  "SDE36622", 2015, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Mirai", "SDE37722",  2018, Model.SUV,"SAD234DLSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Tundra",  "SDE38822", 2018, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Camry Hybride", "SDE39922",  2017, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota RAV4 Hybride", "SDE34411",  2020, Model.SUV,"SAD23S1SSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Highlander Hybride", "SDE34433",  2017, Model.SUV,"SAD23SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Corolla Hatchback", "SDE34444",  2016, Model.SUV,"SAD431D7SDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Yaris Berline", "SDE34455",  2014, Model.SUV,"SAD61SDSSDSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.save(new Vehicle( "Toyota Yaris",  "SDE34466", 2016, Model.SUV,"SAD08SDS6DSS","Alger","Rue Didouche Mourad","WSDLKALK", "Type", "Toyota Motor Corp.",23434,"Red",EngineType.MEDIUM,TyreType.SUMMER, 23333.00,6, true, 12312312.00, false) );
		vehicleRepository.findAll().forEach(System.out::println);

	
		languageRepository.save(new Language("en","English" , "English", "date_format", "Algerian Dinard" ));
		languageRepository.save(new Language("ar","Arabic"  , "العربية", "date_format", "دينار جزائري" ));
		languageRepository.save(new Language("fr","French"  , "Français","date_format", "Dinard Algérien" ));
		languageRepository.save(new Language("de", "German"  ,"Deutsche","date_format", "Algerischer Dinar" ));
		languageRepository.save(new Language("it", "Italian" ,"Italiano","date_format", "Dinaro Algerino" ));
		languageRepository.save(new Language("es", "Spanish" ,"Hispana", "date_format", "Alĝeria dinaro" ));
		languageRepository.findAll().forEach(System.out::println);

		// VehicleTranslation(long vehicleId,String languageId,String name_translation,String plate_translation,String location_translation, String type_translation, String brand_translation, String color_translation ) {
		vehicleTranslationRepository.save(new VehicleTranslation(1,"en","Mazda3","Alger", "type_translation", "Mazda Motor Corp.", "Red"));
		vehicleTranslationRepository.save(new VehicleTranslation(1,"ar","مازدا 3","location_translation", "نوع السيارة", "مازدا موتور كورب", "أحمر"));
		vehicleTranslationRepository.save(new VehicleTranslation(1,"fr","Mazda3","الجزائر", "type_translation", "Mazda Motor Corp.", "Rouge"));
		vehicleTranslationRepository.save(new VehicleTranslation(2,"en","Mazda CX5","Alger", "type_translation", "Mazda Motor Corp.", "Red"));
		vehicleTranslationRepository.save(new VehicleTranslation(2,"ar","مازدا سي اكس 5","location_translation", "نوع السيارة", "مازدا موتور كورب", "أحمر"));
		vehicleTranslationRepository.save(new VehicleTranslation(3,"fr","Mazda CX5","الجزائر", "type_translation", "Mazda Motor Corp.", "Rouge"));
	
		vehicleTranslationRepository.findAll().forEach(System.out::println);
		};
	}

}