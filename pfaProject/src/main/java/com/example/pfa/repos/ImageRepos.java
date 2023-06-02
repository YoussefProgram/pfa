package com.example.pfa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pfa.entities.Image;

public interface ImageRepos extends JpaRepository<Image, Long> {

}
