package ca.rcherara.services.dealership.controller;

import ca.rcherara.services.dealership.domain.Dealership;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/dealership")
public class DealershipController {
    private static final Logger logger = LoggerFactory.getLogger(DealershipController.class);
    private CrudRepository<Dealership, String> repository;

    @Autowired
    public DealershipController(CrudRepository<Dealership, String> repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Dealership> dealerships() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Dealership add(@RequestBody @Valid Dealership dealership) {
        logger.info("Adding Dealership " + dealership.getId());
        return repository.save(dealership);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Dealership update(@RequestBody @Valid Dealership dealership) {
        logger.info("Updating Dealership " + dealership.getId());
        return repository.save(dealership);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Dealership getById(@PathVariable String id) {
        logger.info("Getting Dealership " + id);
        return repository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id) {
        logger.info("Deleting Dealership " + id);
        repository.deleteById(id);
    }
}