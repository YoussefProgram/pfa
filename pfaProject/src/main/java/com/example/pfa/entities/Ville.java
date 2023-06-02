package com.example.pfa.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="villes")
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long villeId;
    @Column(unique = true)
    private String nom;
    
    @OneToMany(mappedBy = "ville",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Annonce> annonces;


    public Ville(String name) {
    }
}
