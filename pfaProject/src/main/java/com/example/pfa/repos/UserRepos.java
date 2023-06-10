package com.example.pfa.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pfa.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepos extends JpaRepository<User, Long> {

    @Query(value = "select i from User as i where i.prénom like %:name% or i.nom like %:name%")
    Page<User> findUserByName(@Param("name") String name, PageRequest pageRequest);

    User findUserByEmail(String email);
}
