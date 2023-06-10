package com.example.pfa.mapper;

import com.example.pfa.dto.AnnonceDTO;
import com.example.pfa.entities.Annonce;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AnnonceMapper {
    private UserMapper userMapper;
    private VilleMapper villeMapper;

    public AnnonceMapper(UserMapper userMapper, VilleMapper villeMapper) {
        this.userMapper = userMapper;
        this.villeMapper = villeMapper;
    }

    public AnnonceDTO fromAnnonce(Annonce annonce) {
        AnnonceDTO annonceDTO=new AnnonceDTO();
        BeanUtils.copyProperties(annonce,annonceDTO);
        annonceDTO.setUser(userMapper.fromUser(annonce.getUser()));
        annonceDTO.setVille(villeMapper.fromVille(annonce.getVille()));
        return annonceDTO;

    }

    public Annonce fromAnnonceDTO(AnnonceDTO annonceDTO) {
        Annonce annonce=new Annonce();
        BeanUtils.copyProperties(annonceDTO,annonce);
        return  annonce;
    }
}
