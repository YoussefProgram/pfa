package com.example.pfa.mapper;

import com.example.pfa.dto.VilleDTO;
import com.example.pfa.entities.Ville;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class VilleMapper {

    public VilleDTO fromVille(Ville ville) {
        VilleDTO villeDTO=new VilleDTO();
        BeanUtils.copyProperties(ville, villeDTO);
        return villeDTO;
    }
    public Ville fromVilleDTO(VilleDTO villeDTO) {

        Ville ville=new Ville();
        BeanUtils.copyProperties(villeDTO, ville);
        return ville;
    }
}
