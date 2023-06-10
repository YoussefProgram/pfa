package com.example.pfa.web;

import com.example.pfa.entities.Annonce;
import com.example.pfa.service.AnnonceService;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/Anonces")
@CrossOrigin("*")
public class AnonceRest {
    private AnnonceService annonceService;

    public AnonceRest(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @GetMapping
    public Page<Annonce> searchAnnonces(@RequestParam(name = "keyword", defaultValue = "") String keyword,
                                       @RequestParam(name = "page", defaultValue = "0") int page,
                                       @RequestParam(name = "size", defaultValue = "5") int size) {
        return annonceService.findAnnonceByTitre(keyword, page, size);

    }

    @DeleteMapping("/{annonceId}")
    public void deleteAnnonce(@PathVariable Long annonceId) {
       annonceService.removeAnnonce(annonceId);
    }

    @PostMapping
    public Annonce saveAnnonce(@RequestBody Annonce annonce) {
        return annonceService.createAnnonce(annonce);
    }
    @PostMapping(value = {"/add"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Annonce addNewAnnonce(@RequestPart("annonce") Annonce annonce,
                                 @RequestPart("imageFile") MultipartFile[] file ) throws IOException {
        return annonceService.createAnnonceImg(annonce, file);
    }

    @PutMapping("/{annonceId}")
    public Annonce updateAnnonce(@RequestBody Annonce annonce, @PathVariable Long anonceId) {
        annonce.setAnnonceId(anonceId);
        return annonceService.updateAnnonce(annonce);
    }



}
