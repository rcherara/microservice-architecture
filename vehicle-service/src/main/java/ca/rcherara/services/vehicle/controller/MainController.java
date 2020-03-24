package ca.rcherara.services.vehicle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.rcherara.services.vehicle.util.Translator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/api/time")
    public String time(Locale locale) {
       
        String receivedL = String.format("\n Request received. Language: %s, Country: %s %n",locale.getLanguage(), locale.getDisplayCountry());
        DateFormat formatter=DateFormat.getDateInstance(DateFormat.DEFAULT,locale);  
        Date currentDate=new Date();  
        String date=formatter.format(currentDate);  
       
        LOGGER.info(receivedL);
        return  Translator.toLocale("time") +" " + date + "\r \n"+ receivedL;
    }

    @GetMapping("/api/contact")
    public String contact() {
        return "Email: cherara.reddah@icloud.com";
    }

    @GetMapping("/api/message")
    public String getMessage(@RequestParam("msg") String message) {
        return Translator.toLocale(message);
    }
}