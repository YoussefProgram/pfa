package com.example.pfa.service;

import com.example.pfa.entities.Type;
import com.example.pfa.entities.Ville;

import java.util.List;

public interface IVille {

    Ville createVille(String name);
    List<Ville> fetchVilles();
}
