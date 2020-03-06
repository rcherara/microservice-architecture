package ca.rcherara.services.vehicle.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.Date;
 
@RestController
public class HelloController {
    @GetMapping("/api/hello")
    public String hello() {
        return "Time at the server is now " + new Date() + "\n";
    }
    @GetMapping("/api/contact")
    public String contact() {
        return "CHERARA REDDAH email: cherara.reddah@icloud.com";
    }
}