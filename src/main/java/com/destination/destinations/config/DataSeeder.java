package com.destination.destinations.config;

import com.destination.destinations.model.Category;
import com.destination.destinations.model.Destination;
import com.destination.destinations.repository.CategoryRepository;
import com.destination.destinations.repository.DestinationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
        //vyčistenie dát
        destinationRepository.deleteAll();
        categoryRepository.deleteAll();

        Category hiking = new Category();
        hiking.setName("Hiking");

        Category spa = new Category();
        spa.setName("Spa");

        Category castles = new Category();
        castles.setName("Castles");

        Category Zoo = new Category();
        Zoo.setName("Zoo");

        categoryRepository.saveAll(Arrays.asList(hiking, spa, castles, Zoo));

        Destination kupeleMaleBielice = new Destination();
        kupeleMaleBielice.setName("Termálne kúpele Malé Bielice");
        kupeleMaleBielice.setCategory(spa);
        kupeleMaleBielice.setDescription("Termálne kúpele Malé Bielice v Partizánskom ponúkajú oddych v šiestich bazénoch s vodou od 27 do 38 °C, ktorá priaznivo pôsobí na pohybový aparát, nervy a celkovú regeneráciu.\n" +
                "\n" +
                "Vo vonkajšom areáli si užijú aj rodiny s deťmi – nechýba bazén s toboganom, šmykľavka a detské ihrisko. Kúpele sú otvorené celoročne.");
        kupeleMaleBielice.setImageURL("https://placehold.co/600x400");
        kupeleMaleBielice.setPrice(24.0);

        Destination javorina = new Destination();
        javorina.setName("Pánska javorina");
        javorina.setCategory(hiking);
        javorina.setDescription("Stredne ťažká túra. Krásne počasie aj prostredie, celkové trvanie 4:50.");
        javorina.setImageURL("https://placehold.co/600x400");
        javorina.setPrice(0.0);

        Destination marhat = new Destination();
        marhat.setName("Marhát");
        marhat.setCategory(hiking);
        marhat.setDescription("Ľahká túra, krásne prostredie. Čas trvania túry bol 3 hodiny");
        marhat.setImageURL("https://placehold.co/600x400");
        marhat.setPrice(0.0);

        Destination gric = new Destination();
        gric.setName("Veľký Gríč");
        gric.setCategory(hiking);
        gric.setDescription("Ľahká túra, krásne prostredie. Čas trvania túry bol 1:45");
        gric.setImageURL("https://placehold.co/600x400");
        gric.setPrice(0.0);

        Destination inovec = new Destination();
        inovec.setName("Považský Inovec");
        inovec.setCategory(hiking);
        inovec.setDescription("Ľahká túra, krásne prostredie. Čas trvania túry bol 1:45");
        inovec.setImageURL("https://placehold.co/600x400");
        inovec.setPrice(0.0);

        destinationRepository.saveAll(Arrays.asList(marhat, gric, inovec,kupeleMaleBielice,javorina));
    }
}
