package com.example.pfa.web;

import com.example.pfa.entities.Annonce;
import com.example.pfa.entities.User;
import com.example.pfa.service.AnnonceService;
import com.example.pfa.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
@CrossOrigin("*")
public class UserRest {

   UserService userService;
   AnnonceService annonceService;

    public UserRest(UserService userService, AnnonceService annonceService) {
        this.userService = userService;
        this.annonceService = annonceService;
    }

    @GetMapping
    public Page<User> searchUsers(@RequestParam(name = "keyword", defaultValue = "") String keyword,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "5") int size) {
        return userService.loadUsersByName(keyword, page, size);
    }

    @DeleteMapping("/{anonceId}")
    public void deleteUser(@PathVariable Long anonceId) {
        userService.removeUser(anonceId);
    }

    @PostMapping
    public User saveStudent(@RequestBody User user) {
       return userService.createUser(user);
    }

    @PutMapping("/{anonceId}")
    public User updateStudent(@RequestBody User user, @PathVariable Long userId) {
        user.setUserId((userId));
        return userService.updateUser(user);
    }
    @GetMapping("/{userId}/annonces")
    public Page<Annonce> annoncesByUserId(@PathVariable Long userId,
                                            @RequestParam(name = "page", defaultValue = "0") int page,
                                            @RequestParam(name = "size", defaultValue = "5") int size) {
        return annonceService.fetchAnnoncesForUser(userId,page,size);
    }

    @GetMapping("/{userId}/favoris")
    public Page<Annonce> favorisByUserId(@PathVariable Long userId,
                                            @RequestParam(name = "page", defaultValue = "0") int page,
                                            @RequestParam(name = "size", defaultValue = "5") int size) {

        return annonceService.fetchAnnoncesFavorisForUser(userId,page,size);
    }

}
