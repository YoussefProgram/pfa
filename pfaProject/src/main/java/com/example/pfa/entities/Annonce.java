package com.example.pfa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name ="annonces")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long annonceId;
    @Column(unique = true)
    private String titre;
    private String description;
    private int nbrPersonne;
    private LocalDate datePub;
    private double prix;
    private Date dateDebut;
    private Date dateFin;
    @Enumerated(EnumType.STRING)
    private Type type;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Ville ville;
    
    @OneToMany(mappedBy = "annonce",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Image> images;
    
    @ManyToMany(mappedBy = "annoncesFavorites")
    private List<User> favorites;
    

}
