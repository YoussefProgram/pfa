package com.example.pfa.service.Impl;

import com.example.pfa.entities.User;
import com.example.pfa.repos.UserRepos;
import com.example.pfa.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;
@Service
@Transactional
public class UserImplService implements UserService {

    private UserRepos userRepos;
    private PasswordEncoder passwordEncoder;

    public UserImplService(UserRepos userRepos, PasswordEncoder passwordEncoder) {
        this.userRepos = userRepos;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserById(Long userId) {
        return userRepos.findById(userId).orElseThrow(() -> new EntityNotFoundException("User with ID" + userId + " not found"));
    }

    @Override
    public Page<User> loadUsersByName(String name, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<User> usersPage = userRepos.findUserByName(name, pageRequest);
        return new PageImpl<>(usersPage.getContent().stream().collect(Collectors.toList()), pageRequest, usersPage.getTotalElements());
    }

    @Override
    public User loadUserByEmail(String email) {
        return userRepos.findUserByEmail(email);
    }

    @Override
    public User createUser(User user) {
        String encodePassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        return userRepos.save(user);
    }

    @Override
    public User updateUser(User user) {
        User userLoad=loadUserById(user.getUserId());
        user.setAnnonces(userLoad.getAnnonces());
        user.setAnnoncesFavorites(userLoad.getAnnoncesFavorites());
        return userRepos.save(user);
    }

    @Override
    public void removeUser(Long userId) {
        userRepos.deleteById(userId);
    }
}
