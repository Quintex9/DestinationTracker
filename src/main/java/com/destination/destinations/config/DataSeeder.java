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
        kupeleMaleBielice.setNazorLenka("Vonku bolo hrozne veľa ľudí a to mi strašne prekážalo. Ale vnútri bolo len pár starších a my čiže super relax. Nemám moc rada verejné priestory s vodou ale celkom sme zrelaxovali.\n" +
                "Body strhávam za to že nebol hot dog v bufete a spravili mi extrém masný langoš.\n");
        kupeleMaleBielice.setNazorMichal("Celkom dobrý výlet. Nebolo veľa bazénov ani dobré sauny ale vnútri nebolo moc ľudí a bola príjemne teplá voda. Jedlo z bufetu nebolo najlepšie ale chutilo.");
        kupeleMaleBielice.setMichalURL("/images/Michal.jpeg");
        kupeleMaleBielice.setLenkaURL("/images/Lenka.png");
        kupeleMaleBielice.setRatingLenka(3.0);
        kupeleMaleBielice.setRatingMichal(3.0);
        kupeleMaleBielice.setFarba("blue-card");
        kupeleMaleBielice.setLan(-48.6058);
        kupeleMaleBielice.setLng(18.3756);

        Destination javorina = new Destination();
        javorina.setName("Pánska javorina");
        javorina.setDescription("Stredne ťažká túra. Krásne počasie aj prostredie, celkové trvanie 4:50.");
        javorina.setImageURL("/images/panskaJavorina.jpg");
        javorina.setPrice(0.0);
        javorina.setCategory(hiking);
        javorina.setDuration(2.0);
        javorina.setNazorLenka("Nikdy viac. Horšiu svalobicu som nemala. Krajina bola nádherná to musím uznať. Aj výhľad. Ale hrooozne dlhé to bolo, nevládala som, potila som sa, muchy ma žrali. \n");
        javorina.setNazorMichal("Nebola to síce najľahšia túra ale bolo pekne vonku a bola to taká výzva. Pravdepodobne by som ešte raz zopakoval ale len na bicykli.");
        javorina.setMichalURL("/images/Michal.jpeg");
        javorina.setLenkaURL("/images/Lenka.png");
        javorina.setRatingLenka(2.0);
        javorina.setRatingMichal(3.0);
        javorina.setFarba("green-card");
        javorina.setLan(-48.7122);
        javorina.setLng(18.0128);

        Destination marhat = new Destination();
        marhat.setName("Marhát");
        marhat.setDescription("Ľahká túra, krásne prostredie. Čas trvania túry bol 3 hodiny");
        marhat.setImageURL("/images/marhat.jpg");
        marhat.setPrice(0.0);
        marhat.setCategory(hiking);
        marhat.setDuration(2.0);
        marhat.setNazorLenka("Bomba turistika. Nádhera. Krása. Úžas. Zopakobala by som. Dokonca som aj dokázala vyliezť na rozhladňu. 0.1 boda strhávam lebo dali eknihu na miesto kde nejdú dáta a za to ako Adelka a Maco nadávali na turistiku.");
        marhat.setNazorMichal("Pokojná túra, nebola moc ťažká. Keby ideme samy tak to zvládneme aj do 2 hodín. Krásny výhľad po ceste aj z rozhliadne, no bola trochu rozheganá.");
        marhat.setMichalURL("/images/Michal.jpeg");
        marhat.setLenkaURL("/images/Lenka.png");
        marhat.setRatingLenka(4.9);
        marhat.setRatingMichal(4.5);
        marhat.setFarba("green-card");
        marhat.setLan(-48.5949);
        marhat.setLng(17.9705);

        Destination gric = new Destination();
        gric.setName("Veľký Gríč");
        gric.setDescription("Ľahká túra, krásne prostredie. Čas trvania túry bol 1:45");
        gric.setImageURL("/images/gric.jpg");
        gric.setPrice(0.0);
        gric.setCategory(hiking);
        gric.setDuration(2.0);
        gric.setNazorLenka("Naša prvá turistika vo výzve. Bolo to vskutku pekné. Body dávam za výhľad na Hnadlovú a za to že som si zobrala pivko a na vrchole vypila ale výstup ma skoro zabil. Skajka utekala jak teren koza a ja som nestíhala. Plus skoro sme sa stratili v dedine keď sme sa vracali. A časť cesty výstupu bola zarastená jak džungla. Čudujem sa že som kliešťa nemala až v riti.\n");
        gric.setNazorMichal("Zatiaľ moja najmenej obľúbená túra. Nebola nejaká záživná cesta. Chodili sme cez zarastenú trávu, aspoň výhľad bol pekný.");
        gric.setMichalURL("/images/Michal.jpeg");
        gric.setLenkaURL("/images/Lenka.png");
        gric.setRatingLenka(3.0);
        gric.setRatingMichal(2.0);
        gric.setFarba("green-card");
        gric.setLan(-48.7122);
        gric.setLng(18.7136);

        Destination inovec = new Destination();
        inovec.setName("Považský Inovec");
        inovec.setDescription("Ľahká túra, krásne prostredie. Čas trvania túry bol 1:45");
        inovec.setImageURL("/images/Inovec.jpg");
        inovec.setPrice(0.0);
        inovec.setCategory(hiking);
        inovec.setDuration(2.0);
        inovec.setNazorLenka("Topka. Vyviezli sme sa až po chatu autom aj keď Miško asi nemal moc dobré pocity z toho. A za 40 min sme boli na inovci. Máme z tade pekné fotky a dobrú storku na ig som spravila. Plus sme našli hríby kde sme mali cikpauzu xd");
        inovec.setNazorMichal("Nebolo zrovna veľa pekných výhľadov. Hore sme išli autom až pri chatu - dlho trvala cesta na aute. Výhľad veľmi pekný a konečne stabilná rozhliadňa.");
        inovec.setMichalURL("/images/Michal.jpeg");
        inovec.setLenkaURL("/images/Lenka.png");
        inovec.setRatingLenka(5.0);
        inovec.setRatingMichal(4.0);
        inovec.setFarba("green-card");
        inovec.setLan(-48.6833);
        inovec.setLng(17.9667);

        Destination oponicky = new Destination();
        oponicky.setName("Oponický hrad");
        oponicky.setDescription("Ľahký výstup, krásny výhľad. Pohodlná prechádzka.");
        oponicky.setImageURL("/images/oponicky.jpg");
        oponicky.setPrice(0.0);
        oponicky.setCategory(castles);
        oponicky.setDuration(2.0);
        oponicky.setNazorLenka("Kiko nás zobral až do veže hradu, veľmi chillový spotík. Ale nebola som moc dobre oblečená a bolo hrozne teplo. Inak krásne šla by som zas. \n");
        oponicky.setNazorMichal("Naša prvá \"túra\". Síce som tento hrad už predtým navštívil ale výhľad sa mi veľmi páčil. Dobre sa sedelo na hrade. Dobrý výlet s Kikom. ");
        oponicky.setMichalURL("/images/Michal.jpeg");
        oponicky.setLenkaURL("/images/Lenka.png");
        oponicky.setRatingLenka(4.5);
        oponicky.setRatingMichal(4.8);
        oponicky.setFarba("green-card");
        oponicky.setLan(-48.4480);
        oponicky.setLng(18.1567);

        Destination ranc = new Destination();
        ranc.setName("Ranč pod Babicou");
        ranc.setDescription("Malá zoo na Bojnej. Krásne zvieratká, zopár z nich sme si mohli pohľadiť");
        ranc.setImageURL("/images/ranc.jpg");
        ranc.setPrice(20.0);
        ranc.setCategory(Zoo);
        ranc.setDuration(2.0);
        ranc.setNazorLenka("Veľmi pekné, vystihli sme dobré počasie takže bolo príjemme. Pokŕmila som ary a lemury a Miško ma s nimi pofotil. Dobre sme sa najedli a neprišlo mi že to bolo také drahé. Pol boda strhávam za to že som nemohla kŕmiť surikaty.\n");
        ranc.setNazorMichal("Vonku super počasie, nebolo moc draho. Veľa zvierat, páčilo sa mi, že sme mohli niektoré pohľadiť. Papagáje mi stále skákali na chrbát.");
        ranc.setMichalURL("/images/Michal.jpeg");
        ranc.setLenkaURL("/images/Lenka.png");
        ranc.setRatingLenka(4.5);
        ranc.setRatingMichal(5.0);
        ranc.setFarba("orange-card");
        ranc.setLan(48.5975);
        ranc.setLng(18.0486);

        destinationRepository.saveAll(Arrays.asList(marhat, gric, inovec,kupeleMaleBielice,javorina, oponicky, ranc));
    }
}
