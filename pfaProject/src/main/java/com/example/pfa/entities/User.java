package com.example.pfa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(unique = true)
    private String email;
    private String password;
    private String sexe;
    private String phone;
    private int age;
    private String prénom;
    private String nom;
    private String img;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Annonce> annonces;
    
    @ManyToMany
    @JoinTable(name = "annonces_favorites",joinColumns = @JoinColumn( name = "userId"),inverseJoinColumns = @JoinColumn(name="annonceId"))
    private List<Annonce> annoncesFavorites;

    


	
	

   
}
