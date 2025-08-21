package com.destination.destinations.config;

import com.destination.destinations.repository.CategoryRepository;
import com.destination.destinations.repository.DestinationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final DestinationRepository destinationRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(DestinationRepository destinationRepository, CategoryRepository categoryRepository) {
        this.destinationRepository = destinationRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {



    }
}
