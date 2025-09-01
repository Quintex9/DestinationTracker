package com.destination.destinations.controller;

import com.destination.destinations.model.Destination;
import com.destination.destinations.service.DestinationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
@CrossOrigin(origins = "http://localhost:5173")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public List<Destination> getAllDestinations(){
        return destinationService.getAllDestinations();
    }

    @GetMapping("/category/{categoryId}")
    public List<Destination> getAllDestinationsByCategory(@PathVariable Long categoryId){
        return destinationService.getDestinationByCategory(categoryId);
    }
}
