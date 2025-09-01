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
        kupeleMaleBielice.setDescription("Termálne kúpele Malé Bielice v Partizánskom ponúkajú oddych v šiestich bazénoch s vodou od 27 do 38 °C, ktorá priaznivo pôsobí na pohybový aparát, nervy a celkovú regeneráciu.\n" +
                "\n" +
                "Vo vonkajšom areáli si užijú aj rodiny s deťmi – nechýba bazén s toboganom, šmykľavka a detské ihrisko. Kúpele sú otvorené celoročne.");
        kupeleMaleBielice.setImageURL("/images/kupeleBielice.jpeg");
        kupeleMaleBielice.setPrice(24.0);
        kupeleMaleBielice.setCategory(spa);
        kupeleMaleBielice.setDuration(4.0);
        kupeleMaleBielice.setNazorLenka("Lenkin názor");
        kupeleMaleBielice.setNazorMichal("Michalov názor");
        kupeleMaleBielice.setMichalURL("/images/Michal.jpeg");
        kupeleMaleBielice.setLenkaURL("/images/Lenka.png");
        kupeleMaleBielice.setRatingLenka(3.5);
        kupeleMaleBielice.setRatingMichal(4.5);
        kupeleMaleBielice.setFarba("blue-card");

        Destination javorina = new Destination();
        javorina.setName("Pánska javorina");
        javorina.setDescription("Stredne ťažká túra. Krásne počasie aj prostredie, celkové trvanie 4:50.");
        javorina.setImageURL("/images/panskaJavorina.jpg");
        javorina.setPrice(0.0);
        javorina.setCategory(hiking);
        javorina.setDuration(2.0);
        javorina.setNazorLenka("Lenkin názor");
        javorina.setNazorMichal("Michalov názor");
        javorina.setMichalURL("/images/Michal.jpeg");
        javorina.setLenkaURL("/images/Lenka.png");
        javorina.setRatingLenka(3.5);
        javorina.setRatingMichal(4.5);
        javorina.setFarba("green-card");

        Destination marhat = new Destination();
        marhat.setName("Marhát");
        marhat.setDescription("Ľahká túra, krásne prostredie. Čas trvania túry bol 3 hodiny");
        marhat.setImageURL("/images/marhat.jpg");
        marhat.setPrice(0.0);
        marhat.setCategory(hiking);
        marhat.setDuration(2.0);
        marhat.setNazorLenka("Túra na Marhát bola nádherná! Nebola príliš ťažká, takže som si ju užila bez toho, aby som bola úplne vyčerpaná. Cestou hore krásna príroda a na vrchole úžasný kľud a výhľady – ideálne na oddych aj romantické chvíle. Pre mňa to bol skvelý deň v prírode");
        marhat.setNazorMichal("Výstup na Marhát bol fakt super! Trasa bola nenáročná, ale pritom som sa aj zapotil, takže som mal pocit, že som si to odmakal. Hore je výhľad, ktorý stojí za to – ideálne miesto na oddych s kamošmi a dobré fotky. Pre mňa taká túra, čo spojí pohodu s troškou športu");
        marhat.setMichalURL("/images/Michal.jpeg");
        marhat.setLenkaURL("/images/Lenka.png");
        marhat.setRatingLenka(3.5);
        marhat.setRatingMichal(4.5);
        marhat.setFarba("green-card");

        Destination gric = new Destination();
        gric.setName("Veľký Gríč");
        gric.setDescription("Ľahká túra, krásne prostredie. Čas trvania túry bol 1:45");
        gric.setImageURL("/images/gric.jpg");
        gric.setPrice(0.0);
        gric.setCategory(hiking);
        gric.setDuration(2.0);
        gric.setNazorLenka("Lenkin názor");
        gric.setNazorMichal("Michalov názor");
        gric.setMichalURL("/images/Michal.jpeg");
        gric.setLenkaURL("/images/Lenka.png");
        gric.setRatingLenka(3.5);
        gric.setRatingMichal(4.5);
        gric.setFarba("green-card");

        Destination inovec = new Destination();
        inovec.setName("Považský Inovec");
        inovec.setDescription("Ľahká túra, krásne prostredie. Čas trvania túry bol 1:45");
        inovec.setImageURL("/images/Inovec.jpg");
        inovec.setPrice(0.0);
        inovec.setCategory(hiking);
        inovec.setDuration(2.0);
        inovec.setNazorLenka("Lenkin názor");
        inovec.setNazorMichal("Michalov názor");
        inovec.setMichalURL("/images/Michal.jpeg");
        inovec.setLenkaURL("/images/Lenka.png");
        inovec.setRatingLenka(3.5);
        inovec.setRatingMichal(4.5);
        inovec.setFarba("green-card");

        Destination oponicky = new Destination();
        oponicky.setName("Oponický hrad");
        oponicky.setDescription("Ľahký výstup, krásny výhľad. Pohodlná prechádzka.");
        oponicky.setImageURL("/images/oponicky.jpg");
        oponicky.setPrice(0.0);
        oponicky.setCategory(hiking);
        oponicky.setDuration(2.0);
        oponicky.setNazorLenka("Lenkin názor");
        oponicky.setNazorMichal("Michalov názor");
        oponicky.setMichalURL("/images/Michal.jpeg");
        oponicky.setLenkaURL("/images/Lenka.png");
        oponicky.setRatingLenka(3.5);
        oponicky.setRatingMichal(4.5);
        oponicky.setFarba("green-card");

        Destination ranc = new Destination();
        ranc.setName("Ranč pod Babicou");
        ranc.setDescription("Malá zoo na Bojnej. Krásne zvieratká, zopár z nich sme si mohli pohľadiť");
        ranc.setImageURL("/images/ranc.jpg");
        ranc.setPrice(0.0);
        ranc.setCategory(Zoo);
        ranc.setDuration(2.0);
        ranc.setNazorLenka("Lenkin názor");
        ranc.setNazorMichal("Michalov názor");
        ranc.setMichalURL("/images/Michal.jpeg");
        ranc.setLenkaURL("/images/Lenka.png");
        ranc.setRatingLenka(3.5);
        ranc.setRatingMichal(4.5);
        ranc.setFarba("orange-card");

        destinationRepository.saveAll(Arrays.asList(marhat, gric, inovec,kupeleMaleBielice,javorina, oponicky, ranc));
    }
}
