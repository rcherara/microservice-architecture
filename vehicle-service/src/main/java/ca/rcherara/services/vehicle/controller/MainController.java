package ca.rcherara.services.vehicle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.springdoc.core.Constants.SWAGGER_UI_PATH;
import static org.springframework.util.AntPathMatcher.DEFAULT_PATH_SEPARATOR;
import static org.springframework.web.servlet.view.UrlBasedViewResolver.REDIRECT_URL_PREFIX;
import io.swagger.v3.oas.annotations.tags.Tag;
import springfox.documentation.annotations.ApiIgnore;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


import ca.rcherara.services.vehicle.util.Translator;

@RestController
@Tag(name = "Main")
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Value(SWAGGER_UI_PATH)
	private String swaggerUiPath;

    @ApiIgnore
    @GetMapping(DEFAULT_PATH_SEPARATOR)
	public String index() {
		return REDIRECT_URL_PREFIX + swaggerUiPath;
	}
    @GetMapping("/api/time")
    public String time(@RequestHeader("accept-language") String language) {
       

        Locale locale = null;
        if(language == null){
            locale =  new Locale("fr-CA");
        } else {
            locale = Locale.forLanguageTag(language);
        }
        LOGGER.info("Sending request time with locale {}", locale);

        String receivedL = String.format("\n Request received. Language: %s, Country: %s %n",locale.getLanguage(), locale.getDisplayCountry());
        DateFormat formatter=DateFormat.getDateInstance(DateFormat.DEFAULT,locale);  
        Date currentDate=new Date();  
        String date=formatter.format(currentDate);      
        LOGGER.info(receivedL);
        return  Translator.toLocale("time") +" " + date + "\r \n"+ receivedL;
    }

    @GetMapping("/api/contact")
    public String contact() {
        return "cherara.reddah@icloud.com";
    }

    @GetMapping("/api/message")
    public String getMessage(@RequestParam("msg") String message,@RequestHeader("accept-language") String language) {

        Locale locale = null;
        if(language == null){
            locale =  new Locale("fr-CA");
        } else {
            locale = Locale.forLanguageTag(language);
        }
        LOGGER.info("Sending request message with locale {}", locale);

        return Translator.toLocale(message,locale );
    }
}