package com.destination.destinations.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(length = 2000)
    private String description;
    private String imageURL;
    private Double price;

    private Double duration;
    @Column(length = 2000)
    private String nazorMichal;
    @Column(length = 2000)
    private String nazorLenka;
    private String michalURL;
    private String lenkaURL;

    private Double ratingMichal;
    private Double ratingLenka;

    private String farba;

    private Double lat;
    private Double lng;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference   //Jackson vie, že toto je "dieťa"
    private Category category;
}
