package com.example.pfa.dto;


import lombok.Data;

@Data
public class VilleDTO {

    private long villeId;
    private String nom;

    public long getVilleId() {
        return villeId;
    }

    public void setVilleId(long villeId) {
        this.villeId = villeId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
