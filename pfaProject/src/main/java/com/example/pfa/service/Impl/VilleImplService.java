package com.example.pfa.service.Impl;

import com.example.pfa.entities.Ville;
import com.example.pfa.repos.VilleRepos;
import com.example.pfa.service.IVille;

import java.util.List;
import java.util.stream.Collectors;

public class VilleImplService implements IVille {

    private VilleRepos villeRepos;

    @Override
    public Ville createVille(String name) {
        return villeRepos.save(new Ville(name));
    }

    @Override
    public List<Ville> fetchVilles() {
        return villeRepos.findAll().stream().collect(Collectors.toList());
    }
}
