package com.example.pfa.service;

import com.example.pfa.dto.AnnonceDTO;
import com.example.pfa.entities.Annonce;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AnnonceService {

    Annonce loadAnnonceById(Long annonceId);

    Annonce createAnnonce(Annonce annonce);

    Annonce createAnnonceImg(Annonce annonce,  MultipartFile[] file) throws IOException;

    Annonce updateAnnonce(Annonce annonce);

    Page<Annonce> findAnnonceByTitre(String keyword, int page, int size);


    Page<Annonce> fetchAnnoncesForUser(Long userId, int page, int size);

    Page<Annonce> fetchAnnoncesFavorisForUser(Long userId, int page, int size);


    void removeAnnonce(Long annonceId);



}
