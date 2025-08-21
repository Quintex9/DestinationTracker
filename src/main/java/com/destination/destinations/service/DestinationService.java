package com.destination.destinations.service;

import com.destination.destinations.model.Destination;
import com.destination.destinations.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public List<Destination> getDestinationByCategory(Long categoryId) {
        return destinationRepository.findByCategoryId(categoryId);
    }
}
