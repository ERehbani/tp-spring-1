package org.eduardomango.practicaspringweb.model.controllers;


import org.apache.coyote.Response;
import org.eduardomango.practicaspringweb.model.entities.SaleEntity;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.eduardomango.practicaspringweb.model.repositories.UserRepository;
import org.eduardomango.practicaspringweb.model.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable int id) {
        UserEntity user = userService.findById(id);
        if(user != null) return ResponseEntity.ok(user);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity newUser){
        if( newUser == null ||
            newUser.getUsername() == null || newUser.getUsername().isBlank() ||
            newUser.getEmail() == null || newUser.getEmail().isBlank() ||
            newUser.getPassword() == null || newUser.getPassword().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        userService.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping("/{id}")
    public String edit(@RequestBody UserEntity newUser, @PathVariable int id) {

        userService.update(newUser, id);
        return "Usuario " + id + " actualizado";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        UserEntity userToDelete = userService.findById(id);
        if(userToDelete == null)  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        userService.delete(userToDelete);
        return ResponseEntity.ok("Usuario eliminado correctamente");

    }


}